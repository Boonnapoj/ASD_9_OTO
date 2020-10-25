/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.controller.catalogueController;



import com.mongodb.MongoException;
import java.io.IOException;
import java.util.ArrayList;
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
public class ReadRestaurantServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();   
        String name = request.getParameter("RName");
        MongoDBConnector manager = (MongoDBConnector) session.getAttribute("manager");
        
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        try {
            if (name == null){
            name = "";
            }
            restaurants = manager.findRestaurants(name);
            session.setAttribute("restaurants", restaurants);
            request.getRequestDispatcher("main.jsp").include(request, response);
        } catch (MongoException ex) {
            Logger.getLogger(ReadRestaurantServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getCode() + " and " + ex.getMessage());
        }
    }
}