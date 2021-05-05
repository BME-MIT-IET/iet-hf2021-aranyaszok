package main.java.aranyaszok.listener;

import main.java.aranyaszok.Player;
import main.java.aranyaszok.gui.GamePanel;
import main.java.aranyaszok.gui.SteppableView;
import main.java.aranyaszok.gui.View;

/**
 * Ez az osztaly valositja meg azt az action, ami akkor torenik, ha a Dig gombra kattintunk.
 * @author aranyaszok
 *
 */
public class DigButtonAction implements IMyAction {
	private static final long serialVersionUID = -4783120729301577451L;

	
	/**
	 *A dig gombra kattintva az aktiv jatekos asast vegez azon a filed-en amelyen eppen tartozkodik.
	 */
	@Override
	public void OnMouseCLick(View w) {
		
		GamePanel gamepanel = (GamePanel)w.getPanel();
		SteppableView playerView = (SteppableView)gamepanel.getSelectedPlayer();
		Player player = (Player)playerView.GetModel();
		
		
		player.Digging();
		player.Work();
		
		gamepanel.setSelectedItem(null);
		
		gamepanel.DisableDropButton();
		gamepanel.DisablePickUpButton();
		gamepanel.DisableUseItemButton();
		
		gamepanel.GetViewManager().Update();
		
		
		
	}
}
