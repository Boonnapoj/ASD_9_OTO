package uts.asd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.asd.model.User;

/**
 *
 * @author webdevelopacc
 */
public class UserDBManager {

    private Statement st;

    public UserDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    // Find user by email and password in the database - Read one row in the database table
    public User findUser(String email, String password, String permission) throws SQLException {
        
        String fetch = "SELECT * FROM IOTUSER.USERS WHERE EMAIL = '" + email + "'";
        
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String pass = rs.getString(3);
            String perm = rs.getString(7);
            if (pass.equals(password) && perm.equals(permission)) {
                String name = rs.getString(2);
                String status = rs.getString(4);              
                return new User(email, name, password, status, permission);
            }
        }
        return null;
    }

    //Add a user-data into the database   
    public void addUser(String email, String name, String password, String status, String permission) throws SQLException {                   //code for add-operation       
        st.executeUpdate("INSERT INTO IOTUSER.USERS " + "VALUES ('" + email + "','" + name + "','" + password + "','" + status + "','" + permission + "')");

    }

    //update a user details in the database   
    public void updateUser(String email, String name, String password) throws SQLException {
        //code for update-operation   
        st.executeUpdate("UPDATE IOTUSER.USERS SET NAME = '" + name + "',PASSWORD = '" + password + "' WHERE EMAIL = '" + email + "'");

    }

    //delete a user from the database   
    public void deleteUser(String email) throws SQLException {
        //code for delete-operation   
        st.executeUpdate("DELECT FROM IOTUSER.USERS WHERE EMAIL = '" + email + "'");

    }
    
    //Fetch all
    public ArrayList<User> fetchAll() throws SQLException {
        String fetch = "select * from USERS";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<User> temp = new ArrayList();
        
        while (rs.next()) {
            String email = rs.getString(1);
            String name = rs.getString(2);
            String password = rs.getString(3);
            String status = rs.getString(4);
            String permission = rs.getString(5);
            temp.add(new User(email, name, password, status, permission));
        }
         return temp;
    }
    
    public boolean checkUser(String email, String password) throws SQLException {
        String fetch = "select * from IOTUSER.USERS where EMAIL = '" + email + "' and PASSWORD = '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next()) {
            String userEmail = rs.getString(1);
            String userPass = rs.getString(3);
            if(userEmail.equals(email) && userPass.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
