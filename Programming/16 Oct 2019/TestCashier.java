package TestCashier;

import java.text.NumberFormat;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.util.Date;
import java.text.DateFormat;


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

class GetData{
    static String str;
    static double getDouble(String s){
        str = JOptionPane.showInputDialog(s);
        return Double.parseDouble(str);
    }
    
    static int getInt(String s){
        str = JOptionPane.showInputDialog(s);
        return Integer.parseInt(str);
    }
    
    static String getWord(String s){
        return JOptionPane.showInputDialog(s);
    }
}


