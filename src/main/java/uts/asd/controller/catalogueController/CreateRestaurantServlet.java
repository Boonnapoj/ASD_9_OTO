/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.controller.catalogueController;

/**
 *
 * @author diamo
 */
import com.mongodb.MongoException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;
import uts.asd.model.Restaurant;
import uts.asd.model.dao.MongoDBConnector;


public class CreateRestaurantServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();  
        
        String name = request.getParameter("Rname");
        String address = request.getParameter("Raddress");
        String businessHour = request.getParameter("RbusinessHour");
        Restaurant restaurant = new Restaurant(name, address, businessHour);
       
        
        MongoDBConnector manager = ( MongoDBConnector) session.getAttribute("manager");
        
        try {
            
        } catch (MongoException ex) {
            Logger.getLogger(ReadRestaurantServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getCode() + " and " + ex.getMessage());
        }
        finally {
            manager.addRestaurant(restaurant);
            request.getRequestDispatcher("main.jsp").include(request, response);
        }
    }
    
}
