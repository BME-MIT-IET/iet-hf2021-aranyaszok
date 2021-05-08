package stresstest.java.aranyaszok;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import main.java.aranyaszok.*;
import main.java.aranyaszok.gui.ItemView;
import main.java.aranyaszok.gui.SteppableView;


public class StressTest {
	
	GameManager gm;
	Ice ice1;
	Ice ice2;
	
	@Test
	@DisplayName("Start the game with default coditions")
	public void EmptyTest() {
		gm = new GameManager();
		gm.vm.Update();
		gm.Reset();
		gm.Play();
		gm.vm.ChangeSelectedPanel("game");
		gm.vm.Update();
	}
	
	@Test
	@DisplayName("Start the game with max number of Bears on each Ice")
	public void BearsTest() {
		gm = new GameManager();
		gm.vm.Update();
		gm.Reset();
		gm.Play();

		List<Water> waters = gm.GetMap();
		
		for (int i = 0; i < waters.size(); i++) {
			if (waters.get(i).IsNeightbour(waters.get(0))) {
				waters.get(i).SetNeighbour(waters.get(0), waters.get(i));
			}
		}
		
		for (int i = 0; i < 32; i++) {
			Bear bear = new Bear();
			SteppableView bearview1 = new SteppableView(0, 0, 64, 64);
			bearview1.AddModel(bear);
			bear.AddView(bearview1);
			gm.vm.AddStaticViewToGamePanel(bearview1);
			
			waters.get(4).AddSteppable(bear);
			
			//waters.get(i % (waters.size() - 1) + 1).AddSteppable(bear);
		}
		
		gm.vm.ChangeSelectedPanel("game");
		gm.vm.Update();
	}
	
	@Test
	@DisplayName("Start the game with X number of FrozenItems")
	public void FrozenItemsTest() {
		gm = new GameManager();
		gm.vm.Update();
		gm.Reset();
		gm.Play();

		List<Water> waters = gm.GetMap();
		
		for (int i = 0; i < waters.size(); i++) {
			for (int j = 0; j < 1000; j++) {
				Food item = new Food();
				ItemView itemView = new ItemView(0, 0, 64, 64);
				itemView.SetActiveImage(gm.vm.images.food);
				item.AddView(itemView);
				itemView.AddModel(item);
				waters.get(i).AddFrozenItem(item);
			}
		}
		
		gm.vm.ChangeSelectedPanel("game");
		gm.vm.Update();
	}
	
	@Test
	@DisplayName("Start the game with X number of FloatingItems")
	public void FloatingItemsTest() {
		gm = new GameManager();
		gm.vm.Update();
		gm.Reset();
		gm.Play();

		List<Water> waters = gm.GetMap();
		
		for (int i = 0; i < waters.size(); i++) {
			for (int j = 0; j < 1000; j++) {
				Food item = new Food();
				ItemView itemView = new ItemView(0, 0, 64, 64);
				itemView.SetActiveImage(gm.vm.images.food);
				item.AddView(itemView);
				itemView.AddModel(item);
				waters.get(i).AddFloatingItem(item);
			}
		}
		
		gm.vm.ChangeSelectedPanel("game");
		gm.vm.Update();
	}
	
	@Test
	@DisplayName("Start the game with X number of Players on each Ice")
	public void PlayersTest() {
		gm = new GameManager();
		gm.vm.Update();
		gm.Reset();
		gm.Play();

		List<Water> waters = gm.GetMap();
		
		System.out.println(waters.size());
		
		for (int i = 0; i < waters.size(); i++) {
			System.out.println(waters.size());
			List<Bear> bears = waters.get(i).GetBears();
			if (bears.size() == 0) {
				if (waters.get(i).GetCapacity() == -1)
					for (int j = 0; j < 440000; j++) {
						ITMan itman = new ITMan();
						SteppableView itmanview = new SteppableView(1000,1000,64,64);
						itmanview.AddModel(itman);
						itman.AddView(itmanview);
						
						Seal seal = new Seal();
						SteppableView sealview = new SteppableView(1000,1000,64,64);
						sealview.AddModel(seal);
						seal.AddView(sealview);
						
						Researcher researcher = new Researcher();
						SteppableView researcherview = new SteppableView(1000,1000,64,64);
						researcherview.AddModel(researcher);
						researcher.AddView(researcherview);
						
						Eskimo eskimo = new Eskimo();
						SteppableView eskimoview = new SteppableView(1000,1000,64,64);
						eskimoview.AddModel(eskimo);
						eskimo.AddView(eskimoview);
						
						waters.get(i).AddSteppable(itman);
						waters.get(i).AddSteppable(seal);
						waters.get(i).AddSteppable(researcher);
						waters.get(i).AddSteppable(eskimo);
				}	
			}
		}
		
		gm.vm.ChangeSelectedPanel("game");
		gm.vm.Update();
	}	
}
