package main.java.aranyaszok.gui;

import main.java.aranyaszok.listener.BackToMenuAction;

/**
 * Ez a panel valositja meg azt a panelt, amit akkor mutatunk, ha a jatekos nyert.
 * Adattagokban taroljuk a hatteret, illetve a "vissza a menure" gombot.
 * @author aranyaszok
 *
 */
public class WinPanel extends MyPanel {
	
	private static final long serialVersionUID = -2639538482547507360L;
	
	private Button exitButton;
	private Background bg;
	
	/**
	 * A WinPanel konstruktora beallitja a panel referenciat, majd a panel hatteret
	 * @param vm A ViewManager referencia.
	 * 
	 */
	public WinPanel(ViewManager vm) {
		super(vm);
		
		exitButton = new Button(478,560,340,88);
		exitButton.SetAction(new BackToMenuAction());
		bg = new Background(0,0,1280,720);
		bg.SetActiveImage(vm.images.winBgImage);
		AddStaticView(bg);
		
		exitButton.SetActiveImage(vm.images.exitButtonImage);
	}

	/**
	 * Dinamikusan jon letre az exit button, ezzel a gombbal lehet visszalepni a fomenube
	 */
	@Override
	public void UpdateDynamicViews() {
		super.UpdateDynamicViews();
		AddDynamicView(exitButton);
	}

}
