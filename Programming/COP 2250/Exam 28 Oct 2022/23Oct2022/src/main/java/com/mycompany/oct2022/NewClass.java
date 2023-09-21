package com.mycompany.oct2022;

import java.util.Scanner;

public class NewClass {
    public static void main(String[] args) {
        /*int input = 5;
        if (input > 0){
            while(input != 0){
                if (input % 2 == 1){
                    input--;
                }
                else{
                    input = input / 2;
                    System.out.println("halves the input");
                }
            }
        }
        System.out.println("input is " + input);
        */
        
        /*
        int i; int j;
        for(i = 0; i < 4; i++){
            for(j = i; j < 4 + i; j++)
                System.out.print("*");
            System.out.println();
        }
        */
        /*
        for(int i = 20; i < 30; i = i + 5)
            System.out.print(i + " ");
        */
        /*
        int i = 0;
        while (i < 12) {
            i++;
            System.out.print("B");
            if (i == 2 && i == 4)
                continue;
            if (i == 6)
                break;
            System.out.print("E");
        }
        */
        /*
        String data = "monarchy";
        int i;
        for(i = data.length() - 1; i >=0; i--){
            switch(data.charAt(i)){
                case 'a':
                    System.out.print("X");
                    break;
                case 'h':
                        System.out.print("Y");
                        break;
                default:
                    System.out.print("Z");
            }
        }
        */
        /*
        int[] numbers = {5, 6, 7, 8, 1, 2};
for(int i = numbers.length - 1; i > - 1; i -= 2){
System.out.print(numbers[i]);
}
*/
        /*
        int[] number = {6, 5, 4, 3, 9, 8, 7, 2, 1, 0};
int i;
for(i = 1; i <= number.length; i++)
if(i % 4 != 0)
System.out.print(number[i-1] );
else
System.out.print(",");
*/
        
        Scanner s = new Scanner(System.in);
        int i = 0;
        while(i<5 || i>20){
            System.out.println("Enter a number between 5 and 20 : ");
            i = s.nextInt();
        }
        System.out.println("Square root of number is : " + Math.sqrt(i));
        
        
    }    
}
