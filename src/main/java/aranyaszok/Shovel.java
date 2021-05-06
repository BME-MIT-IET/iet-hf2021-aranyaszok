package main.java.aranyaszok;


/**
 * Egy olyan targy, mellyel a jatakos, ha hasznalja tobb havat tud letakaritani egy mezorol.
 * @author aranyazok
 *
 */
public class Shovel extends Item {

	private static final long serialVersionUID = -6568665198618920934L;


	/**Az aso konstuktora. Letrehoz egy aso objektumot.
	 * @param uid - Az aso egyedi azonositoja
	 * @param dur - Az aso tartossaga.
	 */
	public Shovel(int dur) {
		super(dur);
	}
	
	
	/**
	 *A targy hasznalataval ketto horeteg kerul ellapatolasra. Hasznalat utan a targy kopik, majd eltorik.
	 *@param p : az a jatekos, aki birtokolja a targyat.
	 */
	public void Use(Player p) {
		Water i = p.GetWater();
		i.Digging(2);
		
		super.Use(p);
	}
	
	
	/**
	 *Az object toString() metodus feluldefinialasa. Az osztaly nevet irja ki szovegesen.
	 */
	@Override
	public String toString() {
		return "Shovel";
	}
	
	
}
