package com.mycompany.cashier;
import java.text.NumberFormat;
import java.text.DecimalFormat;


class Cashier{
    //Variables
    private static int numberOfItems;
    private static double totalSum;
    private String name, s;
    private double amount, price, tendered, change, dollars, quarters, dimes, nickels, pennies;
    NumberFormat nf = NumberFormat.getInstance();
    DecimalFormat df = (DecimalFormat)nf;
    
    //Constructor
    public Cashier(){
        this.name = name;
        this.price = price;
        price = 0;
        this.s = "";
    }
    
    public double average(){
        return totalSum/numberOfItems;
    }
    
    public void Add(String name, double price){
        totalSum = totalSum + price;
        s = s + name + "........" + price + "\n";
        numberOfItems++;
    }
    
    public void tendered(double amount){
        tendered = amount;
    }
    
    public void makeChange(){
        this.tendered = tendered;
        change = tendered - totalSum;
        change = 100 * change;
        change = Math.round(change);
        change = change / 100;
        dollars = (int)(tendered - totalSum) * 100 / 100;
        pennies = (int)(change * 100) % 100;
        quarters = (int)pennies / 25;
        pennies = (int)pennies % 25;
        dimes = (int)pennies / 10;
        pennies = (int)pennies % 10;
        nickels = (int)pennies / 5;
        pennies = (int)pennies % 5;
        pennies = (int)pennies;
    }
    
    public String getNames(){
        return s;
    }
    
    public double getPrices(){
        return price;
    }
    
    public double getTotal(){
        return totalSum;
    }
    
    public double getMoney(){
        return tendered;
    }
    
    public double getChange(){
        return tendered - totalSum;
    }
    
    public double getQuantity(){
        return numberOfItems;
    }
    
    public double getAverage(){
        return average();
    }
    
    public double getDollars(){
        return dollars;
    }
    
    public double getQuarters(){
        return quarters;
    }
    
    public double getDimes(){
        return dimes;
    }
    
    public double getNickels(){
        return nickels;
    }
    
    public double getPennies(){
        return pennies;
    }
}
