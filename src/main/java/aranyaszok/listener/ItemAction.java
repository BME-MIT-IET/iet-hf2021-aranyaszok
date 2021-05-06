package main.java.aranyaszok.listener;

import main.java.aranyaszok.Item;
import main.java.aranyaszok.Player;
import main.java.aranyaszok.Rope;
import main.java.aranyaszok.Water;
import main.java.aranyaszok.gui.FieldView;
import main.java.aranyaszok.gui.GamePanel;
import main.java.aranyaszok.gui.ItemView;
import main.java.aranyaszok.gui.SteppableView;
import main.java.aranyaszok.gui.View;

/**
 * Ez az osztaly valositja meg azt az action, ami akkor torenik, ha egy item-re kattintunk.
 * @author aranyaszok
 *
 */
public class ItemAction implements IMyAction{
	private static final long serialVersionUID = -6575109123529790978L;

	/**
	 *Ha az item-re kattintunk es az a floating item, vagy az aktiv jatekos inventory-jaban levo item, akkor ez az item lesz a kivalasztott item
	 */
	@Override
	public void OnMouseCLick(View w) {
		
		
		GamePanel gamepanel = (GamePanel)w.getPanel();
		gamepanel.setSelectedItem(w);
		ItemView itemView = (ItemView)gamepanel.getSelectedItem();
		Item item = (Item)itemView.GetModel();
		SteppableView playerView = (SteppableView)gamepanel.getSelectedPlayer();
		
		Player playerModel = (Player)playerView.GetModel();
		Water standingWater =  playerModel.GetWater();
		
		FieldView selectedFieldView = (FieldView)gamepanel.getSelectedField();
		Water selectedFieldModel = (Water)selectedFieldView.GetModel();
		
		if (standingWater.IsFloatingItem(item)) {
			
			gamepanel.DisableDropButton();
			gamepanel.EnablePickUpButton();
			gamepanel.DisableUseItemButton();
			
			
		}else if(playerModel.IsInventoryItem(item)) {
			if(!(item instanceof Rope)) {
				gamepanel.EnableUseItemButton();
			}
			if(item instanceof Rope && standingWater.IsNeightbour(selectedFieldModel)) {
				gamepanel.EnableUseItemButton();
			}
			gamepanel.EnableDropButton();
			gamepanel.DisablePickUpButton();
			
			
			
			
		}else {
			gamepanel.setSelectedItem(null);
		}
		
		
		gamepanel.GetViewManager().Update();
		
		
	}

}
