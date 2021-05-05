package main.java.aranyaszok;


/**
 * Ez az osztaly valositja meg a Palinka Item-et, ami az ITMan sajat kepessegehez szukseges
 * @author aranyaszok
 */
public class Palesz extends Item  {
	
	private static final long serialVersionUID = 890686597694360845L;


	public Palesz() {
		super(1);
	}


	/**
	 * A targy hasznalata, ezzel aktivalva az ITMan sajat egyeni kepesseget
	 * @param p - A targynak atadjuk az azt hasznalni akaro szemelyt, 
	 * ezaltal korlatozva, hogy ne tudja barmelyik jatekos hasznalni    
	 */
	public void Use(Player p) {
		if(p instanceof ITMan) {
			PaleszEffect pe = new PaleszEffect();
			pe.Call(p.GetWater());
			super.Use(p);
		}
	}
	
	
	/**
	 *Az object toString() metodus feluldefinialasa. Az osztaly nevet irja ki szovegesen.
	 */
	@Override
	public String toString() {
		return "Palesz";
	}
}
