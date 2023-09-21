package com.mycompany.cashier;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class TestCashier{
    public static void main(String[] arg){
        Cashier c = new Cashier();
        String name = GetData.getWord("Enter name of item");
        double price = GetData.getDouble("Enter price of item");
        c.Add(name, price);
        name = GetData.getWord("Enter name of item");
        price = GetData.getDouble("Enter price of item");
        c.Add(name, price);
        name = GetData.getWord("Enter name of item");
        price = GetData.getDouble("Enter price of item");
        c.Add(name, price);

        // Add a two more entries of your own

        // Now average the price of the items
        c.average();

        // Make payment
        double amount = GetData.getDouble("Enter amount of money for payment");
        c.tendered(amount);

        c.makeChange();

        generateReceipt(c);

    }
    static void generateReceipt(Cashier c){
        String r = "Classic Groceries Shop \n";
        r = r + "Welcome – thanks for stopping, \n";
        DateFormat df = DateFormat.getDateInstance();
        Date d = new Date();
        NumberFormat f = NumberFormat.getCurrencyInstance();
        r = r + "Today is " + df.format(d) + "\n\n";
        r = r + c.getNames();
        r = r + "____________________" + "\n";
        r = r + "Total " + f.format(c.getTotal()) + "\n\n";
        
        r = r + "There were " + c.getQuantity() + " items" + "\n";
        r = r + "The average price is " + f.format(c.getAverage()) + "\n\n";
        
        r = r + "Amount tendered " + f.format(c.getMoney()) + "\n";
        r = r + "The change is " + f.format(c.getChange()) + "\n\n";
        
        r = r + "The change includes :" + "\n";
        r = r + c.getDollars() + " dollars" + "\n" + c.getQuarters()+ " quarters" + "\n" + c.getDimes()+ " dimes" + "\n" + c.getNickels()+ " nickels" + "\n" + c.getPennies() + " cents";
        JTextArea text = new JTextArea(r,15, 25);
        JScrollPane pane = new JScrollPane(text);
        JOptionPane.showMessageDialog(null,pane, "Your bill", JOptionPane.INFORMATION_MESSAGE);
    }
}
