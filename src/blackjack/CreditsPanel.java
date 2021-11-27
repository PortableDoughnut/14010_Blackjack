package blackjack;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.Box;

public class CreditsPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CreditsPanel() {
		
		Box verticalBox = Box.createVerticalBox();
		add(verticalBox);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		JLabel lblNewLabel = new JLabel("Gwen/Alex Thelin");
		horizontalBox.add(lblNewLabel);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		horizontalBox.add(verticalStrut);
		
		JLabel lblNewLabel_1 = new JLabel("Sarah Meehan");
		horizontalBox.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Thank you so much for playing our game");
		verticalBox.add(lblNewLabel_2);
	}

}
