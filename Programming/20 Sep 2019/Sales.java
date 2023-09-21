package Sales;
//Imports used in the code
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


//Sales class for getting user input and alloting sales to products
public class Sales {
    //Class variables for all products
    static double TV_sales;
    static double VCR_sales;
    static double CDPlayers_sales;
    static double IPod_sales;
    static double Remotes_sales;
    
    //Main method
    public static void main(String[] args){
        //Without creating an instance accessing the input method
        //to get the sale values for a week of all products
        new Sales().Get_Input();
        //Passing all the class variables to client class for generating report
        new client(TV_sales, VCR_sales, CDPlayers_sales, IPod_sales, Remotes_sales);
    }
    //Empty default constructor
    public Sales(){
        
    }
    //Customized constructor for alloting values to class variables
    public Sales(String name, double sales){
        if(name.equals("TV")) this.TV_sales=sales;
        else if(name.equals("VCR")) this.VCR_sales=sales;
        else if(name.equals("CDPlayer")) this.CDPlayers_sales=sales;
        else if(name.equals("IPod")) this.IPod_sales=sales;
        else if(name.equals("Remote")) this.Remotes_sales=sales;
        else System.out.println("Wrong input");
        //System.out.println(this.TV_sales);
    }
    //Method to get input from user and passing it to sales method
    public static void Get_Input(){
        //Instance of scanner class for user input, user input is in string format
        Scanner console=new Scanner(System.in);
        System.out.print("Value of TV's sold this week? ");
        //Converting the string input to double and passing it to sales method with product name
        new Sales("TV",Double.parseDouble(console.nextLine()));
        System.out.print("Value of VCR's sold this week? ");
        //Converting the string input to double and passing it to sales method with product name
        new Sales("VCR",Double.parseDouble(console.nextLine()));
        System.out.print("Value of CDPlayers sold this week? ");
        //Converting the string input to double and passing it to sales method with product name
        new Sales("CDPlayer",Double.parseDouble(console.nextLine()));
        System.out.print("Value of IPod's sold this week? ");
        //Converting the string input to double and passing it to sales method with product name
        new Sales("IPod",Double.parseDouble(console.nextLine()));
        System.out.print("Value of Remotes sold this week? ");
        //Converting the string input to double and passing it to sales method with product name
        new Sales("Remote",Double.parseDouble(console.nextLine()));
    }
    
}

//Client class for generating report
class client{
    //Default constructor
    public client(){
        
    }
    //Customized constructor
    public client(double TV, double VCR, double CDPlayer, double IPod, double Remote){
        //Getting total sales
        double Total=TV+VCR+CDPlayer+IPod+Remote;
        //Generating report
        System.out.println("\n\n\nABC Electronic Sales");
        //Getting present date
        String timeStamp = new SimpleDateFormat("MMM dd, yyyy").format(Calendar.getInstance().getTime());
        System.out.println("Date: "+timeStamp );
        System.out.println("Description\t\tSales");
        System.out.println("TV\t\t\t$"+TV);
        System.out.println("VCR\t\t\t$"+VCR);
        System.out.println("CD Player\t\t$"+CDPlayer);
        System.out.println("IPod\t\t\t$"+IPod);
        System.out.println("Remote Control\t\t$"+Remote);
        System.out.println("\t\t\t________");
        System.out.println("\t\tTotal\t$"+Total+"\n\n\n");
        
    }
}
