package com.mycompany.nov02;

import java.util.*;

public class BlackJack {
    public static void initialize(String[] deck) {
	String[] suits = { "♥", "♦", "♣", "♠" };
	int i, j, rand;
	Random random = new Random();
	for (i = 0; i < suits.length; i++) {
	    deck[13*i] = "A" + suits[i];
	    for (j = 2; j < 11; j++)
		deck[13 * i + j - 1] = j + suits[i];
	    deck[13 * i + 10] = "J" + suits[i];
	    deck[13 * i + 11] = "Q" + suits[i];
	    deck[13 * i + 12] = "K" + suits[i];
	}
	String temp;
	for(i = 0; i < deck.length - 1; i++) {
	    rand = i + random.nextInt(deck.length - i);
	    temp = deck[i];
	    deck[i] = deck[rand];
	    deck[rand] = temp;
	}
    }
    public static int value(String card) {
	try (Scanner scanner = new Scanner(card)) {
	    scanner.useDelimiter("[^0-9]");
	    return Character.isDigit(card.charAt(0))? scanner.nextInt(): card.charAt(0) == 'A'? 11: 10;
	}
    }

    public static void main(String[] args) {
	String[] deck = new String[52];
	initialize(deck); // initializes and shuffles the deck of cards. Don't delete
	Scanner keyboard = new Scanner(System.in);
	String playerName;
	System.out.println("Welcome to the Black Jack game made by me! Let's start by entering the player's name: ");
	playerName = keyboard.nextLine();
	int playerScore = 0;
	int dealerScore = 0;
	System.out.println("Let's starts... Dealer has shuffled the cards and is dealing...");
	System.out.printf("First card for %s is %s\n", playerName, deck[0]);//deck[0] for the player
	playerScore += value(deck[0]);
	System.out.println("First card for dealer is faced down");//deck[1] is for the dealer
	dealerScore += value(deck[1]);
	System.out.printf("Second card for %s is %s\n", playerName, deck[2]);//deck[2] for the player
	if(deck[2].startsWith("A") && playerScore > 10)//Ace's value is 1 or 11
	    playerScore++;//Ace's value is 1 here...
	else
	    playerScore += value(deck[2]);//Ace's value is 11 here...
	if(playerScore == 21)//game ends early in favor of the player
	    System.out.println("Congratulations!!! " + playerName + " won!");
	System.out.println("Second card for dealer is " + deck[3]);//deck[3] for the dealer
	if(deck[3].startsWith("A") && dealerScore > 10)//Ace's value is 1 or 11
	    dealerScore++;//Ace's value is 1 here...
	else
	    dealerScore += value(deck[3]);//Ace's value is 11 here...
	//Your code comes HERE...
        
        //phase 3        
        String HitOrStay = "hit";//variable to store user input for hit or stay
        int i = 4, exit =0;//var i is for deck index and exit to control the program after phase 3
        while(HitOrStay.equalsIgnoreCase("hit")){ //while header checking if user has entered hit or stay
            System.out.println("Hit or Stay?"); //msg asking user for hit or stay
            HitOrStay = keyboard.nextLine(); //scanner input from user and storing it in the var
            if(!HitOrStay.equalsIgnoreCase("hit")){ //conditional stmt checking if user has not entered hit 
                break; // if user has not entered hit loop will break
            }
            playerScore += value(deck[i++]); // if user entered hit then player will get a cew card and its value is added
            System.out.printf("Card for %s is %s\n", playerName, deck[i-1]);//deck[i-1] for the player
            if(playerScore == 21){//game ends in favor of the player
                System.out.println("Congratulations!!! " + playerName + " won!"); // msg printing 
                exit=1; // if game is over and program needs to exit
                break; // game over loop will break
            }else if(playerScore>21){ // game ends and player has lost
                System.out.println("Game over!! " + playerName + " lost!"); // msg printing
                exit=1; // if game is over and program needs to exit
                break; // game over loop will break
            }
            
        }
        if(exit != 1){ // condition checking if game is over or not
            //phase 4
            System.out.println("First card for dealer is " + deck[1]);//deck[1] for the dealer
            if(dealerScore<17){ // condition to check if dealer score is less than 17
                dealerScore += value(deck[i++]); // if ddealer score is less than 17 dealer will get a new card and its value is added
                System.out.println("Third card for dealer is " + deck[i-1]);//deck[i-1] for the dealer
            }

            //phase 5
            if(dealerScore > 21 || dealerScore < playerScore){ // condition to check if dealer score is greater than 21
                System.out.println(playerName + " won!"); // msg printing that player has won
            }else if (dealerScore == playerScore){ // condition to check if dealer score is equal to player score
                System.out.println("game ended in a tie"); // msg printing that its a tie
            }else if(dealerScore > playerScore){ // condition to check if dealer score is greater than player score
                System.out.println(playerName + " lost!"); // msg printing that player has lost
            }
        }
    }
}