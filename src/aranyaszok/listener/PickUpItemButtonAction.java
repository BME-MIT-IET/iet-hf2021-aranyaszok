package aranyaszok.listener;

import aranyaszok.Item;
import aranyaszok.Player;
import aranyaszok.gui.GamePanel;
import aranyaszok.gui.ItemView;
import aranyaszok.gui.SteppableView;
import aranyaszok.gui.View;

/**
 * Ez az osztaly valositja meg azt az action, ami akkor torenik, ha a PickUp gombra kattintunk.
 * @author aranyaszok
 *
 */
public class PickUpItemButtonAction implements IMyAction{
	private static final long serialVersionUID = 2666157211065063598L;

	/**
	 *A floating item-ek közül felveszi az itemet az aktiv player inventory-jaba
	 */
	@Override
	public void OnMouseCLick(View w) {
		
		GamePanel gamepanel = (GamePanel)w.getPanel();
		SteppableView playerView = (SteppableView)gamepanel.getSelectedPlayer();
		Player player = (Player)playerView.GetModel();
		
		ItemView itemView = (ItemView)gamepanel.getSelectedItem();
		Item item = (Item)itemView.GetModel();
		
		player.PickUpItem(item);
		player.Work();
		gamepanel.setSelectedItem(null);
		gamepanel.DisableDropButton();
		gamepanel.DisablePickUpButton();
		gamepanel.DisableUseItemButton();
		gamepanel.GetViewManager().Update();
	
	}
}
