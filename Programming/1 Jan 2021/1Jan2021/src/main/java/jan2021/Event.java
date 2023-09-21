package jan2021;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Event {
    static List<String> list=new ArrayList<String>();
    static int lastSerNo=1;
    public static void readFile(){
        String line = "";  
        String splitBy = ",";  
        BufferedReader br;  

        try {
            br = new BufferedReader(new FileReader("events.csv"));
            while ((line = br.readLine()) != null){   //returns a Boolean value  
                String[] employee = line.split(splitBy);    // use comma as separator  
                list.add(employee[0]);
                list.add(employee[1]);
                list.add(employee[2]);
                list.add(employee[3]);
                list.add(employee[4]);
                lastSerNo=Integer.parseInt(employee[0]);
            } 
        } catch (Exception ex) {
            System.out.println(ex.getMessage());;
        }
    }
    
    public static List getEventsList(){
        if(list.isEmpty()){
            System.out.println("null");
            readFile();
        }
        return list;
    }
    
    public static void setList(List<String> newList){
        list.clear();
        list=newList;
        System.out.println("in setlist");
    }

    public static void writeEventsList(String[] data){
        
        //list = readFile();
        list.add(String.valueOf(++lastSerNo));
        list.add(data[0]);
        list.add(data[1]);
        list.add(data[2]);
        list.add(data[3]);
        
    }
    
    public static boolean deleteEventFromList(String eventNametoDelete){
        boolean eventFound=false;
        for (int i=0;i<list.size();i=i+5){
            System.out.println(list.get(i+1));
            if(list.get(i+1).trim().equalsIgnoreCase(eventNametoDelete)){
                System.out.println("removing "+list.get(i)+"removing "+list.get(i+1)+"removing "+list.get(i+2)+"removing "+list.get(i+3)+"removing "+list.get(i+4));
                list.remove(i);
                list.remove(i+1);
                list.remove(i+2);
                list.remove(i+3);
                list.remove(i+4);
                eventFound=true;
            }
        }
        if(eventFound==true){
            return true;
        }else{
            return false;
        }
    }
            
}
