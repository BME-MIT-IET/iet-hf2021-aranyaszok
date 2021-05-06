package main.java.aranyaszok;

import java.io.Serializable;

/**
 * Egy absztrakt osztaly ami majd a kulonbozo epuletek ososztalya lesz
 * @author aranyaszok
 *
 */
public abstract class Building  implements Serializable{
	
	
	private static final long serialVersionUID = -3994646820454943289L;
	protected Water water;

	/**
	 * A building konstruktora
	 * 
	 * @param w : Water, a water amin a building letrejon 
	 */
	public Building(Water w) {
		this.water = w;
	}
	
	
	/**
	 * Egy absztrakt fuggveny melyet majd a kulonbozo epuletek mind egyedileg valositanak meg
	 * @param p : Player, akit sebez a fuggveny.
	 * @param e : Effect, ami majd a jatekos sebzi 
	 */
	public abstract void Damage(Player p, Effect e);
	
	
	/**
	 *  Absztrakt fuggveny
	 */
	public abstract void Destroy();
	
	
	/**
	 * Az epulet waterattributumat lehet allitani  
	 * 
	 * @param w : Water az a water ahol a building allni fogg
	 */
	public void SetWater(Water w) {
		this.water = w;
	}
	
	
	/**
	 * Vissza adja az a water ami a building all
	 * 
	 * @return water
	 */
	public Water GetWater() {
		return water;
	}
	
	
	/**
	 * Egy uj epuletet rak arra a water
	 * es a sajat referenciajat torli  
	 * 
	 * @param newB: Building, az uj epulet 
	 */
	public void ReplaceBuilding(Building newB) {
		
		water.SetBuilding(newB);
		this.SetWater(null);
	}
	
	/**
	 * A toString() fuggveny definialja felul 
	 */
	@Override
	public String toString() {
		return "Building";
	}
}
