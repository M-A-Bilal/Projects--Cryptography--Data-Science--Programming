package com.mycompany.cop2250pa6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Grade {
    public static void main(String[] args){
        ArrayList<Student> students = new ArrayList<>();
        
        System.out.println("Welcometomygradebookversion2!\n" +
                            "Please enter the information of the first student using the following format:\n" +
                            "\\firstName lastName PID grade\".\n"+
                            "Press Enter when you are done"); // welcome msg
        while(true){ 
            try {
                //loop to get students data
                BufferedReader bi = new BufferedReader(new InputStreamReader(System.in)); // object to get input from user
                String[] strNums; // array to store user input initially
                strNums = bi.readLine().split(" "); // splitting user input through white spaces and storing at diff places in an array
                if (strNums[0].equalsIgnoreCase("done")) break; //end the loop when done is entered by the user
                if(Integer.parseInt(strNums[2])>9999999 
                        || Integer.parseInt(strNums[2])<1000000 
                        || Integer.parseInt(strNums[3])>100 
                        || Integer.parseInt(strNums[3])<0){ //checking corectness of PID and grade
                    throw new Exception(); // if found incorrect an exception is thrown
                }
                Student stud = new Student(strNums[0], strNums[1], Integer.parseInt(strNums[2]), Integer.parseInt(strNums[3])); //making a student object to store it in arraylist
                students.add(stud); //adding student object to arraylist
                System.out.println("Please enter the next student's info using the same format. \n"
                        + "If there is no more students, please enter the keyword \\DONE\".\n"
                        + "Press Enter when you are done."); // msg to ask user whether data is to be entered or is completed
                
            } catch (Exception ex) { //catching all exceptions
                System.out.println("Please try again using correct format"); //printing error message
            }
        }
        
        while (true){ try {
            // loop asking user for command
            BufferedReader bi = new BufferedReader(new InputStreamReader(System.in)); // object to get input from user
            System.out.println("Please enter a new command"); // msg to get new command from user
            String[] strNums = bi.readLine().split(" "); // splitting user input through white spaces and storing at diff places in an array
            String cmd = strNums[0]; // storing command of user
            if (cmd.equalsIgnoreCase("average")){ // condition checking
                System.out.println("Average = " + findAverage(students)); // printing average of grades after getting them from the method
            
            }else if (cmd.equalsIgnoreCase("min")){ // condition checking
                System.out.println("Minimum = " + findMinimum(students)); // printing min grade after getting them from the method
            
            }else if (cmd.equalsIgnoreCase("max")){ // condition checking
                System.out.println("Maximum = " + findMaximum(students)); // printing max grade after getting them from the method
            
            }else if (cmd.equalsIgnoreCase("grade")){ // condition checking
                //System.out.println("Please enter PID: "); //asking user to enter PID whose grade the user wants
                int pid = Integer.parseInt(strNums[1]);  // storing user entered PID in a var
                if (pid>9999999 || pid<1000000) throw new Exception(); //exception is thrown if pid is out of limit
                int grd = findGrade(students, pid); // storing grade in a var
                if (grd==-1) System.out.println("PID not found"); //msg printing if pid is not found
                else System.out.println("Grade of PID: " + pid +" = "+ grd); // printing grade after getting them from the method
            
            }else if (cmd.equalsIgnoreCase("name")){ // condition checking
                //System.out.println("Please enter PID: ");  //asking user to enter PID whose grade the user wants
                int pid = Integer.parseInt(strNums[1]); // storing user entered PID in a var
                if (pid>9999999 || pid<1000000) throw new Exception();  //exception is thrown if pid is out of limit
                System.out.println("Full Name of PID: " + pid +" is "+ findFullName(students, pid)); // printing full name after getting them from the method
            
            }else if (cmd.equalsIgnoreCase("change")){ // condition checking
                //System.out.println("Please enter PID: ");  //asking user to enter PID whose grade the user wants
                int pid = Integer.parseInt(strNums[1]); // storing user entered PID in a var
                if (pid>9999999 || pid<1000000) throw new Exception(); //exception is thrown if pid is out of limit
                int grade = Integer.parseInt(strNums[2]); // storing user entered PID in a var
                if (grade>100 || grade<0) throw new Exception(); //exception is thrown if grade is out of limit
                System.out.println("Full Name of PID: " + pid +" is "+ changeGrade(students, pid, grade)+" and grade has been updated"); // printing full name after getting them from the method
            
            }else if (cmd.equalsIgnoreCase("quit")){ // condition checking
                break; //end the loop
            }
            } catch (Exception ex) {//catching all exceptions
                System.out.println("Please try again using correct format"); //printing error message
            }
        }
    }
    
    public static double findAverage (ArrayList<Student> students){ //method to find average of grades
        //Yourcodecomeshere!
        double size=students.size(), SumOfGrades=0; //vars to store size of arraylist and the other will store grades 
        for(int i=0; i<size; i++) SumOfGrades += students.get(i).getGrade(); //loop to get grades of all students and adding and storing them
        
        return SumOfGrades/size; //returning average of grades
    }
    public static int findMinimum(ArrayList<Student> students){ //method to find minimum grade among all students
        //Yourcodecomeshere!
        int size=students.size(), MinGrade=students.get(0).getGrade(); //vars to store size of arraylist and the other will store grade of first student
        for(int i=0; i<size; i++){ //loop to iterate through all grades
            if(MinGrade > students.get(i).getGrade()) MinGrade = students.get(i).getGrade(); //condition checking if prev stored is lesser or greater than new grade            
        }
        return MinGrade; //returing the minimum grade
    }
    public static int findMaximum(ArrayList<Student> students){ //method to find maximum grade among all students
        //Yourcodecomeshere!
        int size=students.size(), MaxGrade=students.get(0).getGrade();//vars to store size of arraylist and the other will store grade of first student
        for(int i=0; i<size; i++){//loop to iterate through all grades
            if(MaxGrade < students.get(i).getGrade()) MaxGrade = students.get(i).getGrade();//condition checking if prev stored is lesser or greater than new grade
        }
        return MaxGrade;//returing the maximum grade
    }
    public static int findGrade(ArrayList<Student> students,int givenPID){ //method to find a grade of student using pid
        //Yourcodecomeshere!
        for(int i=0; i<students.size(); i++){ //loop to iterate through all pid's
            if(givenPID == students.get(i).getPID()) return students.get(i).getGrade(); //if pid found return its grade
        }
        return -1; //if pid not found return -1
    }
    public static String findFullName(ArrayList<Student> students,int givenPID){ //method to find full name of using pid
        //Yourcodecomeshere!
        //This methodreturnsthefullname(first+\"+last)
        for(int i=0; i<students.size(); i++){//loop to iterate through all pid's
            if(givenPID == students.get(i).getPID()) return students.get(i).getFullName(); //if pid found return its full name
        }
        return "Student of given PID not found"; //return msg if pid not found
    }
    public static String changeGrade(ArrayList<Student> students,int givenPID, int newGrade){ //method to change grade
        //Yourcodecomeshere!
        //This methodreturnsthefullname(first+\"+last)
        for(int i=0; i<students.size(); i++){ //loop to iterate through all pid's
            if(givenPID == students.get(i).getPID()){ // condition checking if PID found
                students.get(i).setGrade(newGrade); //setting new grade
                return students.get(i).getFullName(); //after setting returning full name of student
            }
        }
        return "Student of given PID not found"; //return msg if pid not found
    }
}

class Student{ //class header
    private String firstName; //class var storing first name of student
    private String lastName; //class var storing last name of student
    private int pID; //class var storing PID of student
    private int grade; //class var storing grade of student
    public Student(String givenFirstName,String givenLastName,int givenPID, int givenGrade){ //customized constructor
        //implementthisconstructorproperly...
        this.firstName=givenFirstName; //setting class vars values
        this.lastName=givenLastName; //setting class vars values
        this.pID=givenPID; //setting class vars values
        this.grade=givenGrade; //setting class vars values
    }
    public String getFullName(){ //method to get full name
        //implement this method properly...returns first+\"+lastnames.
        return this.firstName+" "+this.lastName; //returning full name
    }
    public int getGrade(){ //method to get grade 
        //implementthismethodproperly
        return this.grade; //returning grade
    }
    public int getPID(){ //method to get PID
        //implementthismethodproperly
        return this.pID; //returning PID
    }
    public void setGrade(int newGrade){ //method to set the grade
        //implementthismethodproperly...
        this.grade=newGrade; //setting the grade
    }
}