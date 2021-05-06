package main.java.aranyaszok;


/**
 *A Researcher osztaly valositja meg az kutato karaktert a jatekban. Ososztalya a Player.
 * @author aranyaszok
 *
 */
public class Researcher extends Player {
	
	private static final long serialVersionUID = 1649077182040873807L;


	/**
	 * A researcher osztaly konstuktora. Letrehoz egy researcher objektumot.
	 * @param uid: a researcher egyeni azonositoja.
	 */
	public Researcher() {
		this.bodyHeatBase = 4;
		this.bodyHeat = bodyHeatBase;
	}
	
	
	/**
	 * A Skill fugveny a kutato kulonleges kepesseget valositja meg. Ennek a segitsegevel kepes megvizsgalni egy adott terulet teherbirasa.
	 */
	public void Skill() {
		this.GetFacing().setResearched(true);
	}
	
	
	/**
	 * Az object toString() metodus feluldefinialasa. Az osztaly nevet irja ki szovegesen.
	 */
	@Override
	public String toString() {
		return "Researcher";
	}
	
}
