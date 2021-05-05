package main.java.aranyaszok;


/**
 * Egy karaktertipus. Kulonleges kepessege, hogy nem fullad meg a kor vegen a vizben.
 * @author aranyaszok
 *
 */
public class Seal extends Player {
	

	private static final long serialVersionUID = -1786069697087428691L;


	/**
	 * Alpveto ertekek beallitasa. A foka kepessegenel fogva biztonsagban van a vizben.
	 * @param uid
	 */
	public Seal() {
		SetSafe(true);
		this.bodyHeatBase = 2;
		this.bodyHeat = bodyHeatBase;
	}

	
	/**
	 * Nincs kulon hivhato kepessege. 
	 */
	public void Skill() {}
	
	
	/**
	 *Az objektum tipusanak kiiratasa.
	 */
	@Override
	public String toString() {
		return "Seal";
	}
}
