/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3.persistentData;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rob
 */
public class Controller extends HttpServlet{
   @Override
    public void init() {
        ControllerHelper.initHibernate(this);
    }
    @Override
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
                         throws IOException, ServletException
    {
        ControllerHelper helper = new ControllerHelper(this, request,response);
        helper.doGet();
    }
    
    protected void doPost(HttpServletRequest request, 
                         HttpServletResponse response) 
                         throws IOException, ServletException
    {
        ControllerHelper helper = new ControllerHelper(this, request,response);
        helper.doPost();
    }
    
}
