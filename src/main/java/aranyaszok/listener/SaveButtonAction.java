package main.java.aranyaszok.listener;

import java.io.File;

import javax.swing.JFileChooser;

import main.java.aranyaszok.Main;
import main.java.aranyaszok.gui.MyFileFilter;
import main.java.aranyaszok.gui.View;

/**
 * Ez az osztaly valositja meg azt az action, ami akkor torenik, ha a Save gombra kattintunk.
 * @author aranyaszok
 *
 */
public class SaveButtonAction implements IMyAction{
	private static final long serialVersionUID = -4073597996817842213L;

	/**
	 *A save gombra kattintva, megjelenik a fileChooser, fajl kivalasztasa utan elmenti a jatek allapotat a fajlba
	 */
	@Override
	public void OnMouseCLick(View w) {
		

		File dir = new File(System.getProperty("user.dir") + "\\Saves");
		JFileChooser chooser = new JFileChooser(dir);
		chooser.setFileFilter(new MyFileFilter("data"));
		
	    int returnVal = chooser.showSaveDialog(w.getPanel());
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       File file = chooser.getSelectedFile();
	       
	       try {
	    	   
	            String temp = file.getName();

	            int i = temp.lastIndexOf('.');
	            
	            if (i == -1) {
	            	file = new File(file.getAbsolutePath()+".data");
	  
	            }
	    	   
				Main.gameManager.SaveGame(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		
		
		
		
		
	}
}
