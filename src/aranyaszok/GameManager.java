package aranyaszok;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import aranyaszok.gui.BuildingView;
import aranyaszok.gui.FieldView;
import aranyaszok.gui.GamePanel;
import aranyaszok.gui.ItemView;
import aranyaszok.gui.SteppableView;
import aranyaszok.gui.View;
import aranyaszok.gui.ViewManager;
import aranyaszok.listener.FieldAction;
import aranyaszok.listener.IMyAction;

/**
 * A jatek lebonyolitasaert  felelos osztaly
 * 
 * @author aranyasszok
 *
 */
public class GameManager implements Serializable {

	private static final long serialVersionUID = -2456625605031716147L;

	private final int chanceOfStormLimit;
	
	private List<Water> map;
	private List<Player> players;
	private List<Item> allItems;
	private List<Bear> bears;
	private int chanceOfStorm;
	private int chanceOfStormAverageStep;
	private int chanceOfStormAverageStepRange;
	private boolean isActiveGame;
	public ViewManager vm;
	private int remainingRounds;
	

	public  GameManager() {
		
		map = new ArrayList<Water>();
		players = new ArrayList<>();
		allItems = new ArrayList<>();
		bears = new ArrayList<>();
		
		isActiveGame = false;
		chanceOfStorm = 10;
		chanceOfStormAverageStep = 22;
		chanceOfStormAverageStepRange = 5;
		chanceOfStormLimit = 10;
		vm = new ViewManager();
		remainingRounds = 0;
		
	}
	

	/**
	 * Uj jatek inditasakor general egy uj palyat, amit a palya alap betoltesevel kezd, majd
	 * kisorsolja hogy hol legyenek a viz es a betorheto jegtablak, veletlenszamu horeteget helyez el minden field-en,
	 * ezek utan letrehozza a targyakat mindegyikbol veletlenszamut, kiveve a komponensbol, es elhelyezi oket a tablakon,
	 * ezek utan peldanyositja a jatekosokat es a medveket es oket is elhelyezi kezdopalyajukon.
	 */
	public void GenerateMap() {
		
		this.Reset();
		
		try {
			this.LoadGame(new File(System.getProperty("user.dir")+"/Resources/Maps/mapBase.data"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Random random = new Random();
		
		final int mapWidth = 7;
		final int mapHeight = 5;
		final int startingX = 0;
		final int startingY = 0;
		int indexOfStartingTile = mapHeight * startingX + startingY;
		
		final int numOfWaters = random.nextInt(4) + 3;
		final int numOfUnstableIces = random.nextInt(5) + 10; 
		
		Integer[] types = new Integer[map.size()];
		for (int i = 0; i < types.length; i++)
			types[i] = 0;
		
		int succeed = 0;
		
		while (succeed < numOfWaters) {
			int r = random.nextInt(map.size());
			if (types[r] != 1 && r != indexOfStartingTile) {
				types[r] = 1;
				succeed++;
			}
		}
		
		succeed = 0;
		while (succeed < numOfUnstableIces) {
			int r = random.nextInt(map.size());
			if (types[r] != 1 && types[r] != 2 && r != indexOfStartingTile) {
				types[r] = 2;
				succeed++;
			}
		}
		
		for (int i = 0; i < map.size(); i++) {
			Water newTile = null;
			if (types[i] == 1) {
				newTile = new Water();	
			}
			else if (types[i] == 2) {
				newTile = new UnstableIce(random.nextInt(3)+1);
			}
			
			if (types[i] != 0) {
				newTile.AddView(map.get(i).GetView());
				map.get(i).GetView().AddModel(newTile);
				
				map.get(i).GetBuildingView().AddModel(newTile);
				newTile.AddBuildingView(map.get(i).GetBuildingView());
				
				map.get(i).SetAllNeighbours(newTile);	
				this.ReplaceCrashedFields(map.get(i), newTile);
			}	
			
		}
		
		
		for(int i  = 0; i< map.size(); i++) {
			map.get(i).SetSnowLayers(random.nextInt(4));
		}
		
		
		
		String[] itemTypes = {"Food", "Shovel", "Rope", "Component", "PackedTent", "Palesz", "DivingSuit"};
		List<Integer> currentPlaces = new ArrayList<Integer>();
		Item item = null;
		
		for (String type : itemTypes) {
			
			int max = 0;
			currentPlaces.clear();
			
			switch (type) {
			case "Food":	
				max = random.nextInt(6) + 11;
				break;
			case "Shovel":
				max = random.nextInt(5) + 8;
				break;
			case "Rope":
				max = random.nextInt(5) + 10;
				break;
			case "PackedTent":
				max = random.nextInt(5) + 14;
				break;
			case "Palesz":
				max = random.nextInt(5) + 6;
				break;
			case "DivingSuit":
				max = random.nextInt(3) + 1;
				break;
			case "Component":
				max = 3;
				break;
			default:
				break;
			}
				
			for(int i = 0; i < max; i++) {
				
				ItemView itemView = new ItemView(0, 0, 64, 64);
				
				switch (type) {
				case "Food":
					item = new Food();
					itemView.SetActiveImage(vm.images.food);
					break;
				case "Shovel":
					item = new Shovel(random.nextInt(3) + 1);
					itemView.SetActiveImage(vm.images.shovel);
					break;
				case "Rope":
					item = new Rope();
					itemView.SetActiveImage(vm.images.rope);
					break;
				case "PackedTent":
					item = new PackedTent();
					itemView.SetActiveImage(vm.images.packedTent);
					break;
				case "Palesz":
					item = new Palesz();
					itemView.SetActiveImage(vm.images.palesz);
					break;
				case "DivingSuit":
					item = new DivingSuit();
					itemView.SetActiveImage(vm.images.divingSuit);
					break;
				case "Component":
					item = new Component();	
					itemView.SetActiveImage(vm.images.componentImages.get(i));
					break;
				default:
					break;
				}
				
				Water place = null;
				int index = 0;
				do {
					index = random.nextInt(map.size());
					place = map.get(index);
					
				}while(!(place instanceof Ice) || currentPlaces.contains(index));
				
				currentPlaces.add(index);
				
				
				place = map.get(index);
				place.AddFrozenItem(item);
				
				item.AddView(itemView);
				itemView.AddModel(item);
				
				
				allItems.add(item);
				
				this.isActiveGame = true;
				vm.Update();
				
			}
		}
		
		
		ITMan itman = new ITMan();
		SteppableView itmanview = new SteppableView(1000,1000,64,64);
		itmanview.AddModel(itman);
		itman.AddView(itmanview);
		players.add(itman);
		
		Seal seal = new Seal();
		SteppableView sealview = new SteppableView(1000,1000,64,64);
		sealview.AddModel(seal);
		seal.AddView(sealview);
		players.add(seal);
		
		Researcher researcher = new Researcher();
		SteppableView researcherview = new SteppableView(1000,1000,64,64);
		researcherview.AddModel(researcher);
		researcher.AddView(researcherview);
		players.add(researcher);
		
		Eskimo eskimo = new Eskimo();
		SteppableView eskimoview = new SteppableView(1000,1000,64,64);
		eskimoview.AddModel(eskimo);
		eskimo.AddView(eskimoview);
		players.add(eskimo);
		
		vm.AddStaticViewToGamePanel(itmanview);
		vm.AddStaticViewToGamePanel(sealview);
		vm.AddStaticViewToGamePanel(researcherview);
		vm.AddStaticViewToGamePanel(eskimoview);
		
		Water place = map.get(indexOfStartingTile);
		
		

		for(int i = 0; i<players.size(); i++) {	
			place.AddSteppable(players.get(i));
		}
		
		Bear bear1 = new Bear();
		SteppableView bearview1 = new SteppableView(0, 0,64,64);
		bearview1.AddModel(bear1);
		bear1.AddView(bearview1);
		vm.AddStaticViewToGamePanel(bearview1);
		bears.add(bear1);
		
		Bear bear2 = new Bear();
		SteppableView bearview2 = new SteppableView(0, 0,64,64);
		bearview2.AddModel(bear2);
		bear1.AddView(bearview2);
		vm.AddStaticViewToGamePanel(bearview2);
		bears.add(bear2);
		
		for (int i = 0; i < bears.size(); i++) {
			
			int randomPlaceIndex = 0;
			
			do {
				
				randomPlaceIndex=random.nextInt(map.size());
				
			}while(indexOfStartingTile == randomPlaceIndex);
			
			Water place2 = map.get(randomPlaceIndex);
			place2.AddSteppable(bears.get(i));
		}
		
		this.isActiveGame = true;
	}
	
	/**
	 * Uj jatek inditasakor general egy uj palyat es elinditja a jatekot
	 */
	public void Play() {
		this.GenerateMap();
		remainingRounds = players.size();
		Swap();
	}

	/**
	 * A jatek kozben a fuggveny meghivasaval atvaltunk a kovetkezo jatekosra, egy kor vegen pedig frissitjuk a jatekmenetet, illetve
	 * hovihart generalunk es leptetjuk a medveket.
	 */
	public void Swap() {
		
		if(remainingRounds == 0) {
			
			remainingRounds = players.size();
			
			for(int i = 0; i < bears.size(); i++) {
				bears.get(i).Work();
			}
			
			this.GenerateStorm();
			this.GameUpdate();
		}
		
		if (players.size() > 0) {
			
			Player temp = players.get(0);
			players.remove(0);
			GamePanel gamepanel = (GamePanel) temp.GetView().getPanel();
			gamepanel.setSelectedPlayer(temp.GetView());
			gamepanel.setSelectedField(temp.GetWater().GetView());
			temp.GetWater().GetView().GetAction().OnMouseCLick(temp.GetWater().GetView());
			
			temp.SetRemainingWork(4);
			
			players.add(temp);
		}
		
		remainingRounds--;
		vm.Update();
	}
	
	/**
	 * Egy random tablara general egy vihart, ha pedig az adott korben nem hoz letre vihart, akkor megnoveli annak az eselyet
	 * 
	 */
	public void GenerateStorm() {

		Random ran = new Random();
		chanceOfStorm += ran.nextInt(chanceOfStormAverageStepRange*2) - chanceOfStormAverageStepRange + chanceOfStormAverageStep;
		
		if(chanceOfStorm >= ran.nextInt(100 -  chanceOfStormLimit) +  chanceOfStormLimit) {			
			int selectice = ran.nextInt(map.size());
			Water w = map.get(selectice);
			w.StormCenter();
			chanceOfStorm = 0;
		}
				
	}
	
	
	
	/**
	 * A vihar eselyet lehet lekerdezni az adott korben
	 * 
	 * @return int - a vihar eselye
	 */
	public int GetChancheOfStorm() {return this.chanceOfStorm;}
	
	
	/**
	 * Minden kor meghivja a osszes player Die fuggvenyet es 
	 * es elpusztitja az osszes epuletet amit lehet. Vegul a
	 * jatekosok sorrendjet megvaltoztatja  
	 */
	public void GameUpdate() {
		
		for (int i = 0; i < players.size(); i++) {
			players.get(i).Die();
		}
		
		
		for ( int i = 0; i < map.size(); i++) {
			map.get(i).DestroyBuilding();
		}

		Collections.shuffle(players);
	}

	
	/**
	 * A jatek veget jelzi, ekkor a jatek torlodik es megjelenik a jatek vege ablak
	 */
	public void Lose() {
		this.Reset();
		this.isActiveGame = false;
		vm.ChangeSelectedPanel("lose");
	}
	
	
	/**
	 * A jatek teljesiteset jelzi, ekkor a jatek torlodik es megjelenik a jatek vege ablak
	 */
	public void Win() {
		this.Reset();
		this.isActiveGame = false;
		vm.ChangeSelectedPanel("win");
	}
	

	/**
	 * Amikor egy nem stabil jegtabla osszetorik akkor az
	 * osszes referenciat ami annak a jegtablanak volt egy 
	 * uj waternek allitja be 
	 * @param list: List<Item> minden item ami a jegtablan van 
	 */
	public void RelocateCrashedItems(List<Item> list) {
		
		Random r = new Random();
		
		while(list.size()!=0) {

			int random = r.nextInt(map.size());
			
			if(map.get(random).GetCapacity() != 0)
			{
				map.get(random).AddFrozenItem(list.remove(0));
			}
		}
	}
	
	/**
	 * Amikor egy jegtabla betorik akkor egy uj waterre csereli ki azt 
	 * 
	 * @param oldW: Water a regi jegtabla 
	 * @param newW: Water az uj water
	 */
	public void ReplaceCrashedFields(Water oldW, Water newW) {
		this.map.set(this.map.indexOf(oldW), newW);
	}
	
	/**
	 * Ha a jatek vegeter, akkor torli az adott jatekmenetet
	 */
	public void Reset() {
		
		map.clear();
		players.clear();
		allItems.clear();	
		bears.clear();
		vm.Reset();
		this.isActiveGame = false;
	
	}
	
	/**
	 * Annak lekerdezese, hogy az adott pillanatban van-e folyamatban levo jatek.
	 * 
	 * @return boolean - a jatek allapota
	 */
	public boolean getStateOfGame() { return this.isActiveGame; }

	
	/**
	 * A jatek allasat menti ki fajlba 
	 * @param filename: File, az a fajl, amibe menteni akarunk
	 * @throws Exception 
	 */
	public void SaveGame(File filename) throws Exception {
		 FileOutputStream file = null;
		 ObjectOutputStream out = null;
		 try
	        {    
			 	file = new FileOutputStream(filename.getAbsolutePath()); 
	            out = new ObjectOutputStream(file); 
	            out.writeObject(this);  
	        } 
		 catch(IOException ex) 
	        { 
	            throw new Exception("IOException is caught" + ex.getMessage()); 
	        } 
		 finally {
	         try {
	             if (out != null) out.close();
	             if (file != null) file.close();
	         } catch (IOException ex) { 
	        	 throw new Exception("IOException is caught" + ex.getMessage()); 
	         }
		 }
		
	}
	
	/**
	 * Egy korabbi jatekmenet betoltese 
	 * @param filename: File, az a fajl, amibol betoltjuk a korabbi jatekmenetet
	 * @throws Exception 
	 */
	public void LoadGame(File gameFile) throws Exception {
		
		GameManager gm = null;
		FileInputStream file = null;
		ObjectInputStream in = null;
		if (gameFile != null) {
			try
	        {    
	    
				file = new FileInputStream(gameFile.getAbsolutePath());
	            in = new ObjectInputStream(file); 
	              
	            gm = (GameManager)in.readObject(); 
	            
	        	this.map = gm.map;
	        	this.players = gm.players;
	        	this.allItems = gm.allItems;
	        	this.bears = gm.bears;
	        	this.chanceOfStorm = gm.chanceOfStorm;
	        	this.chanceOfStormAverageStep = gm.chanceOfStormAverageStep;
	        	this.chanceOfStormAverageStepRange = gm.chanceOfStormAverageStepRange;
	        	this.remainingRounds = gm.remainingRounds;
	     
	        	this.vm.getGamePanel().Reset();
	        	ArrayList<View> gmStaticViews = gm.vm.getGamePanel().getStaticViews();
	        	
	        	for (int i = 0; i< gmStaticViews.size(); i++) {
	        		
	        		this.vm.AddStaticViewToGamePanel(gmStaticViews.get(i));
	        		
	        	}
	        	
	        	if(gm.vm.getGamePanel().getSelectedField() != null) {
	        	this.vm.getGamePanel().setSelectedField(gm.vm.getGamePanel().getSelectedField());
	        	this.vm.getGamePanel().setSelectedItem(gm.vm.getGamePanel().getSelectedItem());
	        	this.vm.getGamePanel().setSelectedPlayer(gm.vm.getGamePanel().getSelectedPlayer());
	        	}
	        	
	        	int numberOfComponent = 0;
	      
	        	for ( int i = 0;  i < this.allItems.size(); i++) {
	        		
	        		if ( this.allItems.get(i) instanceof Rope ) {
	        			this.allItems.get(i).GetView().SetActiveImage(vm.images.rope);
	        		}
	        		else if ( this.allItems.get(i) instanceof PackedTent ) {	
						this.allItems.get(i).GetView().SetActiveImage(vm.images.packedTent);
					}
	        		else if ( this.allItems.get(i) instanceof Palesz ) {
						this.allItems.get(i).GetView().SetActiveImage(vm.images.palesz);
					}
	        		else if ( this.allItems.get(i) instanceof Food ) {	
						this.allItems.get(i).GetView().SetActiveImage(vm.images.food);
					}
	        		else if ( this.allItems.get(i) instanceof Shovel ) {	
						this.allItems.get(i).GetView().SetActiveImage(vm.images.shovel);
					}
	        		else if ( this.allItems.get(i) instanceof DivingSuit ) {	
						this.allItems.get(i).GetView().SetActiveImage(vm.images.divingSuit);
				    }
	        		else if ( this.allItems.get(i) instanceof Component ) {	
						this.allItems.get(i).GetView().SetActiveImage(vm.images.componentImages.get(numberOfComponent++));
					}
	        		
	        	}
	         	
	        } 
	        catch(IOException ex) 
	        { 
	        	throw new Exception("IOException is caught" + ex.getMessage() +"\n" + ex.getCause() + " \n"+  ex.getLocalizedMessage() + "\n" + ex.getSuppressed() + "\n" + ex.getStackTrace() + "\n"); 
	        } 
	          
	        catch(ClassNotFoundException ex) 
	        { 
	        	throw new Exception("ClassNotFoundException is caught"); 
	        } 
			 finally {
		         try {
		             if (in != null) in.close();
		             if (file != null) file.close();
		         } catch (IOException ex) { }
			 }
		}
		
		this.isActiveGame = true;
		
	}
	
	/**
	 * A toString() fuggveny definialja felul 
	 */
	@Override
	public String toString() {
		return "GameManager";
	}
	
	/**
	 * Az adott korben hatralevo jatekosok szamanak lekerese.
	 * @return int - az adott korben hatralevo jatekosok szama
	 */
	public int getRemainingRounds() {
		return remainingRounds;	
	}
	
	/**
	 * A jatekosokat tartalmazo lista lekerese (A grafikus megjelenites miatt szukseges)
	 * 
	 * @return a jatekosokat tartalmazo lista
	 */
	public ArrayList<Player> GetPlayers(){
		return  new ArrayList<Player>(this.players);
	}
}
