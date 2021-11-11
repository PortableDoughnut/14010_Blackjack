package blackjack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {
	
	Resources resources = new Resources();
	GamePanel gamePanel = new GamePanel();
	RulesPanel rulesPanel = new RulesPanel();
	BackstoryPanel backstoryPanel = new BackstoryPanel();
	CreditsPanel creditsPanel = new CreditsPanel();
	
	/**
	 * Creates the panel and all of the buttons and style in this window.
	 */
	public MenuPanel() {
		
		setLayout(new BorderLayout(0, 0));
		
		// First panel that holds everything but mostly the background
		JLayeredPane panel = new JLayeredPane();
		add(panel, BorderLayout.NORTH);
		panel.setOpaque(false);
		setBackground(new Color(0, 0, 0, 0));
		panel.setBackground(new Color(0, 0, 0, 0));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		/**
		 * This is the background imaage.
		 * 
		 * I set up a JLabel and then set an image in the classpath to it.
		 * I don't really understand that MenuPanel is to be clear.
		 */
		JLabel menuBackground  = new JLabel(new ImageIcon(MenuPanel.class.getResource("/assets/images/backgrounds/MenuBackground.jpg")));
		menuBackground.setHorizontalTextPosition(SwingConstants.LEFT);
		panel.add(menuBackground);
	
		//This is the second panel that holds the welcome banner and the buttons for all of the options. 
		JPanel textPanel = new JPanel();
		add(textPanel, BorderLayout.NORTH);
		textPanel.setBackground(Color.GREEN);
		
		
		//Using a method I made in the Resorces class I added a font in the classpath to the system.
		resources.addFont("/assets/fonts/Showtime.TTF");
		
		//I'm setting the text to be on top
		panel.setLayer(textPanel, 0);
		
		textPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//The "WELCOME TO BLACKJACK!" label
		JLabel welcomeLabel = new JLabel("WELCOME TO BLACKJACK!");
		welcomeLabel.setVerticalAlignment(SwingConstants.TOP);
		textPanel.add(welcomeLabel);
		welcomeLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//Adding the font that I inputed earlier in a Plain 32 size
		welcomeLabel.setFont(new Font("Showtime", Font.PLAIN, 32));
		
		//The Play button that opens the game screen
		JButton playButton = new JButton("Play");
		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//I use a method that is lower down in this code to open the diffrent windows
				buttonClick(gamePanel);
			}
		});
		textPanel.add(playButton);
		playButton.setHorizontalAlignment(SwingConstants.LEADING);
		playButton.setVerticalAlignment(SwingConstants.BOTTOM);
		
		//The Rules button that opens the rules screen
		JButton rulesButton = new JButton("Rules");
		rulesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//I use a method that is lower down in this code to open the diffrent windows
				buttonClick(rulesPanel);
			}
		});
		textPanel.add(rulesButton);
		
		//The Backstory button that opens the backstory screen
		JButton backstoryButton = new JButton("Backstory");
		backstoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//I use a method that is lower down in this code to open the diffrent windows
				buttonClick(backstoryPanel);
			}
		});
		textPanel.add(backstoryButton);
		
		//The Credits button that opens the credits screen
		JButton creditsButton = new JButton("Credits");
		creditsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//I use a method that is lower down in this code to open the diffrent windows
				buttonClick(creditsPanel);
			}
		});
		textPanel.add(creditsButton);

	}
	
	
	/**
	 * 
	 * This closes the current window and opens a new window specified by the button clicked.
	 * 
	 * @param <E>
	 * 
	 * This just means you input a JPanel here
	 * 
	 * @param toOpen
	 * 
	 * This is the JPanel you want to be opened
	 * 
	 */
	public <E extends JPanel> void buttonClick(E toOpen) {
		MainFrame mainFrame = new MainFrame(toOpen);
		MainFrame.end();
		MainFrame.start(toOpen);
	}
}
