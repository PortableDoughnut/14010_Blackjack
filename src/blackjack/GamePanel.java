package blackjack;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class GamePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4368601223118212790L;
	Deck deck;
	Dealer jenny;
	
	/**
	 * Create the panel.
	 */
	public GamePanel() {
		
		deck = new Deck();
		deck.shuffle();
		
		jenny = new Dealer(deck);
		
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel dealerPanel = new JPanel();
		add(dealerPanel);
		
		dealerPanel.add(DealerCardPanel(deck, jenny));
		
		JPanel userPanel = new JPanel();
		add(userPanel);

	}
	
	public JLabel DealerCardPanel(Deck deck, Dealer jenny) {
			JLabel cardLabel = new JLabel(String.valueOf(jenny.getHand().cards.get(0).getRank()) + " \n");
			cardLabel.setFont(new Font("Impact", Font.PLAIN, 26));
			cardLabel.setIcon(new ImageIcon(GamePanel.class.getResource(jenny.getHand().cards.get(0).getSuit().imgLocation)));
			cardLabel.setBackground(Color.blue);
			cardLabel.setBorder(BorderFactory.createLineBorder(Color.black));
			cardLabel.setOpaque(true);
			return cardLabel;
	}

}
