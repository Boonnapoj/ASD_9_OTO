/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.asd.model;

/**
 *
 * @author diamo
 */
public class Food {
    private String rname;
    private String name;
    private String type;
    private int stock;
    private double price;
    
    
    public Food(String rname, String name, String type, int stock, double price){
            this.rname = rname;
            this.name = name;
            this.type = type;
            this.stock = stock;
            this.price = price;
          
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
