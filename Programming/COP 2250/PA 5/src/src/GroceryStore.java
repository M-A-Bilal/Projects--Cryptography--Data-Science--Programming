import javax.swing.plaf.metal.MetalLookAndFeel;
import java.util.Scanner;
public class GroceryStore {
    public static final int CAVIAR_PRICE_PER_OUNCE = 12150;//in cents
    public static final int BREAD_PRICE_PER_LOAF = 324;//in cents
    public static final int RICE_PRICE_PER_POUND = 235;//in cents
    public static final int EGG_PRICE_PER_DOZEN = 1345;//in cents
    public static final int MEAT_PRICE_PER_POUND = 975;//in cents
    public static final double TAX_RATE = 6.75;//percentage
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        String riceName = null, eggName = null, breadName = null, caviarName = null, meatName = null;
        System.out.println("Welcome to the checkout system of Awesome Grocery Store!\n\n"
        + "Please enter the number of 10lbs rice bags: ");
        ShoppingCart cart = new ShoppingCart();
        int bagsOfRice = keyboard.nextInt();
        if(bagsOfRice > 0) {
            System.out.println("Now, enter the name of picked rice:");
            riceName = keyboard.next();
            cart.soldRice = new Rice(riceName, bagsOfRice, RICE_PRICE_PER_POUND);
        }
        System.out.println("Now, enter the number of eggs:");
        int numberOfEggs = keyboard.nextInt();
        if(numberOfEggs > 0) {
            System.out.println("Now, enter the name of picked egg:");
            eggName = keyboard.next();
            cart.soldEgg = new Egg(eggName, numberOfEggs, EGG_PRICE_PER_DOZEN);
        }
        System.out.println("Now, enter the number of loaves of bread:");
        int numberOfBreadLoaves = keyboard.nextInt();
        if(numberOfBreadLoaves > 0) {
            System.out.println("Now, enter the name of picked bread:");
            breadName = keyboard.next();
            cart.soldBread = new Bread(breadName, numberOfBreadLoaves, BREAD_PRICE_PER_LOAF);
        }
        System.out.println("Now, enter the weight of caviar in ounce:");
        double caviarWeight = keyboard.nextDouble();
        if(caviarWeight > 0) {
            System.out.println("Now, enter the name of picked caviar:");
            caviarName = keyboard.next();
            cart.soldCaviar = new Caviar(caviarName, caviarWeight, CAVIAR_PRICE_PER_OUNCE);
        }
        System.out.println("Now, enter the weight of meat in pounds:");
        double meatWeight = keyboard.nextDouble();
        if(meatWeight > 0) {
            System.out.println("Now, enter the name of picked meat:");
            meatName = keyboard.next();
            cart.soldMeat = new Meat(caviarName, caviarWeight, MEAT_PRICE_PER_POUND);
        }
        cart.printReceipt();
    }
}
