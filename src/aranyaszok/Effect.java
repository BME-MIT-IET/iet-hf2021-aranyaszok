package aranyaszok;

import java.io.Serializable;

/**
 * Az effect osztály valósítja meg az effekteknek az ososztalyat a jatekban. Ebbol az osztálybol származik az osszes effect.
 * @author aranyaszok
 *
 */
public abstract class Effect implements Serializable {
	
	
	private static final long serialVersionUID = 1392483590098638256L;


	/**A Call fuggveny valositja meg a hivast a teruletre. Ennek a fuggvenynek a segitsegevel tudjuk adott teruletre elkezdeni az effektus hivast.
	 * @param w : Water
	 */
	public void Call(Water w) {
		w.EffectCall(this);
	}
	
	
	/**
	 * Absztrak fuggveny a leszarmazotjai fogjak megvalositani
	 * 
	 * @param p: Player akin az effektus majd hat
	 */
	public abstract void Effects(Player p);
	
	
	/**
	 * A toString() fuggveny definialja felul 
	 */
	@Override
	public String toString() {
		return "Effect";
	}
}
