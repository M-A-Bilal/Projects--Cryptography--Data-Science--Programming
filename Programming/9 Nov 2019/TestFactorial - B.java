package TestFactorial;
public class TestFactorial{
    public static void main(String[] arg){
        int x = 4;
	String fact;
		
	Factorial f = new Factorial(4);
		
	if (f.positive()){
            fact = f.calculateFactorial ();
            f.getUnderline();
            System.out.println(fact);
	}
	else
            System.out.println("Factorial cannot be calculated");
    }	
}



class Factorial{
    int 	n;
    long fact, sum;
    String result ;

    Factorial(int x){	
        n = x;
        fact = 1;
        sum = 0;
        result = "";
    }
	
    boolean positive(){
        return (n >= 0) ;
    }
	
    String  calculateFactorial(){	
        int x = n;
        result = "n\tFactorial\tSum\n";
        while (n > 1){
            fact = fact * n;
            sum = sum + fact;
            result = result + n + "\t" + fact + "\t\t" + sum +"\n";
            n = n - 1;
            if(n==1){
                result=result+"****************************\nThe sum of n! factorial is "+sum;
            }
	}
	return result;	
    }
	
    String getUnderline(){
        String str = "";
        int i = 0;
	do{
            str = str + "*";
	}
		
        while(++i < 10);
            str = str + "\n";
		
        return str;
    }
}
