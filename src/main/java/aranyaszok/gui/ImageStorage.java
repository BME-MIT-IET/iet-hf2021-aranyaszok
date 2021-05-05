package main.java.aranyaszok.gui;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

/**
 * Ezen osztaly foglalja ossze a jatek soran hasznalt osszes kepet. El akartuk kerulni, hogy minden egyes uj objektum letrehozasanal I/O muveletet kelljen vegezni, helyette
 * a ViewManager-ben peldanyositjuk ezen osztalyt igy a kepeket egyszer olvassuk csak be. Ezek utan barmely objektum szamara elerheto ebbol a tarolobol a szukseges kepek.
 * 
 * @author aranyaszok
 */
public class ImageStorage {
	
	
	/**
	 * Ahogy lentebb lathato, minden egyes objektum kirajzolasahoz kulon valtozoban taroljuk a kepet, kiveve azoknal az objektumoknal, amiknek tobb allapota van,
	 * ezeket HasMap-ban tarolva rendszerezzuk, majd a kepek a megfelelo key-el erhetoek el.
	 */
	public static BufferedImage waterImages;
	public static Map<Integer, BufferedImage> iceImages = new HashMap<Integer, BufferedImage>();
	
	public static Map<String, BufferedImage> itmanImages = new HashMap<String, BufferedImage>();
	public static Map<String, BufferedImage> sealImages = new HashMap<String, BufferedImage>();
	public static Map<String, BufferedImage> eskimoImages = new HashMap<String, BufferedImage>();
	public static Map<String, BufferedImage> researcherImages = new HashMap<String, BufferedImage>();
	public static Map<String, BufferedImage> bearImages = new HashMap<String, BufferedImage>();

	
	public static BufferedImage tent;
	public static BufferedImage iglu;
	public static BufferedImage nullbuilding;
	
	public static BufferedImage rope;
	public static BufferedImage shovel;
	public static BufferedImage packedTent;
	public static BufferedImage palesz;
	public static BufferedImage food;
	public static BufferedImage charge;
	public static BufferedImage flare;
	public static BufferedImage gun;
	public static BufferedImage divingSuit;
	public static Map<Integer, BufferedImage> componentImages = new HashMap<Integer, BufferedImage>();
	
	public static BufferedImage loadButtonImage;
	public static BufferedImage exitButtonImage;
	public static BufferedImage newGameButtonImage;
	public static BufferedImage backToMenuButtonImage;
	public static Map<String, BufferedImage> resumeButtonImages = new HashMap<String, BufferedImage>();
	public static Map<String, BufferedImage> saveButtonImages = new HashMap<String, BufferedImage>();
	
	public static Map<String, BufferedImage> useItemButtonImages = new HashMap<String, BufferedImage>();
	public static Map<String, BufferedImage> dropItemButtonImages = new HashMap<String, BufferedImage>();
	public static Map<String, BufferedImage> pickItemButtonImages = new HashMap<String, BufferedImage>();
	public static Map<String, BufferedImage> useSkillButtonImages = new HashMap<String, BufferedImage>();
	public static Map<String, BufferedImage> moveButtonImages = new HashMap<String, BufferedImage>();
	public static Map<String, BufferedImage> skipTurnButtonImages = new HashMap<String, BufferedImage>();
	public static Map<String, BufferedImage> digButtonImages = new HashMap<String, BufferedImage>();
	public static Map<String, BufferedImage> endTurnButtonImages = new HashMap<String, BufferedImage>();
	public static Map<Integer, BufferedImage> redNumberImages = new HashMap<Integer, BufferedImage>();
	public static Map<Integer, BufferedImage> blueNumberImages = new HashMap<Integer, BufferedImage>();
	public static Map<Integer, BufferedImage> lightBlueNumberImages = new HashMap<Integer, BufferedImage>();
	public static BufferedImage lightBluePercent;
	
	public static Map<Integer, BufferedImage>  emptyImages = new HashMap<Integer, BufferedImage>();
	public static Map<Integer, BufferedImage>  capacityImages = new HashMap<Integer, BufferedImage>();
	public static BufferedImage capacityInfiniteImage;
	public static BufferedImage capacityUnknownImage;
	
	public static BufferedImage loseBgImage;
	public static BufferedImage winBgImage;
	public static BufferedImage menuBgImage;
	public static BufferedImage gameBgImage;
	public static BufferedImage infoBgImage;
	public static BufferedImage selectedFieldFrame;
	public static BufferedImage selectedItemFrame;
	public static Map<Integer, BufferedImage> numberOfPlayersLeftImages = new HashMap<Integer, BufferedImage>();
	
	
	public ImageStorage() {
		LoadImages();
	}
	
	/**
	 * Kepek betoltese.
	 */
	private void LoadImages() {
	
		File dir = new File(System.getProperty("user.dir")+"/Resources/Ices" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				for ( int i = 0; i< files.length; i++) {
					iceImages.put(i, ImageIO.read(files[i]));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		dir = new File(System.getProperty("user.dir")+"/Resources/Players/Eskimo" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				eskimoImages.put("standing", ImageIO.read(files[0]));
				eskimoImages.put("standingD", ImageIO.read(files[1]));
				eskimoImages.put("inWater", ImageIO.read(files[2]));
				eskimoImages.put("inWaterD", ImageIO.read(files[3]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		dir = new File(System.getProperty("user.dir")+"/Resources/Players/ITMan" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				itmanImages.put("standing", ImageIO.read(files[0]));
				itmanImages.put("standingD", ImageIO.read(files[1]));
				itmanImages.put("inWater", ImageIO.read(files[2]));
				itmanImages.put("inWaterD", ImageIO.read(files[3]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		dir = new File(System.getProperty("user.dir")+"/Resources/Players/Researcher" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				researcherImages.put("standing", ImageIO.read(files[0]));
				researcherImages.put("standingD", ImageIO.read(files[1]));
				researcherImages.put("inWater", ImageIO.read(files[2]));
				researcherImages.put("inWaterD", ImageIO.read(files[3]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		dir = new File(System.getProperty("user.dir")+"/Resources/Players/Seal" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				sealImages.put("standing", ImageIO.read(files[0]));
				sealImages.put("inWater", ImageIO.read(files[1]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		dir = new File(System.getProperty("user.dir")+"/Resources/Bear" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				bearImages.put("standing", ImageIO.read(files[0]));
				bearImages.put("inWater", ImageIO.read(files[1]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		dir = new File(System.getProperty("user.dir")+"/Resources/Components" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				componentImages.put(0, ImageIO.read(files[0]));
				componentImages.put(1, ImageIO.read(files[1]));
				componentImages.put(2, ImageIO.read(files[2]));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		File tent = new File(System.getProperty("user.dir")+"/Resources/Buildings/tent.png" );
		if(tent != null) {
			try {
				this.tent =  ImageIO.read(tent);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		File iglu = new File(System.getProperty("user.dir")+"/Resources/Buildings/iglu.png" );
		if(iglu != null) {
			try {
				this.iglu =  ImageIO.read(iglu);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		File base = new File(System.getProperty("user.dir")+"/Resources/Backgrounds/losebg.png" );
		if(base != null) {
			try {
				loseBgImage =  ImageIO.read(base);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		 base = new File(System.getProperty("user.dir")+"/Resources/Backgrounds/winbg.png" );
		if(base != null) {
			try {
				winBgImage =  ImageIO.read(base);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		 base = new File(System.getProperty("user.dir")+"/Resources/Backgrounds/menubg.png" );
		if(base != null) {
			try {
				menuBgImage =  ImageIO.read(base);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		 base = new File(System.getProperty("user.dir")+"/Resources/Backgrounds/gamebg.png" );
		if(base != null) {
			try {
				gameBgImage =  ImageIO.read(base);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		 base = new File(System.getProperty("user.dir")+"/Resources/Backgrounds/infoPanel.png" );
			if(base != null) {
				try {
					infoBgImage =  ImageIO.read(base);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		base = new File(System.getProperty("user.dir")+"/Resources/Backgrounds/selectedFieldFrame.png" );
		if(base != null) {
			try {
				selectedFieldFrame =  ImageIO.read(base);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		base = new File(System.getProperty("user.dir")+"/Resources/Backgrounds/selectedItemFrame.png" );
		if(base != null) {
			try {
				selectedItemFrame =  ImageIO.read(base);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		 base = new File(System.getProperty("user.dir")+"/Resources/Buttons/LoadButton/loadButton.png" );
		if(base != null) {
			try {
				loadButtonImage =  ImageIO.read(base);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 base = new File(System.getProperty("user.dir")+"/Resources/Buttons/ExitButton/exitButton.png" );
		if(base != null) {
			try {
				exitButtonImage =  ImageIO.read(base);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		base = new File(System.getProperty("user.dir")+"/Resources/Buttons/NewGameButton/newGameButton.png" );
		if(base != null) {
			try {
				newGameButtonImage =  ImageIO.read(base);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		dir = new File(System.getProperty("user.dir")+"/Resources/Buttons/ResumeButton" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				this.resumeButtonImages.put("normal", ImageIO.read(files[0]));
				this.resumeButtonImages.put("disabled", ImageIO.read(files[1]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dir = new File(System.getProperty("user.dir")+"/Resources/Buttons/SaveButton" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				this.saveButtonImages.put("normal", ImageIO.read(files[0]));
				this.saveButtonImages.put("disabled", ImageIO.read(files[1]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		dir = new File(System.getProperty("user.dir")+"/Resources/Buttons/DigItemButton" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				this.digButtonImages.put("normal", ImageIO.read(files[0]));
				this.digButtonImages.put("disabled", ImageIO.read(files[1]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		dir = new File(System.getProperty("user.dir")+"/Resources/Buttons/DropItemButton" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				this.dropItemButtonImages.put("normal", ImageIO.read(files[0]));
				this.dropItemButtonImages.put("disabled", ImageIO.read(files[1]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dir = new File(System.getProperty("user.dir")+"/Resources/Buttons/EndTurnButton" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				this.endTurnButtonImages.put("normal", ImageIO.read(files[0]));
				this.endTurnButtonImages.put("disabled", ImageIO.read(files[1]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dir = new File(System.getProperty("user.dir")+"/Resources/Buttons/PickUpButton" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				this.pickItemButtonImages.put("normal", ImageIO.read(files[0]));
				this.pickItemButtonImages.put("disabled", ImageIO.read(files[1]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dir = new File(System.getProperty("user.dir")+"/Resources/Buttons/UseItemButton" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				this.useItemButtonImages.put("normal", ImageIO.read(files[0]));
				this.useItemButtonImages.put("disabled", ImageIO.read(files[1]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dir = new File(System.getProperty("user.dir")+"/Resources/Buttons/UseSkillButton" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				this.useSkillButtonImages.put("normal", ImageIO.read(files[0]));
				this.useSkillButtonImages.put("disabled", ImageIO.read(files[1]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dir = new File(System.getProperty("user.dir")+"/Resources/Buttons/MoveButton" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				this.moveButtonImages.put("normal", ImageIO.read(files[0]));
				this.moveButtonImages.put("disabled", ImageIO.read(files[1]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		base = new File(System.getProperty("user.dir")+"/Resources/Items/rope.png" );
		if(base != null) {
			try {
				rope =  ImageIO.read(base);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		base = new File(System.getProperty("user.dir")+"/Resources/Items/shovel.png" );
		if(base != null) {
			try {
				shovel =  ImageIO.read(base);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		base = new File(System.getProperty("user.dir")+"/Resources/Items/packedTent.png" );
		if(base != null) {
			try {
				packedTent =  ImageIO.read(base);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		base = new File(System.getProperty("user.dir")+"/Resources/Items/palesz.png" );
		if(base != null) {
			try {
				palesz =  ImageIO.read(base);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		base = new File(System.getProperty("user.dir")+"/Resources/Items/food.png" );
		if(base != null) {
			try {
				food =  ImageIO.read(base);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		base = new File(System.getProperty("user.dir")+"/Resources/Items/charge.png" );
		if(base != null) {
			try {
				charge =  ImageIO.read(base);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		base = new File(System.getProperty("user.dir")+"/Resources/Items/flare.png" );
		if(base != null) {
			try {
				flare =  ImageIO.read(base);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		base = new File(System.getProperty("user.dir")+"/Resources/Items/gun.png" );
		if(base != null) {
			try {
				gun =  ImageIO.read(base);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		base = new File(System.getProperty("user.dir")+"/Resources/Items/divingSuit.png" );
		if(base != null) {
			try {
				divingSuit =  ImageIO.read(base);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		dir = new File(System.getProperty("user.dir")+"/Resources/Numbers/Red" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				for (int i = 0; i < files.length; i++) {
					this.redNumberImages.put(i, ImageIO.read(files[i]));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		dir = new File(System.getProperty("user.dir")+"/Resources/Numbers/Blue" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				for (int i = 0; i < files.length; i++) {
					this.blueNumberImages.put(i, ImageIO.read(files[i]));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		dir = new File(System.getProperty("user.dir")+"/Resources/Numbers/LightBlue" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				for (int i = 0; i < files.length; i++) {
					this.lightBlueNumberImages.put(i, ImageIO.read(files[i]));
				}
				this.lightBluePercent =ImageIO.read(files[10]);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		base = new File(System.getProperty("user.dir")+"/Resources/Buttons/backToMenuButton.png" );
		if(base != null) {
			try {
				this.backToMenuButtonImage =  ImageIO.read(base);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		dir = new File(System.getProperty("user.dir")+"/Resources/Empty" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				this.emptyImages.put(128, ImageIO.read(files[0]));
				this.emptyImages.put(64, ImageIO.read(files[1]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		dir = new File(System.getProperty("user.dir")+"/Resources/Capacity" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				this.capacityImages.put(0, ImageIO.read(files[0]));
				this.capacityImages.put(1, ImageIO.read(files[1]));
				this.capacityImages.put(2, ImageIO.read(files[2]));
				this.capacityImages.put(3, ImageIO.read(files[3]));
				this.capacityImages.put(4, ImageIO.read(files[4]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		base = new File(System.getProperty("user.dir")+"/Resources/Capacity/capacityInfinite.png" );
		if(base != null) {
			try {
				this.capacityInfiniteImage =  ImageIO.read(base);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		base = new File(System.getProperty("user.dir")+"/Resources/Capacity/capacityUnknown.png" );
		if(base != null) {
			try {
				this.capacityUnknownImage =  ImageIO.read(base);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		dir = new File(System.getProperty("user.dir")+"/Resources/NumberOfPlayersLeft" );
		if(dir != null) {
			try {
				File files[] = dir.listFiles();
				this.numberOfPlayersLeftImages.put(0, ImageIO.read(files[0]));
				this.numberOfPlayersLeftImages.put(1, ImageIO.read(files[1]));
				this.numberOfPlayersLeftImages.put(2, ImageIO.read(files[2]));
				this.numberOfPlayersLeftImages.put(3, ImageIO.read(files[3]));
				this.numberOfPlayersLeftImages.put(4, ImageIO.read(files[4]));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
