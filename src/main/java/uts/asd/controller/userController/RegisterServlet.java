package uts.asd.controller.userController;

import java.io.IOException;

import java.sql.SQLException;

import java.util.logging.Level;

import java.util.logging.Logger;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import uts.asd.model.User;

import uts.asd.model.dao.UserDBManager;

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
        
        UserDBManager manager = (UserDBManager) session.getAttribute("manager");
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
                User exist = manager.findUser(email, password, permission);
                if (exist != null) {
                    session.setAttribute("existErr", "User already exists in the Database");
                    request.getRequestDispatcher("register.jsp").include(request, response);
                } else {
                    manager.addUser(email, name, password, status, permission);
                    User user = new User(email, name, password, status, permission);
                    session.setAttribute("user", user);
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}