/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw2.enhanced;



import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shared.ButtonMethod;
import shared.HelperBaseCh4;

/**
 *
 * @author Rob
 */
public class ControllerHelper extends HelperBaseCh4{

    protected RequestData bean;
    protected String message;

    public ControllerHelper(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
        bean = new RequestData();
        logger.info("Called controller attribute constructor");
    }

    public Object getBean() 
    {
        logger.info("called get bean");
        return bean;
    }
    
    String jspLocation(String page)
    {
        return "/WEB-INF/jsps/" + page;
    }
    
    @Override
    protected void copyFromSession(Object sessionHelper)
    {
        logger.info("copyfromsession called");
        if (sessionHelper.getClass() == this.getClass())
        {
            bean = ((ControllerHelper)sessionHelper).bean;
        }
    }
    
    @ButtonMethod(buttonName="processButton")
    public String processMethod()
    {
        //logger.debug("process method called" + bean.getItem());
        return "Process.jsp";
    }
     
    @ButtonMethod(buttonName="confirmButton")
    public String confirmMethod()
    {
        fillBeanFromRequest(bean);
        return "Confirm.jsp";
    }
    
    @ButtonMethod(buttonName="wishlistButton")
    public String wishlistMethod()
    {
        return "WishList.jsp";
    }
    
    @ButtonMethod(buttonName="editButton", isDefault=true)
    public String editMethod()
    {
        //logger.warn("edit method called");
        return "Edit.jsp";
    }

    public void doGet() throws IOException, ServletException {
        
        //logger.info("Called doGet");
        addHelperToSession("attribute", SessionBean.READ);
        
        
        String address = executeButtonMethod();
        address = jspLocation(address);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
    
    
}
