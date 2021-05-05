package main.java.aranyaszok;


/**
 * Egy olyan targy amivel egy jatekos meg tud menteni egy masik jatekost. A hasznalo a masik jatakost ( aki vizben van es nincs biztonsagban), 
 * a sajat mezojere huzza.
 * @author kisBodo
 *
 */
public class RopeEffect extends Effect {
	

	private static final long serialVersionUID = 4893228436520743235L;
	
	private Water targetWater;
	
	
	/**
	 * A konstruktorban beallitodik az a mezo ahova a jatekost kell kimenteni.
	 * @param w
	 */
	public RopeEffect(Water w) {
		targetWater = w;
	}
	
	
	/**
	 * A jatakoson van hatassal, ha bajban van a targetWater mezore atlep.
	 */
	public void Effects(Player p) {
		p.Move(targetWater);
	}
	
	
	/**
	 *Az object toString() metodus feluldefinialasa. Az osztaly nevet irja ki szovegesen.
	 */
	@Override
	public String toString() {
		return "RopeEffect";
	}
	
}
