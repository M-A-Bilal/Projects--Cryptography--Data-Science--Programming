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
	System.out.print("Welcome to the Black Jack game made by me! Let's start by entering the player's name: ");
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
    }
}
