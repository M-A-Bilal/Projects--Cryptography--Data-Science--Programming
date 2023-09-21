/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jan2021;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ahmad
 */
public class test {
    public static void main(String[] args) throws Exception  {  
        //parsing a CSV file into Scanner class constructor  
        Scanner sc = new Scanner(new File("events.csv"));  
        /*sc.useDelimiter(",");   //sets the delimiter pattern  
        while (sc.hasNext()){  //returns a boolean value    
            System.out.print(sc.next());  //find and returns the next complete token from this scanner  
        }   
        sc.close();  //closes the scanner  */
        int lastSerNo=1;
        List<String> list=new ArrayList<String>();
        String line = "";  
        String splitBy = ",";  
        BufferedReader br = new BufferedReader(new FileReader("events.csv"));  
        while ((line = br.readLine()) != null){   //returns a Boolean value  
            String[] employee = line.split(splitBy);    // use comma as separator  
            //System.out.println("Employee [First Name=" + employee[0] + ", Last Name=" + employee[1] + ", Designation=" + employee[2] + ", Contact=" + employee[3] + ", Salary= " + employee[4] + "]");  
            System.out.println(employee[0]+"   "+employee[1]+"   "+employee[2]+"   "+employee[3]+"   "+employee[4]);
            list.add(employee[0]);
            list.add(employee[1]);
            list.add(employee[2]);
            list.add(employee[3]);
            list.add(employee[4]);
            lastSerNo=Integer.parseInt(employee[0]);
        }  
        
        System.out.println(lastSerNo);
        /*
        //Creating Array  
        String[] array={"Java","Python","PHP","C++"};  
        System.out.println("Printing Array: "+Arrays.toString(array));  
        //Converting Array to List  
        List<String> list=new ArrayList<String>();  
        for(String lang:array){  
        list.add(lang);  
        }  
        
        System.out.println("Printing List: "+list.get(0));  
*/
    }  
}
