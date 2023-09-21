package com.mycompany.grocerystore;
/*
 * This is a program written by Rashid Almerekhi
 * as a deliverable of Programming Assignment 1
 * for COP2250 - Fall 2022
 * Date: 09/20/2022
 */
import java.util.Scanner;

public class GroceryStoreCheckout { //class header
    
    public static final double TAXR_PERCENTAGE = 6.75;//This is a constant value given by the assignment specification
    public static final double RICE_PRICE_PER_POUNDS = 1.25; //This is a constant value given by the assignment specification
    public static final double EGG_PRICE_PER_DOZEN = 14.75; //This is a constant value given by the assignment specification
    public static final double BREAD_PRICE_PER_LOAF = 2.75; //This is a constant value given by the assignment specification
    
    public static void main(String[] args) { // main method header
        Scanner in = new Scanner(System.in); // scanner object for input
        //double costRicePerPound = 1.25, costEggsPerDz = 14.75, costBreadPerLoaf = 2.75, taxPercent = 6.75; //declared and initialized cost of items
        double weightRice, numberEggs, loafBread; // variables to store purchased quantity of items
        double RicePurchaseCost, EggsPurchaseCost, BreadPurchaseCost; // variables to store cost of purchased items
        double subTotal, tax, total; // variables to store tax and total amount
        System.out.println("Welcome to the checkout system of Awesome Grocery Store!\n\nPlease enter the weight of rice in pounds: "); // welcome message and message to input quantity of rice purchased
        weightRice = in.nextDouble(); // get input of rice quantity and storing it
        
        System.out.println("Now, enter the number of eggs: "); // message to input quantity of eggs purchased
        numberEggs = in.nextDouble(); // get input of number of eggs and storing it
        
        System.out.println("Now, enter the number of loafs of French bread: "); // message to input quantity of loaf of bread purchased
        loafBread = in.nextDouble(); // get input of loafs of bread and storing it
        
        RicePurchaseCost = weightRice * RICE_PRICE_PER_POUNDS; // calculating total cost of rice purchased
        EggsPurchaseCost = (numberEggs/12) * EGG_PRICE_PER_DOZEN; // calculating total cost of eggs purchased
        BreadPurchaseCost = loafBread * BREAD_PRICE_PER_LOAF; // calculating total cost of bread purchased
        subTotal = RicePurchaseCost + EggsPurchaseCost + BreadPurchaseCost; // calculating total cost of all items purchased without tax
        tax = (TAXR_PERCENTAGE/100) * subTotal; // calculating tax on all items purchased 
        total = subTotal + tax; // calculating total cost of items including tax
        
        // Receipt printing
        System.out.println("Here is your receipt:\n---------------------"); 
        System.out.printf("SUBTOTAL: $%.2f\n", subTotal);
        System.out.printf("TAX: $%.2f\n",tax);
        System.out.printf("TOTAL: $%.2f\n",total);
    }
}