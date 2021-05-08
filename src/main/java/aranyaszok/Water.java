package main.java.aranyaszok;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import main.java.aranyaszok.gui.View;


/**
 * Az osztaly a jatekban szereplo viztablat valositja meg.
 * @author aranyaszok
 *
 */
public class Water implements Serializable, IViewable {
	
	private static final long serialVersionUID = 2720378532314588475L;
	protected final int maxSnowLayers = 5;
	protected int snowLayers = 0;	
	protected List<Player> players;	
	protected List<Bear> bears;	
	protected List<Water> neighbours;
	protected List<Item> frozenItems;
	protected List<Item> floatingItems;
	protected Building building;
	protected View view;
	protected View Buildinview;
	protected boolean researched;
	
	/**
	 * A konstruktor letrehozza a tarolokat.
	 */
	public Water() {
		players = new ArrayList<>();
		bears = new ArrayList<>();
		neighbours = new ArrayList<>();
		floatingItems = new ArrayList<>();
		frozenItems = new ArrayList<>();
		this.building = new NullBuilding(this);
		researched = false;
		
	}
	
	/**
	 * Visszaadja a mezőn lévő játékosok litáját
	 * Jelenleg CSAK teszteléshez használva
	 */
	public List<Player> GetPlayers() {
		return players;
	}
	
	/**
	 * Visszaadja a mezőn lévő medvék litáját
	 * Jelenleg CSAK teszteléshez használva
	 */
	public List<Bear> GetBears() {
		return bears;
	}
	
	/**
	 * Egy mezo fel lett e mar terkepezve a kutato altal
	 * @return Igaz, ha felterkepezett
	 */
	public boolean isResearched() {
		return researched;
	}

	/**
	 * Egy mezo fel lett e mar terkepezve a kutato altal, setter fuggbeny
	 * @param researched
	 */
	public void setResearched(boolean researched) {
		this.researched = researched;
	}

	/**
	 * Referenciak a mezon levo floating item-ekhez
	 * @return	Floatin Itemek
	 */
	public ArrayList<Item> GetFloatingItems(){
		return (ArrayList) floatingItems;
	}
	
	/**
	 *Setter fuggveny, beallitja logai modelhez tartozo nezeti modelt
	 */
	public void AddView(View w) {
		this.view = w;
	}
	
	
	/**
	 * Setter fuggveny, beallitja a mezohoz tartozo epuleti nezetet
	 * @param w Epulet nezet
	 */
	public void AddBuildingView(View w) {
		this.Buildinview = w;
	}
	
	/**
	 *Getter fuggveny a mezo nezeti modeljere
	 */
	@Override
	public View GetView() {
		return this.view;
	}
	
	/**
	 * Getter fuggveny, a mezohoz tartozo epuleti nezethez
	 * @return building view
	 */
	public View GetBuildingView() {
		return this.Buildinview;
	}
	
	/**
	 * Uj karakter hozzadasa a mezohoz.
	 * @param s - Steppable tipusu karakter, amit hozzaadunk a mezohoz.
	 */
	public void AddSteppable(Steppable s) {
		
		s.SetWater(this);
		s.SetFacing(this.neighbours.get(0));
		
		if ( s instanceof Bear ){
			if(bears.size() != 0) {
				s.Work();
			}
			else {
				bears.add((Bear)s);
			}
			
		}
		
		if ( s instanceof Player ){
			players.add((Player)s);
		}
		ReactToStep();
	}
	
	/**
	 *Ha egy steppable ralep a mezore ez a fuggveny hivodik
	 */
	public void ReactToStep() {
		this.SetSnowLayers(0);
		
		if(bears.size() > 0)
			bears.get(0).Attack();
	}
	
	/**
	 * Karakter eltavolitasa a mezorol.
	 * @param s - Steppable tipusu karakter, amit torlunk a mezorol.
	 */
	public void RemoveSteppable (Steppable s) {
		if ( s instanceof Bear )
			bears.remove((Bear)s);
		
		if ( s instanceof Player )
			players.remove((Player)s);
	}
	
	/**
	 * Vihar generálása az adott mezon, a viharrol ertesiti szomszedait is, mivel a vihar azokra a tablakra is hatassal van. Ez azt jelenti, hogy ez a mezo lesz a vihar epicentruma.
	 * 
	 */
	public void StormCenter(){
		for (int i = 0; i < this.neighbours.size(); i++) {
			this.neighbours.get(i).Storm();
		}
		
		Storm();
	}
	
	
	/**
	 * A vihar hatasanak kifejtese, vagyis a horetegek szamanak novelese es a jatekosokra gyakorolt hatas elinditasa.
	 */
	public void Storm() {
		StormEffect st = new StormEffect();
		
		if (!((!(this instanceof Ice) && players.size() != 0) || (!(this instanceof Ice) && bears.size() != 0))) {
			this.SetSnowLayers(++snowLayers);
		}
		
		if (snowLayers >= maxSnowLayers) {
			snowLayers = maxSnowLayers;
		}
		st.Call(this);
	}	
	
	
	/**
	 * Ha egy jatekos ilyen tipusu mezon van, akkor nem tud asni.
	 * 
	 * @param i  - Az asas merteke.
	 */
	public void Digging(int i) {}
	
	
	/**
	 * A tablan bekovetkezett effektus eltalalja az osszes ott allo jatekost.
	 * 
	 * @param e - Ez az effektus kovetkezett be az adott mezon. 
	 */
	public void EffectCall(Effect e) {
		ArrayList<Player> temp = new ArrayList(players);
		for (Player p : temp) {
			p.HitByEffect(e);
		}
	}
	
	
	/**
	 * Az iranyvaltoztatashoz szukseges. 
	 * 
	 * @param w - Az a mezo, amire a jatekos eppen nez.
	 * @return A sorban kovetkezo mezo, vagyis az az uj mezo, amire a jatekos fog nezni, az iranya megvaltoztatasa utan.
	 */
	public Water GetNextNeighbour(Water w) {
		Water nextWater = null;
		int index = neighbours.indexOf(w);
		
		if (index < neighbours.size() - 1)
			nextWater = neighbours.get(index + 1);
		else
			nextWater = neighbours.get(0);
		
		return nextWater;
	}
	
	
	/**
	 * A szomszedokhoz hozzaad egy uj elemet.
	 * @param w - Az uj szomszed.
	 */
	public void AddNeighbour(Water w) {
		neighbours.add(w);		
	}
	
	
	/**
	 * A mezo teherbirasaval ter vissza (vagyis azzal, hogy hanyan allhatnak maximum a mezon).
	 * @return A viznek fixen 0.
	 */
	public int GetCapacity() {
		return 0;
	}
	
	
	/**
	 * A horeteg szamanak lekerdezese.
	 * @return Horetegek szama.
	 */
	public int GetSnowLayers() {
		return snowLayers;
	}
	
	public void SetSnowLayers(int i) {
		if(i > maxSnowLayers)
			this.snowLayers = maxSnowLayers;
		else
			this.snowLayers = i;
		
	}
	
	/**
	 * A mezon allo epulet lekerese.
	 * @return Visszater az epulettel.
	 */
	public Building GetBuilding() {
		return building;
	}
	
	
	/**
	 * Beallitja az epuletet a mezore. (Jelenleg a vizen csak egyfajta epulet allhat.)
	 * @param b - A beallitando epulet.
	 */
	public void SetBuilding(Building b) {}
	

	/**
	 * Hozzaad egy uj targyat a vizbe fagyott elemekhez.
	 * @param i - A hozzaadando targy.
	 */
	public void AddFrozenItem(Item i) {
		frozenItems.add(i);
	}
	
	
	/**
	 * Eltavolit egy targyat a befagyott targyak kozul.
	 * @param i - Az eltavolitando targy.
	 */
	public void RemoveFrozenItem(Item i) {
		frozenItems.remove(i);
	}
	
	
	/**
	 * A mezohoz hozzaad egy lebego targyat.
	 * @param i -  A hozzaadando targy.
	 */
	public void AddFloatingItem(Item i) {
		this.floatingItems.add(i);
	}
	
	
	/**
	 * Lebego targy eltavolitasa.
	 * @param i - Az eltavolitando targy.
	 */
	public void RemoveFloatingItem(Item i) {
		this.floatingItems.remove(i);
	}
	
	
	/**
	 * Az epuletek megsemmisitese ket kor kozott. A megsimmisites megtortentje az epulet tipusatol fugg.
	 */
	public void DestroyBuilding() {
		this.building.Destroy();
	}
	
	
	/**
	 * Egy jegtabla betorese esten a szomszedos mezokon kicsereli a szomszedot a listaban. 
	 * @param oldW - Regi mezo refernciaja.
	 * @param newW - Uj mezo referenciaja.
	 */
	public void SetNeighbour(Water oldW, Water newW) {
		this.neighbours.set(this.neighbours.indexOf(oldW), newW);
	}
	
	public void SetAllNeighbours(Water newW) {
		for(int j=0; j < neighbours.size(); j++) {
			neighbours.get(j).SetNeighbour(this, newW);
			newW.AddNeighbour(neighbours.get(j));
		}
	}
	
	/**
	 *Az objektum tipusanak kiirasa.
	 */
	@Override
	public String toString() {
		return "Water";
	}

	/**
	 * A szomszedok szamanak lekerdezese.
	 * @return A szomszedok szama (int).
	 */
	public int GetNumberOfNeighbours() {
		return neighbours.size();
	}
	
	/**
	 * Egy mezorol eldonti e hogy szomszedjae
	 * @param w mezo,amit vizsgal
	 * @return Igazzal ter vissza ha szomszedja
	 */
	public boolean IsNeightbour(Water w) {
		return this.neighbours.contains(w);
	}
	
	/**
	 * Egy Item-rol vizsgalja hogy floating Item-e
	 * @param i item, amit vizsgal
	 * @return Igaz, ha floating item
	 */
	public boolean IsFloatingItem(Item i) {
		return this.floatingItems.contains(i);
	}
	
	/**
	 * Floating itemek szamat lekerdezo fuggveny
	 * @return floating itemek szama
	 */
	public int getNumberOfFloatingItem() { return floatingItems.size(); }
}
