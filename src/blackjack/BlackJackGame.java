package blackjack;

import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackJackGame {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		Player samPlayer = new Player();
		samPlayer.money = 600;
		playGame(samPlayer);
	}
	
	
	public static void playGame(Player samPlayer) {
		Deck deck = new Deck();
		deck.shuffle();
		Dealer jenny = new Dealer(deck);
		
		boolean isReady = false;
		
		while(!isReady) {
		System.out.printf("You have: $%d\nHow much do you want to bet?\n", samPlayer.getMoney());
		try {
			Integer x = scanner.nextInt();
			if(x < samPlayer.getMoney())
				isReady = true;
			else {
				isReady = false;
			}
		} catch(InputMismatchException e) {
			System.out.println("Please input a number that is valid and that you can afford");
			isReady = false;
		}
		}
		
		System.out.println("The Dealers first card is " + jenny.getHand().cards.get(0));
		
		while(!samPlayer.hasStood) {
				gameStateOne(samPlayer, deck);
		}
		getResults(deck, jenny, samPlayer);
		
	}
	
	public static void gameStateOne(Player samPlayer, Deck deck) {
		boolean correctInput = false;
		System.out.println("Do you hit or stand? ");
		String inputString = scanner.nextLine();
	while(!correctInput) {
			if(inputString.toLowerCase().equals("hit")) {
				samPlayer.hit(deck);
				correctInput = true;
			}
			else if(inputString.toLowerCase().equals("stand")) {
				samPlayer.stand();
				correctInput = true;
			}
			else {
				System.out.println("Try a dirrerent input: ");
				correctInput = false;
				break;
			}
			if(samPlayer.getHand().getTotal(samPlayer.getHand().cards) > 21) {
				samPlayer.stand();
			}
		}
		System.out.println(samPlayer);
	}
	
	public static void getResults(Deck deck, Dealer jenny, Player samPlayer) {
		System.out.printf("Your dealer had the following cards:\n %s\n", jenny.getHand());
		
		int playerTotal = samPlayer.getHand().getTotal(samPlayer.getHand().cards);
		int dealerTotal = jenny.getHand().getTotal(jenny.getHand().cards);
		
		if((playerTotal < 21) && ((playerTotal > dealerTotal) || dealerTotal > 21)) {
			System.out.println("You won! congrats!");
			samPlayer.money += samPlayer.bet;
		}
		else {
			System.out.println("You Lost... I'm sorry the house always wins");
			samPlayer.money -= samPlayer.bet;
		}
		
		System.out.println("Do you want to play again? \n");
		if(scanner.next().toLowerCase() == "yes" || scanner.next().toLowerCase() == "y")
			samPlayer.setHand(new Hand());
			playGame(samPlayer);
		
	}

}

	
