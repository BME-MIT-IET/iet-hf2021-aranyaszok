package main.java.aranyaszok.listener;

import java.io.File;
import javax.swing.JFileChooser;

import main.java.aranyaszok.Main;
import main.java.aranyaszok.gui.MyFileFilter;
import main.java.aranyaszok.gui.View;

/**
 * Ez az osztaly valositja meg azt az action, ami akkor torenik, ha a Load gombra kattintunk.
 * @author aranyaszok
 *
 */

public class LoadButtonAction implements IMyAction {
	private static final long serialVersionUID = 1383571181699969660L;

	/**
	 *A save gombra kattintva, megjelenik a fileChooser, fajl kivalasztasa utan betolti a jatek allapotat a fajlbol, majd frissul a kep
	 */
	@Override
	public void OnMouseCLick(View w) {
	
		File dir = new File(System.getProperty("user.dir") + "\\Saves");
		JFileChooser chooser = new JFileChooser(dir);
		chooser.setFileFilter(new MyFileFilter("data"));
		
	    int returnVal = chooser.showOpenDialog(w.getPanel());
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       File file = chooser.getSelectedFile();
	       try {
				Main.gameManager.LoadGame(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			w.getPanel().GetViewManager().ChangeSelectedPanel("game");
			w.getPanel().GetViewManager().Update();
	    }
		
		
		
	}
	
	
}
