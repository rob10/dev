/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1.servletController;

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
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
                         throws IOException, ServletException
    {
        ControllerHelper helper = new ControllerHelper(this, request,response);
        helper.doGet();
    }
    
}
