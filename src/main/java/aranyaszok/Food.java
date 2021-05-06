package main.java.aranyaszok;

import java.io.Serializable;

/**
 * Az elelmet valositja meg a jatekban aminek az ososztalya a Item
 * @author aranyaszok
 *
 */
public class Food extends Item implements Serializable {
	
	private static final long serialVersionUID = 2787206596534606695L;

	public Food() {
		super(1);
	}
	
	/**
	 *Ez az etel hasznalataert felelos 
	 *fuggveny. Az a player aki hasznalja ezt 
	 *az itemet a teshoje eggyel noni fog
	 *
	 *@param p : Player aki hasznalja az etelt 
	 */
	public void Use(Player p) {
		p.ChangeBodyHeat(1);
		
		super.Use(p);
	}
	
	/**
	 * A toString() fuggveny definialja felul 
	 */
	@Override
	public String toString() {
		return "Food";
	}
}
