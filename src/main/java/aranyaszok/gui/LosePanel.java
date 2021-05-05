package main.java.aranyaszok.gui;

import main.java.aranyaszok.listener.BackToMenuAction;

/**
 * Ez a panel valositja meg azt a panelt, amit akkor mutatunk, ha a jatekos veszit.
 * Adattagokban taroljuk a hatteret, illetve a "Vissza a menube" gombot.
 * @author aranyaszok
 *
 */
public class LosePanel extends MyPanel{

	private static final long serialVersionUID = -1321431674856091034L;
	
	private Button exitButton;
	private Background bg;
	
	/**
	 * Az osztaly konstruktora. Itt inicializaljuk a gombot, hatteret.
	 * @param vm A viewManager referenciaja.
	 */
	public LosePanel(ViewManager vm) {
		super(vm);
		
		exitButton = new Button(478,560,340,88);
		exitButton.SetAction(new BackToMenuAction());
		bg = new Background(0,0,1280,720);
		bg.SetActiveImage(vm.images.loseBgImage);
		AddStaticView(bg);
		
		exitButton.SetActiveImage(vm.images.exitButtonImage);
	}
	
	/**
	 * Beallitja a dinamikusan frissulo nezeteket
	 */
	@Override
	public void UpdateDynamicViews() {
		super.UpdateDynamicViews();
		AddDynamicView(exitButton);		
	}

}
