package main.java.aranyaszok;

import main.java.aranyaszok.gui.BuildingView;

/**
 * Az Eskimo osztaly valositja meg az eszkimo karaktert a jatekban. Ososztalya a Player.
 * @author aranyaszok
 *
 */
public class Eskimo extends Player {
	
	private static final long serialVersionUID = -5171362991341413725L;

	/**
	 * A Eskimo konstruktora
	 * 
	 */
	public Eskimo() {
		super();
		this.bodyHeatBase = 5;
		this.bodyHeat = bodyHeatBase;
	}
	
	
	/**
	 * A Skill fugveny az eszkimo kulonleges kepesseget valositja meg. 
	 * Ennek a segitsegevel kepes iglut letrehozni, majd azt elhelyezni az adott teruleten.
	 */
	public void Skill() {
		Building ig = new Iglu(this.GetWater());
		this.GetWater().GetBuilding().ReplaceBuilding(ig);
	}
	
	/**
	 * A toString() fuggveny definialja felul 
	 */
	@Override
	public String toString() {
		return "Eskimo";
	}
}
