package main.java.aranyaszok;

import java.io.Serializable;
/*
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;*/

import main.java.aranyaszok.gui.View;

/**
 * Egy absztrak osztaly amelynek a leszarmazotjai majd az egyedi 
 * targyak lesznek 
 * @author aranyaszok
 *
 */
public abstract class Item implements Serializable, IViewable {
	
	private static final long serialVersionUID = 6724237463612087706L;

	private int durability;

	private View view;
	
	/**
	 * Visszaadja a item viewt
	 */
	@Override
	public View GetView() {
		return view;
	}
	
	/**
	 * Beallitja az item viewt amit parameterben megkap
	 * 
	 * @param view ami adott itemhez kapcsolodik 
	 */
	@Override
	public void AddView(View view) {
		this.view = view;
	}

	

	/**
	 * @param d - Az Item durability erteke
	 */
	public Item(int d) {
		this.durability = d;
		
	}

	
	
	/**
	 * Az Item hasznalata. Minden leszarmazott felulirja es meghivja 
	 * az os Use metodusat is (ezt a metodust)
	 * Csokkenti a durability erteket 1-el
	 * 
	 * @param p - A hasznalo jatekos
	 */
	public void Use(Player p) {
		durability--;
		if(durability <= 0 )
			p.RemoveItem(this);
	}
	
	

	/**
	 * A toString() fuggveny definialja felul 
	 */
	@Override
	public String toString() {
		return "Item";
	}
}
