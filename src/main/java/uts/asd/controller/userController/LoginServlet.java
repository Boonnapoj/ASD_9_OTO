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
import org.bson.Document;

import uts.asd.model.User;
import uts.asd.model.dao.MongoDBConnector;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        //1- retrieve the current session
        HttpSession session = request.getSession();
        //2- create an instance of the Validator class
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String permission = request.getParameter("permission");
        //3- retrieve the manager instance from session
         MongoDBConnector manager = (MongoDBConnector) session.getAttribute("manager");
        // Conn connection = (Connection)session.getAttribute("conn");

        User user = null;
        validator.clear(session);
        
        if (permission.equals("anony")){
            session.setAttribute("user", user);
            request.getRequestDispatcher("main.jsp").include(request, response);
            return; // dosen't work
        }

        try {
            Document found = manager.findByEmail(email);
            user = manager.getUser(found.getString("Email"));
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

