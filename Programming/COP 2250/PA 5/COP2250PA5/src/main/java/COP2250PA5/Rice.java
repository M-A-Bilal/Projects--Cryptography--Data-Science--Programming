package COP2250PA5;

public class Rice {
    private int pricePerPound;//in cents! For example, $2.45 is represented by 245.
    private String name;//e.g. Indian Basmati Rice
    private int numberOfBags;//Rice is sold in bags of size 10lbs.
    
    public Rice(String riceName, int bagsOfRice, int RICE_PRICE_PER_POUND){ //constructor setting values of class variables
        this.name=riceName;
        this.numberOfBags=bagsOfRice;
        this.pricePerPound=RICE_PRICE_PER_POUND;
    }
    
    public String getName(){ //getter method to get name
        return this.name;
    }
    
    public int getNumberOfBags(){ //getter method to get quantity
        return this.numberOfBags;
    }
    
    public int getCost(){ //getter method to get cost
        return this.pricePerPound;
    }
}
