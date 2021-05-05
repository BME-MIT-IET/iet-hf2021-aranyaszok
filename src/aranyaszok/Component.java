package aranyaszok;

import java.io.Serializable;

/**
 * A component osztály valósítja meg a flare gun részeit. Õsosztálya az item.
 * @author aranyaszok
 *
 */
public class Component extends Item {	
	
	private static final long serialVersionUID = -8663727564328683405L;

	public Component() {
		super(1);
	}

	/**
	 * A Use fuggveny ami majd a player craft fuggvenyet hívja meg
	 * 
	 *@param p :Player, aki majd megprobalja osszerakni.
	 */
	public void Use(Player p) {
		p.Craft();
	}
	
	/**
	 * A toString() fuggveny definialja felul 
	 */
	@Override
	public String toString() {
		return "Component";
	}
}
