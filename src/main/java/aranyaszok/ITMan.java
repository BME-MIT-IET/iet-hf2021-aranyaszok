package main.java.aranyaszok;


/**
 * A ITmant valoszitja meg a jatekban ososztalya a Player
 * @author aranyaszok
 *
 */
public class ITMan extends Player {
	
	private static final long serialVersionUID = -6148147581660679339L;


	/**
	 * Beallitja a jatokos maximum es kezdo testhojet  
	 */
	public ITMan() {
		this.bodyHeatBase = 3;
		this.bodyHeat = bodyHeatBase;
	}
	
	
	/**
	 * Ures fuggveny, a kepessege itemmel lehet aktivalni 
	 */
	public void Skill() {}

	
	/**
	 * A toString() fuggveny definialja felul 
	 */
	@Override
	public String toString() {
		return "ITMan";
	}
}
