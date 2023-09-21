package COP2250PA5;

public class Meat {
    private int pricePerPound;//in cents! For example, $2.45 is represented by 245.
    private String name;//e.g. organic tenderlion beaf
    private double weight;//Meat is sold by weight.
    
    public Meat(String meatName, double meatWeight, int MEAT_PRICE_PER_POUND){ //constructor setting values of class variables
        this.name=meatName;
        this.weight=meatWeight;
        this.pricePerPound=MEAT_PRICE_PER_POUND;
    }
    
    public String getName(){ //getter method to get name
        return this.name;
    }
    
    public double getWeightInPounds(){ //getter method to get quantity
        return this.weight;
    }
    
    public int getCost(){ //getter method to get cost
        return this.pricePerPound;
    }
}
