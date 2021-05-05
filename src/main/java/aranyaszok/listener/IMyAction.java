package main.java.aranyaszok.listener;
import java.io.Serializable;

import main.java.aranyaszok.gui.View;

/**
 * Ennek az interface-nek a segitsegevel valositjuk eg azt, hogy minde view-nak lehessen kulon action-je kattintaskor.
 * @author aranyaszok
 *
 */
public interface IMyAction extends Serializable{
	
	/**
	 * Ebben a fuggvenyben kell megvalositani azt, amit szeretnenk, hogy tortenjen az egyes view-ok action-jeben.
	 * @param w A view, amelyre be szeretnenk allitani.
	 */
	public void OnMouseCLick(View w);
	
}
