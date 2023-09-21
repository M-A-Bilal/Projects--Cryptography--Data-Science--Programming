package TestPetrol;
import javax.swing.JOptionPane;
public class TestPetrol{
    public static void main(String[] arg){
	String str = JOptionPane.showInputDialog("COP2210 Petrol Station"
                                                + "\nEnter the type of petrol"
                                                + "\nR - for regular gas"
                                                + "\nP - for premium gas"
                                                + "\nS - for super gas");
	char ch = str.charAt(0);	
	str = JOptionPane.showInputDialog("Enter the amount of gas to be purchased");
	float amount = Float.parseFloat (str);
        Petrol p = new Petrol(ch, amount);
	p.calculateCost();
	JOptionPane.showMessageDialog(null, p.toString()); 
    }
}


class Petrol{
    char gas;
    String type, free;
    
    static final float REGULAR_GAS 	= 2.99f;
    static final float PREMIUM_GAS	= 3.15f;
    static final float SUPER_GAS		= 3.25f;
	
    static final String REGULAR_WASH =  "You get free wash excluding under carriage and wheels";
    static final String PREMIUM_WASH = "You get free wash excluding under carriage";
    static final String SUPER_WASH = "You get free super wash";
    
    static final String NO_REWARD = "You do not get any free reward";

    double amount, cost;
    Petrol(char ch, double a){
        gas = ch;
	amount = a;
    }
	
    void calculateCost(){	
	switch(gas){
            case 'r':
            case 'R': 
                	type = "Regular";
                 cost = amount * REGULAR_GAS;
                    if (amount >= 10) free = REGULAR_WASH;
                    else free = NO_REWARD;
		break;
            case 'p':
            case 'P': 
		type = "Premium";
                 cost = amount * PREMIUM_GAS;
                    if (amount >= 10)free = PREMIUM_WASH;
                    else free = NO_REWARD;
		break;
            case 's':
            case 'S': 
		type = "Super";
                cost = amount * SUPER_GAS;
                    if (amount >= 10)free = SUPER_WASH;
                    else free = NO_REWARD;
		break;
            default:
		type = "Unknown";
		break;
	}
    }
    public String toString(){
        if (type.equals("Unknown"))
            return "Petrol is " + type + " cannot be served";
	else
            return "The type of petrol that will be served is " + type 
		+"\nYour bill is: $" + cost + "\n" +  free;
    }
}

