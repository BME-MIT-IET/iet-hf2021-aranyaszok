package main.java.aranyaszok.gui;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import main.java.aranyaszok.IViewable;
import main.java.aranyaszok.listener.IMyAction;

/**
 * Ez az osztaly valositja meg a nezetek oset. Egy absztrakt osztaly, ebbol szarmazik az osszes nezet, amelyek az egyes objektumok megjeleniteseert felelnek.
 * Itt taroljuk adattagkent a meretet, illetve azt, hogy melyik panelen van. Minden view-hoz tartozik egy IMyAction, amely akkor fut le, ha az adott nezet-re kattintott 
 * a felhasznalo.
 * Minden view-hoz tartozhat egy model referencia, amely tarolja a logikai modelt.
 * Minden view-ban taroljuk egy BufferedImage-ben, a hozza tartozo kep referenciajat.
 * @author aranyaszok
 *
 */
public abstract class View implements IDrawable, Serializable{

	private static final long serialVersionUID = 552282663187338272L;
	
	private int posX;
	private int posY;
	private int width;
	private int height;
	
	transient private MyPanel panel; 
	private IMyAction action;
	transient private BufferedImage activeImage;
	
	private IViewable modelObject;
	

	/**
	 * A view konstruktora a nezet mereteit
	 * @param x kezdo x koordinata
	 * @param y kezdo y koordinata
	 * @param w kezdo x koordinatahoz kepest x iranyu eltolas
	 * @param h kezdo y koordinatahoz kepest y iranyu eltolas
	 */
	public View(int x, int y, int w, int h) {
		this.posX = x;
		this.posY = y;
		this.width = w;
		this.height = h;

	}
	
	/**Setter fuggveny, a view-hoz tartozo cselekmeny beallitasa
	 * @param a
	 */
	public void SetAction(IMyAction a) {
		this.action = a;
	}
	/**Getter fuggveny, a viewhoz tartozo panel referenciaval
	 * @return Panel referencia
	 */
	public MyPanel getPanel() {
		return panel;
	}
	
	/**Setter fuggveny, a view-hoz tartozo panel referenciajanak a beallitasa
	 * @param panel A beallitando panel referencia
	 */
	public void setPanel(MyPanel panel) {
		this.panel = panel;
	}
	
	@Override
	public String toString() {
		
		return super.toString() + " " + this.posX + " " + this.posY + " " + this.width+  " " + this.height;
	}
	
	/**
	 *A parameterben kapott image-re rarajzolja magat a view
	 */
	public void Draw(BufferedImage image) {
		
		if (activeImage != null) {
			Graphics2D g = (Graphics2D) image.getGraphics();
			g.drawImage(activeImage,null,posX,posY);
		}
		
		
	}
	/**
	 * Egy fuggveny ami arra szolgal hogy egy esemeny, pl kattintas a view altal hatarolt teruleten tortent-e
	 * @param x esemeny x koordinataja
	 * @param y esemeny y koordinataja
	 * @return Igazzal ter vissza ha az esemeny rajta tortent
	 */
	public boolean clickWithinRange(int x, int y) {
		if ( this.posX < x && this.posY < y && this.posX + this.width > x  && this.posY + this.height >  y  )
			return true;
		return false;
	}
	
	
	/**
	 * Egy view-ra kattint a felhasznalo
	 * @param e A keletkezett MouseEvent
	 */
	public void mousePressed(MouseEvent e) {
		if (action != null) {
			
			if ( this.clickWithinRange(e.getX() -3 , e.getY() - 26)) {
				this.action.OnMouseCLick(this);
			}
		}
		
	}
	
	
	/**
	 * A view-hoz tartozo logiai model referenciajara szolgalot setter fuggveny
	 * @param model
	 */
	public void AddModel(IViewable model) {
		this.modelObject = model;
	}
	
	/**
	 * A view-hoz tartozo logikai modell referencijara szolgalo getter fuggveny
	 * @return logikai modell referenciaja
	 */
	public IViewable GetModel() {return this.modelObject;}
	
	/** A view-hoz tartozo kep referencajat beallito fuggveny
	 * @param image A BufferedImage referencia.
	 */
	public void SetActiveImage(BufferedImage image) {
		this.activeImage = image;
	}
	
	/**A view-hoz tartozo action-t lekerdezo fuggveny
	 * @return IMyAction, a view-hoz tartozo action.
	 */
	public IMyAction GetAction() {return this.action;}
	
	
	/** A view-hoz tartozo kep referencajat lekerdezo fuggveny
	 * @return A referencia, BufferedImage
	 */
	public BufferedImage GetActiveImage() {
		return this.activeImage;
	}
	
	
	/**
	 * A nezet frissiteset megvalosito fuggveny. Az egyes nezetek ezt a fuggvenyt irjak felul, ha szukseguk van ra.
	 */
	public void Refresh() {}
	
	
	/***Az x iranyu eltolas beallitasa.
	 * @return Az x iranyu eltolas
	 */
	public int GetX() {return this.posX;}
	
	
	/**Az x iranyu eltolasa beallitasa
	 * @param x Az x iranyu eltolas
	 */
	public void SetX(int x) { this.posX = x;}
	
	
	/***Az y iranyu eltolas lekerdezese.
	 * @return Az y iranyu eltolas
	 */
	public int GetY() {return this.posY;}
	
	
	/**Az y iranyu eltolas beallitasa.
	 * @param y az eltolas parameter
	 */
	public void SetY(int y) { this.posY = y;}
	
	
	
	
}
