package aranyaszok.listener;

import aranyaszok.Item;
import aranyaszok.Player;
import aranyaszok.gui.GamePanel;
import aranyaszok.gui.ItemView;
import aranyaszok.gui.SteppableView;
import aranyaszok.gui.View;

/**
 * Ez az osztaly valositja meg azt az action, ami akkor torenik, ha a UseItem gombra kattintunk.
 * @author aranyaszok
 *
 */
public class UseItemButtonAction implements IMyAction{
	private static final long serialVersionUID = -978737055053719004L;

	/**
	 *A jelenleg kivalasztott Item hivodik a jelenleg aktic jatekoson. Majd frissul a kep
	 */
	@Override
	public void OnMouseCLick(View w) {
		GamePanel gamepanel = (GamePanel)w.getPanel();
		SteppableView playerView = (SteppableView)gamepanel.getSelectedPlayer();
		Player player = (Player)playerView.GetModel();
		
		ItemView itemView = (ItemView)gamepanel.getSelectedItem();
		Item item = (Item)itemView.GetModel();
		
		item.Use(player);
		player.Work();
		gamepanel.setSelectedItem(null);
		gamepanel.DisableDropButton();
		gamepanel.DisablePickUpButton();
		gamepanel.DisableUseItemButton();
		gamepanel.GetViewManager().Update();
	}
}
