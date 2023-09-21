import java.util.ArrayList;
import java.util.Scanner;

public class wordGame {
    static ArrayList<String> words= new ArrayList<String>(); //arraylist to store all the words
    static Boolean outcome = false;
    
    public static void gameStart(){
        System.out.println("Word Game started with lamp");
        int wordIndex=0; 
        words.add("lamp");
        Scanner input = new Scanner(System.in); //to get input from the user
        while(!outcome){
            for(int i=0;i<=wordIndex; i++){ //to print all the words entered in the list
                System.out.print(words.get(i)+"  ");
            }
            System.out.println("");
            System.out.print("Enter a word (caseSensitive) to play the game, such as pen->net->top...:  ");
            String newWord = input.nextLine(); //store the user input into a variable before adding it to the actual list
            char[] ch_prevWord = words.get(wordIndex).toCharArray(); //converting the last word of the list into character array
            char[] ch_newWord = newWord.toCharArray(); //converting the currently entered word by the user into character array
            Boolean invalidWord=false;
            
            
            if(newWord.equals("")){ //checking the condition if the user entered an empty string
                wordIndex=gameRestart();
                
                System.out.println("Word Game started with lamp");
        
                words=new ArrayList<String>();
                words.add("lamp");
                invalidWord=true;
                
            }else if(ch_prevWord[ch_prevWord.length-1] != ch_newWord[0]){ //check if the 1st and last char of new and last word doesnt match
                System.out.println("Game Over");                
                outcome=true;
            }
            
            for(int i=0; i<=wordIndex && outcome==false; i++){
                if(words.get(i).equals(newWord)){ //check if the new word is already entered in the list or not
                    System.out.println("Game Over");
                    outcome=true;
                    break;
                }
            }
            
            for(int i=0; i<newWord.length() && outcome==false;i++){ //check if the word contains only letters
                if ((ch_newWord[i] >= 'a' && ch_newWord[i] <= 'z') 
                        || (ch_newWord[i] >= 'A' && ch_newWord[i] <= 'Z')) {
                    
                    
                }else{
                    
                    System.out.println("Entered word is invalid, please try again");
                    invalidWord=true;
                }
            }
            
            
            if(outcome==false && invalidWord==false){ // if the newly entered word passes all conditions add it the list 
                wordIndex++;
                words.add(newWord);
                
                 
            }
            
            
            
        }
    }
    
    public static int gameRestart(){
        words.clear(); //clear the list from all the words
        outcome=false;
        return 0;
    }
    
    public static void main(String [] args){
        gameStart();
    }
        
}
