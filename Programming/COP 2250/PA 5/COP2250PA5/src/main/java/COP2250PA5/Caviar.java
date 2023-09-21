package COP2250PA5;

public class Caviar {
    private int pricePerOunce;//in cents! For example, $56.75 is represented by 5675.
    private String name;//e.g. Caspian five-star Caviar!
    private double weightInOunce;//e.g. 3.5 Ozs
    
    public Caviar(String caviarName, double caviarWeight, int CAVIAR_PRICE_PER_OUNCE){ //constructor setting values of class variables
        this.name=caviarName;
        this.weightInOunce=caviarWeight;
        this.pricePerOunce=CAVIAR_PRICE_PER_OUNCE;
    }

    public String getName(){ //getter method to get name
        return this.name;
    }
    
    public double getWeightInOunce(){ //getter method to get quantity
        return this.weightInOunce;
    }
    
    public int getCost(){ //getter method to get cost
        return this.pricePerOunce;
    }
}
