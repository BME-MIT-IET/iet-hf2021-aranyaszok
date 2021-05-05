package main.java.aranyaszok.listener;

import main.java.aranyaszok.gui.View;


/**
 * Ez az osztaly valositja meg azt az action, ami akkor torenik, ha a Resume gombra kattintunk.
 * @author aranyaszok
 *
 */
public class ResumeButtonAction implements IMyAction {
	private static final long serialVersionUID = 7714567456213454108L;

	/**
	 *A resume gombra kattintva folytatni tudjuk az eppen betoltott jatekot
	 */
	@Override
	public void OnMouseCLick(View w) {
		w.getPanel().GetViewManager().ChangeSelectedPanel("game");
		
	}

	
}
