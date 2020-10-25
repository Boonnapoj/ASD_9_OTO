/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import uts.asd.model.Restaurant;

import uts.asd.model.User;
import uts.asd.model.Users;

public class MongoDBConnector {

    private List<Document> users = new ArrayList();
    private List<Document> restaurants = new ArrayList();
    private MongoClientURI uri;
    private MongoClient client;
    private MongoDatabase db;
    private String owner;
    private String password;
    private String connectionStringPostfix = "@ds051943.mlab.com:51943/heroku_91qr7kht";

    public MongoDBConnector(String owner, String password) throws UnknownHostException {
        this.owner = owner;
        this.password = password;
        connect();
    }

    public void showall(Users users) {
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
        MongoCollection<Document> userlist = db.getCollection("ASD-1-9-OTO");
        Document doc = new Document("_id", (((int) userlist.count()) + 1)).append("Email", user.getEmail()).append("Name", user.getName()).append("Password", user.getPassword()).append("Status", user.getStatus()).append("Permission", user.getPermission());
        userlist.insertOne(doc);
    }

    public Document findByEmail(String email) {
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
        if (findByID(id) != null) {
            Document user = findByID(id);
            Bson updateValue = new Document("Email", email).append("Name", name).append("Password", password);
            Bson updateOperation = new Document("$set", updateValue);
            userlist.updateOne(user, updateOperation);
        }

    }

    public void updateByEmail(String email, String name, String password) {
        MongoCollection<Document> userlist = db.getCollection("ASD-1-9-OTO");
        if (findByEmail(email) != null) {
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

    public User getUser(String email) {
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

    public void addRestaurant(Restaurant restaurant) {
        MongoCollection<Document> restaurantlist = db.getCollection("ASD-1-9-OTO-Catalogue");
        Document doc = new Document("_id", (((int) restaurantlist.count()) + 1)).append("RName", restaurant.getName()).append("Address", restaurant.getAddress()).append("BusinessHour", restaurant.getBusinessHour()).append("Active", restaurant.isActive());
        restaurantlist.insertOne(doc);
    }

    public Document findByRestaurantName(String name) {
       
        MongoCollection<Document> restaurantlist = db.getCollection("ASD-1-9-OTO-Catalogue");
         Document result = restaurantlist.aggregate(
                Arrays.asList(
                        Aggregates.match(Filters.eq("RName", name)),
                        Aggregates.match(Filters.and(Filters.eq("Active", true)))
                        )).first();
        return result;
    }

    public void updateByRestaurantName(String name, String address, String businessHour) {
        MongoCollection<Document> restaurantlist = db.getCollection("ASD-1-9-OTO-Catalogue");
        if (findByRestaurantName(name) != null) {
            Document restaurant = findByRestaurantName(name);
            Bson updateValue = new Document("RName", name).append("Address", address).append("BusinessHour", businessHour);
            Bson updateOperation = new Document("$set", updateValue);
            restaurantlist.updateOne(restaurant, updateOperation);
        }

    }

    public void deleteRestaurant(String name) {
        MongoCollection<Document> restaurantlist = db.getCollection("ASD-1-9-OTO-Catalogue");
         Restaurant restaurant = null;
        if (findByRestaurantName(name) != null) {
            Document found = findByRestaurantName(name);
            restaurant = new Restaurant(name, found.getString("Address"), found.getString("BusinessHour"), found.getBoolean("Active"));
            Bson updateValue = new Document("RName", name).append("Address", restaurant.getAddress()).append("BusinessHour", restaurant.getBusinessHour()).append("Active", false);
            Bson updateOperation = new Document("$set", updateValue);
            restaurantlist.updateOne(found, updateOperation);
        }
    }

    public Restaurant getRestaurant(String name) {
        MongoCollection<Document> restaurantlist = db.getCollection("ASD-1-9-OTO-Catalogue");
        Restaurant restaurant = null;
        if (findByRestaurantName(name) != null) {
            Document found = findByRestaurantName(name);
            if (found.getBoolean("Active") == true){
            restaurant = new Restaurant(name, found.getString("Address"), found.getString("BusinessHour"), found.getBoolean("Active"));
            }
        }
        return restaurant;
    }

    public ArrayList<Restaurant> findRestaurants(String name) {
        ArrayList<Restaurant> results = new ArrayList();
        MongoCollection<Document> restaurantlist = db.getCollection("ASD-1-9-OTO-Catalogue");
        FindIterable<Document> cursor;
        if (name.equals("")) {
            cursor = restaurantlist.find();
        } else {
            cursor = restaurantlist.find(Filters.eq("RName", name));
        }
        for (Document d : cursor) {
            Restaurant r = getRestaurant(d.getString("RName"));
            results.add(r);
        }
        return results;
    }
}
