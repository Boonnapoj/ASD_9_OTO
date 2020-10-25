/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.controller.catalogueController;

import com.mongodb.MongoException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.asd.model.Restaurant;
import uts.asd.model.dao.MongoDBConnector;

/**
 *
 * @author diamo
 */
public class DeleteRestaurantServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        MongoDBConnector manager = (MongoDBConnector) session.getAttribute("manager");
        String name = (String) request.getParameter("RName");
         try {
        } 
        catch (MongoException ex) {
            Logger.getLogger(ReadRestaurantServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getCode() + " and " + ex.getMessage());

        } 
        finally {
            manager.deleteRestaurant(name);
            request.getRequestDispatcher("main.jsp").include(request, response);
        }
    }    
}
