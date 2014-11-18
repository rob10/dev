/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4.complexPersistent;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {

    @Override
    public void init() {
        ControllerHelper.initHibernate(this);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
        ControllerHelper helper = new ControllerHelper(this, request, response);
        helper.doGet();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
        ControllerHelper helper = new ControllerHelper(this, request, response);
        helper.doPost();
    }

}
