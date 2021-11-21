package blackjack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {

	private Hand hand;
	public int bet;
	
	int money;
	public boolean hasStood = false;
	
	public Player() {
		hand = new Hand();
	}
	
	@Override
	public String toString() {
		return "You Bet: \n" + bet + "Your cards are: \n" + hand;
	}

	public void hit(Deck deck) {
		hand.addCard(deck.recieveCard());
	}
	
	public void stand() {
		hasStood = true;
	}
	
	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public void setBet(int bet) {
		this.bet = bet;
	}
	
}
