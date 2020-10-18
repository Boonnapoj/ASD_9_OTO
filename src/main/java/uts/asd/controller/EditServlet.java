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

public class EditServlet extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        MongoDBConnector manager = (MongoDBConnector) session.getAttribute("manager");
        User user = (User) session.getAttribute("user");
        validator.clear(session);

        if (!validator.validateName(name)) {
            session.setAttribute("nameErr", "Error: Name format is incorrect");
            request.getRequestDispatcher("edit.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password format is incorrect");
            request.getRequestDispatcher("edit.jsp").include(request, response);
        } else {

            try {
            } catch (MongoException ex) {
                Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getCode() + " and " + ex.getMessage());
            } finally {
                manager.updateByEmail(user.getEmail(), name, password);
                session.setAttribute("user", user);
                request.getRequestDispatcher("edit.jsp").include(request, response);
            }

        }
    }
}
