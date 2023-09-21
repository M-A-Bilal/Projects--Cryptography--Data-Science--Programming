package com.mycompany.abccheaplodging;
import java.util.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
	
class TestHotel{
    public static void main(String[] arg){
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        // Create customer objects, calculate amounts, display receipts
        
        Hotel customer1 = new Hotel("10 - M", 2, 2);
        customer1.calculate();
        display(customer1, nf);
        
        
        Hotel customer2 = new Hotel("12 - B");
        customer2.calculate();
        display(customer2, nf);

        Hotel customer3 = new Hotel("12 - C", 2);
        customer3.calculate();
        display(customer3, nf);
        
        //Official Use only Totals everything up
        display2(customer1, customer2, customer3, nf);
    }

    static void display(Hotel h, NumberFormat f){
        // Set up and display heading and date for each receipt
        System.out.println("\tThe ABC Cheap Lodging, Inc");
        Date d = new Date();
        DateFormat df = DateFormat.getDateInstance();
        System.out.println("\tDate: \t" + df.format(d));
        

        // Disply expenses line by line including subtotal
        System.out.println("Room# \t\t" + h.getRoomNumber());
        System.out.println("Room Rate: \t" + f.format(h.getRoomRate()));
        System.out.println("Length of stay\t" + h.getNoOfNights() + " nights");
        System.out.println("No. of guests: \t" + h.getNoOfGuests());
        System.out.println("Room cost: \t" + f.format(h.getAmountDue()));
        System.out.println("Tax : " + h.getTaxRate() + "%\t"  + f.format(h.getTax()));
        System.out.println("\tSubtotal \t" + f.format(h.getSubtotal()));
        System.out.println("Telephone \t" + f.format(h.getTelephoneTotal()));
        System.out.println("Meal charges \t" + f.format(h.getMeal()));
        System.out.println("Tip \t\t" + f.format(h.getTip()));

        //Display to total
        System.out.println("\nTOTAL AMOUNT DUE  .......  " + f.format(h.getTotal()));

        // Display thank you message
        System.out.println("\nThanks for staying at The ABC Cheap Lodging, Inc" );
        System.out.println("\tPlease come again !!!");
        System.out.println("\n");
    }
    
    //Official Use only Totals everything up
    static void display2(Hotel customer1, Hotel customer2,Hotel customer3, NumberFormat nf){
        // Complete this method so that it displays the summary amounts as shown in the output
        System.out.println();
        System.out.println("\tOFFICIAL USE ONLY");
        System.out.println("\tToday's Summary");
        System.out.println("Room\t\t\t\t...." + nf.format(customer1.getAmountDue() + customer2.getAmountDue() + customer3.getAmountDue()));
        System.out.println("Telephone\t\t\t...." + nf.format(customer1.getTelephoneTotal()+customer2.getTelephoneTotal()+customer3.getTelephoneTotal()));
        System.out.println("Meal\t\t\t\t...." + nf.format(customer1.getMeal() + customer2.getMeal() + customer3.getMeal()));
        System.out.println("Tips\t\t\t\t...." + nf.format(customer1.getTip() + customer2.getTip() + customer3.getTip()));
        System.out.println("Tax\t\t\t\t...." + nf.format(customer1.getTax() + customer2.getTax() + customer3.getTax()));
        System.out.println("-----------------------------");
        System.out.println("Gross Transaction\t\t...." + nf.format(customer1.getTotal() + customer2.getTotal() + customer3.getTotal()));
    }   
}