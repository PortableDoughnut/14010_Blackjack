package blackjack;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackstoryPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public BackstoryPanel() {
		Box verticalBox = Box.createVerticalBox();
		
		addNewLine("You walk into the casino.", verticalBox);
		addNewLine("You just turned 21 and you have no idea what is going on or where to start.", verticalBox);
		addNewLine("The blackjack table class your name, It is the only thing you know how to play after all.", verticalBox);
		addNewLine("You walk up and start to play.", verticalBox);
		
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
	public void addNewLine(String line, Box box) {
		box.add(new JLabel(line));
	}

}
