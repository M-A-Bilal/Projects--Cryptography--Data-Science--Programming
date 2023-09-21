/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam20apr2021;

import java.util.Stack;

public class NewClass1 {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push("P");
        s.pop();
        s.push("Q");
        s.push("R");
        s.push(s.peek());
        s.peek();
        System.out.println(s.toString());
        
        System.out.println(cheer(4));
    }
    
    static String cheer(int n){
        if(n==1)
            return "Hurray!!";
        else if (n==2)
            return "Hip Yes "+cheer(n-1);
        else
            return "Hip "+cheer(n-1);
    }
}
