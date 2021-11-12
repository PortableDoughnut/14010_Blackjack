package blackjack;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GamePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GamePanel() {
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GamePanel.class.getResource(Suit.SPADES.imgLocation)));
		add(lblNewLabel);

	}

}
