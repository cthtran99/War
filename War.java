/* Christopher Tran
 * CECS 277 Project #1
 * Date - 9/24/19
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;   
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Our game of war that will be used to play a game between a user and the computer
 * It requires both players to put down the top card of a randomly shuffled deck
 * The highest card played is the winner of the round, winner of the game is whoever has cards left
 * Loser is the player who has 0 cards at the end
 * @author christran
 *
 */
public class War {
	/**
	 * The start of our logic for the card game of War, we start off with building a deck that will be
	 * split into two decks of 26.
	 * @param args
	 */
    public static void main(String[] args) {        
        List<Card> deck = new ArrayList<Card>();
       
        //Create a new deck for the game of War
        
        for(int i=0; i<4; i++)
        {
            for(int j=2; j<15; j++)
            {     
                deck.add(new Card(i,j));                                 
            } 
        }        
        Collections.shuffle(deck, new Random()); //shuffle the deck randomly using Collection
        //Shuffles newly created deck using Random 

        // New decks for the user and for the Bot
        LinkedList<Card> userDeck = new LinkedList<Card>();
        LinkedList<Card> botDeck = new LinkedList<Card>();
        
        
        //This adds 26 cards from our deck we made earlier into user and bot's deck
        userDeck.addAll(deck.subList(0, 26));                 
        botDeck.addAll(deck.subList(26, deck.size()));
        Scanner Input = new Scanner(System.in);
    	System.out.println("What is your name? ");
    	String userName = Input.nextLine();
    	
    	
    	//War game logic
        while(true){
        	System.out.println(userName + " Press (P) to play the card on top of your deck");
			char userInput = Input.next().charAt(0);
			if (userInput == 'P' || userInput == 'p') {
				

				//pulls top of stack
				Card userCard = userDeck.pop();  
	            Card botCard = botDeck.pop();
	            
	            //display the face up card
	            System.out.println(userName + " plays the card " + userCard.toString() );
	            System.out.println("Computer plays the card " + botCard.toString() + "\n");
	            
	            //Condition for if player wins against computer
	            if(userCard.cardValue() > botCard.cardValue()){//if the user wins
	                userDeck.addLast(userCard);  //Whoever has the higher rank wins the card
	                userDeck.addLast(botCard);  //This will place losers card into winner's deck
	                System.out.println(userName + " wins the round" + "\n" + "\n");
	                System.out.println(userName + ": " + userDeck.size());
	                System.out.println("Computer: " + botDeck.size());

	            }
	            //Condition for if Computer beats player
	            else if(userCard.cardValue() < botCard.cardValue()){
	                botDeck.addLast(userCard);   
	                botDeck.addLast(userCard);  
	                System.out.println("Computer wins the round"  + "\n" + "\n");
	                System.out.println(userName + ": " + userDeck.size());
	                System.out.println("Computer: " + botDeck.size());
	            }
	            
	            
	            //Conditions for a tie causing War
	            else {
	                System.out.println("There is a tie - time for War"); 
	                
	              
	                List<Card> userWar = new ArrayList<Card>(); 
	                List<Card> botWar = new ArrayList<Card>();
	                
	                //Checks for if each deck has enough cards to play
	                for(int x=0; x<3; x++){ 
	                	
	                	
	                	//Ends if a deck is empty for either participant
	                    if(userDeck.size() == 0 || botDeck.size() == 0 ){                      
	                        break;
	                    }
	                    
	                    //Extra cards added for game of war
	                    userWar.add(userDeck.pop());  
	                    botWar.add(botDeck.pop());                  
	                }
	                
	                
	                //This will run if both decks have enough cards
	                if(userWar.size() == 3 && botWar.size() == 3 ){
	               
	                    System.out.println(userName + " war card is " + userWar.get(0).toString());
	                    System.out.println("The computer's war card is " + botWar.get(0).toString());
	                    
	                    //Same logic as game logic previous except more cards are taken
	                    if(userWar.get(2).cardValue() > botWar.get(2).cardValue()){
	                        userDeck.addAll(userWar); //User gets all cards
	                        botDeck.addAll(botWar);
	                        System.out.println(userName + " win the war round");
	    	                System.out.println(userName + ": " + userDeck.size());
	    	                System.out.println("Computer: " + botDeck.size());
	                    }
	                    
	                    

	                    else{
	                        botDeck.addAll(userWar); //Bot gets all cards
	                        botDeck.addAll(botWar);
	                        System.out.println("Computer wins the war round");
	    	                System.out.println(userName + ": " + userDeck.size());
	    	                System.out.println("Computer: " + botDeck.size());
	                    }                    
	                }
	            }
	            
	            //Conditions for when either deck is empty
	            //Declares a winner of the match
	            if(userDeck.size() == 0 ){
	                System.out.println("Game over\nComputer wins the game");
	                break;
	            }
	            else if(botDeck.size() == 0){
	                System.out.println("Game over\n" + userName + " wins the game");
	                break;
	            }
	       }
        }
    }
}            
      



