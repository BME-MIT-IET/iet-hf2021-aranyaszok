package main.java.aranyaszok.listener;

import main.java.aranyaszok.Player;
import main.java.aranyaszok.gui.GamePanel;
import main.java.aranyaszok.gui.SteppableView;
import main.java.aranyaszok.gui.View;

/**
 * Ez az osztaly valositja meg azt az action, ami akkor torenik, ha a Move gombra kattintunk.
 * @author aranyaszok
 *
 */
public class MoveButtonAction implements IMyAction{
	private static final long serialVersionUID = 3073715099046456524L;

	/**
	 *A jelenleg aktiv jatekoson hivodik a move fuggveny (munkaba kerul). Majd frissul a kep
	 */
	@Override
	public void OnMouseCLick(View w) {
		
		GamePanel gamepanel = (GamePanel)w.getPanel();
		SteppableView playerView = (SteppableView)gamepanel.getSelectedPlayer();
		
		Player player = (Player)playerView.GetModel();
		player.Move(player.GetFacing());
		player.Work();
		gamepanel.DisableMoveButton();
		
		if (player.GetWater().GetView() != null){
			player.GetWater().GetView().GetAction().OnMouseCLick(player.GetWater().GetView());
		}
		
		
		gamepanel.GetViewManager().Update();
	}
}
