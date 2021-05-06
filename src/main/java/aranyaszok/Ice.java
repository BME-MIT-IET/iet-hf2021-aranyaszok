package main.java.aranyaszok;

/**
 * Egy mezo, aminek vegtelen a kapacitasa. Allhat rajta epulet. Lehet rajta es belefagyva is Item.
 * Az ososztalya a Water.
 * 
 * @author aranyaszok
 */
public class Ice extends Water {
	
	private static final long serialVersionUID = -6499634921991988351L;

	/**
	 * A Digging fugveny hivatott arra, hogy a jegrol a 
	 * ho retegeket eltavolitsuk vagy ha nincs rajta ho akkor
	 * egy targyat kias a jegbol
	 * 
	 * @param i - megadja hogy hany reteg havat tuntessen el a jeg feluleterol 
	 */
	public void Digging(int i) {
		if (snowLayers > 0) {
			snowLayers -= i;
			if (snowLayers < 0)
				snowLayers = 0;
		}
		else {
			if(frozenItems.size() > 0 && floatingItems.size() < 8) {
				floatingItems.add(frozenItems.get(0));
				frozenItems.remove(0);
			}
		}
	}
	
	@Override
	public void ReactToStep() {
		if(bears.size() > 0)
			bears.get(0).Attack();
	}

	/**
	 * A jegen levo epuletet a kapott Building-re allitja
	 * 
	 * @oaram b a beallitando epulet
	 */
	public void SetBuilding(Building b) {
		building = b;
	}
	
	
	/**
	 *Ezzel a foggvennyel lehet a jegtabla kapacitasarol
	 *informaciot szerezni a researchernek
	 *
	 * @return a jegtabla kapacitasarol ad informaciot
	 */
	public int GetCapacity() {
		return -1;
	}

	/**
	 * A toString() fuggveny definialja felul 
	 */
	@Override
	public String toString() {
		return "Ice";
	}
}
