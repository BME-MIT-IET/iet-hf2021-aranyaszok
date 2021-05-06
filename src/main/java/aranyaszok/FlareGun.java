package main.java.aranyaszok;

/**
 * Ez az osztaly felelos a jatek gyozelmeert 
 * @author aranyaszok
 *
 */
public class FlareGun {
	
	int accepted;

	
	public FlareGun() {
		accepted = 0;
	}
	
	
	/**
	 * Vizsgalja hogy megvan-e a harom 
	 * darab componens. Es ha igen akkor meghivjuk a 
	 * Win fuggvenyt a GameManagerbol
	 * 
	 * @param i: Item viszgaljuk, hogy Component-e
	 */
	public void Check(Item i) {
		if(i instanceof Component) {
			accepted++;
		}
		
		if (accepted == 3) {
			Main.gameManager.Win();
		}
	}
	
	/**
	 * A toString() fuggveny definialja felul 
	 */
	@Override
	public String toString() {
		return "FlareGun";
	}
}
