package main.java.aranyaszok.gui;

import main.java.aranyaszok.Building;
import main.java.aranyaszok.Iglu;
import main.java.aranyaszok.NullBuilding;
import main.java.aranyaszok.Tent;
import main.java.aranyaszok.Water;

/**
 * A building logikai osztalyt megjelenito view.
 * @author aranyaszok
 *
 */
public class BuildingView extends View{

	private static final long serialVersionUID = -5888336798441915998L;


	/**
	 * Az osztaly kontruktora.
	 * @param x A nezet x koordinataja
	 * @param y A nezet y koordinataja
	 * @param w A nezet x szerinti eltolasa
	 * @param h A nezet y szerinti eltolasa
	 */
	public BuildingView(int x, int y, int w, int h) {
		super(x, y, w, h);
		
	}


	/**
	 * A buildingeket frissito fuggveny. Itt frissitjuk a kepet, aszerint, hogy milyen building van a filed-en.
	 */
	@Override
	public void Refresh() {
		Water model = (Water) this.GetModel();
	
		int x = model.GetView().GetX();
		int y = model.GetView().GetY();
		
		Building building = model.GetBuilding();
		
		if ( building instanceof Iglu ) {
			
			this.SetActiveImage(this.getPanel().vm.images.iglu);
			
		}
		if ( building instanceof Tent ) {
			
			this.SetActiveImage(this.getPanel().vm.images.tent);
			
		}
		if ( building instanceof NullBuilding ) {
			
			this.SetActiveImage(this.getPanel().vm.images.emptyImages.get(64));
		}
		
		x+=34;
		y+=20;
		
		this.SetX(x);
		this.SetY(y);
		
	}

	
	

}
