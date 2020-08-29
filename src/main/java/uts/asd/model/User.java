 /*
* Student is a JavaBean that stores name, email, password, and Date of birth
 */
package uts.asd.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author peter
 */
public class User {
    private String email;
    private String name;
    private String password;
    private String status;
    private String permission;

    
    //insert a constructor that intializes thefields
    public User(String email, String name, String password, String status, String permission) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.status = status;
        this.permission = permission;
    }
    
    public static void updateUser(HttpSession session, HttpServletRequest request, User user) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String status = request.getParameter("status");
        String permission = request.getParameter("permission");
        user = new User(email, name ,password, status, permission);
        session.setAttribute("user", user);
    }
    
    //insert getter and setter

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

       
}
