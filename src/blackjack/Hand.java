package blackjack;

import java.util.ArrayList;

public class Hand {

	ArrayList<Card> cards;
	int value;
	
	public Hand() {
		cards = new ArrayList<>();
	}
	
	/**
	 * 
	 * adds a card to the Hand
	 * 
	 * @param c
	 * 
	 * The card you are adding
	 * 
	 */
	public void addCard(Card c)
	{	
		cards.add(c);
	}
	
	
	/**
	 * 
	 * gets the total of all of hte cards in the hand
	 * 
	 * @param cardHand
	 * 
	 * the ArrayList of Cards you want to check
	 * 
	 * @return
	 * 
	 * returns the total of all of the cards in the hand
	 * 
	 */
	public int getTotal(ArrayList<Card> cardHand) {	
		int total = 0;
		
		for(Card c: cardHand) {
			total = total + c.getRank();
		}
		
		return total;
		}
	
	/**
	 * 
	 * checks if the total is equal to 21.
	 * 
	 * if it is it returns true.
	 * in any other case it returns false.
	 * 
	 * @return
	 */
	public boolean blackJack() {
		if(getTotal(cards) == 21) {
			return true;
		}
		else {
			return false;
		}
	}
	
//	public int bestScore() {
//			return null; //TODO
//	}
	
	/**
	 * 
	 * Checks if the total of the hand is over 21
	 * 
	 * @return
	 * 
	 * if the total of the hand is over 21 is returns true.
	 * otherwise it returns false.
	 * 
	 */
	public boolean bust() {
		if(getTotal(cards) > 21) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/**
	 * the toString for th
	 */
	@Override
	public String toString() {
		return "" + cards + ", The value of your cards are " + getTotal(cards);
	}
	
}
