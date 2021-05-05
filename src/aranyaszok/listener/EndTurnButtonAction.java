package aranyaszok.listener;

import aranyaszok.Main;
import aranyaszok.Player;
import aranyaszok.gui.GamePanel;
import aranyaszok.gui.SteppableView;
import aranyaszok.gui.View;

/**
 * Ez az osztaly valositja meg azt az action, ami akkor torenik, ha az EndTurn gombra kattintunk.
 * @author aranyaszok
 *
 */

public class EndTurnButtonAction implements IMyAction{
	private static final long serialVersionUID = -720819166670648383L;

	
	/**
	 * EndTurn gombra kattintva a kor veget er.
	 */
	@Override
	public void OnMouseCLick(View w) {
		
		GamePanel gamepanel = (GamePanel)w.getPanel();
		SteppableView playerView = (SteppableView)gamepanel.getSelectedPlayer();
		
		Player player = (Player)playerView.GetModel();
		
		player.SetRemainingWork(4);
		Main.gameManager.Swap();
		gamepanel.GetViewManager().Update();
	}
}
