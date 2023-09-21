package jan2021;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class EventManagement {
    
    
    public EventManagement(){
    }
    
    public static boolean deleteEvent(String eventName){
        return Event.deleteEventFromList(eventName);
        
        
    }
    
    public static String[] searchEventName(String event){
        String[] eventSearched=new String[4];
        List <String> list = Event.getEventsList();
        boolean eventFound = false;
        for(int i =0; i<list.size();i=i+5){
            if(list.get(i+1).trim().equalsIgnoreCase(event)){
                eventSearched[0]=list.get(i+1);
                eventSearched[1]=list.get(i+2);
                eventSearched[2]=list.get(i+3);
                eventSearched[3]=list.get(i+4);
                System.out.println(eventSearched);
                eventFound=true;
            }
        }
        if(eventFound) return eventSearched;
        else return null;
        
    }
    
    public static List <String> searchEventFees(double fees){
        List <String> eventSearched=new ArrayList<String>();
        List <String> list = Event.getEventsList();
        boolean eventFound = false;
        for(int i =0; i<list.size();i=i+5){
            if(Double.parseDouble(list.get(i+4).trim()) <= fees){
                eventSearched.add(list.get(i+1));
                eventSearched.add(list.get(i+2));
                eventSearched.add(list.get(i+3));
                eventSearched.add(list.get(i+4));
                System.out.println(eventSearched);
                eventFound=true;
            }
        }
        if(eventFound) return eventSearched;
        else return null;
        
    }
    
    
    
}
