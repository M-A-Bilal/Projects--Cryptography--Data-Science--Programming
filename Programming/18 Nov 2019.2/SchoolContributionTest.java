package SchoolContributionTest;
import java.awt.Component;
import java.text.NumberFormat;
import javax.swing.JOptionPane;

public class SchoolContributionTest {
    public static void main(String[] args) {
        SchoolContribution s = new SchoolContribution();
        Component frame = null;
        while (s. hasNotMadeTarget() && s.hasMoreTime()){
            s.addContribution(Double.parseDouble(JOptionPane.showInputDialog("Make contribution")));
        }
        if (s.metTarget ()){
            System.out.println(s);
            
            JOptionPane.showMessageDialog(frame, s+"\nCongrats, you made it.");
        }
        else{
            System.out.println("We did not make the target" + "\nSorry we cannot go on the trip\n" + s);
            JOptionPane.showMessageDialog(frame, s +"\nWe did not make the target" + "\nSorry we cannot go on the trip\n");
        }
    }
}


class SchoolContribution{
    static final byte  DAYS = 30;
    static final float TARGET = 5000;
    int day;
    double totalContribution;
    String s;
    NumberFormat df;
    public SchoolContribution(){
        totalContribution = 0;
        day = 0;
        s = "Day \t\tDaily Contribution\t\tTotal Contribution\n";
        df = NumberFormat.getCurrencyInstance();
    }
    
    public void addContribution(double amount){
        totalContribution = totalContribution + amount;
        day = day + 1;
        s = s + day + "\t\t\t    " + df.format(amount);
        s = s + "\t\t\t    " + df.format(totalContribution) + "\n";
    }
    
    public boolean hasNotMadeTarget(){
        return totalContribution < TARGET;
    }
    
    public boolean hasMoreTime(){
        return day < DAYS;
    }
    
    public boolean metTarget (){
        return day <= DAYS && totalContribution >= TARGET;
    }
    
    public String toString(){
        return s;
    }
}