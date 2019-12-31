/**
 * This class will give us the value of the card and also the name and combination of cards
 * @author christran
 *
 */
public class Card {
    private int rank; 
    private int suit; 
    
    // Constructor
    /**
     * Suit is the type of card
     * @param suit
     * Rank gives us the rank of the card
     * @param rank
     */
    public Card(int suit, int rank){
        this.rank = rank;
        this.suit = suit;
    }
    
    
    
    // My getter method
    /**
     * returns the value of the card given
     * @return

     */
    public int cardValue(){
        return rank; 
    }
    
    // My setter method
    /**
     * Sets the rank of the card
     * @param rank
     */
    public void setCard(int rank){
        this.rank = rank;
    }
    
    // Used Stringbuilder() to put together Suit and rank 
    // Allows for my strings to be easily modifiable 
   /**
    * This class will give us the string for the combination of rank and suit
    * @return
    * 
    */
    public String toString(){

        StringBuilder cardString = new StringBuilder();
        switch(rank){

            case 11:
                cardString.append("Jack");
                break;
            case 12:
                cardString.append("Queen");
                break;
            case 13:
                cardString.append("King");
                break;
            case 14:
                cardString.append("Ace");
                break;    
            default:
               cardString.append(rank); 
                break;
        }
        //Appends " of " in between rank and suit
        cardString.append(" of "); 
        
        
        switch(suit){
            case 0:
                cardString.append("Spades");
                break;
            case 1:
                cardString.append("Hearts");
                break;
            case 2:
                cardString.append("Clubs");
                break;
            case 3:
                cardString.append("Diamonds");
                break;
            default: 
                break;
        }
        // Returns created string
        return cardString.toString();
    }
    
}

	
	
