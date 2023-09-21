import java.util.Scanner;


class petClient{
    //Variables
    private static String day, time, PetName, PetParentName, type, injuryPlace, illnessType;
    
    public void Add(String day, String time, String PetName, String PetParentName, String type, String injuryPlace, String illnessType){
        this.day=day;
        this.time=time;
        this.PetName=PetName;
        this.PetParentName=PetParentName;
        this.type=type;
        this.injuryPlace=injuryPlace;
        this.illnessType=illnessType;
    }
    
    public String getDay(){
        return this.day;
    }
    public String getTime(){
        return this.time;
    }
    public String getPetName(){
        return this.PetName;
    }
    public String getPetParentName(){
        return this.PetParentName;
    }
    public String getType(){
        return this.type;
    }
    public String getInjuryPlace(){
        return this.injuryPlace;
    }
    public String getIllnessType(){
        return this.illnessType;
    }
    
    
    
}




public class vetExam{
    public static void main(String[] arg){
        String day, time, PetName, PetParentName, type, injuryPlace, illnessType;
        petClient pc = new petClient();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter day: ");
        day = in.nextLine();
        
        System.out.println("Enter time: ");
        time = in.nextLine();
        
        System.out.println("Enter pet name: ");
        PetName = in.nextLine();
        
        System.out.println("Enter pet parent name: ");
        PetParentName = in.nextLine();
        
        System.out.println("Enter type (cat or dog): ");
        type = in.nextLine();
        
        System.out.println("Enter injury place on body: ");
        injuryPlace = in.nextLine();
        
        System.out.println("Enter illness type: ");
        illnessType = in.nextLine();
        
        pc.Add(day, time, PetName, PetParentName, type, injuryPlace, illnessType);
        System.out.println(pc.getDay()+" "+pc.getTime()+" "+pc.getPetName()+" "+pc.getPetParentName()+" "+pc.getType()+" "+pc.getInjuryPlace()+" "+pc.getIllnessType());
       
    }
}