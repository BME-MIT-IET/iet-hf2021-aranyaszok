package main.java.aranyaszok.listener;

import main.java.aranyaszok.Main;
import main.java.aranyaszok.gui.View;

/**
 * Ez az osztaly valositja meg azt az action, ami akkor torenik, ha a NewGme gombra kattintunk.
 * @author aranyaszok
 *
 */

public class NewGameButtonAction  implements IMyAction  {
	private static final long serialVersionUID = 1113407180800353453L;

	public NewGameButtonAction() {}

	/**
	 *A newGame gombra kattintva uj palya generalodik
	 */
	@Override
	public void OnMouseCLick(View w) {
		
		Main.gameManager.Reset();
		Main.gameManager.Play();
		w.getPanel().GetViewManager().ChangeSelectedPanel("game");
		w.getPanel().GetViewManager().Update();
		
	}	
}
