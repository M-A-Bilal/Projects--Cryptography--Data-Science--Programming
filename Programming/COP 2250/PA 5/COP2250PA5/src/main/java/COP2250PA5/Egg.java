package COP2250PA5;

public class Egg {
    private int pricePerDozen;//in cents! For example, $6.45 is represented by 645.
    private String name;//e.g. free range large egg
    private int count;//e.g. 10 eggs
    
    public Egg(String eggName, int numberOfEggs, int EGG_PRICE_PER_DOZEN){ //constructor setting values of class variables
        this.name=eggName;
        this.count=numberOfEggs;
        this.pricePerDozen=EGG_PRICE_PER_DOZEN;
    }
    
    public String getName(){ //getter method to get name
        return this.name;
    }
    
    public int getNumberOfEggs(){ //getter method to get quantity
        return this.count;
    }
    
    public int getCost(){ //getter method to get cost
        return this.pricePerDozen;
    }
}
