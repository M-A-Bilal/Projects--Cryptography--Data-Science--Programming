package COP2250PA5;

public class Bread {
    private int pricePerLoaf;//in cents! For example, $2.45 is represented by 245.
    private String name;//e.g. French baguette
    private int count;//bread is sold by number of loaves.
    
    public Bread(String breadName, int numberOfBreadLoaves, int BREAD_PRICE_PER_LOAF){ //constructor setting values of class variables
        this.name=breadName; 
        this.count=numberOfBreadLoaves;
        this.pricePerLoaf=BREAD_PRICE_PER_LOAF;
    }
    
    public String getName(){ //getter method to get name
        return this.name;
    }
    
    public int getNumberOfLoaves(){ //getter method to get quantity
        return this.count;
    }
    
    public int getCost(){ //getter method to get cost
        return this.pricePerLoaf;
    }
}
