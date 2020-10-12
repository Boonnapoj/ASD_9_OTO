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

public class RegisterServlet extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String status = "active";
        String permission = "customer";
        
        MongoDBConnector manager = (MongoDBConnector) session.getAttribute("manager");
        validator.clear(session);

        if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validateName(name)) {
            session.setAttribute("nameErr", "Error: Name format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        } else {
            try {
                if (manager.getUser(email) != null) {
                    session.setAttribute("existErr", "User already exists in the Database");
                    request.getRequestDispatcher("register.jsp").include(request, response);
                } else {
                    User user = new User(email, name, password, status, permission);
                    manager.add(user);
                    session.setAttribute("user", user);
                    session.setAttribute("permission", "customer");
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }
            } catch (MongoException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}