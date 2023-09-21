package com.mycompany.cop2250exam07dec2022;

import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;


public class NewClass {
    /*public static void main(String[] args) {
       Shirt shirt = new Shirt("aaaa", 23.5, 6);
       System.out.println(shirt.getBrand()+" "+shirt.getPrice()+" "+shirt.getSize());
       Shirt shirt2 = new Shirt("aaaa", 23.5);
       System.out.println(shirt2.getBrand()+" "+shirt2.getPrice()+" "+shirt2.getSize());
       shirt2.setBrand("zzzzz");
       shirt2.setPrice(45.76);
       shirt2.setSize(22);
       System.out.println(shirt2.getBrand()+" "+shirt2.getPrice()+" "+shirt2.getSize());
       System.out.println(shirt2.getPriceInEuros());
       shirt.compareSize(shirt);
    }*/
    
    public static void main(String[] args) {
       ArrayList<String>names= new ArrayList<>();
names.add("Alice");
names.add("Bob");
names.add("Ann");
names.add("John");
System.out.print(names.get(3)); 
    }
}

class Shirt{
    private String brand;
    private double price;
    private int size;
    //your code comes here...
    public Shirt(String brand, Double price, int size ){
        this.brand=brand;
        this.price=price;
        this.size=size;                
    }
    public Shirt(String brand, Double price){
        this.brand=brand;
        this.price=price;
        this.size=9;
    }
    
    public String getBrand(){
        return this.brand;
    }
    public double getPrice(){
        return this.price;
    }
    public int getSize(){
        return this.size;
    }
    
    
    public void setBrand(String brand){
        this.brand=brand;
    }
    public void setPrice(Double price){
        this.price=price;
    }
    public void setSize(int size){
        this.size=size;
    }
    
    public double getPriceInEuros(){
        return this.price*0.85;
    }
    
    public void compareSize (Shirt another){
        int size = another.getSize();
        if(this.size==size){
            System.out.println("same size");
        }else if(this.size>size){
            System.out.println("larger");
        }else if(this.size<size){
            System.out.println("smaller");
        }
        
    }
}