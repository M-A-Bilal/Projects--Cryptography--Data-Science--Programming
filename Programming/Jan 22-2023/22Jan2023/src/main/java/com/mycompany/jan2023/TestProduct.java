package com.mycompany.jan2023;

import java.text.*;
import javax.swing.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class TestProduct{
    // Get the date
   static SimpleDateFormat Date_Format = new SimpleDateFormat("MM/dd/yyyy");
   public static void main(String args[]) throws ParseException{
       // Declare variables
       String Address_street, Address_city, Address_state, Address_zip, Company_Name, Product_Name, DateOfManufacture;
       int Product_Quantity;
       double Product_Price;
       Product product;
       Manufacturer manufacturer;
       Address Full_Address;
       Database Product_Data = new Database();
       Database Deleted_Product_Data = new Database();
       Date current;
       boolean isDone = false;
       int subMenu;
       // loop until, the program is done
       while (!isDone){
           // prompt the user for the menu
           int selectedMenu = GetData.get_Int(
                   "Welcome to Inventory\n"
                           + "\t1. Create\n"
                           + "\t2. Update (Quantity/Price)\n"
                           + "\t3. Remove\n"
                           + "\t4. Search product\n"
                           + "\t5. Inventory Report\n"
                           + "\t6. List of Deleted Products\n"
                           + "\t7. Quit");
           // Switch for menu
           switch (selectedMenu){
           case 1://add items
               // Get user input regarding product
               Product_Name = GetData.get_String("Enter product name: ");
               Product_Quantity = GetData.get_Int("Enter the quantity of product: ");
               Product_Price = GetData.get_Double("Enter the unit price of product(in $): ");
               Company_Name = GetData.get_String("Enter the name of the manufacturer company: ");
               Address_street = GetData.get_String("Enter street address of company: ");
               Address_city = GetData.get_String("Enter city address of company: ");
               Address_state = GetData.get_String("Enter state address of company: ");
               Address_zip = GetData.get_String("Enter ZIP code of company: ");
               DateOfManufacture = GetData.get_String("Enter date of manufacturing product in the form of(MM/dd/yyyy): ");
               Full_Address = new Address(Address_street, Address_city, Address_state, Address_zip);
               manufacturer = new Manufacturer(Company_Name, Full_Address);
               current = Date_Format.parse(DateOfManufacture);
               product = new Product(Product_Name, Product_Quantity, Product_Price, current, manufacturer);
               // add the product to the data base
               Product_Data.add(product);
               break;
           
           case 2://Update product data
               // Get what to update
               Product_Name = GetData.get_String("Enter name of the product to update: ");
               subMenu = GetData.get_Int("Enter 1 or 2: \n"
                       + "1. Update quantity\n"
                       + "2. Update price\n");
               // search product
               Product_Data.search(Product_Name);
               if (!Product_Data.inList()){//if product is not found
                   JOptionPane.showMessageDialog(null, "Product does not exists.");
               }else{//if product is found
                   switch (subMenu){
                   case 1: //Update product Product_Quantity
                       int menuOpt = GetData.get_Int("Enter 1 or 2: \n"
                               + "1. Add quantity\n"
                               + "2. Remove quantity\n");
                       int addRDeductQuant;
                       // Condition to check for the valid input
                       if (menuOpt < 1 || menuOpt > 2){//Invalid input
                           JOptionPane.showMessageDialog(null, "Please choose the correct choice");
                       }
                       else{//Valid input
                           switch (menuOpt){
                           case 1://Add Product_Quantity
                               addRDeductQuant = GetData.get_Int("Enter quantity to add: ");
                               // Update the product in the database
                               product = Product_Data.getProduct();
                               product.update_Product_Quantity(addRDeductQuant);
                               JOptionPane.showMessageDialog(null,"Record updated successfully.");
                               break;
                           case 2://Remove Product_Quantity
                               addRDeductQuant = GetData.get_Int("Enter quantity to remove: ");
                               // Update the product in the database
                               product = Product_Data.getProduct();
                               if (product.get_Product_Quantity()-addRDeductQuant<0){
                                   JOptionPane.showMessageDialog(null,"Entered quantity exceeds quantity in the inventory.");
                               }else{
                                   product.update_Product_Quantity(addRDeductQuant * -1);
                                   JOptionPane.showMessageDialog(null,"Record updated successfully.");
                               }
                               break;
                           }
                           
                       }
                       break;
                   case 2://Update the price
                       // Get new price
                       double priceToUpdate = GetData.get_Double("Enter the unit price of product to update: ");
                       // Price validation
                       if (priceToUpdate < 0){
                           JOptionPane.showMessageDialog(null,"Price of the product is not updated.");
                       }else{
                           // Update the database
                           product = Product_Data.getProduct();
                           product.update_Product_Price(priceToUpdate);
                           JOptionPane.showMessageDialog(null,"Price updated successfully.");
                       }
                       break;
                   default:
                       JOptionPane.showMessageDialog(null,"Invalid option");
                   }
               }
               break;
              
           case 3://Delete product
               // Get product name
               Product_Name = GetData.get_String("Enter product name: ");
              
               // Get product from database
               Product_Data.search(Product_Name);
               if (Product_Data.inList()){//if product exists
                   int index = Product_Data.getIndex();
                   // Add the product to the deleted database
                   Deleted_Product_Data.add(Product_Data.getProduct());
                   // delete the product from the product database
                   Product_Data.delete(index);
                   JOptionPane.showMessageDialog(null, "Product deleted successfully.");
               }else JOptionPane.showMessageDialog(null, "Product not found.");//if product does not exists
               
               break;
              
           case 4://Search product
               Product_Name = GetData.get_String("Enter product name: ");
              
               // Search database for the product
               Product_Data.search(Product_Name);
               if (Product_Data.inList()){ //If product exists
                   Display_Single_Product(Product_Data.getProduct(),JOptionPane.INFORMATION_MESSAGE);
               }else JOptionPane.showMessageDialog(null, "Product not found."); //If product does not exists
               
               break;
              
           case 5: //Inventory report
               if (Product_Data.getList() != null){ // If inventory has some records
                   Display_Product_Inventory(Product_Data,JOptionPane.INFORMATION_MESSAGE);
               }else JOptionPane.showMessageDialog(null,"No products present."); //If no record exists
               
               break;
               
           case 6: //Deleted products
               if (Deleted_Product_Data.getList() != null){ //If deleted database has some records
                   Display_Product_Inventory(Deleted_Product_Data,JOptionPane.INFORMATION_MESSAGE);
               }else JOptionPane.showMessageDialog(null,"No products present.");//If no record exists
               
               break;
               
           case 7://Exit
               isDone = true;
               break;
              
           default: //Other than 1-7 input
               JOptionPane.showMessageDialog(null,"Unable to process the option selected from the menu list.");
           }
       }
   }
   // Get product info into a specific format
   public static String ProductInfo_Format(Product info){
       String ProdInfo = String.format("%30s", info.get_Product_Name());
       ProdInfo += String.format("%30s", Date_Format.format(info.get_Product_Date()));
       ProdInfo += String.format("%30s", info.get_Manufacturer().get_Company_Name());
       return ProdInfo;
   }
   // Get deleted products list
   public static void Deleted_Prod_Display(Database productDB,int Type_Message){
       String inventResult = null;
       ArrayList<Product> prodList = productDB.getList();
       inventResult += String.format("%30s %30s %30s", "Product","Purchase Date", "Manufacturer");
       for (int i = 0; i < productDB.size(); i++){
           inventResult += ProductInfo_Format(prodList.get(i)) + "\n";
       }
       JTextArea text = new JTextArea(inventResult, 10, 50);
       JScrollPane pane = new JScrollPane(text);
       JOptionPane.showMessageDialog(null, pane, "Deleted Inventory Details", Type_Message);
   }
   // Display inventory
   public static void Display_Product_Inventory(Database productDB, int Type_Message){
       String inventResult = "";
       ArrayList<Product> prodList = productDB.getList();
       inventResult += String.format("%-30s \t%s %10s %15s %20s %15s\n","Product", "Purchase Date", "Quantity", "Price($)", "Manufacturer", "State");
       for (int i = 0; i < productDB.size(); i++){
           inventResult += prodList.get(i).get_Product_Infomation() + "\n";
       }
       JTextArea text = new JTextArea(inventResult, 10, 60);
       JScrollPane pane = new JScrollPane(text);
       JOptionPane.showMessageDialog(null, pane, "Inventory Details", Type_Message);
   }
   // Single product info
   public static void Display_Single_Product(Product product, int Type_Message){
       String Product_Info = "Product Name: " + product.get_Product_Name() + "\n";
       Product_Info += String.format("Unit Price: $%.2f", product.get_Product_Price()) + "\n";
       Product_Info += "Quantity: " + product.get_Product_Quantity() + "\n";
       JTextArea text = new JTextArea(Product_Info, 10, 30);
       JScrollPane pane = new JScrollPane(text);
       JOptionPane.showMessageDialog(null, pane, product.get_Product_Name() + " Details", Type_Message);
   }
}

// Product database class
class Database{
   private ArrayList<Product> list;
   private Product prod;
   private int index;
   private boolean found;
   public Database(){
       list = new ArrayList<Product>();
       prod = null;
       index = 0;
       found = false;
   }
   // Product search method
   public void search(String key){
       found = false;
       int i = 0;
       while (!found && i < list.size()){
           Product b = list.get(i);
           if (b.get_Product_Name().equalsIgnoreCase(key)){
               prod = b;
               found = true;
               index = i;
           }
           else i++;
       }
   }
   // Add the product to the database
   public void add(Product newProduct){
       list.add(newProduct);
   }
   // Remove the product from the database
   public Product delete(int i){
       return list.remove(i);
   }
   // Get index of current product
   public int getIndex(){
       return index;
   }
   // If product in the database
   public boolean inList(){
       return found;
   }
   // Current product
   public Product getProduct(){
       return prod;
   }
   // List size
   public int size(){
       return list.size();
   }
   // If list is empty
   public boolean isEmpty(){
       return list.isEmpty();
   }
   // Get product list
   public ArrayList<Product> getList(){
       return list;
   }
}

// Product info class
class Product{
   SimpleDateFormat Date_Format = new SimpleDateFormat("MM/dd/yyyy");
   Manufacturer manufacturer;
   String Product_Name;
   int Product_Quantity;
   double Product_Price;
   Date Product_Date;
   public Product(){
       this.Product_Name = "";
       this.Product_Quantity = 0;
       this.Product_Price = 0.0;
       this.Product_Date = null;
       this.manufacturer = null;
   }
   // Customized constructor
   public Product(String prod_Name, int prod_Quantity, double prod_Price, Date product_Created, Manufacturer manufact){
       this.Product_Name = prod_Name;
       this.Product_Quantity = prod_Quantity;
       this.Product_Price = prod_Price;
       this.Product_Date = product_Created;
       this.manufacturer = manufact;
   }
  
   // Get product date
   public Date get_Product_Date(){
       return Product_Date;
   }
  
   // Add product date
   public void set_Product_Date(Date productCreated){
       this.Product_Date = productCreated;
   }
  
   // Get manufacturer
   public Manufacturer get_Manufacturer(){
       return manufacturer;
   }
  
   // Add Manufacturer
   public void set_Manufacturer(Manufacturer manufacture){
       this.manufacturer = manufacture;
   }
  
   // Get product name
   public String get_Product_Name(){
       return Product_Name;
   }
  
   // Set product name
   public void set_Product_Name(String prodName){
       this.Product_Name = prodName;
   }
  
   // Get product quantity
   public int get_Product_Quantity(){
       return Product_Quantity;
   }
  
   // Set Product Quantity
   public void set_Product_Quantity(int quantity){
       this.Product_Quantity = quantity;
   }
  
   // Get product price
   public double get_Product_Price(){
       return Product_Price;
   }
  
   // Set product price
   public void set_Product_Price(double unitPrice){
       this.Product_Price = unitPrice;
   }
  
   // Update product quantity
   public void update_Product_Quantity(int quantity_upDate){
       Product_Quantity += quantity_upDate;
   }
  
   // Updtae product price
   public void update_Product_Price(double price_upDate){
       this.Product_Price = price_upDate;
   }
  
   // Get product info
   public String get_Product_Infomation(){
       String result = "";
       result += String.format("%-30s", Product_Name);
       String dateForm = Date_Format.format(Product_Date);
       result += String.format("\t %s", dateForm);
       result += String.format("%10d", Product_Quantity);
       result += String.format("\t%15.2f", Product_Price);
       result += String.format("\t%15s", manufacturer.get_Company_Name());
       result += String.format("\t%20s", manufacturer.get_Company_Address().get_State());
       return result;
   }  
}

// Product manufacturer class
class Manufacturer{
   private String companyName;
   private Address companyAddress;
   public Manufacturer(){
       this.companyName = "";
       this.companyAddress = null;
   }
   // Customized constructor
   public Manufacturer(String compName, Address address){
       this.companyName = compName;
       this.companyAddress = address;
   }
   // Get manufacturer company name
   public String get_Company_Name(){
       return companyName;
   }
   // Set manufacturer company name
   public void set_Company_Name(String companyName){
       this.companyName = companyName;
   }
   // Get manufacturer address
   public Address get_Company_Address(){
       return companyAddress;
   }
   // Set manufacturer address
   public void set_Company_Address(Address address){
       this.companyAddress = address;
   }
}

// Manufacturer address class
class Address{
   private String street, city, state, zip;
   // Customized constructor
   public Address(String str, String city, String st, String zip){
       street = str;
       this.city = city;
       state = st;
       this.zip = zip;
   }
   // Get manufacturer street address
   public String get_Street(){
       return street;
   }
   // Get manufacturer City address
   public String get_City(){
       return city;
   }
   // Get manufacturer state address
   public String get_State(){
       return state;
   }
   // Get manufacturer zipcode
   public String get_Zip(){
       return zip;
   }
}

// Retrieve data class
class GetData{
   public static double get_Double(String s){
       return Double.parseDouble(get_Word(s));
   }
   public static int get_Int(String s){
       return Integer.parseInt(get_Word(s));
   }
   public static String get_Word(String s){
       return JOptionPane.showInputDialog(s);
   }
   public static String get_String(String s){
       return JOptionPane.showInputDialog(s);
   }
}