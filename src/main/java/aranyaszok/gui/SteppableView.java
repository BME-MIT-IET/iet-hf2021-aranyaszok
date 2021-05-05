package main.java.aranyaszok.gui;

import main.java.aranyaszok.Bear;
import main.java.aranyaszok.Eskimo;
import main.java.aranyaszok.ITMan;
import main.java.aranyaszok.Ice;
import main.java.aranyaszok.Researcher;
import main.java.aranyaszok.Seal;
import main.java.aranyaszok.Steppable;
import main.java.aranyaszok.Water;

/**
 * A Steppable logikai osztalyt megjelenito view.
 * @author aranyaszok
 *
 */
public class SteppableView extends View{

	private static final long serialVersionUID = 7923797108517813305L;


	/**
	 * Az osztaly kontruktora.
	 * @param x A nezet x koordinataja
	 * @param y A nezet y koordinataja
	 * @param w A nezet x szerinti eltolasa
	 * @param h A nezet y szerinti eltolasa
	 */
	public SteppableView(int x, int y, int w, int h) {
		super(x, y, w, h);

	}


	/**
	 *A Refresh hivasakor beallitodik a logikai modell alapjan a jatekos nezete, ennek megfeleloen eldonti ki a jatekos, vizben van-e, visel-e buvarruhat
	 *A nezet x,y koordinataja beallitodik az alapjan, hogy a logikai modell melyik mezon all
	 */
	@Override
	public void Refresh() {
		
		Steppable model = (Steppable) this.GetModel();
		Water field = model.GetWater();
		
		int x = model.GetWater().GetView().GetX();
		int y = model.GetWater().GetView().GetY();
		
		if ( model instanceof ITMan ) {
			x+=0;
			y-=20;
			if(field instanceof Ice) {
				if(((ITMan) model).GetSafe())
				{
					this.SetActiveImage(this.getPanel().vm.images.itmanImages.get("standingD"));
				}else {
					this.SetActiveImage(this.getPanel().vm.images.itmanImages.get("standing"));
				}
				
			}else {
				if(((ITMan) model).GetSafe())
				{
					this.SetActiveImage(this.getPanel().vm.images.itmanImages.get("inWaterD"));
				}else {
					this.SetActiveImage(this.getPanel().vm.images.itmanImages.get("inWater"));
				}
			}
		}
		
		if ( model instanceof Eskimo ) {	
			x+=0;
			y+=42;
			if(field instanceof Ice) {
				if(((Eskimo) model).GetSafe())
				{
					this.SetActiveImage(this.getPanel().vm.images.eskimoImages.get("standingD"));
				}else {
					this.SetActiveImage(this.getPanel().vm.images.eskimoImages.get("standing"));
				}
				
			}else {
				
				if(((Eskimo) model).GetSafe())
				{
					this.SetActiveImage(this.getPanel().vm.images.eskimoImages.get("inWaterD"));
				}else {
					this.SetActiveImage(this.getPanel().vm.images.eskimoImages.get("inWater"));
				}
			}
		}
		
		if ( model instanceof Seal ) {
			x+=64;
			y-=20;	
			if(field instanceof Ice) {
				
				this.SetActiveImage(this.getPanel().vm.images.sealImages.get("standing"));
			}else {
				
				this.SetActiveImage(this.getPanel().vm.images.sealImages.get("inWater"));
			}
		}
		
		if ( model instanceof Researcher ) {	
			x+=64;
			y+=42;
			if(field instanceof Ice) {
				if(((Researcher) model).GetSafe())
				{
					this.SetActiveImage(this.getPanel().vm.images.researcherImages.get("standingD"));
				}else {
					this.SetActiveImage(this.getPanel().vm.images.researcherImages.get("standing"));
				}
				
			}else {
				if(((Researcher) model).GetSafe())
				{
					this.SetActiveImage(this.getPanel().vm.images.researcherImages.get("inWaterD"));
				}else {
					this.SetActiveImage(this.getPanel().vm.images.researcherImages.get("inWater"));
				}
			}
		}
		
		if(model instanceof Bear) {
			x +=30;
			y +=32;
			if(field instanceof Ice) {
				
				this.SetActiveImage(this.getPanel().vm.images.bearImages.get("standing"));
			}else {
				
				this.SetActiveImage(this.getPanel().vm.images.bearImages.get("inWater"));
			}
		}
		
		this.SetX(x);
		this.SetY(y);
	}

	

}
