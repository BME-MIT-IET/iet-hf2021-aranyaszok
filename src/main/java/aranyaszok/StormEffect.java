package main.java.aranyaszok;


/**
 * Egy olyan effekt mely a jatekost menek�lesre osztokeli. Bekuldi a mezon allo epuletbe.
 * @author aranyaszok
 */
public class StormEffect extends Effect {


	private static final long serialVersionUID = 3264523867414285984L;


	/**
	 * Az effektus ami a j�t�kosra hat�ssal van. Az effektus hatasara a jatekos bemenekul az adott mezon allo epuletbe.
	 * 
	 * @param p - Az effektel eltalalt jatekos
	 */
	public void Effects(Player p) {
		p.RunInside(this);
	}
	
	
	/**
	 * Az objektum tipusanak kiirasa.
	 */
	@Override
	public String toString() {
		return "StormEffect";
	}
}
