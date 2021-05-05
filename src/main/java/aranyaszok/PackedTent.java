package main.java.aranyaszok;

/**
 * Ez az osztaly valositja meg a jatekban a sator item formajat.
 * @author aranyaszok
 * 
 *
 */
public class PackedTent extends Item{
	
	private static final long serialVersionUID = 5968978296412648187L;


	public PackedTent() {
		super(1);
	}


	/**
	 * A jatekos egy satrat (Tent) hoz letre ennek a targynak a felhasznalasaval.
	 * 
	 * @param p - A hasznalo jatekos
	 */
	@Override
	public void Use(Player p) {
		Building tent = new Tent(p.GetWater());
		p.GetWater().GetBuilding().ReplaceBuilding(tent);
		super.Use(p);
	}
	
	
	/**
	 *Az object toString() metodus feluldefinialasa. Az osztaly nevet irja ki szovegesen.
	 */
	@Override
	public String toString() {
		return "PackedTent";
	}
}
