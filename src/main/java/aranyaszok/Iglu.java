package main.java.aranyaszok;

/**
 * Megvedi a vele egy mezon levo jatekosokat a hovihar es a medve hatasaitol.
 * Csak az Eszkimo kepes letrehozni.
 * 
 * @author aranyaszok
 */
public class Iglu extends Building {
	
	private static final long serialVersionUID = 601001808695282929L;


	public Iglu(Water w) {
		super(w);
	}	
	
	/**
	 * A Damage fuggveny parameterben megkap egy jatekost 
	 * akit megved a vihar es medve sebzesetol.
	 * 
	 * @param p - Ez az a jatekos akit megved 
	 * @param e - Az effect ami az adott mezot eltalata
	 */
	@Override
	public void Damage(Player p, Effect e) {}

	
	/**
	 * Ures fuggveny
	 */
	@Override
	public void Destroy() {}	
	
	
	/**
	 * A toString() fuggveny definialja felul 
	 */
	@Override
	public String toString() {
		return "Iglu";
	}
}
