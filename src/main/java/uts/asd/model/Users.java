/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diamo
 */
public class Users {
    private List<User> users = new ArrayList();
    
    public Users(User user){
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
  
}
