package main.java.aranyaszok.listener;

import main.java.aranyaszok.Eskimo;
import main.java.aranyaszok.Ice;
import main.java.aranyaszok.Player;
import main.java.aranyaszok.Researcher;
import main.java.aranyaszok.Water;
import main.java.aranyaszok.gui.GamePanel;
import main.java.aranyaszok.gui.SteppableView;
import main.java.aranyaszok.gui.View;

/**
 * Ez az osztaly valositja meg azt az action, ami akkor torenik, ha egy mezore kattintunk.
 * @author aranyaszok
 *
 */

public class FieldAction implements IMyAction{
	private static final long serialVersionUID = 4612393288516511612L;

	/**
	 *Egy field-re kattintva kivalasztodik az aktiv mezo
	 */
	@Override
	public void OnMouseCLick(View w) {
		
		GamePanel gamepanel = (GamePanel)w.getPanel();
		gamepanel.setSelectedField(w);
		
		SteppableView playerView = (SteppableView)gamepanel.getSelectedPlayer();
		
		Player playerModel = (Player)playerView.GetModel();
		Water standingWater =  playerModel.GetWater();
		
		
		
		gamepanel.setSelectedItem(null);
		gamepanel.DisableAllButtons();
		
		
		if ( (Water)w.GetModel() == standingWater) {
			
			if(standingWater instanceof Ice) {
				gamepanel.EnableDigButton();
				if(playerModel instanceof Researcher) {
					gamepanel.EnableUseSkillButton();
				}
				if(playerModel instanceof Eskimo) {
					gamepanel.EnableUseSkillButton();
				}
			}
			playerModel.SetFacing((Water)w.GetModel());
			return;
		}

		if (standingWater.IsNeightbour((Water)w.GetModel())) {
			if(standingWater instanceof Ice) {
				gamepanel.EnableMoveButton();
				if(playerModel instanceof Researcher) {
					gamepanel.EnableUseSkillButton();
				}
			}else {
				if(playerModel.GetSafe()) {
					gamepanel.EnableMoveButton();
					
				}
			}
			
			
			playerModel.SetFacing((Water)w.GetModel());
		}

		
	}

	
	
}
