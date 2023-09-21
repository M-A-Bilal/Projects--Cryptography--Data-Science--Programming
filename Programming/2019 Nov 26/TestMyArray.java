package TestMyArray;
public class TestMyArray {
    public static void main(String []args){
        int[] arr = {1, 2, 3, 4, 6};
        MyArray MyArr = new MyArray(arr);
        System.out.println(arr);
        MyArr.reverse();
        System.out.println("Sum is = "+MyArr.sum());
        System.out.println("Average is = "+MyArr.average());
        System.out.println(MyArr.search(3));
        System.out.println("Smallest number is = "+MyArr.findSmallest());
        
    }
}

class MyArray{
    int original[], length;
	
    MyArray(int[] a){
        this.original = a;
        this.length = a.length;
    }
    void reverse(){
	int[] b = new int[length]; 
        int j = length; 
        for (int i = 0; i < length; i++) { 
            b[j - 1] = original[i]; 
            j = j - 1; 
        } 
  
        /*printing the reversed array*/
        System.out.println("Reversed array is: \n"); 
        for (int k = 0; k < length; k++) { 
            System.out.println(b[k]); 
        } 

    }
    int sum(){
        int sum = 0; // initialize sum 
        int i; 
        
        // Iterate through all elements and add them to sum 
        for (i = 0; i < length; i++) 
            sum +=  original[i]; 
        
        return sum; 
    }
    int average(){
        // Find sum of array element 
        int sum = 0; 
        for (int i=0; i<length; i++) 
        sum += original[i]; 
        
        return sum/length;	
    }
	
    boolean search(int key){
        // if array is Null 
        if (original == null) { 
            return false; 
        } 

        int i = 0; 
  
        // traverse in the array 
        while (i < length){ 
  
            // if the i-th element is t 
            // then return the index 
            if (original[i] == key) { 
                return true; 
            } 
            else { 
                i = i + 1; 
            } 
        } 
        return false; 	
    }	
	
    int findSmallest(){ // The will find the smallest value in an array
        /* There should be atleast two elements */
        if (length < 1){ 
            System.out.println(" Invalid Input "); 
            return -1; 
        } 
  
        int smallest  = Integer.MAX_VALUE; 
        for (int i = 0; i < length ; i ++){ 
            if (original[i] < smallest)
                smallest = original[i]; 
        } 
        
        if (smallest == Integer.MAX_VALUE)
            return -1;
        else
            return smallest;

    }
}
