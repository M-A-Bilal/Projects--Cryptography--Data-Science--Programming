package COP2250PA5;

public class ShoppingCart {
    Rice soldRice;
    Bread soldBread;
    Egg soldEgg;
    Caviar soldCaviar;
    Meat soldMeat;
    public void printReceipt(){
        int subTotal  = 0;
        if(soldRice != null){
            System.out.println(soldRice.getName() + ", " + soldRice.getNumberOfBags() + ": " + soldRice.getCost()); //print rice name quantity and cost
            subTotal += soldRice.getCost() * soldRice.getNumberOfBags() * 10; //calculating cost of rice purchased and adding them to subtotal
        }
        if(soldBread != null){
            //add your code here...
            System.out.println(soldBread.getName() + ", " + soldBread.getNumberOfLoaves() + ": " + soldBread.getCost()); //print bread name quantity and cost
            subTotal += soldBread.getCost() * soldBread.getNumberOfLoaves(); //calculating cost of bread purchased and adding them to subtotal
        }
        if(soldEgg != null){
            //add your code here...
            System.out.println(soldEgg.getName() + ", " + soldEgg.getNumberOfEggs() + ": " + soldEgg.getCost());//print eggs name quantity and cost
            subTotal += (soldEgg.getCost()/12) * soldEgg.getNumberOfEggs(); //calculating cost of Eggs purchased and adding them to subtotal
        }
        if(soldCaviar != null){
            //add your code here...
            System.out.println(soldCaviar.getName() + ", " + soldCaviar.getWeightInOunce() + ": " + soldCaviar.getCost()); //print caviar name quantity and cost
            subTotal += soldCaviar.getCost() * soldCaviar.getWeightInOunce(); //calculating cost of Caviar purchased and adding them to subtotal
        }
        if(soldMeat != null){
            //add your code here...
            System.out.println(soldMeat.getName() + ", " + soldMeat.getWeightInPounds() + ": " + soldMeat.getCost()); //print meat name quantity and cost
            subTotal += soldMeat.getCost() * soldMeat.getWeightInPounds(); //calculating meat of rice purchased and adding them to subtotal
        }
        System.out.printf("Subtotal: $%.2f\n", subTotal/100.0);
        double tax = subTotal * GroceryStore.TAX_RATE / 100.0;
        System.out.printf("Tax: $%.2f\n", tax /100.0);
        double total = subTotal + tax;
        System.out.printf("Total: $%.2f\n", total/100.0);
    }
}
