/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4.complexPersistent;

import java.util.List;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import shared.HelperBaseCh6;
import shared.ButtonMethod;
import shared.HibernateHelper;

public class ControllerHelper extends HelperBaseCh6 {
    
    private ComplexDataPersistent bean = 
        new ComplexDataPersistent();
    
    public ControllerHelper(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
        logger.warn("Controller Helper");
        logger.info("Controller Helper");
        logger.error("Controller Helper");
        logger.debug("Controller Helper");
    }

    static public void initHibernate(HttpServlet servlet) 
    {
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
	    HibernateHelper
		.createTable(ComplexDataPersistent.class);
	}     
	HibernateHelper
	    .initSessionFactory(ComplexDataPersistent.class); 
            
    }

    public Object getData() {   
        return bean;
    }
    
    @Override
    public void copyFromSession(Object sessionHelper) {
        ControllerHelper attribute = (ControllerHelper) sessionHelper;
        bean = attribute.bean;
        checked = attribute.checked;
        selected = attribute.selected;
    }
    
    public void resetNullable() {
        //Checkbox
        bean.setExtra(null);
        //Mulitple select
        
    }

    protected String jspLocation(String page) {
         return "/WEB-INF/jsps/" + page;
    }
    
    @ButtonMethod(buttonName="editButton", isDefault=true)
    public String editMethod() {
        return jspLocation("Edit.jsp");
    }

    @ButtonMethod(buttonName="confirmButton")
    public String confirmMethod() {
        //Create new bean and populate from the query string
        resetNullable();
        fillBeanFromRequest(bean);
        setCheckedAndSelected(bean);
        //The next JSP address depends on the validity of the bean.
        String address;
        if (isValid(bean)) {
            address = jspLocation("Confirm.jsp");
        } else {
            address = jspLocation("Edit.jsp");
        }
        return address;
    }

    @ButtonMethod(buttonName="processButton")
    public String processMethod() { 
        if (!isValid(bean)) {
            return jspLocation("Expired.jsp");
        }
        HibernateHelper.updateDB(bean);
        List list = HibernateHelper.getListData(ComplexDataPersistent.class);
        request.setAttribute("beanbase", list);
        return jspLocation("Process.jsp");
    }
    
    @Override
    protected void doGet() 
        throws ServletException, java.io.IOException
    {      
        //Call the method with false to place a new attribute in the session
        addHelperToSession("attribute", SessionBean.IGNORE);

        //Edit.jsp is the only page that will be displayed from a GET request.
        String address = editMethod();

        request.getRequestDispatcher(address)
            .forward(request, response);
        
        
      
    }
    
    @Override
    protected void doPost() 
        throws ServletException, java.io.IOException 
    {           
        //Call the method with false to place a new attribute in the session
         addHelperToSession("attribute", SessionBean.READ);

        //Edit.jsp is the only page that will be displayed from a GET request.
        String address = executeButtonMethod();

        request.getRequestDispatcher(address)
            .forward(request, response);
        
        
        
      }        
    
 
}