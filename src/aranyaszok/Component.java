package aranyaszok;

import java.io.Serializable;

/**
 * A component oszt�ly val�s�tja meg a flare gun r�szeit. �soszt�lya az item.
 * @author aranyaszok
 *
 */
public class Component extends Item {	
	
	private static final long serialVersionUID = -8663727564328683405L;

	public Component() {
		super(1);
	}

	/**
	 * A Use fuggveny ami majd a player craft fuggvenyet h�vja meg
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
