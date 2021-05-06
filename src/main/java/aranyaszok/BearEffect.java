package main.java.aranyaszok;

/**
 * Ez az osztaly a medve tamadasaert felelos, hogy a egy jatekos es medve 
 * egy mezon allnak akkor a jatek befejezodjon ososztalya az Effect
 * 
 * @author aranyaszok
 * 
 */
public class BearEffect extends Effect {
	
	private static final long serialVersionUID = 1762039909391706612L;

	/**
	 * A jatekosok RunInsied() fuggvenyet hivja meg a bearEffecttel 
	 */
	public void Effects(Player p) {		
		p.RunInside(this);
	}
	
	/**
	 * A toString() fuggveny definialja felul 
	 */
	@Override
	public String toString() {
		return "BearEffect";
	}
}
