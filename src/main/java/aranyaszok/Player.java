package main.java.aranyaszok;

import java.util.ArrayList;

import java.util.List;


/**
 * Absztrakt osztaly. Minden karakter kozos tulajdonsagait es fuggvenyeit foglalja ossze.
 * @author aranyaszok
 */
public abstract class Player extends Steppable {
	
	private static final long serialVersionUID = -1207039366986674748L;

	private final int maxInventory = 4;

	protected int bodyHeat;	
	protected int bodyHeatBase;
	private boolean safe = false;
	private List<Item> items;
	private int workLeft;
	
	
	

	/**
	 * Konstruktor beallitja a munkak szamat
	 */
	public Player() {
		items = new ArrayList<Item>();
		workLeft = 4;
	}
	
	public int GetBodyHeat() {
		return bodyHeat;
	}

	public ArrayList<Item> GetItems(){
		return (ArrayList) items;
	}
	
	/**
	 *  Az adott jatekossal munkat vegeztethetunk, a GameManager itt adja at a vezerlest az adott jatekosnak (a konkret megvalositasnal lesz funkcioja)
	 *  Ez majd a program kovetkezo fazisaban valosul meg, jelenleg ennek a funkciojat a parancsertelmezo valositja meg. 
	 */
	public void Work() {
		
		workLeft--;
	
		if(workLeft == 0) {
			workLeft = 4;
			Main.gameManager.Swap();
		}
	}	
	
	public void SetRemainingWork(int work) { 
		
		this.workLeft = work; 
		
	}
	
	
	/**
	 * Az adott jatekos asas kepesseget valositja meg, alapvetoen ho eltakaritsssra hasznalhato, de ha mar tiszta a jegtabla amin allunk, akkor targyakat is ashatunk ki a vele a mezobol
	 */
	public void Digging() {
		this.GetWater().Digging(1);
	}
	
	
	/**
	 * A jatekos testhojenek megvaltoztatasa
	 * @param i - A parameterul kapott ertekkel valtozik meg
	 */
	public void ChangeBodyHeat(int i) {
		bodyHeat += i;
		if (bodyHeat < 0) bodyHeat = 0;
		else if (bodyHeat > bodyHeatBase) bodyHeat = bodyHeatBase;
	}
	
	
	/**
	 * A fuggveny hivasaval kiserletet tehet a jatekos a jelzopisztoly osszeszerelesere (Csak egy komponens hasznalatan keresztul mukodik) 
	 */
	public void Craft() {
		
		FlareGun fg = new FlareGun();
		for(int i=0; i < items.size();i++) {
			fg.Check(items.get(i));
		}
		
	}
	
	
	/**
	 * Egy targy hozzaadasa a jatekos sajat eszkozeihez
	 * @param i - A parameterul kapott targy kerul hozzaadasra
	 */
	public void AddItem(Item i) {
		if(items.size() <= maxInventory) {
			items.add(i);
		}
		else
			this.GetWater().AddFloatingItem(i);
	}
	
	
	/**
	 * Egy targy eldobasa a jatekos sajat eszkozei kozul, ilyenkor a targy az adott mezore kerul
	 * @param i - A parameterul kapott targyat dobja el
	 */
	public void DropItem(Item i) {
		
		if(this.GetWater().getNumberOfFloatingItem() < 8) {
			
			this.GetWater().AddFloatingItem(i);
			RemoveItem(i);
		}
	}
	
	
	/**
	 * Egy adott targy felvetele az adott mezorol
	 * @param i - A parameterul adott targyat veszi fel 
	 */
	public void PickUpItem(Item i) {
		this.GetWater().RemoveFloatingItem(i);
		AddItem(i);
	}
	
	
	/**
	 * Egy targy eltavolitasa a jatekos sajat targyai kozol
	 * @param i - A parameterul kapott targyat tavolitjuk el
	 */
	public void RemoveItem(Item i) {	
		items.remove(i);
	}
	
	
	/**
	 * A jatekos sajat kepessege. (Minden jatekosnal mas)
	 */
	public abstract void Skill();
	
	
	/**
	 * A jatakost ert effektus hatasanak kifejtese az adott jatekoson 
	 * @param e - A parameterul kapott effektus hatasat hajtja vegre
	 */
	public void HitByEffect(Effect e) {
		e.Effects(this);
	}
	
	
	/**
	 * A jatekos bemenekulhet a mezon talalhato epuletbe
	 */
	public void RunInside(Effect e) {
		this.GetWater().GetBuilding().Damage(this,e);
	}
	
	/**
	 * Egy jatekos testhojet allitja
	 * @param i testho
	 */
	public void SetBodyHeat(int i) {
		this.bodyHeat = i;
	}
	

	/**
	 * A jatekos maximalis testhojenek lekerdezese
	 * @return Visszater a jatekos maximalis testhojevel
	 */
	public int GetBodyHeatBase() {
		return this.bodyHeatBase;
	}	
	
	/**
	 * Egy jatekos energia szintjet lekerdezo fuggveny
	 * @return energiaszint
	 */
	public int GetWorkLeft() {
		return workLeft;
	}
	
	/**
	 * A jatekos biztonsaganak beallitasa
	 * @param newsafe - Ezt az erteket allitjuk be
	 */
	public void SetSafe(boolean newSafe) {
		this.safe = newSafe;
	}
	
	
	/**
	 * A jatekos biztonsagi allapotanak lekerdezese
	 * @return Egy boolean ertekkel ter vissza
	 */
	public boolean GetSafe() {
		return safe;
	}	
	
	/**
	 * Egy itemrol lekerdezi hogy a jatekos birtokaban van-e
	 * @param i vizsgalt item
	 * @return Igaz, ha a jatekosnal van
	 */
	public boolean IsInventoryItem(Item i) {
		return this.items.contains(i);
	}
	
	
	/**
	 * A jatekos megprobal meghalni. Ez akkor teljesulhet, ha az alabbiakbol legalabb egy teljesul:
	 *  a) a bodyHeat erteke elerte a 0-t
	 *  b) a jatekos vizben van es a safe attributum erteke false
	 * Igaz eseten vege a jateknak
	 */
	public void Die() {
		if ((safe == false && this.GetWater().GetCapacity() == 0) || bodyHeat <= 0) {
			Main.gameManager.Lose();
		}
			
	}

	/**
	 * Beallitja a jatekos testhojet a maximalis ertekre.
	 */
	public void SetBodyHeatToMax() {
		this.bodyHeat = this.bodyHeatBase;
	}
	
	/**
	 *Az objektum tipusanak kiirasa.
	 */
	@Override
	public String toString() {
		return "Player";
	}
}
