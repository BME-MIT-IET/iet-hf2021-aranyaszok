package main.java.aranyaszok;

/**
 * @author aranyaszok
 *
 */
public class Tent extends Building{
	

	private static final long serialVersionUID = 1412749705691732636L;


	/**
	 * A Tent osztaly konstuktora. Letrehoz egy tent objektumot.
	 * 
	 * @param w : Water parameter, erre a waterre lesz beallitva a tent referenciaja.
	 */
	public Tent(Water w) {
		super(w);
	}
	
	/**
	 * A building Damage fuggveny feluldefinialasa. Effektus hatasara ez a fuggveny sebzi a jatekosokat.
	 * 
	 * @param p - Az epuletben levo jatekos
	 * @param e - Az epuletet eltalalo effektus
	 */
	@Override
	public void Damage(Player p, Effect e) {
		if ( e instanceof BearEffect )
			Main.gameManager.Lose();
	}

	
	/**
	 * A tent objecktumot torlo metodus. Letrehoz egy null building-et, amjd azzal kicsereli a tent-et.
	 */
	@Override
	public void Destroy() {
		
		NullBuilding newB = new NullBuilding(water);
		this.ReplaceBuilding(newB);
	}
	
	
	/**
	 * Az object toString() metodus feluldefinialasa. Az osztaly nevet irja ki szovegesen.
	 */
	@Override
	public String toString() {
		return "Tent";
	}
}
