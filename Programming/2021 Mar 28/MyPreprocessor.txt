import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

public class MyPreprocessor { 
    public static void main (String [] args) throws Exception { 
        Preprocessor pp;
        FileReader fr;
        String text; 
        BufferedReader br;
        pp = new Preprocessor(); 
        fr = new FileReader("input.txt"); 
        br = new BufferedReader(fr); 
        boolean result;
        while((text=br.readLine())!=null) {
            result = pp.check_stmt_bal(text);
            if(result) {
                System.out.println(text +" is balanced");
            }
            else {
                System.out.println(text +" is not balanced");
            }
        }
    }
}

class Preprocessor { 
    public static boolean check_stmt_bal(String text) { 
        Stack<Character> stk = new Stack<Character>();
        for(int i =0; i< text.length(); i++) { 
            Character ch = text.charAt(i);
            if(ch == '*' || ch == ')' || ch == ']' || ch=='}'){ 
                switch(ch) { 
                    case '*': 
                        if(text.charAt(i +1 )=='/') 
                            if (stk.pop() != '/') 
                                return false; 
                        break; 
                    case ')': 
                        if (stk.pop() != '(') 
                            return false; 
                        break; 
                    case ']': 
                        if (stk.pop() != '[') 
                            return false;                         
                        break; 
                    case '}': 
                        if (stk.pop() != '{')
                            return false; 
                        break; 
                    default: 
                        break;
                }
            }else if(ch == '/' || ch == '(' || ch == '[' || ch=='{') { 
                switch(ch) { 
                    case '/':                         
                        if(text.charAt(i +1)=='*'){
                            stk.push(ch);
                        }
                        break;
                    case '(': 
                        stk.push(ch);
                        break; 
                    case '[':  
                        stk.push(ch);
                        break;
                    case '{': 
                        stk.push(ch);
                        break;
                    default: 
                        break;
                }
            }
        }
        if(stk.isEmpty()){
            return true;
        } 
        return false; 
    }
} 