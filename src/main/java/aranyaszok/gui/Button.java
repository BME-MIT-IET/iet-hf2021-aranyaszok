package main.java.aranyaszok.gui;


/**
 * A gombokat megjelenito view.
 * @author aranyaszok
 *
 */
public class Button extends View {
	
	private static final long serialVersionUID = 3544817137389273760L;
	
	private boolean disabled = false;
	
	/**
	 * Az osztaly kontruktora.
	 * @param x A nezet x koordinataja
	 * @param y A nezet y koordinataja
	 * @param w A nezet x szerinti eltolasa
	 * @param h A nezet y szerinti eltolasa
	 */
	public Button(int x, int y, int w, int h) {
		super(x,y,w,h);
	}


	/**
	 *A clickWithinRange fuggveny feluldefinialasa. Csak akkor lehetseges a rakattintas, ha engedelyezve van a gomb.
	 */
	@Override
	public boolean clickWithinRange(int x, int y) {
		return super.clickWithinRange(x, y) && disabled == false;
	}
	
	
	/**
	 * A gomb engedelyezeset beallito fuggveny.
	 * @param bool Parametere true / false, eszerint engedelyezzuk vagy tiltjuk a gombot.
	 */
	public void SetDisabled(boolean bool) {
		this.disabled = bool;
	}
	
	
}
