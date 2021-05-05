package main.java.aranyaszok;

import main.java.aranyaszok.gui.View;

/**
 * Egy interface ami a jatekban lathato dolgokat valositja meg 
 * 
 * @author aranyaszok 
 *
 */
public interface IViewable {

	/**
	 * Hozza adja a viewt 
	 * 
	 * @param v View ez lesz az adott dolog viewja
	 */
	public void AddView(View v);
	/**
	 * @return visszater az adott dolog viewjaval
	 */
	public View GetView();
	
}
