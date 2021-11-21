package blackjack;

import java.util.ArrayList;

public class Dealer {
		private Hand hand;
		
		public Dealer(Deck deck) {
			setHand(new Hand());
			getHand().addCard(deck.recieveCard());
			getHand().addCard(deck.recieveCard());
			getHand().addCard(deck.recieveCard());
		}
		
		public void shuffle(Deck deck) {
			deck.shuffle();
		}
		
		public <K extends Card> ArrayList<Card> getPile(Deck deck) {
			return deck.getDeck();
		}
		
//		public void getCardFromPile(Deck deck) {		
//			hand.addCard(deck.recieveCard());
//		}

		public void playHand() {
			
		}
		
		public void start() {
			
		}
		
		public Hand getHand() {
			return hand;
		}
		
		@Override
		public String toString() {
			return "Dealer [hand=" + getHand() + "]";
		}

		public void setHand(Hand hand) {
			this.hand = hand;
		}

		
}
