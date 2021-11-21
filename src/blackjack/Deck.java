package blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
		ArrayList<Card> cards;

		public Deck() {
			cards = new ArrayList<>();
			for(int i = 1; i <= 13; i++) {
				cards.add(new Card(i, Suit.CLUBS));
				cards.add(new Card(i, Suit.DIAMONDS));
				cards.add(new Card(i, Suit.HEARTS));
				cards.add(new Card(i, Suit.SPADES));
			}
		}
		
		/**
		 * @return
		 * 
		 * Returns the ArrayList of Cards
		 * 
		 */
		public ArrayList<Card> getDeck() {
			return cards;
		}
		
		/**
		 * 
		 * returns the top card and removes it from the deck
		 * 
		 * @return
		 * 
		 * Retunrs the top card
		 * 
		 */
		public Card recieveCard() {
			Card topCard = cards.get(0);
			cards.remove(0);
			return topCard;
		}
		
		/**
		 * Shufffles the deck three times
		 */
		public void shuffle() {
			for(int i = 0; i < 3; i++)
				Collections.shuffle(cards);
		}

		/**
		 * 
		 * Gets the first card in the array.
		 * 
		 * @param <K>
		 * @param cards
		 * 
		 * The ArrayList of cards you want to ge the first card from.
		 * 
		 * @return
		 * 
		 * Returns the card at the beginning of the List
		 * 
		 */
		public <K extends ArrayList<Card>> Card getCard(K cards) {
			return cards.get(0);
			
		}
		
		
		/**
		 * Sorts the deck
		 */
		public void sortDeck() {
			Collections.sort(cards);
		}
		
		
		/**
		 * A toString containing the cards ArrayList
		 */
		@Override
		public String toString() {
			return "Deck [cards=" + cards + "]";
		}
		
}
