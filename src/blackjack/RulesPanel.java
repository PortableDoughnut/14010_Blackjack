package blackjack;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RulesPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6353463459642346875L;

	/**
	 * Create the panel.
	 */
	public RulesPanel() {
		Box verticalBox = Box.createVerticalBox();
				addRuleLine("Your goal in blackjack is to beat the dealer’s hand without going over 21.", verticalBox);
				addRuleLine("You’ll receive 2 cards at the beginning of each round, and you’ll add up the values of these cards.", verticalBox);
				addRuleLine("Cards 2-10 have face value; King, Queen, Jack are worth 10; and Aces are either a 1 or an 11 — it’s up to you to decide.", verticalBox);
				addRuleLine("The dealer also draws two cards. The aim of the game is to beat his hand (have a higher hand) without going over 21.", verticalBox);
				addRuleLine("If you would like the dealer to deal you another card, you tell him “hit”", verticalBox);
				addRuleLine("If you do not want to be dealt another card, you “stand”", verticalBox);
				addRuleLine("“Busting” is when the sum of your hand is over 21.", verticalBox);
				addRuleLine("The winner of the round is whoever has the highest hand without going bust.", verticalBox);
		add(verticalBox);
	}
	
	/**
	 * 
	 * Adds a line to the JPanel through a Jlabel.
	 * 
	 * @param line
	 * 
	 * The line of text you want to add to the JPanel in a string variable
	 * 
	 * @param box
	 * 
	 * The verticalBox that you are adding the text to
	 * 
	 */
	public void addRuleLine(String line, Box box) {
		box.add(new JLabel(line));
	}

}
