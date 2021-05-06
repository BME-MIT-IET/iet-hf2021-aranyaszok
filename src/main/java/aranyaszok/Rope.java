package main.java.aranyaszok;


/**
 * Egy olyan targy, melyet ha hasznalnak a szomszedos mezorol kimenti a jatekosokat.
 * @author aranyaszok
 */
public class Rope extends Item {
	
	private static final long serialVersionUID = 8772308225110647709L;


	/**
	 * Konstruktor, 1 a durability
	 */
	public Rope() {super(1);}
	
	
	/**
	 * Hasznalatkor letrejon egy ropeeffect, mely arra a mezore hivodik amerre eppen a hasznalo jatekos nez.
	 * 
	 * @param p - A hasznalo jatekos
	 */
	public void Use(Player p) {
		RopeEffect re = new RopeEffect(p.GetWater());
		re.Call(p.GetFacing());
		super.Use(p);
	}
	
	
	/**
	 *Az objektum tipusanak kiirasa.
	 */
	@Override
	public String toString() {
		return "Rope";
	}
	
}
