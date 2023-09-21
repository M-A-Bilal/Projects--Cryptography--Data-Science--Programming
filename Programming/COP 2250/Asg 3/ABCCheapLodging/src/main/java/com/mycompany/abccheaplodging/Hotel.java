package com.mycompany.abccheaplodging;

public class Hotel{
    // Class constants
    private static final double ROOM_RATE = 79.95;
    private static final double TAX_RATE = 6.5;
    private static final double TELEPHONE = 5.75;
    private static final double MEAL_COST = 12.95;
    private static final double TIP_RATE = 0.075;
    // Instance variables
    private int noOfNights;
    private int noOfGuest;
    private double amountDue;
    private double meal;
    private double tax;
    private double subtotal;
    private double total;
    private double tip;
    private String roomNumber;
	
    public Hotel(String room){
        roomNumber = room;
        noOfGuest = 1;
        noOfNights = 1;
    }

    public Hotel(String room, int nights){
        this(room);
        noOfNights = nights;
    }

    public Hotel(String room, int nights, int guest){
        this(room, nights);
        noOfGuest = guest;
    }

    public void add(int nights){
        noOfNights = noOfNights + nights;
    }

    public void calculate(){
        amountDue = ROOM_RATE * noOfNights * noOfGuest;
        tax = amountDue * TAX_RATE/100;
        subtotal = amountDue + tax;
        meal = MEAL_COST * noOfNights;
        tip = TIP_RATE * (subtotal + meal + TELEPHONE);	
        total = subtotal + TELEPHONE + meal + tip;
    }

    //Getters / Accessor Methods for Constant class variables (I know some aren't used, but its good convention)
    public static final double getRoomRate(){return ROOM_RATE;}
    public static final double getTaxRate(){return TAX_RATE;}
    public static final double getTelephone(){return TELEPHONE;}
    public static final double getMealCost(){return MEAL_COST;}
    public static final double getTipRate(){return TIP_RATE;}

    //Getters / Accessor Methods for Instance variables
    public int getNoOfNights(){return noOfNights;}
    public int getNoOfGuests(){return noOfGuest;}
    public double getAmountDue(){return amountDue;}
    public double getMeal(){return meal;}
    public double getTax(){return tax;}
    public double getSubtotal(){return subtotal;}
    public double getTotal(){return total;}
    public double getTip(){return tip;}
    public double getTelephoneTotal(){return TELEPHONE;}
    public String getRoomNumber(){return roomNumber;}

    
}