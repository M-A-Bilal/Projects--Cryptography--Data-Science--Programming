package com.mycompany.jan2020;
public class TestItem {
    public static void main(String []args){
        item item1 = new item("Choco", 2.1, 2.5, "15-Jan-2020", 50.0);
        System.out.println("Name = " + item1.getName());
        System.out.println("Date of Manufacture = " +item1.getDatefoManufacture());
        System.out.println("Purchase Price ($) = " +item1.getPurchasePrice());
        System.out.println("Selling Price ($) = " +item1.getSellingPrice());
        System.out.println("Profit made ($) = " +item1.calcProfit());
        System.out.println("Weight (gm)= " +item1.getWeight());
    }
}

class item{
    private String name;
    private double purchasePrice;
    private double sellingPrice;
    private String datefoManufacture;
    private double weight;

    public item (String theName,  double thePurchasePrice, double theSellingPrice, String theDateofManufacture,  double theWeight){
	name = theName;
	purchasePrice = thePurchasePrice;
	sellingPrice = theSellingPrice;
	datefoManufacture = theDateofManufacture;
	weight = theWeight;
    }  

    public String getName(){
        return name;
    }
    
    public double getPurchasePrice(){
        return purchasePrice;
    }
    
    public double getSellingPrice(){
        return sellingPrice;
    }
    public String getDatefoManufacture(){
        return datefoManufacture;
    }
    public double getWeight(){
        return weight;
    }

    public double calcProfit(){
        double profit = sellingPrice - purchasePrice ;
        return profit;
    }
    
    public void changeName(String theName){
        name = theName ;
    }
    
    public void changePurchasePrice(double thePurchasePrice){
        purchasePrice = thePurchasePrice;
    }

    public void changeSellingPrice (double theSellingPrice){
        sellingPrice= theSellingPrice ;
}

        
}