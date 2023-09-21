package com.mycompany.cop2250sevensegment;

import java.util.Scanner;

// class header
public class SevenSegmentDisplay { 
    // main method
    public static void main(String[] args) { 
        // welcome message
        System.out.println( "Welcome to my 7-segment display!"); 
        // Scanner class object for user input
        Scanner input = new Scanner(System.in); 
        // a char to check whether user wants to continue or not
        char exit = 'n'; 
        
        // loop will start since initially the user is not asked about exit variable
        while (exit == 'n' || exit == 'N'){ 
            int h_len = 0;
            while(h_len < 3 || h_len > 40){
                // message asking user to enter horizontal length
                System.out.println( "Please enter the length of horizontal segments (from 3 to 40): "); 
                // initializing horizontal length var and storing the user value in it
                h_len = input.nextInt(); 
                // initializing vertical length var with 0 value and digit var with value 10
                int v_len = 0, digit = 10; //
                // condition statement to check correctness of horizontal length var
                if (h_len >= 3 && h_len <= 40){
                    // loop will start initially since vertical length value is 0 and will keep iterating till correct ver length is not entered
                    while(v_len < 3 || v_len > 40 || h_len > v_len*2 || 2*h_len < v_len){
                        // message asking user to enter vertical length
                        System.out.println( "Please enter the length of vertical segments (from 3 to 40): ");
                        // storing user input in vertical length var
                        v_len = input.nextInt();
                        // condition checking if vertical length is between 3-40
                        if (v_len >= 3 && v_len <= 40){
                            // condition checking if the length of vertical segment is greater than twice the length of horizontal segment or less than half of the length of horizontal segment,
                            if (h_len > v_len*2 || 2*h_len < v_len){
                                // error message if the length is not correct
                                System.out.println("Length is not acceptable try entering the length again");
                            // else statement is correct vertical length is entered
                            }else{
                                // loop will keep iterating till correct digit value is not entered
                                while(digit<0 || digit>9){
                                    // message to enter digit to be printed
                                    System.out.println("Enter a digit: ");
                                    // getting user input and storing it in digit variable
                                    digit = input.nextInt();
                                    // condition checking if a single digit is entered or not
                                    if (digit<0 || digit>9){
                                        // error message if user has entered multiple digits or below 0 value
                                        System.out.println("input is not acceptable, try entering the digit again");
                                    // if user has entered correct digit value
                                    }else{
                                        // calling print method and passing all three vars
                                        print(h_len, v_len, digit);

                                    }
                                }
                            }
                        // if user has entered out of limit vertical value
                        }else{
                            // error message for wrong vertical value
                            System.out.println("Length is not acceptable try entering the length again");
                        }
                    }
                // if user has entered out of limit horizontal value
                }else{
                    // error message for wrong horizontal value
                    System.out.println("Length is not acceptable try entering the length again");
                }
            }
            // message for user if he/ she wants to continue or not
            System.out.println("Do you want to exit? (y=yes, n=no): ");
            // storing the choice of user in exit var
            exit = input.next().charAt(0);
        }
    }
    
    //print method to print the digit using 7 segment display
    public static void print(int v_len, int h_len, int digit){
        // switch is used since all digit are going to use different segments for displaying
        switch(digit){
            // if digit to be printed is 0
            case 0:
                // printing horizontal lines
                System.out.print("   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                //printing vertical lines
                System.out.print("\n ");
                for(int i=0; i<v_len; i++){
                    System.out.print("||");
                    for(int j=0; j<h_len; j++){
                        System.out.print(" ");
                    }
                    System.out.print("||\n ");
                }
                
                //printing vertical lines
                System.out.print("\n\n ");
                for(int i=0; i<v_len; i++){
                    System.out.print("||");
                    for(int j=0; j<h_len; j++){
                        System.out.print(" ");
                    }
                    System.out.print("||\n ");
                }
                
                // printing horizontal lines
                System.out.print("  ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                break;
                
            // if digit to be printed is 1
            case 1:    
                //printing vertical lines
                System.out.println(" ");
                for(int i=0; i<v_len; i++){
                    System.out.print(" ");
                    for(int j=0; j<h_len; j++){
                        System.out.print(" ");
                    }
                    System.out.print("||\n");
                }
                
                //printing vertical lines
                System.out.println("\n ");
                for(int i=0; i<v_len; i++){
                    System.out.print(" ");
                    for(int j=0; j<h_len; j++){
                        System.out.print(" ");
                    }
                    System.out.print("||\n");
                }
                break;
            
            // if digit to be printed is 2
            case 2:
                // printing horizontal lines
                System.out.print("   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                //printing vertical lines
                System.out.print("\n ");
                for(int i=0; i<v_len; i++){
                    for(int j=0; j<h_len; j++){
                        System.out.print(" ");
                    }
                    System.out.print("  ||\n ");
                }
                
                // printing horizontal lines
                System.out.print("  ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                //printing vertical lines
                System.out.print("\n");
                for(int i=0; i<v_len; i++){
                    System.out.println(" ||");
                }
                
                // printing horizontal lines
                System.out.print("   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                System.out.println("");
                break;
            
            // if digit to be printed is 3
            case 3:
                // printing horizontal lines
                System.out.print("   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                //printing vertical lines
                System.out.print("\n ");
                for(int i=0; i<v_len; i++){
                    for(int j=0; j<h_len; j++){
                        System.out.print(" ");
                    }
                    System.out.print("  ||\n ");
                }
                
                // printing horizontal lines
                System.out.print("  ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                //printing vertical lines
                System.out.print("\n ");
                for(int i=0; i<v_len; i++){
                    for(int j=0; j<h_len; j++){
                        System.out.print(" ");
                    }
                    System.out.print("  ||\n ");
                }
                
                // printing horizontal lines
                System.out.print("  ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                System.out.println("");
                break;
            
            // if digit to be printed is 4
            case 4:
                //printing vertical lines
                System.out.print("\n ");
                for(int i=0; i<v_len; i++){
                    System.out.print("||");
                    for(int j=0; j<h_len; j++){
                        System.out.print(" ");
                    }
                    System.out.print("||\n ");
                }
                
                // printing horizontal lines
                System.out.print("  ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                //printing vertical lines
                System.out.print("\n ");
                for(int i=0; i<v_len; i++){
                    for(int j=0; j<h_len; j++){
                        System.out.print(" ");
                    }
                    System.out.print("  ||\n ");
                }
                break;
            
            // if digit to be printed is 5
            case 5:
                // printing horizontal lines
                System.out.print("   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                //printing vertical lines
                System.out.print("\n ");
                for(int i=0; i<v_len; i++){
                    System.out.print("||\n ");
                }
                
                // printing horizontal lines
                System.out.print("  ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                //printing vertical lines
                System.out.print("\n ");
                for(int i=0; i<v_len; i++){
                    for(int j=0; j<h_len; j++){
                        System.out.print(" ");
                    }
                    System.out.print("  ||\n ");
                }
                
                // printing horizontal lines
                System.out.print("  ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                System.out.println("");
                break;
            
            // if digit to be printed is 6
            case 6:
                // printing horizontal lines
                System.out.print("   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                //printing vertical lines
                System.out.print("\n ");
                for(int i=0; i<v_len; i++){
                    System.out.print("||\n ");
                }
                
                // printing horizontal lines
                System.out.print("  ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                //printing vertical lines
                System.out.print("\n ");
                for(int i=0; i<v_len; i++){
                    System.out.print("||");
                    for(int j=0; j<h_len; j++){
                        System.out.print(" ");
                    }
                    System.out.print("||\n ");
                }
                
                // printing horizontal lines
                System.out.print("  ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                System.out.println("");
                break;
            
            // if digit to be printed is 7
            case 7:
                // printing horizontal lines
                System.out.print("   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                //printing vertical lines
                System.out.print("\n ");
                for(int i=0; i<v_len; i++){
                    //System.out.print("||");
                    for(int j=0; j<h_len; j++){
                        System.out.print(" ");
                    }
                    System.out.print("  ||\n ");
                }
                
                //printing vertical lines
                System.out.print("\n ");
                for(int i=0; i<v_len; i++){
                    for(int j=0; j<h_len; j++){
                        System.out.print(" ");
                    }
                    System.out.print("  ||\n ");
                }
                break;
            
            // if digit to be printed is 8
            case 8:
                // printing horizontal lines
                System.out.print("   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                //printing vertical lines
                System.out.print("\n ");
                for(int i=0; i<v_len; i++){
                    System.out.print("||");
                    for(int j=0; j<h_len; j++){
                        System.out.print(" ");
                    }
                    System.out.print("||\n ");
                }
                
                // printing horizontal lines
                System.out.print("  ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                //printing vertical lines
                System.out.print("\n ");
                for(int i=0; i<v_len; i++){
                    System.out.print("||");
                    for(int j=0; j<h_len; j++){
                        System.out.print(" ");
                    }
                    System.out.print("||\n ");
                }
                
                // printing horizontal lines
                System.out.print("  ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                System.out.println("");
                break;  
            
            // if digit to be printed is 9
            case 9:
                // printing horizontal lines
                System.out.print("   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                //printing vertical lines
                System.out.print("\n ");
                for(int i=0; i<v_len; i++){
                    System.out.print("||");
                    for(int j=0; j<h_len; j++){
                        System.out.print(" ");
                    }
                    System.out.print("||\n ");
                }
                
                // printing horizontal lines
                System.out.print("  ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                //printing vertical lines
                System.out.print("\n ");
                for(int i=0; i<v_len; i++){
                    for(int j=0; j<h_len; j++){
                        System.out.print(" ");
                    }
                    System.out.print("  ||\n ");
                }
                
                // printing horizontal lines
                System.out.print("  ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                
                // printing horizontal lines
                System.out.print("\n   ");
                for(int j=0; j<h_len; j++){
                    System.out.print("-");
                }
                System.out.println("");
                break;
            default: // default doing nothing
                
        }
    }
}