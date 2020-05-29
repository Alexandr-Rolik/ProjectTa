package Controller;


import Model.Customer;
import Repository.CustomerModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/mainPage"})
public class Startup extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Customer> customerList = new CustomerModel().selectAllList();
        req.setAttribute("customers", customerList);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
