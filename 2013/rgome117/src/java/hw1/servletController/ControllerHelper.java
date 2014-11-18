/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw1.servletController;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rob
 */
public class ControllerHelper extends HelperBase{

    protected RequestData data;

    public ControllerHelper(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
        data = new RequestData();
    }

    public Object getInfo() {
        return data;
    }

    public void doGet() throws IOException, ServletException {
        
        request.getSession().setAttribute("attribute", this);
        data.setAthlete(request.getParameter("athlete"));
        data.setSport(request.getParameter("sport"));
        data.setItem(request.getParameter("item"));
        data.getMessage();

        String address;

        if (request.getParameter("processButton") != null) {
            address = "Process.jsp";
        } else if (request.getParameter("confirmButton") != null) {
            address = "Confirm.jsp";
        } else if (request.getParameter("wishlistButton") != null) {
            address = "WishList.jsp";
        } else {
            address = "Edit.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
