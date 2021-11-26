package blackjack;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4368601223118212790L;
	Deck deck;
	Dealer jenny;
	Player sam;
	
	JLabel winOrLoss;
	
	public int hitsDone = 0;
	
	/**
	 * Create the panel.
	 */
	public GamePanel() {
		
		// Creating The deck and the shuffling it
		deck = new Deck();
		deck.shuffle();
		
		//creating the deck and dealer and then setting the Layout
		jenny = new Dealer(deck);
		sam = new Player();
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		setBackground(Color.green);
		
		//creating the Labels and Panels
		JPanel dealerPanel = new JPanel();
		dealerPanel.setBackground(Color.GREEN);
		add(dealerPanel);
		
		Box verticalBox = Box.createVerticalBox();
		dealerPanel.add(verticalBox);
		
		JLabel dealerCardsLabel = new JLabel("Dealer's Cards");
		dealerCardsLabel.setFont(new Font("Showtime", Font.PLAIN, 32));
		verticalBox.add(dealerCardsLabel);
		
		JLabel dealerValueLabel = new JLabel();
		dealerValueLabel.setFont(new Font("Impact", Font.PLAIN, 32));
		verticalBox.add(dealerValueLabel);
		verticalBox.add(DealerCardPanel(deck, jenny, 0));
		
		JPanel winStatus = new JPanel();
		winStatus.setBackground(Color.GREEN);
		add(winStatus);
		
		//Creating the winorLoss label 
		winOrLoss = new JLabel();
		winOrLoss.setFont(new Font("Showtime", Font.PLAIN, 32));
		winStatus.add(winOrLoss);
		
		/**
		 * This panel is for the stuff the user uses
		 */
		JPanel userPanel = new JPanel();
		userPanel.setBackground(Color.GREEN);
		add(userPanel);
		
		Box playerBox = Box.createVerticalBox();
		playerBox.setOpaque(true);
		playerBox.setBackground(Color.GREEN);
		userPanel.add(playerBox);
		
		//Text that says "Your Cards"
		JLabel yourCardsLabel = new JLabel("Your Cards");
		yourCardsLabel.setFont(new Font("Showtime", Font.PLAIN, 32));
		playerBox.add(yourCardsLabel);
		
		//The Label that displays the value of the combined cards
		JLabel playerValueLabel = new JLabel();
		playerValueLabel.setFont(new Font("Impact", Font.PLAIN, 32));
		playerBox.add(playerValueLabel);
		
		JPanel optionsButton = new JPanel();
		playerBox.add(optionsButton);
		
		Box horizontalBox = Box.createHorizontalBox();
		optionsButton.add(horizontalBox);
		
		JButton hitButton = new JButton("Hit");
		hitButton.setFont(new Font("Impact", Font.PLAIN, 16));
		hitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((sam.getHand().value < 22) && (!sam.hasStood))
					onHit(playerBox, playerValueLabel, deck, sam, hitsDone);
					hitsDone++;
			}
		});
		horizontalBox.add(hitButton);
		
		//Stand Button
		JButton standButton = new JButton("Stand");
		standButton.setFont(new Font("Impact", Font.PLAIN, 16));
		standButton.addActionListener(new ActionListener() {
			/**
			 * checks if the dealer has busted.
			 * Then it calls the endgame() method and refreshes the panel.
			 */
			public void actionPerformed(ActionEvent e) {
				sam.stand();
				for(int i = 0; i < jenny.getHand().cards.size(); i++) {
					verticalBox.add(DealerCardPanel(deck, jenny, i));
				}
				
				int dealerTotal = jenny.getHand().getTotal(jenny.getHand().cards);
				int playerTotal = sam.getHand().getTotal(sam.getHand().cards);
				
				if(dealerTotal < 22) {
					dealerValueLabel.setText(String.valueOf(dealerTotal));
				}
				else {
					dealerValueLabel.setText("BUST");
				}
				endgame();
				
				revalidate();
				repaint();
			}
		});
		horizontalBox.add(standButton);
		
		

	}
	
	/**
	 * 
	 * Adds a card to the JPanel from the dealer hand
	 * 
	 * @param deck
	 * 
	 * The deck object that is being used
	 * 
	 * @param jenny
	 * 
	 * The dealer you are getting the cards from
	 * (Sorry for naming it jenny)
	 * 
	 * @param cardNumber
	 * 
	 * the number of card from the deck you want to add
	 * 
	 * @return
	 * 
	 * Returns the label including the image of the suit and the number of the card
	 * 
	 */
	public JLabel DealerCardPanel(Deck deck, Dealer jenny, int cardNumber) {
		JLabel cardLabel = new JLabel(String.valueOf(jenny.getHand().cards.get(cardNumber).getRank()) + " \n");
		cardLabel.setFont(new Font("Impact", Font.PLAIN, 26));
		cardLabel.setIcon(new ImageIcon(GamePanel.class.getResource(jenny.getHand().cards.get(cardNumber).getSuit().imgLocation)));
		cardLabel.setBackground(Color.white);
		cardLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		cardLabel.setOpaque(true);
		return cardLabel;
	}
	
	/**
	 * 
	 * Adds a card to the JPanel from the player hand
	 * 
	 * @param deck
	 * 
	 * The deck object that is being used
	 * 
	 * @param sam
	 * 
	 * The player you are getting the cards from
	 * (Sorry for naming it sam)
	 * 
	 * @param cardNumber
	 * 
	 * the number of card from the deck you want to add
	 * 
	 * @return
	 * 
	 * Returns the label including the image of the suit and the number of the card
	 * 
	 */
	public JLabel PlayerCardPanel(Deck deck, Player sam, int cardNumber) {
		JLabel cardLabel = new JLabel(String.valueOf(sam.getHand().cards.get(cardNumber).getRank()) + " \n");
		cardLabel.setFont(new Font("Impact", Font.PLAIN, 26));
		cardLabel.setIcon(new ImageIcon(GamePanel.class.getResource(sam.getHand().cards.get(cardNumber).getSuit().imgLocation)));
		cardLabel.setBackground(Color.white);
		cardLabel.setBorder(BorderFactory.createLineBorder(Color.black));
		cardLabel.setOpaque(true);
		return cardLabel;
	}
	
	
	/**
	 * 
	 * 
	 * This is called when a player hits.
	 * 
	 * It calls the hit method from the player class and then updates the total value of the cards.
	 * 
	 * After that it checks if the player has busted. If the player has it stands for the player.
	 * 
	 * It then refreshes the JPanel
	 * 
	 * @param box
	 * 
	 * The Box that is holding the player info
	 * 
	 * @param valueLabel
	 * 
	 * The label that displays the value of the total cards in the hand
	 * 
	 * @param deck
	 * 
	 * the deck that is being used for the game
	 * 
	 * @param sam
	 * 
	 *	The player you are getting the cards from
	 * (Sorry for naming it sam)
	 * 
	 * @param cardNumber
	 * 
	 * 
	 * The number of card that the player is receiving
	 * 
	 */
	public void onHit(Box box, JLabel valueLabel, Deck deck, Player sam, int cardNumber) {
		sam.hit(deck);
		box.add(PlayerCardPanel(deck, sam, cardNumber));
		
		int playerTotal = sam.getHand().getTotal(sam.getHand().cards);
		
		if(playerTotal < 22) {
			valueLabel.setText(String.valueOf(playerTotal));
		} else {
			valueLabel.setText("BUST");
			sam.stand();
		}
		
		revalidate();
		repaint();
	}
	
	
	/**
	 * 
	 * Checks if the player or dealer has busted and then checks who won or if it is a tie.
	 * 
	 * After that it refreshes the JPanel
	 * 
	 */
	public void endgame() {
		
		int dealerTotal = jenny.getHand().getTotal(jenny.getHand().cards);
		int playerTotal = sam.getHand().getTotal(sam.getHand().cards);
		
		if(((dealerTotal > playerTotal) && (dealerTotal < 22))) {
			winOrLoss.setText("You Lost!\nI'm sorry, but the house always wins.");
		} else if(((playerTotal > dealerTotal) && (playerTotal < 22)) || ((dealerTotal > 22) && (playerTotal < 22))) {
			winOrLoss.setText("You Won! Congrats!");
		} else {
			winOrLoss.setText("You somehow tied.");
		}
		
		revalidate();
		repaint();
	}

}
