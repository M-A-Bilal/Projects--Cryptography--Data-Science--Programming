package Main;

import java.io.*;
import java.util.*;

/**
 * For saving and fetching lists of places from files
 */

public class Storage {
    
    public void writeListToFile(List<String> places, String filename) {
        FileWriter writer = null; 
        try {
            writer = new FileWriter(filename);
            for(String str: places) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public List<String> readListFromFile(String filename) {
        
        List<String> placesFromFile =new ArrayList<String>();
        File file = new File(filename); 
        BufferedReader br; 
        try {
            br = new BufferedReader(new FileReader(file));
            String st; 
            while ((st = br.readLine()) != null)
                placesFromFile.add(st);
            return placesFromFile;
        } catch (Exception ex) {
            //System.out.println(ex.getMessage());
            return placesFromFile;
        }
    }
}
