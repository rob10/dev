/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shared;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Rob
 */
public abstract class HelperBaseCh4 {

    protected HttpServlet servlet;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected Logger logger;

    protected enum SessionBean {READ, IGNORE};

    public HelperBaseCh4(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        this.servlet = servlet;
        this.request = request;
        this.response = response;

        initLogger();
        logger.info("Called helperbasech4 constructor");
    }

    protected void initLogger() {

        String logName = this.servlet.getInitParameter("logName");
        if (logName == null) {
            logName = "bytesizebook.guide.ch4";
        }

        String logLevel = this.servlet.getInitParameter("logLevel");
        if (logLevel == null) {
            logLevel = "ERROR";
        }

        logger = Logger.getLogger(logName);
        logger.setLevel(Level.toLevel(logLevel));
        logger.info("Called initlogger");
    }

    protected abstract void copyFromSession(Object helper);

    protected void addHelperToSession(String name, SessionBean state) {
        if (SessionBean.READ == state) {
            Object sessionObj =
                    request.getSession().getAttribute(name);
            if (sessionObj != null) {
                copyFromSession(sessionObj);
            }
        }
        request.getSession().setAttribute(name, this);
    }
    Method methodDefault = null;

    protected String executeButtonMethod()
            throws ServletException, IOException {
        String result = "";
        methodDefault = null;
        Class clazz = this.getClass();
        Class enclosingClass = clazz.getEnclosingClass();
        while (enclosingClass != null) {
            clazz = this.getClass();
            enclosingClass = clazz.getEnclosingClass();
        }

        try {
            result = executeButtonMethod(clazz, true);
        } catch (Exception ex) {
            writeError(request, response,
                    "Button Method Error", ex);
            return "";
        }

        return result;
    }

    protected String executeButtonMethod(Class clazz,
            boolean searchForDefault)
            throws IllegalAccessException, InvocationTargetException {
        String result = "";
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            ButtonMethod annotation =
                    method.getAnnotation(ButtonMethod.class);
            if (annotation != null) {
                if (searchForDefault && annotation.isDefault()) {
                    methodDefault = method;
                }
                if (request.getParameter(annotation.buttonName())
                        != null) {
                    result = invokeButtonMethod(method);
                    break;
                }
            }
        }
        if (result.equals("")) {
            Class superClass = clazz.getSuperclass();
            if (superClass != null) {
                result =
                        executeButtonMethod(superClass,
                        methodDefault == null);
            }
            if (result.equals("")) {
                if (methodDefault != null) {
                    result = invokeButtonMethod(methodDefault);
                } else {
                    logger.error(
                            "(executeButtonMethod) No default method "
                            + "was specified, but one was needed.");
                    result = "No default method was specified,.";
                }
            }
        }
        return result;
    }

    protected String invokeButtonMethod(Method buttonMethod)
            throws IllegalAccessException, InvocationTargetException {
        String resultInvoke = "Could not invoke method";
        try {
            resultInvoke =
                    (String) buttonMethod.invoke(this,
                    (Object[]) null);
        } catch (IllegalAccessException iae) {
            logger.error("(invoke) Button method is not public.",
                    iae);
            throw iae;
        } catch (InvocationTargetException ite) {
            logger.error("(invoke) Button method exception",
                    ite);
            throw ite;
        }
        return resultInvoke;
    }

    static public void writeError(
            javax.servlet.http.HttpServletRequest request,
            javax.servlet.http.HttpServletResponse response,
            String title,
            Exception ex)
            throws IOException, ServletException {
        java.io.PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html>");
        out.println("  <head>");
        out.println("    <title>" + title + "</title>");
        out.println("  </head>");
        out.println("  <body>");
        out.println("<h2>" + title + "</h2>");
        if (ex.getMessage() != null) {
            out.println("    <h3>" + ex.getMessage() + "</h3>");
        }
        if (ex.getCause() != null) {
            out.println("    <h4>" + ex.getCause() + "</h4>");
        }
        StackTraceElement[] trace = ex.getStackTrace();
        if (trace != null && trace.length > 0) {
            out.print("<pre>");
        }
        ex.printStackTrace(out);
        out.println("</pre>");
        out.println("  </body>");
        out.println("</html>");
        out.close();
    }
    
    protected void fillBeanFromRequest(Object bean)
    {
        try{
            BeanUtils.populate(bean, request.getParameterMap());
        }
        catch(IllegalAccessException iae)
        {
            logger.error("Populate - Illegal Access.", iae);
        }
        catch (InvocationTargetException ite) 
        {
            logger.error("Populate - Invocation Target.", ite);
        }
    }
}
