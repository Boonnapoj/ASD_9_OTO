package uts.asd.controller;

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

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String permission = request.getParameter("permission");
        MongoDBConnector manager = (MongoDBConnector) session.getAttribute("manager");


        User user = null;
        validator.clear(session);

        try {
            user = manager.getUser(email);
        } catch (MongoException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } 
        else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } 
        else if (user == null) {
            session.setAttribute("existErr", "User does not exist in the database");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } 
        else {
            session.setAttribute("user", user);
            request.getRequestDispatcher("main.jsp").include(request, response);
        }
    }
}

