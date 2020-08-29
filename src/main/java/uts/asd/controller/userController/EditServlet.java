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

public class EditServlet extends HttpServlet {
    
    @Override
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();   
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String permission = request.getParameter("permission");
        UserDBManager manager = (UserDBManager) session.getAttribute("manager");
        
        User user = null;
        try {
            user = manager.findUser(email, password, permission);
            if (user != null) {
                session.setAttribute("user", user);
                request.getRequestDispatcher("edit.jsp").include(request, response);
            } else {
                session.setAttribute("existErr", "User does not exist in the Database!");
                request.getRequestDispatcher("edit.jsp").include(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
        request.getRequestDispatcher("edit.jsp").include(request, response);
    }
}
