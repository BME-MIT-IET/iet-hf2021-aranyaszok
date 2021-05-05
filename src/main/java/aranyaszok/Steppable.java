package main.java.aranyaszok;

import java.io.Serializable;

import main.java.aranyaszok.gui.View;

/**
 * Egy a palyan megjeleno, mozogni kepes karaktert reprezental.
 * @author aranyaszok
 */
public abstract class Steppable implements Serializable, IViewable {
	

	private static final long serialVersionUID = -3715064454354150504L;
	
	private Water facing;
	private Water water;
	private View view;
	
	
	/**
	 *A logikai modelhez tartozo nezetet beallito fuggveny
	 */
	@Override
	public void AddView(View v) {
		this.view = v;
	}

	/**
	 *A nezeti model lekeredezo fuggvenye
	 */
	public View GetView() {
		return view; 
	}
	
	/**
	 * Annak lekerdezese, hogy a karakter melyik iranyba nez.
	 * @return Azzal a mezovel ter vissza, amelyikre a jatekos nez.
	 */
	public Water GetFacing() {
		return facing;
	}
	
	
	/**
	 * A leszarmazottaknak meg kell valositaniuk. Ezen fuggvenyen keresztul a GameManager adhat lehetoseget a munkara az adott karakternek. 
	 * Ezt a funkciot jelen fazisban a commander valositja meg. A kesobbiekben fog ez a fuggveny elkeszulni.
	 */
	abstract public void Work();
		
	/**
	 * A karakter atlepese egy masik mezore.
	 * @param w - Az a hely, ahova a karakternek kell lepnie.
	 */
	public void Move(Water w) {
		water.RemoveSteppable(this);
		w.AddSteppable(this);
	}
	
	/**
	 * A karakter iranyt valtoztat.
	 * @param n - Azt adhatjuk meg, hogy mennyivel forduljon el a karakter. (Hany szomszeddal forduljon arrebb, ez negativ szammal is mukodik.)
	 */
	public void  ChangeDirection(int n) {
		int length = water.GetNumberOfNeighbours();
		
		n -= (n / length) * length;
		
		for (int i = 0; i < (n < 0 ? length + n : n); i++) {
			facing = water.GetNextNeighbour(facing);
		}
	}
	
	
	/**
	 * Annak a lekerdezese, hogy a karakter melyik mezon all.
	 * @return - A karakter mezoje. 
	 */
	public Water GetWater() {
		return water;
	}
	
	
	/**
	 * Annak a beallitasa, hogy a karakter melyik mezon alljon.
	 * @param w - A beallitando mezo.
	 */
	public void SetWater(Water w) {
		water = w;
	} 
	
	
	/**
	 * Annak beallitasa, hogy a karakter meliyk iranyba nezzen.
	 * @param w - Az a mezo, amire a karaktert szeretnenk hogy nezzen.
	 */
	public void SetFacing(Water w) {
		facing = w;
	}
	

}
