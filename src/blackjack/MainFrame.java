package blackjack;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	
	static MenuPanel menuPanel = new MenuPanel();
	static MainFrame frame;
	
	/**
	 * 
	 * Launches the application.
	 * It just calls the start() method.
	 * 
	 */
	public static void main(String[] args) {
		start(menuPanel);
	}

	/**
	 * 
	 * Sets up the frame and then adds the inputed JPanel.
	 * 
	 * @param <E>
	 * 
	 * This just means that you put a JPanel in here.
	 * 
	 * @param toOpen
	 * 
	 * You put in the JPanel that you want to be displayed here.
	 * 
	 */
	public <E extends JPanel> MainFrame(E toOpen) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setMaximumSize(new Dimension(960, 640));
		setMinimumSize(new Dimension(960, 640));
		setPreferredSize(getMinimumSize());
		setResizable(false);
		add(toOpen);
	}
	
	/**
	 * 
	 * The set up of the frame, I honestly don't get how this works right now.
	 * 
	 * @param toOpen
	 * 
	 * Put the JPanel that you want to be displayed here.
	 * 
	 */
	public static void start(JPanel toOpen) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainFrame(toOpen);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Call this method and it will close the current window,
	 */
	public static void end() {
		frame.dispose();
	}
	
}
