package com.mycompany.pa4grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GradeBook { // class name
    public static final int STUDENTS_LIMIT =100; // max students in the class
    public static void main(String[] args) throws IOException { // main method
        String[] firstNames = new String [STUDENTS_LIMIT]; // array of first names
        String[] lastNames = new String [STUDENTS_LIMIT]; // array of last names
        int[] pIDs = new int [STUDENTS_LIMIT]; // array of IDs
        int[] grades = new int [STUDENTS_LIMIT]; // array of grades
        int numberOfStudents = 0; // var to keep track of no of students whose record is entered
        Scanner input = new Scanner(System.in); //scanner object to get input
        System.out.println("This program keeps grades of students and provides accurate stats!!!\n" +
                            "Please enter the information of the first student using the following format:\n" +
                            "\\firstName lastName PID grade\"."); // welcome msg
        while(true){ //loop to get students data
            BufferedReader bi = new BufferedReader(new InputStreamReader(System.in)); // object to get input from user
            String[] strNums; // array to store user input initially
            strNums = bi.readLine().split(" "); // splitting user input through white spaces and storing at diff places in an array
            if (strNums[0].equalsIgnoreCase("done")) break; //end the loop when done is entered by the user
            firstNames[numberOfStudents] = strNums[0]; //storing the values in respective array
            lastNames[numberOfStudents] = strNums[1]; //storing the values in respective array
            pIDs[numberOfStudents] = Integer.parseInt(strNums[2]); //storing the values in respective array
            grades[numberOfStudents] = Integer.parseInt(strNums[3]); //storing the values in respective array
            System.out.println("Please enter the next student's info using the same format. If there is no\n" +
                                "more students, please enter the keyword \\DONE\"."); // msg to ask user whether data is to be entered or is completed
            numberOfStudents++; // inc the var
        }
        
        while (true){ // loop asking user for command
            System.out.println("Please enter a new command"); // msg to get new command from user
            String cmd = input.nextLine(); // storing command of user
            if (cmd.equalsIgnoreCase("average")){ // condition checking
                System.out.println("Average = " + calculateAverage(grades, numberOfStudents)); // printing average of grades after getting them from the method
            }else if (cmd.equalsIgnoreCase("min")){ // condition checking
                System.out.println("Minimum = " + calculateMinimum(grades, numberOfStudents)); // printing min grade after getting them from the method
            }else if (cmd.equalsIgnoreCase("max")){ // condition checking
                System.out.println("Maximum = " + calculateMaximum(grades, numberOfStudents)); // printing max grade after getting them from the method
            }else if (cmd.equalsIgnoreCase("grade")){ // condition checking
                System.out.println("Please enter PID: "); //asking user to enter PID whose grade the user wants
                int pid = input.nextInt();  // storing user entered PID in a var
                System.out.println("Grade of PID: " + pid +" = "+ findGrade(pIDs, grades, numberOfStudents, pid)); // printing grade after getting them from the method
            }else if (cmd.equalsIgnoreCase("name")){ // condition checking
                System.out.println("Please enter PID: ");  //asking user to enter PID whose grade the user wants
                int pid = input.nextInt(); // storing user entered PID in a var
                System.out.println("Full Name of PID: " + pid +" is "+ findFullName(firstNames, lastNames, pIDs, numberOfStudents, pid)); // printing full name after getting them from the method
            }else if (cmd.equalsIgnoreCase("quit")){ // condition checking
                break; //end the loop
            }
        }   
    }
    
    public static double calculateAverage(int[] grades, int numberOfStudents){ // method to calculate average
        //Your code comes here!
        double sum = 0; // var to store sum of grades
        for (int i=0; i<numberOfStudents; i++){ // loop to access all grades
            sum += grades[i]; // calc sum of grades
        }
        return sum/numberOfStudents; //returning average of grades
        
    }
    public static int calculateMinimum(int[] grades, int numberOfStudents){ // method to find minimum
        //Your code comes here!
        int min = grades[0]; //initializing a var with the first grade in array
        for (int i=0; i<numberOfStudents; i++){ //loop to go through all grades
            if (min > grades[i]){ // condition check if min is greater than the next value
                min = grades[i]; // change the value of min
            }
        }
        return min; // returning minimum value
    }
    public static int calculateMaximum(int[] grades, int numberOfStudents){ // method to find maximum
        //Your code comes here!
        int max = grades[0]; //initializing a var with the first grade in array
        for (int i=0; i<numberOfStudents; i++){ //loop to go through all grades
            if (max < grades[i]){ // condition check if max is less than the next value
                max = grades[i]; // change the value of max
            }
        }
        return max; //returning maximum value
    }
    public static int findGrade(int[] pIDs, int[] grades, int numberOfStudents, int pID){ // method to find grade of entered PID
        //Extra Credit! Your code comes here!
        int grade = 0; // initializing grade with zero value
        for (int i=0; i<numberOfStudents; i++){ // loop to go through all PIDs
            if (pID == pIDs[i]){ // condition check if PID match found
                grade = grades[i]; // getting the grade of required PID
                break; // ending the loop
            }
        }
        return grade; // returning the grade
    }
    public static String findFullName(String[] firstNames, String[] lastNames, int[] pIDs, int numberOfStudents, int givenPID){ // method to get full name of entered PID
        //Extra Credit! Your code comes here!
        //This method returns the full name (first + \ " + last)
        String fullName = "";  // initializing fullname with empty string
        for (int i=0; i<numberOfStudents; i++){ // loop to go through all PIDs
            if(givenPID == pIDs[i]){ // condition check if PID match found
                fullName = firstNames[i] + " " + lastNames[i]; // getting and storing first and last name
                break; // ending the loop
            }
        }
        return fullName; // returning full name
    }
}
