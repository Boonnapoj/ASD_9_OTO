/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model.dao;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

import uts.asd.model.User;
import uts.asd.model.Users;


public class MongoDBConnector {
    
    private List<Document> users = new ArrayList();
    private MongoClientURI uri;
    private MongoClient client;
    private MongoDatabase db;
    private String owner;
    private String password;
    private String connectionStringPostfix="@ds051943.mlab.com:51943/heroku_91qr7kht";
    
    public MongoDBConnector(String owner, String password) throws UnknownHostException {
        this.owner = owner;
        this.password = password;
        connect();
    } 
    public void showall(Users users){
        for (User u : users.getUsers()) {
            System.out.println(u.getName());
        }
    } 
    private void connect() throws UnknownHostException {
        uri = new MongoClientURI("mongodb://" + owner + ":" + password + connectionStringPostfix);
        client = new MongoClient(uri);
        db = client.getDatabase(uri.getDatabase());
    }
    public void add(User user) {
        users.add(new Document("_id", (users.size()+1)).append("Email", user.getEmail()).append("Name", user.getName()).append("Password", user.getPassword()).append("Status", user.getStatus()).append("Permission", user.getPermission()));
        MongoCollection<Document> userlist = db.getCollection("ASD-1-9-OTO");
        userlist.insertMany(users);
    }
    public Document findByEmail(String email){
        MongoCollection<Document> userlist = db.getCollection("ASD-1-9-OTO");
        Document found = (Document) userlist.find(new Document("Email", email)).first();
        return found;
    }
    public Document findByID(String id) {
        MongoCollection<Document> userlist = db.getCollection("ASD-1-9-OTO");
        Document found = (Document) userlist.find(new Document("_id", id)).first();
    return found;
    }
    public void updateByID(String id, String email, String name, String password) {
        MongoCollection<Document> userlist = db.getCollection("ASD-1-9-OTO");
        if (findByID(id) != null){
            Document user = findByID(id); 
            Bson updateValue = new Document("Email", email).append("Name", name).append("Password", password);
            Bson updateOperation = new Document("$set", updateValue);
            userlist.updateOne(user, updateOperation);
        }
        
    }
    public void updateByEmail(String email, String name, String password) {
        MongoCollection<Document> userlist = db.getCollection("ASD-1-9-OTO");
        if (findByEmail(email) != null){
            Document user = findByEmail(email); 
            Bson updateValue = new Document("Name", name).append("Password", password);
            Bson updateOperation = new Document("$set", updateValue);
            userlist.updateOne(user, updateOperation);
        }
        
    }
    public void delete(String email) {
            MongoCollection<Document> userlist = db.getCollection("ASD-1-9-OTO");
            if (findByEmail(email) != null) {
                Document user = findByEmail(email); 
                userlist.deleteOne(user);
            }
    }
    public User getUser(String email){
        MongoCollection<Document> userlist = db.getCollection("ASD-1-9-OTO");
        User user = null;
         if (findByEmail(email) != null) {
             Document found = findByEmail(email);
             user = new User(email, found.getString("Name"), found.getString("Password"), found.getString("Status"), found.getString("Permission"));
         }
        return user;
    }
    public MongoClientURI getUri() {
        return uri;
    }

    public MongoClient getClient() {
        return client;
    }

    public MongoDatabase getDb() {
        return db;
    }

    
}
