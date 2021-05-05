package main.java.aranyaszok;

/**
 * Ez az ostaly valositja meg a null buildiget a jatekban, vagyis azt, ha nincs building egy mezon.
 * @author aranyaszok
 *
 */
public class NullBuilding extends Building{
	
	private static final long serialVersionUID = 2375615251319182703L;


	/**A nullbuilding konstuktora
	 * @param w
	 */
	public NullBuilding(Water w) {
		super(w);
	}
	
	/**
	 * A Damage fuggveny parameterben megkap egy jatekost 
	 * es az effetet hogy mi talalta el az adott jatekost.
	 * Ha egy BearEffect akkor vege a jateknak, ha pedig egy
	 * StormEffect akkor csoken a testhoje eggyel. 
	 * 
	 * @param p - Az epuletben levo jatekos
	 * @param e - Az epuletet eltalalo effektus
	 */
	public void Damage(Player p, Effect e) {
	    if ( e instanceof BearEffect ) {
	    	Main.gameManager.Lose();
	    }
			
	    
		if ( e instanceof StormEffect ) {
			p.ChangeBodyHeat(-1);
		}
			
	}

	
	/**
	 * Ures fuggveny
	 */
	@Override
	public void Destroy() {}
	
	
	/**
	 *Az object toString() metodus feluldefinialasa. Az osztaly nevet irja ki szovegesen.
	 */
	@Override
	public String toString() {
		return "NullBuilding";
	}
}
