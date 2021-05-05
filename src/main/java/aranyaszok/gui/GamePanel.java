package main.java.aranyaszok.gui;

import java.io.Serializable;
import java.util.ArrayList;

import main.java.aranyaszok.Item;
import main.java.aranyaszok.Main;
import main.java.aranyaszok.Player;
import main.java.aranyaszok.Water;
import main.java.aranyaszok.listener.BackToMenuAction;
import main.java.aranyaszok.listener.DigButtonAction;
import main.java.aranyaszok.listener.DropItemButtonAction;
import main.java.aranyaszok.listener.EndTurnButtonAction;
import main.java.aranyaszok.listener.ItemAction;
import main.java.aranyaszok.listener.MoveButtonAction;
import main.java.aranyaszok.listener.PickUpItemButtonAction;
import main.java.aranyaszok.listener.UseItemButtonAction;
import main.java.aranyaszok.listener.UseSkillButtonAction;

/**
 * Ez a panel valositja meg azt a panelt, amit akkor mutatunk, ha a jatekos eppen jatszik.
 * Adattagokban taroljuk a hattereket, gombokat, illetve az aktiv item-et, jatekost, filed-et.
 * A tobbit, ami a jatekohozt kell (mezok, jatekos, itemek), kivulrol adjuk hozza, a megfelelo listaba.
 * @author aranyaszok
 *
 */
public class GamePanel extends MyPanel implements Serializable{
	
	private static final long serialVersionUID = -1856468396738766116L;
	
	private IDrawable selectedPlayer;
	private IDrawable selectedItem;
	private IDrawable selectedField;
	
	Button digItemButton;
	Button dropItemButton;
	Button endTurnButton;
	Button backToMenuButton;
	Button moveButton;
	Button pickUpButton;
	Button useItemButton;
	Button useSkillButton;

	private Background bg;
	private Background infoPanelBg;
	private Background selectedFieldFrame;  
	private Background selectedItemFrame; 
	private Background researchView; 
	private Background numberOfPlayerLeftView; 

	/**
	 * A konstruktor beallitja a panel referenciat, letrehozza a navigalo gombokat
	 * @param vm A ViewManager referenciaja.
	 */
	public GamePanel(ViewManager vm) {
		super(vm);
		
		BackgroundSetUp();
		ButtonSetUp();
	}
	
	
	/**
	 * A gombokat beallito fuggveny. Itt inicializaljuk a gomokat, illetve allitjuk be a kezdeti kepuket.
	 */
	public void ButtonSetUp() {
		digItemButton = new Button(1100,464,84,28);
		digItemButton.SetAction(new DigButtonAction());
		digItemButton.SetActiveImage(vm.images.digButtonImages.get("normal"));
		
		dropItemButton = new Button(1012,498,84,28);
		dropItemButton.SetAction(new DropItemButtonAction());
		dropItemButton.SetActiveImage(vm.images.dropItemButtonImages.get("normal"));
		
		endTurnButton = new Button(1078,534,128,34);
		endTurnButton.SetAction(new EndTurnButtonAction());
		endTurnButton.SetActiveImage(vm.images.endTurnButtonImages.get("normal"));
		
		backToMenuButton = new Button(1210,0,70,22);
		backToMenuButton.SetAction(new BackToMenuAction());
		backToMenuButton.SetActiveImage(vm.images.backToMenuButtonImage);
		
		moveButton = new Button(1012,464,84,28);
		moveButton.SetAction(new MoveButtonAction());
		moveButton.SetActiveImage(vm.images.moveButtonImages.get("normal"));
		
		pickUpButton = new Button(1100,498,84,28);
		pickUpButton.SetAction(new PickUpItemButtonAction());
		pickUpButton.SetActiveImage(vm.images.pickItemButtonImages.get("normal"));
		
		useItemButton = new Button(1188,498,84,28);
		useItemButton.SetAction(new UseItemButtonAction());
		useItemButton.SetActiveImage(vm.images.useItemButtonImages.get("normal"));
		
		useSkillButton = new Button(1188,464,84,28);
		useSkillButton.SetAction(new UseSkillButtonAction());
		useSkillButton.SetActiveImage(vm.images.useSkillButtonImages.get("normal"));
		
		AddPanelView(digItemButton);
		AddPanelView(dropItemButton);
		AddPanelView(endTurnButton);
		AddPanelView(backToMenuButton);
		AddPanelView(moveButton);
		AddPanelView(pickUpButton);
		AddPanelView(useItemButton);
		AddPanelView(useSkillButton);
	}
	
	/**
	 * A Panel-ben talalhato hattereket beallito fuggveny
	 */
	public void BackgroundSetUp() {
		bg = new Background(0,0,1280,720);
		infoPanelBg = new Background(1006,0,274,720);
		selectedFieldFrame = new Background(1500,0,204,720);
		selectedItemFrame = new Background(1500,0,204,720);
		researchView = new Background(1186,72,5,5);
		numberOfPlayerLeftView = new Background(1114,10,5,5);
		
		bg.SetActiveImage(vm.images.gameBgImage);
		infoPanelBg.SetActiveImage(vm.images.infoBgImage);
		selectedFieldFrame.SetActiveImage(vm.images.selectedFieldFrame);	
		
		AddPanelView(bg);
		AddPanelView(infoPanelBg);
		AddPanelView(selectedFieldFrame);
		
	}
	
	/**
	 * A jelenlegi aktiv player nezet lekerdezesere szolgalo fuggveny
	 * @return
	 */
	public IDrawable getSelectedPlayer() {
		return selectedPlayer;
	}

	/**
	 * A jelenlegi aktiv player nezet beallitasara szolgalo fuggveny
	 * @param selectedPlayer Aktiv jatekos nezete
	 */
	public void setSelectedPlayer(IDrawable selectedPlayer) {
		this.selectedPlayer = selectedPlayer;
	}

	/**
	 * A jelenleg aktiv item nezetet lekerdezesere szolgalo fuggveny
	 * @return Aktiv item view
	 */
	public IDrawable getSelectedItem() {
		return selectedItem;
	}

	/**
	 * A jelenlegi aktiv item nezet beallitasara szolgalo fuggveny
	 * @param selectedItem
	 */
	public void setSelectedItem(IDrawable selectedItem) {
		this.selectedItem = selectedItem;
		if(selectedItem != null) {
			View i = (ItemView)selectedItem;
			selectedItemFrame.SetX(i.GetX());
			selectedItemFrame.SetY(i.GetY());
		}
	}

	/**
	 * A jelenlegi aktiv item nezet lekerdezesere szolgalo fuggveny
	 * @return
	 */
	public IDrawable getSelectedField() {
		return selectedField;
	}

	/**
	 * A jelenlegi aktiv item nezet beallitasara szolgalo fuggveny
	 * @param selectedField
	 */
	public void setSelectedField(IDrawable selectedField) {
		this.selectedField = selectedField;
		View f = (FieldView)selectedField;
		
		selectedFieldFrame.SetX(f.GetX());
		selectedFieldFrame.SetY(f.GetY());
		
	}
	
	public Button getDigItemButton() {
		return digItemButton;
	}

	public Button getDropItemButton() {
		return dropItemButton;
	}

	public Button getEndTurnButton() {
		return endTurnButton;
	}

	public Button getBackToMenuButton() {
		return backToMenuButton;
	}

	public Button getMoveButton() {
		return moveButton;
	}

	public Button getPickUpButton() {
		return pickUpButton;
	}

	public Button getUseItemButton() {
		return useItemButton;
	}

	public Button getUseSkillButton() {
		return useSkillButton;
	}
	
	public Background getSelectedFieldFrame() {
		return selectedFieldFrame;
	}

	public void setSelectedFieldFrame(Background selectedFieldFrame) {
		this.selectedFieldFrame = selectedFieldFrame;
	}

	public Background getSelectedItemFrame() {
		return selectedItemFrame;
	}

	public void setSelectedItemFrame(Background selectedItemFrame) {
		this.selectedItemFrame = selectedItemFrame;
	}

	/**
	 * Tiltja a Dig gombot
	 */
	public void DisableDigButton() {
		digItemButton.SetDisabled(true);
		digItemButton.SetActiveImage(vm.images.digButtonImages.get("disabled"));
	}
	
	/**
	 * Engedelyezi a Dig gombot
	 */
	public void EnableDigButton() {
		digItemButton.SetDisabled(false);
		digItemButton.SetActiveImage(vm.images.digButtonImages.get("normal"));
	}

	
	/**
	 * Tiltja a DropItem gombot
	 */
	public void DisableDropButton() {
		this.dropItemButton.SetDisabled(true);
		dropItemButton.SetActiveImage(vm.images.dropItemButtonImages.get("disabled"));
	}
	
	/**
	 * Engedelyezi a DropItem gombot
	 */
	public void EnableDropButton() {
		dropItemButton.SetDisabled(false);
		dropItemButton.SetActiveImage(vm.images.dropItemButtonImages.get("normal"));
	}

	
	/**
	 * Tiltja a Move gombot
	 */
	public void DisableMoveButton() {
		this.moveButton.SetDisabled(true);
		moveButton.SetActiveImage(vm.images.moveButtonImages.get("disabled"));
	}
	
	
	/**
	 * Engedelyezi a Move gombot
	 */
	public void EnableMoveButton() {
		moveButton.SetDisabled(false);
		moveButton.SetActiveImage(vm.images.moveButtonImages.get("normal"));
	}
	
	
	/**
	 * Tiltja a PickUpButton gombot
	 */
	public void DisablePickUpButton() {
		this.pickUpButton.SetDisabled(true);
		pickUpButton.SetActiveImage(vm.images.pickItemButtonImages.get("disabled"));
	}
	
	
	/**
	 * Engedelyezi a PickUp gombot
	 */
	public void EnablePickUpButton() {
		pickUpButton.SetDisabled(false);
		pickUpButton.SetActiveImage(vm.images.pickItemButtonImages.get("normal"));
	}
	
	
	/**
	 * Tiltja a UseItem gombot
	 */
	public void DisableUseItemButton() {
		useItemButton.SetDisabled(true);
		useItemButton.SetActiveImage(vm.images.useItemButtonImages.get("disabled"));
	}
	
	
	/**
	 * Engedelyezi a UseItem gombot
	 */
	public void EnableUseItemButton() {
		useItemButton.SetDisabled(false);
		useItemButton.SetActiveImage(vm.images.useItemButtonImages.get("normal"));
	}
	
	
	/**
	 * Tiltja a UseSkill gombot
	 */
	public void DisableUseSkillButton() {
		useSkillButton.SetDisabled(true);
		useSkillButton.SetActiveImage(vm.images.useSkillButtonImages.get("disabled"));
	}
	
	
	/**
	 * Engedelyezi a UseSkill gombot
	 */
	public void EnableUseSkillButton() {
		useSkillButton.SetDisabled(false);
		useSkillButton.SetActiveImage(vm.images.useSkillButtonImages.get("normal"));
	}
	
	
	/**
	 * Tiltja az osszes gombot.
	 */
	public void DisableAllButtons() {
		DisableUseSkillButton();
		DisableUseItemButton();
		DisablePickUpButton();
		DisableMoveButton();
		DisableDropButton();
		DisableDigButton();
	}
	
	
	/**
	 *Frissiti a dinamikus view-kat.
	 */
	@Override
	public void UpdateDynamicViews() {
		super.UpdateDynamicViews();
		
		if (selectedField != null) {
			
			this.selectedField = selectedField;
			View field = (FieldView)selectedField;
			Water water = (Water)field.GetModel();
			ArrayList<Item> items = water.GetFloatingItems();
			
			for (int i = 0; i < items.size(); i++) {
				if(i < 4) {
					 items.get(i).GetView().SetX(i * 66 + 1012);
					 items.get(i).GetView().SetY(116);
				}else {
					int n = i - 4;
					 items.get(i).GetView().SetX(n * 66 + 1012);
					 items.get(i).GetView().SetY(182);
				}

				
				items.get(i).GetView().SetAction(new ItemAction());
				this.AddDynamicView(items.get(i).GetView());
			}
			
			
			if(water.isResearched()) {
				int numberOfCapacity = water.GetCapacity();
				if(numberOfCapacity == -1) {
					this.researchView.SetActiveImage(vm.images.capacityInfiniteImage);
				}else {
					this.researchView.SetActiveImage(vm.images.capacityImages.get(numberOfCapacity));	
				}
			}else {
				this.researchView.SetActiveImage(vm.images.capacityUnknownImage);
			}
			
			this.AddDynamicView(this.researchView);
		}
		
		if(selectedPlayer != null) {
			Background playerToShow = new Background(1012,296,64,64);
			SteppableView temp = (SteppableView)selectedPlayer;
			playerToShow.SetActiveImage(temp.GetActiveImage());
			AddDynamicView(playerToShow);
			Player playerModel = (Player)temp.GetModel();
			ArrayList<Item> items = playerModel.GetItems();

			
			for (int i = 0; i < items.size(); i++) {
				
					 items.get(i).GetView().SetX(i * 66 + 1012);
					 items.get(i).GetView().SetY(390);
				
				
				items.get(i).GetView().SetAction(new ItemAction());
				this.AddDynamicView(items.get(i).GetView());
			}
			
			int currHealth = playerModel.GetBodyHeat();
			int maxHealth = playerModel.GetBodyHeatBase();
			
			Background currHealtView = new Background(1180,308,5,5);
			Background maxHealtView = new Background(1200,308,5,5);
			currHealtView.SetActiveImage(vm.images.redNumberImages.get(currHealth));
			maxHealtView.SetActiveImage(vm.images.redNumberImages.get(maxHealth));
			this.AddDynamicView(currHealtView);
			this.AddDynamicView(maxHealtView);
			
			
			int energy = playerModel.GetWorkLeft();
			
			Background energyView = new Background(1180,333,5,5);
			Background maxEnergyView = new Background(1200,333,5,5);
			energyView.SetActiveImage(vm.images.blueNumberImages.get(energy));
			maxEnergyView.SetActiveImage(vm.images.blueNumberImages.get(4));
			this.AddDynamicView(energyView);
			this.AddDynamicView(maxEnergyView);
			
			
			ArrayList<Player> players = Main.gameManager.GetPlayers();
			int counter = 0;
			for (int j = 0; j < players.size(); j++) {
				if(players.get(j) != playerModel) {
					currHealth = players.get(j).GetBodyHeat();
					maxHealth = players.get(j).GetBodyHeatBase();
					
					currHealtView = new Background(1050 + counter * 78 ,694,5,5);
					maxHealtView =  new Background(1070 + counter * 78 ,694,5,5);
					currHealtView.SetActiveImage(vm.images.redNumberImages.get(currHealth));
					maxHealtView.SetActiveImage(vm.images.redNumberImages.get(maxHealth));
					this.AddDynamicView(currHealtView);
					this.AddDynamicView(maxHealtView);
					
					
					Background otherPlayerView = new Background(1032 + counter * 78,624,20,20);
					SteppableView tempOtherPlayerView = (SteppableView)players.get(j).GetView();
					otherPlayerView.SetActiveImage(tempOtherPlayerView.GetActiveImage());
					this.AddDynamicView(otherPlayerView);
					counter++;
				}
			}
			if (selectedItem != null) {
				
				selectedItemFrame.SetActiveImage(vm.images.selectedItemFrame);
				AddDynamicView(selectedItemFrame);
			}
			
			
			
		}
		
		Background stormPercentElsoSzamjegy = new Background(1048,14,5,5);
		Background stormPercentMasodikSzamjegy = new Background(1058,14,5,5);
		Background percent = new Background(1070,14,5,5);
		int chanche = Main.gameManager.GetChancheOfStorm();

		stormPercentElsoSzamjegy.SetActiveImage(vm.images.lightBlueNumberImages.get(chanche / 10));
		stormPercentMasodikSzamjegy.SetActiveImage(vm.images.lightBlueNumberImages.get(chanche % 10));
		percent.SetActiveImage(vm.images.lightBluePercent);
		
		
		
		this.AddDynamicView(stormPercentElsoSzamjegy);
		this.AddDynamicView(stormPercentMasodikSzamjegy);
		this.AddDynamicView(percent);
		

		int numberOfPlayerLeft = Main.gameManager.getRemainingRounds();
		numberOfPlayerLeftView.SetActiveImage(vm.images.numberOfPlayersLeftImages.get(numberOfPlayerLeft));
		this.AddDynamicView(numberOfPlayerLeftView);
	}

	@Override
	public void Reset() {
		
		super.Reset();
		this.selectedField = null;
		this.selectedItem = null;
		this.selectedPlayer = null;
	}

}
