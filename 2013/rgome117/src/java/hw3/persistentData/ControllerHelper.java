/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3.persistentData;




import java.io.IOException;
import java.util.List;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shared.ButtonMethod;
import shared.HelperBaseCh5;
import shared.HibernateHelper;

/**
 *
 * @author Rob
 */
public class ControllerHelper extends HelperBaseCh5{

    
    public static void initHibernate(HttpServlet servlet) {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect",
                "org.hibernate.dialect.MySQLDialect");
        props.setProperty("hibernate.connection.driver_class",
                "com.mysql.jdbc.Driver");
        props.setProperty("hibernate.c3p0.min_size", "1");
        props.setProperty("hibernate.c3p0.max_size", "5");
        props.setProperty("hibernate.c3p0.timeout", "300");
        props.setProperty("hibernate.c3p0.max_statements",
                "50");
        props.setProperty("hibernate.c3p0.idle_test_period",
                "300");

        //The following properties must be updated with your information.
        //Replace the capitalized words with your database information.
        //The standard port for MySQL is 3306.
        props.setProperty("hibernate.connection.url",
                "jdbc:mysql://ocelot.aul.fiu.edu:3306/fall13_rgome117");
        props.setProperty("hibernate.connection.username",
                "fall13_rgome117");
        props.setProperty("hibernate.connection.password",
                "allen20");
        
        boolean create =
                Boolean.parseBoolean(servlet.getInitParameter("create"));
        if (create) {
            HibernateHelper.createTable(props, RequestDataRequired.class);
        }
        HibernateHelper.initSessionFactory(
                props, RequestDataRequired.class);
    } 
  
    
    protected RequestDataRequired bean;
    protected String message;

    public ControllerHelper(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
        bean = new RequestDataRequired();
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
        if (!isValid(bean)) {
          return "Expired.jsp";
        }
        HibernateHelper.updateDB(bean);
        List list = HibernateHelper.getListData(bean.getClass());
        request.setAttribute("database", list);
        return "Process.jsp";
    }
    @ButtonMethod(buttonName="viewButton")
    public String viewMethod()
    {
        if (!isValid(bean)) {
          return "Expired.jsp";
        }
        HibernateHelper.updateDB(bean);
        List list = HibernateHelper.getListData(bean.getClass());
        request.setAttribute("database", list);
        return "View.jsp";
    }
     
    @ButtonMethod(buttonName="confirmButton")
    public String confirmMethod()
    {
        fillBeanFromRequest(bean);
        if(isValid(bean)){
            return "Confirm.jsp";
        }else {
            return "Edit.jsp";
        }
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
        addHelperToSession("attribute", SessionBean.IGNORE);
        
        
        String address = editMethod();
        address = jspLocation(address);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
    
    void doPost() throws IOException, ServletException
    {
      
        logger.info("Called do post");
        addHelperToSession("attribute", SessionBean.READ);
        
        
        
        String address = executeButtonMethod();
        address = jspLocation(address);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
        
    }
    
    
}
