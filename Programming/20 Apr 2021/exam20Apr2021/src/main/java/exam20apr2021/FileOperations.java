package exam20apr2021;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class FileOperations {
    String fileName;
    public FileOperations(String str){
        fileName = str;
        LineNumberReader LNR;
    }
    
    public void readFile(){
        try {  
            FileInputStream fis=new FileInputStream(fileName);       
            Scanner sc=new Scanner(fis);
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();    
        }catch(IOException e) {
            e.printStackTrace();  
        }  
    }
    
    public boolean fileExists(){
        File file = new File(fileName);
        boolean exists = file.exists();
        return exists;
    }
     public long fileSize() throws Exception{
         FileInputStream fileinputstream = new FileInputStream(fileName);
         long size = fileinputstream.getChannel().size();
         return size;
     }
     
     public String fileName(){
         return fileName;
     }
     
}
