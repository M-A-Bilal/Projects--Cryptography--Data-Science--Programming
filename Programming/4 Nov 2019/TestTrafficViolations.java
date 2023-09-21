package TestTrafficViolations;

import java.util.*;
import java.lang.*;
import java.io.*;

public class TestTrafficViolations{
    public static void main(String args[]){
        TrafficViolations a = null;
        a.trafficviolation();
    }
}

class TrafficViolations{
    public static void trafficviolation(){
        int speed, lic, registration, insurance, location;
        double fine = 0, sfine=0;
        String court = "", warning = "";
        
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you have license (1/0) 1 for yes or 0 No ( for No driver license $25.00)");
        lic=scan.nextInt();
        
        System.out.println("Tag expired (1/0) 1 for yes or 0 No ( for Expired tag $20.00)");
        int tag=scan.nextInt();
        
        System.out.println("Do you have Registration (1/0) 1 for yes or 0 No ( No registration $20.00)");
        registration=scan.nextInt();
        
        System.out.println("Do you have Insurance(1/0) 1 for yes or 0 No (No insurance $10.00)");
        insurance=scan.nextInt();
        
        if(lic==0) fine=fine+25;
        if(tag==1) fine=fine+20;
        if(registration==0)fine=fine+20;
        if(insurance==0) fine=fine+10;
        
        //Moving Violation
        //Speeding violation or speeding in construction zone
        System.out.println("Enter Speed ");
        speed =scan.nextInt();
        System.out.println("Enter location (Enter 1/0) if school area 1 otherwise zero ");
        location= scan.nextInt();
        
        switch(location){
                case 0:
                    //Miles 0ver the Speed Limit
                    if(speed>=1 &&speed <=5 ) warning = "Warning for Speed Limit violation, please drive below the speed limit.";
                    if(speed>6 &&speed <=9 )sfine=sfine+130.00;
                    if(speed>10 && speed <=14 )sfine=sfine+205.00;
                    if(speed>=15 && speed<=19 )sfine=sfine+405.00;
                    if(speed>20 && speed<=29 )sfine=sfine+455.00;
                    if(speed>30){
                        sfine=sfine+605.00;
                        court = "Court appearance.";
                    }                               
                    break;
                case 1:
                    //Speeding in school zone or speeding within a toll facility
                    if (speed>=1 &&speed <=5 && location ==1) sfine=sfine+155.00;
                    if (speed>6 && speed <=9 && location ==1 ) sfine=sfine+255.00;
                    if (speed>10 && speed <=14 && location ==1 )sfine=sfine+305.00;
                    if (speed>15 && speed <=19 && location ==1)sfine=sfine+405.00;
                    if (speed>20 && speed <=29 && location ==1)sfine=sfine+455.00;                   
                    break;
                default:
                    break;
        }
        System.out.println("Fine for Non Moving Violation = "+fine+"$");
        if(court.equals("") && warning.equals("")){
            System.out.println("Fine for Moving Violation = "+sfine+"$");
            System.out.println("Fine for Non Moving + Moving Violation = "+(fine+sfine)+"$");
        }else{
            System.out.println("Fine for Moving Violation = "+sfine+"$ and "+court+warning);
            System.out.println("Fine for Non Moving + Moving Violation = "+(fine+sfine)+"$ and "+court+warning);
        }
        
    }
}
