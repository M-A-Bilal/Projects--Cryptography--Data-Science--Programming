import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

class Preprocessor { 
    public static boolean balance_Chek(String input) { 
        Stack<Character> stack = new Stack<Character>();
        for(int i =0; i< input.length(); i++) { 
            Character charac = input.charAt(i);
            if(charac == '[' || charac == '{' || charac == '(' || charac=='/') { 
                switch(charac) { 
                    case '[':  
                    case '{': 
                    case '(': 
                        stack.push(charac);
                        break; 
                    case '/':                         
                        if(input.charAt(i +1)=='*') stack.push(charac);
                    default: 
                        break;
                }
            }else if(charac == ']' || charac == '}' || charac == ')' || charac=='*'){ 
                switch(charac) {  
                    case ']': 
                        if (stack.pop() != '[') 
                            return false;                         
                        break; 
                    case '}': 
                        if (stack.pop() != '{')
                            return false; 
                        break; 
                    case ')': 
                        if (stack.pop() != '(') 
                            return false; 
                        break; 
                    case '*': 
                        if(input.charAt(i +1 )=='/') 
                            if (stack.pop() != '/') 
                                return false; 
                        break; 
                    default: 
                        break;
                }
            }
        }
        if(stack.isEmpty())return true; 
        return false; 
    }
} 

public class MyPreprocessor { 
    public static void main (String [] args) throws FileNotFoundException, IOException { 
        FileReader file_reader=new FileReader("src/input.txt"); 
        BufferedReader buffered_reader=new BufferedReader(file_reader); 
        Preprocessor pre_process = new Preprocessor(); 
        String input; 
        while((input=buffered_reader.readLine())!=null) {
            if(pre_process.balance_Chek(input)) System.out.println("Input: \""+input +"\" is balanced");
            else System.out.println("Input: \""+input +"\" is not balanced");
        }
    }
}