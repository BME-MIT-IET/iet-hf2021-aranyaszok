package main.java.aranyaszok.gui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;



/**
 * Ez az osztaly felelos a nezetek menedzseleseert. Itt taroljuk a kulonbozo nezeteket, itt hozzuk letre a JFrame-et, illetve a fo BufferedImage-et, amelyre minden
 * View (nezet) rajzol. Az oszaly megvalositja a Serializable interface-t, mivel az egyes elemeit ki szeretnenk menteni.
 * @author aranyaszok
 *
 */

public class ViewManager implements Serializable{
	
	private static final long serialVersionUID = -4872202392813779508L;
	
	transient private MyPanel selectedPanel;
	private GamePanel gamePanel;
	

	transient private MyPanel winPanel;
	transient private MyPanel losePanel;
	transient private MyPanel menuPanel;
	transient private Map<String,MyPanel> panels;
	
	transient private BufferedImage image;
	transient private JFrame frame = new JFrame();
	transient public ImageStorage images;
	transient private MyAction myAction;
	
	
	/**
	 * Az osztaly construktora. Itt inicializaljuk az egyes paneleket, a frame-et, illetve megjeloljuk a menupanelt aktiv panelkent. Az aktiv panelhez actionListener-t
	 * is itt rendelunk hozza.
	 */
	public ViewManager() {
		FrameInit();
		image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
		panels = new HashMap<String,MyPanel>();
		
		images = new ImageStorage();
		
		gamePanel = new GamePanel(this);
		losePanel = new LosePanel(this);
		winPanel = new WinPanel(this);
		menuPanel = new MenuPanel(this);
		
		panels.put("menu", menuPanel);
		panels.put("game", gamePanel);
		panels.put("lose", losePanel);
		panels.put("win", winPanel);

		selectedPanel = panels.get("menu");
		frame.add(selectedPanel,BorderLayout.PAGE_END);
		myAction = new MyAction(selectedPanel);
		frame.addMouseListener(myAction);
	}
	
	/**A jatekk panel lekerdezesehez szolgalo fuggveny
	 * @return A jatekter panelje
	 */
	public GamePanel getGamePanel() {
		return gamePanel;
	}

	
	/**
	 * Az aktualisan kivalasztott panelt rajzolja ki
	 */
	public void DrawPanel() {
		if (selectedPanel != null) {
			selectedPanel.DrawAll(image);
		}
		
	}
	
	/**
	 * A program indulasakor, a frame-et latja a felhasznalo, ennek a frame-nek az inicializalo fuggvenye
	 */
	public void FrameInit() {		
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setSize(1286, 746);
		frame.setTitle("Ice Diggers");
		frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);    
        
	}
	
	/**
	 * Az aktualis panel altal generalt kepet megjeleniti a frame-en
	 */
	public void DrawImageToScreen() { 
		Graphics g = frame.getGraphics();
        g.drawImage(image, 3, 26,null);
	}
	
	/**
	 * Az aktualis panel uj kepet general, majd megjeleniti a frame-en
	 */
	public void Update() {
		DrawPanel();
		DrawImageToScreen();
	}
	

	/** Jatek betoltesekor/ uj jatek kezdsenel a jatekpanel-ben talalhato static view tarolok feltoltesere szolgalo fuggveny
	 * @param view
	 */
	public void AddStaticViewToGamePanel(View view) {this.gamePanel.AddStaticView(view);}
	
	/**Jatek betoltesekor/ uj jatek kezdsenel a jatekpanel-ben talalhato dynamic view tarolok feltoltesere szolgalo fuggveny
	 * @param view
	 */
	public void AddDynamicViewToGamePanel(View view) {this.gamePanel.AddDynamicView(view);}
	
	/**A jelenleg aktiv panelt csereli le egy masik panelre
	 * @param s Megjelenitendo panel neve
	 */
	public void ChangeSelectedPanel(String s) {
		
		this.selectedPanel = this.panels.get(s);
		
		frame.removeMouseListener(myAction);
		myAction = new MyAction(selectedPanel);
		frame.addMouseListener(myAction);
	}
	
	/**
	 * A jatek panel Reset fuggvenye hivodik (torlodnek a statikus, dinamikus view-k)
	 */
	public void Reset() {
		gamePanel.Reset();
	}
	
	
	/**
	 * MyAction egy inner class, amely a mouseAdapter-bol szarmazik. Az actionListenert ennek segitsegevel valositjuk meg.
	 * @author aranyaszok
	 *
	 */
	public class MyAction extends MouseAdapter     {
		
		MyPanel sPanel;
		
		/**Az osztaly konstruktora, itt taroljuk el, hogy melyik panelre ervenyes az actionListener.
		 * @param sPanel Az aktiv panelt megkapja parameterkent.
		 */
		MyAction(MyPanel sPanel){
			this.sPanel = sPanel;
			
		}
		
		/**
		 * mousePressed feluldefinialasa, majd atadasa a panel szamara.
		 */
		@Override
		public void mousePressed(MouseEvent e) {
			sPanel.mousePressed(e);
		}
	}
	
	
	
}


