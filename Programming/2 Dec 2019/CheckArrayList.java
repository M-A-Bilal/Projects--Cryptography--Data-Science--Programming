package CheckArrayList;

import java.util.ArrayList;

public class CheckArrayList {
    public static void main(String[] arg){
        ArrayList list = new ArrayList();
        display(list);
        list.add("A");
        list.add(0,"B");
        list.add(1, "C");
        list.add(new Product("Chair", 249.99));
        list.add(new Integer(25));
        display(list);
        
        list.add("A");
        list.add(0,"B");
        list.add(1, "C");
        display(list);
        list.remove(1);
        list.add("D");
        list.get(2);
        display(list);
        
        double x = Double.valueOf(3.75);
        list.add(x);
        char p = new Character('a');
        list.add(p);
        display(list);
        
    }
    
    static void display(ArrayList list){
        System.out.println("The size of the list is " + list.size());
        System.out.println("The list is empty " + list.isEmpty());
        System.out.println();
        for (int i = 0; i < list.size(); i++){
            Object o = list.get(i);
            if (o instanceof String)
                System.out.println("This object " + (String)o + " is a string " );
            else if (o instanceof Integer)
                System.out.println("This object " + (Integer)o + " is an integer " );
            else if (o instanceof Double)
                System.out.println("This object " + (Double)o + " is a double " );
            else if (o instanceof Character)
                System.out.println("This object " + (Character)o + " is a character " );
            else if (o instanceof Product)
                System.out.println("This object " + ((Product) o).getName() + " is a product " );
        }
    }
}


class Product{
    String name;
    double price;
    Product(String s, double p){
        name = s;
        price = p;
    }
    String getName(){
        return name;
    }
}