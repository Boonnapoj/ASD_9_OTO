package uts.asd.controller.userController;

import com.mongodb.MongoException;
import java.io.IOException;


import java.util.logging.Level;

import java.util.logging.Logger;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import uts.asd.model.User;
import uts.asd.model.dao.MongoDBConnector;


public class EditServlet extends HttpServlet {
    
    @Override
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();   
        String email = request.getParameter("email");
        MongoDBConnector manager = (MongoDBConnector) session.getAttribute("manager");
        
        User user = null;
        try {
            user = manager.getUser(email);
            if (user != null) {
                session.setAttribute("user", user);
                request.getRequestDispatcher("edit.jsp").include(request, response);
            } else {
                session.setAttribute("existErr", "User does not exist in the Database!");
                request.getRequestDispatcher("edit.jsp").include(request, response);
            }
        } catch (MongoException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getCode() + " and " + ex.getMessage());
        }
        request.getRequestDispatcher("edit.jsp").include(request, response);
    }
}
