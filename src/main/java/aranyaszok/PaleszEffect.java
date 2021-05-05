package main.java.aranyaszok;


/**
 * A Palinka targy hasznalatahoz szukseges, az osztaly altal megvalositott 
 * effektust, arra hasznaljuk, hogy a megfelelo szemelyekhez eljusson a 
 * targy hasznalatanak hatasa.   
 * @author aranyaszok
 */
public class PaleszEffect extends Effect {
	
	private static final long serialVersionUID = -8447775288732231282L;


	/**
	 * Az effektus hatasanak ervenyesitese
	 * @param p - A parameterul kapott jatekos testhojet noveljuk 
	 * (igy visszaallitva az eredeti ertekre)
	 */
	public void Effects(Player p) {
		p.SetBodyHeatToMax();
	}
	
	/**
	 *Az objektum tipusanak kiirasa.
	 */
	@Override
	public String toString() {
		return "PaleszEffect";
	}
}
