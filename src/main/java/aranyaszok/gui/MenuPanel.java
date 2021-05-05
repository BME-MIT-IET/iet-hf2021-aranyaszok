package main.java.aranyaszok.gui;

import main.java.aranyaszok.Main;
import main.java.aranyaszok.listener.ExitButtonAction;
import main.java.aranyaszok.listener.LoadButtonAction;
import main.java.aranyaszok.listener.NewGameButtonAction;
import main.java.aranyaszok.listener.ResumeButtonAction;
import main.java.aranyaszok.listener.SaveButtonAction;

/**
 * Ez a panel valositja meg azt a panelt, amit akkor mutatunk, ha a jatekos a menube lep.
 * Adattagokban taroljuk a hatteret, illetve a gombokat.
 * @author aranyaszok
 *
 */
public class MenuPanel extends MyPanel {
	 
	private static final long serialVersionUID = 5549682774025842038L;
	Button newGameButton;
	Button resumeButton;
	Button exitButton;
	Button loadButton;
	Button saveButton;
	Background bg;
	
	/**
	 * Az osztaly konstruktora.
	 * A konstruktorban inicializaljuk a gombokat, hatteret.
	 * @param vm A ViewManage referenciaja.
	 */
	public MenuPanel(ViewManager vm) {
		super(vm);
		
		resumeButton = new Button(478,215,340,88);
		resumeButton.SetAction(new ResumeButtonAction());
		newGameButton = new Button(478,313,340,88);
		newGameButton.SetAction(new NewGameButtonAction());
		loadButton = new Button(478,411,340,88);
		loadButton.SetAction(new LoadButtonAction());
		saveButton = new Button(478,509,340,88);
		saveButton.SetAction(new SaveButtonAction());
		exitButton = new Button(478,607,340,88);
		exitButton.SetAction(new ExitButtonAction());
		bg = new Background(0,0,1280,720);
		bg.SetActiveImage(vm.images.menuBgImage);
		this.AddStaticView(bg);
		
		newGameButton.SetActiveImage(vm.images.newGameButtonImage);
		loadButton.SetActiveImage(vm.images.loadButtonImage);
		saveButton.SetActiveImage(vm.images.saveButtonImages.get("normal"));
		exitButton.SetActiveImage(vm.images.exitButtonImage);
	}

	/**
	 * Dinamikusan beallitodnak a gombok a menupanelen, annak fuggvenyeben milyen allapotban vannak a gombok (kattinthato e?)
	 */
	@Override
	public void UpdateDynamicViews() {
		super.UpdateDynamicViews();
		
		
		if (Main.gameManager.getStateOfGame()) {
			EnableSaveButton();
			EnableResumeButton();
		} else {
			DisableSaveButton();
			DisableResumeButton();
		}
		
		AddDynamicView(newGameButton);
		AddDynamicView(exitButton);
		AddDynamicView(loadButton);
		AddDynamicView(saveButton);
		AddDynamicView(resumeButton);
		
		
	}
	
	/**
	 * Letiltja a save gombot
	 */
	public void DisableSaveButton() {
		saveButton.SetDisabled(true);
		saveButton.SetActiveImage(vm.images.saveButtonImages.get("disabled"));
	}
	
	/**
	 * Engedelyezi a save gombot
	 */
	public void EnableSaveButton() {
		saveButton.SetDisabled(false);
		saveButton.SetActiveImage(vm.images.saveButtonImages.get("normal"));
	}
	
	
	/**
	 * Letiltja a resume gombot
	 */
	public void DisableResumeButton() {
		resumeButton.SetDisabled(true);
		resumeButton.SetActiveImage(vm.images.resumeButtonImages.get("disabled"));
	}
	
	/**
	 * Engedelyezi a resume gombot
	 */
	public void EnableResumeButton() {
		resumeButton.SetDisabled(false);
		resumeButton.SetActiveImage(vm.images.resumeButtonImages.get("normal"));
	}
	
	
	
}

