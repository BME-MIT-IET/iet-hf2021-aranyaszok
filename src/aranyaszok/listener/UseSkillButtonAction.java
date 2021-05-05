package aranyaszok.listener;


import aranyaszok.Player;
import aranyaszok.gui.GamePanel;
import aranyaszok.gui.SteppableView;
import aranyaszok.gui.View;

/**
 * Ez az osztaly valositja meg azt az action, ami akkor torenik, ha a UseSkill gombra kattintunk.
 * @author aranyaszok
 *
 */
public class UseSkillButtonAction implements IMyAction{
	private static final long serialVersionUID = 5982235871916337793L;

	/**
	 *A jelenleg aktiv jatekoson hivodik a skill fuggveny (munkaba kerul). Majd frissul a kep
	 */
	@Override
	public void OnMouseCLick(View w) {
		
		GamePanel gamepanel = (GamePanel)w.getPanel();
		SteppableView playerView = (SteppableView)gamepanel.getSelectedPlayer();
		Player player = (Player)playerView.GetModel();
		
		
		player.Skill();
		player.Work();
		
		gamepanel.setSelectedItem(null);
		gamepanel.DisableDropButton();
		gamepanel.DisablePickUpButton();
		gamepanel.DisableUseItemButton();
		gamepanel.GetViewManager().Update();
	}
}
