/**
 * 
 */
package blackjack;

import java.util.Comparator;

/**
 * @author Gwen
 *
 */
public class Card implements Comparable<Card>, Comparator<Card> {
	Suit suit;
	int rank;
	
	
	public Card(int rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	@Override
		public int compareTo(Card card)	{
			if(this.rank < card.rank) {
				return -1;
			}
			else if(this.rank > card.rank) {
				return 1;
			}
			else {
				return 0;
			}
	}
	
	@Override
	public int compare(Card one, Card two) {
		return one.rank - two.rank;
	}
	
	@Override
	public String toString() {
		return String.format("the %d of %s", rank, suit);
	}
	
	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
