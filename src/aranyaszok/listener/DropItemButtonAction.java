package aranyaszok.listener;

import aranyaszok.Item;
import aranyaszok.Player;
import aranyaszok.gui.GamePanel;
import aranyaszok.gui.ItemView;
import aranyaszok.gui.SteppableView;
import aranyaszok.gui.View;

/**
 * Ez az osztaly valositja meg azt az action, ami akkor torenik, ha a DropItem gombra kattintunk.
 * @author aranyaszok
 *
 */

public class DropItemButtonAction implements IMyAction {
	private static final long serialVersionUID = 728672254559907312L;

	
	/**
	 *DropItem gombra kattintva a jelenleg aktiv item-et eldobja a palyer.
	 */
	@Override
	public void OnMouseCLick(View w) {
		
		GamePanel gamepanel = (GamePanel)w.getPanel();
		SteppableView playerView = (SteppableView)gamepanel.getSelectedPlayer();
		Player player = (Player)playerView.GetModel();
		
		ItemView itemView = (ItemView)gamepanel.getSelectedItem();
		Item item = (Item)itemView.GetModel();
		
		player.DropItem(item);
		player.Work();
		gamepanel.setSelectedItem(null);
		gamepanel.DisableDropButton();
		gamepanel.DisablePickUpButton();
		gamepanel.DisableUseItemButton();
		gamepanel.GetViewManager().Update();
	}
}