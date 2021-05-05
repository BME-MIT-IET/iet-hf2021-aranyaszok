package main.java.aranyaszok.gui;

import main.java.aranyaszok.Ice;
import main.java.aranyaszok.Water;

/**
 * A Water logikai osztalyt megjelenito view.
 * @author aranyaszok
 *
 */
public class FieldView extends View {
	
	private static final long serialVersionUID = -5600294758334037893L;

	/**
	 * Az osztaly kontruktora.
	 * @param x A nezet x koordinataja
	 * @param y A nezet y koordinataja
	 * @param w A nezet x szerinti eltolasa
	 * @param h A nezet y szerinti eltolasa
	 */
	public FieldView(int x, int y, int w, int h) {
		super(x, y, w, h);
		
	}

	/**
	 *A refresh fuggveny hivasakkor frissul a field kepe.
	 */
	@Override
	public void Refresh() {

		super.Refresh();
		Water water = (Water) this.GetModel();
		int numberOfLayers = water.GetSnowLayers();
		
		if(water instanceof Ice) {
			this.SetActiveImage(this.getPanel().GetViewManager().images.iceImages.get(numberOfLayers));
			return;
		}
		
		if(water instanceof Water) {
			if ( numberOfLayers > 0) {
				this.SetActiveImage(this.getPanel().GetViewManager().images.iceImages.get(numberOfLayers));
			}else {
				this.SetActiveImage(this.getPanel().GetViewManager().images.emptyImages.get(128));
			}
			return;
		}
		
		
	}
}
