/**
 * 
 */
package blackjack;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.IOException;

import javax.swing.JPanel;

/**
 * @author Gwen
 *
 */
public class Resources {

	public GraphicsEnvironment ge = null;

	/**
	 * 
	 * Use this method to add a font to the JPanel you are working in.
	 * 
	 * @param location
	 * 
	 * Add the path to the font in String format here.
	 * 
	 */
	public void addFont(String location) {
	    try{
	      ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	      ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream(location)));
	    } catch(FontFormatException e){} catch (IOException e){}
	}
}