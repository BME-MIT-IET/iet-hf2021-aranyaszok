package main.java.aranyaszok.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;


/**
 * Ez az osztaly valositja meg a panelek oset. Egy absztrakt osztaly, ebbol szarmazik az osszes panel, amelyek az egyes objektumokhoz tartozo nezetek tarolasaert,
 * es kirajzolasaert felel.
 * Itt taroljuk a nezeteket harom kulon listaban. Az elso a static, amely nagyon ritkan valtozik. A masodik a dynamic, amelyben a nagyon gyakran
 * valtozo nezeteket taroljuk. A harmadik a panelView, amelyben a penelen levo gombokat, hattereket taroljuk.
 * A paneleknek kozos a meretuk, ezt itt az ososztalyban taroljuk.
 * Az osszes panel tartalmaz referenciat a ViewManagerre.
 * @author aranyaszok
 *
 */
public abstract class MyPanel extends JPanel  {
	
	private static final long serialVersionUID = 8345176854787935113L;
	
	protected ArrayList<View> panelViews;
	protected ArrayList<View> staticViews;
	protected ArrayList<View> dynamicViews;
	
	protected int width = 1280;
	protected int height = 720;
	protected ViewManager vm;

	/**
	 * A MyPanel konstruktora letrehozza a view-at tarolo listakat
	 * @param viewm
	 * @param name
	 */
	public MyPanel(ViewManager viewm) {
		super();
		init();
		vm = viewm;
		staticViews = new ArrayList<View>();
		dynamicViews = new ArrayList<View>();
		panelViews = new ArrayList<View>();
	}
	
	/**
	 * Az init fuggvenye a JPanel-nek, beallitja a meretet, lathatosagot
	 */
	public void init() {
		setFocusable(true);
        requestFocus();
        setPreferredSize(new Dimension(width, height));
        this.setVisible(true);
	}
	
	
	/**
	 * A statikus view-kat tarolo listahoz hozzaad egy uj view-t, beallitja rajta a panel referenciat
	 * @param view
	 */
	public void AddStaticView(View view) {
		view.setPanel(this);
		staticViews.add(view);
	}
	
	/**
	 * A dinamikus view-kat tarolo listahoz hozzaad egy uj view-t, beallitja rajta a panel referenciat
	 * @param view
	 */
	public void AddDynamicView(View view) {
		view.setPanel(this);
		dynamicViews.add(view);
	}
	
	/**
	 * A panel view-kat tarolo listahoz hozzaad egy uj view-t, beallitja rajta a panel referenciat
	 * @param view
	 */
	public void AddPanelView(View view) {
		view.setPanel(this);
		panelViews.add(view);
	}
	
	/**
	 * Reset hivasra torlodik a statikus, dinamikus tarolo, a taroloban levo view referenciak torlesre kerulnek
	 */
	public void Reset() {
		for ( int i = 0; i < staticViews.size(); i++) {
			if(staticViews.get(i).GetModel() != null) {
				staticViews.get(i).GetModel().AddView(null);
			}
			staticViews.get(i).AddModel(null);
			
		}
		
		for ( int i = 0; i < dynamicViews.size(); i++) {
			if(dynamicViews.get(i).GetModel() != null) {
				dynamicViews.get(i).GetModel().AddView(null);
			}
		
			dynamicViews.get(i).AddModel(null);
		}
		
		this.staticViews.clear();
		this.dynamicViews.clear();
	}
	
	/**
	 * A view tarolokban talalhato view-k rarajzoljak magukat a parameterben kapott image-re
	 * @param image Az image amire rajzolodnak
	 */
	public void DrawAll(BufferedImage image) {
		
		this.UpdateDynamicViews();
		
		Graphics g = image.getGraphics();
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, width, height);
		
		for (int j = 0; j < this.panelViews.size(); j++) {
			panelViews.get(j).Refresh();
			panelViews.get(j).Draw(image);
		}
		
		for (int i = 0; i< this.staticViews.size(); i++) {
			staticViews.get(i).Refresh();
			staticViews.get(i).Draw(image);
		}
		
		
		for (int j = 0; j < this.dynamicViews.size(); j++) {
			dynamicViews.get(j).Refresh();
			dynamicViews.get(j).Draw(image);
		}
		
		
		
	}
	
	/**
	 * A dinanikusan letrehozott view-kat torli elsonek, majd letrehozza a jelenlegi allapot szerint az ujakat
	 */
	public void UpdateDynamicViews() {
		dynamicViews.clear();
	}
	
	

	/**
	 * Egy panelen kattintas tortent, az esemenyt tovabbadja az osszes view-nak
	 * @param e A kattintas esemeny
	 */
	public void mousePressed(MouseEvent e) {
		
		for (int i = 0; i < this.staticViews.size(); i++) {
			this.staticViews.get(i).mousePressed(e);
		}
		for (int i = 0; i < this.dynamicViews.size(); i++) {
			this.dynamicViews.get(i).mousePressed(e);
		}
		
		for (int i = 0; i < this.panelViews.size(); i++) {
			this.panelViews.get(i).mousePressed(e);
		}
		
		vm.Update();
	}
	
	
	/**
	 * A statickus nezeteket lekerdezo fuggveny.
	 * @return A statikus nezeteket tarolo lista.
	 */
	public ArrayList<View> getStaticViews() { return staticViews;}
	
	
	/**
	 * A viewManager-t lekerdezo fuggveny
	 * @return A VM referenciaja.
	 */
	public ViewManager GetViewManager() {return this.vm;}

}
