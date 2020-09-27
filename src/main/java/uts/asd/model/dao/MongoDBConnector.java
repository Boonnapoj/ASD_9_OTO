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
import uts.asd.model.User;
import uts.asd.model.Users;


public class MongoDBConnector {
    
    private List<Document> users = new ArrayList();
    private MongoClientURI uri;
    private MongoClient client;
    private MongoDatabase db;
    private String owner;
    private String password;
    private String connectionStringPostfix="";
    
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
        uri = new MongoClientURI("mongodb://" + owner + ":" + password + "");
        client = new MongoClient(uri);
        db = client.getDatabase(uri.getDatabase());
    }
    public void add(User user) {
        users.add(new Document("Username", user.getEmail()).append("Password", user.getPassword()).append("Name", user.getName()));
        MongoCollection<Document> userlist = db.getCollection("ASD-1-9-OTO");
        userlist.insertMany(users);
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
