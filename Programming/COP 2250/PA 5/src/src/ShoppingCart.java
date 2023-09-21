public class ShoppingCart {
    Rice soldRice;
    Bread soldBread;
    Egg soldEgg;
    Caviar soldCaviar;
    Meat soldMeat;
    public void printReceipt(){
        int subTotal  = 0;
        if(soldRice != null){
            System.out.println(soldRice.getName() + ", " + soldRice.getNumberOfBags() + ": " + soldRice.getCost());
            subTotal += soldRice.getCost();
        }
        if(soldBread != null){
            //add your code here...
        }
        if(soldEgg != null){
            //add your code here...
        }
        if(soldCaviar != null){
            //add your code here...
        }
        if(soldMeat != null){
            //add your code here...
        }
        System.out.printf("Subtotal: $%.2f\n", subTotal/100.0);
        double tax = subTotal * GroceryStore.TAX_RATE / 100.0;
        System.out.printf("Tax: $%.2f\n", tax /100.0);
        double total = subTotal + tax;
        System.out.printf("Total: $%.2f\n", total/100.0);
    }

}
