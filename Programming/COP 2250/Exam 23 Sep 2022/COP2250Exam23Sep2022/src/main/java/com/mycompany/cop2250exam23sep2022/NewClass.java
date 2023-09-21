package com.mycompany.cop2250exam23sep2022;

import java.util.Scanner;

public class NewClass {
    public static void main(String[] args) {
        //int num =6;
        //double Num =4.5;
        //System.out.printf("%d %.2f %d", num/(int)Num,num/Num, (int)(Num/num));
    
    
        //String message = "greetings";
        //System.out.println(message.charAt(6));
        
        
        //System.out.println("Hello World!
        //        ");
        
        
        //System.out.printf("%.3f", Math.pow(4 - 3 * 2, 5 - 3 * 1));
        
        
        //System.out.printf("%d", (int)12.5%8);
        
        
        /*Scanner keyboard = new Scanner(System.in);
        int number = keyboard.nextInt();
        if (number>=0 && number <=4){
            System.out.println("weekday");
        }else if(number==5 || number==6){
            System.out.println("weekend");
        }else{
            System.out.println("Invalid");
        }*/
        
        
        /*Scanner keyboard = new Scanner(System.in);
        int number = keyboard.nextInt();
        
        switch (number){
            case 0:
                System.out.println("Monday");
                break;
            case 1:
                System.out.println("Tuesday");
                break;
            case 2:
                System.out.println("Wednesday");
                break;
            case 3:
                System.out.println("Thursday");
                break;
            case 4:
                System.out.println("Friday");
                break;
            case 5:
                System.out.println("Saturday");
                break;
            case 6:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid");
        }*/
        
        
        
        Scanner keyboard = new Scanner(System.in);
        int number = keyboard.nextInt();
        
        if (number>=0){
            System.out.printf("%.2f", Math.sqrt(number));
        }else{
            System.out.println(number*number);
        }
                
    }
}

