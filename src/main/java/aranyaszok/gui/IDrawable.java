package main.java.aranyaszok.gui;

import java.awt.image.BufferedImage;

/**
 * Ezt azt interface-t akik megvalositjak, azok kepesek kepre rajzolni. Ilyenek a View-ok.
 * @author aranyaszok
 *
 */
public interface IDrawable {
	
	/**
	 * A megvalositando rajzolo fuggveny.
	 * @param image Erre az image-re kell rajzolni.
	 */
	public void Draw(BufferedImage image);
	
}
