package main.java.aranyaszok;

import java.util.ArrayList;

/**
 * Egy olyan mezo melyen a jatekosok nincsenek teljes biztonsagban. Van egy teherbirasa amit ha eler, akkor beszakad es a jatekosok a vizbe kerulnek.
 * 
 * @author aranyaszok
 */
public class UnstableIce extends Ice {
	
	private static final long serialVersionUID = -4575825898563558813L;
	private int capacity;
	
	/**
	 * Az osztaly konstruktora, letrehoz egy unstable ice objektumot.
	 * @param uid az unstable ice objektum egyedi azonositoja
	 * @param capacity az unstable ice objektum kapacitasa
	 */
	public UnstableIce(int capacity) {
		this.capacity=capacity;
	}


	/**
	 * Beszakadt a jegtabla, A jatekosok a vizbekerulnek.
	 */
	private void Crash() {
		Water w = new Water();
		w.AddView(this.view);
		this.view.AddModel(w);
		w.setResearched(true);
		w.AddBuildingView(this.Buildinview);
		this.Buildinview.AddModel(w);
		this.SetAllNeighbours(w);
		ArrayList<Player> tempPlayers = new ArrayList<>(this.players);
		
		for(int i=0; i<tempPlayers.size(); i++) {
			tempPlayers.get(i).Move(w);
		}
		ArrayList<Item> items = new ArrayList<Item>(this.floatingItems);
		items.addAll(this.frozenItems);
		Main.gameManager.RelocateCrashedItems(items);
		Main.gameManager.ReplaceCrashedFields(this, w);
		
	}
	
	
	/**
	 * A mezohoz ad egy jatekost. A teherbirasa fuggvenyeben beszakadhat. EKkor a jatekosok atkerulnek a vizbe.
	 * 
	 * @param p - A mezohoz adando jatekos
	 */
	@Override
	public void AddSteppable(Steppable s) {
		super.AddSteppable(s);
		if(this.players.size() > GetCapacity())
			Crash();
	}

	


	/**
	 *Visszaadja az unstable ice kapacitasanak erteket.
	 */
	public int GetCapacity() {
		return capacity;
	}
	
	
	/**
	 * Az object toString() metodus feluldefinialasa. Az osztaly nevet irja ki szovegesen.
	 */
	@Override
	public String toString() {
		return "UnstableIce";
	}
	
}
