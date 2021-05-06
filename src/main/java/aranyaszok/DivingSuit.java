package main.java.aranyaszok;

import java.io.Serializable;

/**
 * A DivingSuit valositja meg a buvarruhat a jatekban.
 * Az Item az ososztalya 
 * @author aranyaszok
 *
 */
public class DivingSuit extends Item {
	
	
	private static final long serialVersionUID = 223422201334406781L;

	public DivingSuit() {
		super(1);
	}
	
	/**
	 * A Use fuggveny valositja meg a buvarruha hasznalati logikajat. Miutan egy jatekos meghivta a use-t, a safe attributomot igazra allitja
	 * es a tratosaga csokenti 1-gyel 
	 *@param p : Player, aki meghivja a buvarruha hasznalatat.
	 */
	public void Use(Player p) {
		p.SetSafe(true);
		super.Use(p);
	}
	
	/**
	 * A toString() fuggveny definialja felul 
	 */
	@Override
	public String toString() {
		return "DivingSuit";
	}
}
