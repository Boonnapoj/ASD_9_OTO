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


public class UpdateServlet extends HttpServlet {

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1- retrieve the current session
        HttpSession session = request.getSession();
        //3- capture the posted email      
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String status = request.getParameter("status");
        String permission = request.getParameter("permission");
        User user = new User(email, name, password, status, permission);
        //5- retrieve the manager instance from session      
         MongoDBConnector manager = (MongoDBConnector) session.getAttribute("manager");
        try {
            if (user != null) {
                session.setAttribute("user", user);
                manager.updateByEmail(email, name, password);
                session.setAttribute("update", "Update was successful");
                request.getRequestDispatcher("edit.jsp").include(request, response);
            } else {
                session.setAttribute("update", "Update was not successful");
                request.getRequestDispatcher("edit.jsp").include(request, response);
            }
        } catch (MongoException ex) {
            Logger.getLogger(EditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("edit.jsp");
    }
}
