/* File: Convert.java
 * Date: 20 March 2020
 * Author: Tyler D Clark
 * Description: Method for converting postfix expressions to prefix and prefix expressions to postfix. Additionally,
 * there are two utility methods: 1. to tokenize the input string 2. check if operator or not */

package wk2;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.*;

public class Convert {
    //==========================================================================================
    //  method: fromPostfixToPrefix / arg: String / returns: String / complexity: O(n)
    //  description: converts a prefix exp to postfix, EX: A B + -> + A B
    //==========================================================================================
    public static String fromPostfixToPrefix(String expression) throws IOException, SyntaxError {
        if (!expression.equals("")){
            //tokenize the string and create stack
            List<String> expressionToArray = tokenizeExpression(expression);
            Stack<String> operandStack = new Stack<>();
            //loop through the expression array and first check for operands
            for (String token:expressionToArray) {
                if (!isOperator(token)){
                    operandStack.push(token + " ");
                }else {
                    try {//replaced many if/else statements with a try/catch which simply throws the custom exception
                        //for proper order, the second operand is the first from the stack
                        String operandTwo = operandStack.pop();
                        String operandOne = operandStack.pop();
                        String innerExpression = token + " " + operandOne + operandTwo;
                        operandStack.push(innerExpression);
                    }catch (EmptyStackException ex){
                        throw new SyntaxError("Trying to call pop on an empty stack! Please check expression.");
                    }
                }
            }
            String result = operandStack.pop();
            //check if stack is empty. If it is, return result
            if (operandStack.empty()){
                return result;
            }else { // else throw new exception
                throw new SyntaxError("Stack isn't empty! Please check expression.");
            }
        } else { //will add empty string to stack without this
            throw new SyntaxError("Please enter something!");
        }
    }
    //==========================================================================================
    //  method: fromPrefixToPostfix / arg: String / returns: String / complexity: O(n)
    //  description: converts a prefix exp to postfix, EX: + A B -> A B +
    //==========================================================================================
    public static String fromPrefixToPostfix(String expression) throws SyntaxError, IOException {
            if(!expression.equals("")){
                List<String> expressionToArray = tokenizeExpression(expression);
                Stack<String> operandStack = new Stack<>();
                //reversal of the list
                Collections.reverse(expressionToArray);
                //loop through the expression array and first check for operands
                for (String token:expressionToArray) {
                    if (!isOperator(token)){
                        operandStack.push(token + " ");
                    }else {
                        try {//replaced many if/else statements with a try/catch which simply throws the custom exception
                            String operandOne = operandStack.pop();
                            String operandTwo = operandStack.pop();
                            String innerExpression = operandOne + operandTwo + token + " ";
                            operandStack.push(innerExpression);
                        }catch (EmptyStackException ex){
                            throw new SyntaxError("Trying to call pop on an empty stack! Please check expression.");
                        }
                    }
                }
                String result = operandStack.pop();
                //check if stack is empty. If it is, return result
                if (operandStack.empty()){
                    return result;
                }else { // else throw new exception
                    throw new SyntaxError("Stack isn't empty! Please check expression.");
                }

            }else { //will add empty string to stack without this
                throw new SyntaxError("Please enter something!");
            }
    }
    //==========================================================================================
    //  method: tokenizeExpression / arg: String expression / returns: Arraylist / complexity: O(n)
    //  description: takes a String and tokenizes it into an ArrayList of ints, chars, and Strings
    //==========================================================================================
    private static List<String> tokenizeExpression(String expression) throws IOException {
        StreamTokenizer tokenizeExpression = new StreamTokenizer(new StringReader(expression));
        //treat the following as normal chars
        tokenizeExpression.ordinaryChar('-');
        tokenizeExpression.ordinaryChar('/');
        List<String> tokenList = new ArrayList<>();// can also store as objects and cast
        // match tokens until end of stream
        while (tokenizeExpression.nextToken() != StreamTokenizer.TT_EOF){
                //number
            if (tokenizeExpression.ttype == StreamTokenizer.TT_NUMBER){
                tokenList.add(String.valueOf((int)tokenizeExpression.nval));
            //if for some reason there are words
            }else if(tokenizeExpression.ttype == StreamTokenizer.TT_WORD){
                tokenList.add(tokenizeExpression.sval);
            }else{ //operator
                tokenList.add(String.valueOf((char) tokenizeExpression.ttype));
            }
        }
        return tokenList;
    }
    //==========================================================================================
    //  method: isOperator / arg: String term / returns: boolean / complexity: constant
    //  description: takes a String (AKA char array) and looks at the first element and compares
    //  against cases of known operators
    //==========================================================================================
    private static boolean isOperator(String term){
         switch (term.charAt(0)){ //also looks at the first operand in inner expressions
             case '+':
             case '-':
             case '/':
             case '*':
             case '^':
                 return true;
         } return false;
    }
}
