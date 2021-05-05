package main.java.aranyaszok;

import java.util.Random;


/**
 * Ez az osztaly valositja meg a medvet a jatekban 
 * ososztalya a Steppable osztaly
 * 
 * @author aranyaszok
 *
 */
public class Bear extends Steppable {

	private static final long serialVersionUID = 6789894442987790615L;
	
	private BearEffect bearEffect;	
	
	/**
	 * A Bear konstruktora feladata 
	 * a bearEffect peldanyositasa
	 *  
	 */
	public Bear() {
		bearEffect = new BearEffect();
	}
	
	
	/**
	 * A Work() fuggveny a medve veletlenszeru mozgasat 
	 * hivatott megvalositani 
	 */
	public void Work() {
		Random r = new Random();
		int veletlen = r.nextInt(20);
		this.ChangeDirection(veletlen);
		this.Move(this.GetFacing());
	}
	
	
	/**
	 * Feladata a bearEffect Call metodusat hivja meg azzal 
	 * a Water parameterrel amin a medve all
	 */
	public void Attack() {		
		bearEffect.Call(this.GetWater());
	};
	

	
	/**
	 * A toString() függvény definiálja felul 
	 */
	@Override
	public String toString() {
		return "Bear";
	}

}
