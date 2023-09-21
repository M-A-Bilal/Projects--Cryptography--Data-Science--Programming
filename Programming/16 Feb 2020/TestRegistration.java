package TestRegistration;
public class TestRegistration {
    public static void main(String arg[]){
        System.out.println("The number of children registerd :"+Registration.getCount()); 
        Registration r1 = new Registration("James","Berrisford", "William");
        System.out.println(r1.getFirst() + ","+ r1.getLast()+ " is registered");
        System.out.println("The number of children registered: " +Registration.getCount());
        r1.changeLast("Bellami"); 
        System.out.println(r1.getFirst() +","+ r1.getLast() +" is registerd");
        System.out.println("The number of children registered: " +Registration.getCount());
        
        Registration r2 = new Registration("Mary","", "Jane");
        System.out.println("The number of children registered: " +Registration.getCount());
        System.out.println(r2.getFirst() + ","+ r2.getMiddle()+ ","+ r2.getLast()+ " is registered");
        r2.changeFullName("A", "B", "C");
        System.out.println("The number of children registered: " +Registration.getCount());
        System.out.println(r2.getFirst() + ","+ r2.getMiddle()+ ","+ r2.getLast()+ " is registered");
        
        Registration r3 = new Registration("Maryln","Agnes Lucrecia", "Henry");
        System.out.println("The number of children registered: " +Registration.getCount());
        System.out.println(r3.getFirst() + ","+ r3.getMiddle()+ ","+ r3.getLast()+ " is registered");
        r3.changeFullName("X", "Y", "Z");
        System.out.println("The number of children registered: " +Registration.getCount());
        System.out.println(r3.getFirst() + ","+ r3.getMiddle()+ ","+ r3.getLast()+ " is registered");
    }
}

class Registration{
    static int totalRegistered = 0;
    String firstName = null;
    String middleName = null;
    String lastName = null;
    
    public Registration(String fName, String mName, String lName){
        if (mName != ""){
            this.middleName = mName;
        }
        this.firstName = fName;
        this.lastName = lName;
        totalRegistered ++;
    }
    
    public static int getCount(){
        return totalRegistered;
    }
    
    public String getFirst(){
        return this.firstName;
    }
    public String getMiddle(){
        if (this.middleName == null){
            return "-";
        }
        return this.middleName;
    }
    public String getLast(){
        return this.lastName;
    }
    
    public void changeLast(String lName){
        this.lastName = lName;
    }
    public void changeFullName(String fName, String mName, String lName){
        if (mName != ""){
            this.middleName = mName;
        }
        this.firstName = fName;
        this.lastName = lName;
    }
    
}
