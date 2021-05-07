package test.java.aranyaszok;

import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;

import main.java.aranyaszok.*;

public class Test1 extends AbstractBenchmark {

	Ice ice = new Ice();
	Ice ice2 = new Ice();
	ITMan player1 = new ITMan();
	Eskimo player2 = new Eskimo();
	Palesz p = new Palesz(); 
	
	@Before
	public void setUp() {
		player1.SetWater(ice);
		player2.SetWater(ice);
		ice.AddNeighbour(ice2);
		ice.AddSteppable(player1);
		ice.AddSteppable(player2);		
		player1.SetBodyHeat(1);
		player2.SetBodyHeat(1);
		player1.AddItem(p);
	}

	@Test
	public void test() throws Exception {
		p.Use(player1);
		assertEquals(player2.GetBodyHeatBase(), player2.GetBodyHeat());
		assertEquals(player1.GetBodyHeatBase(), player1.GetBodyHeat());
	}

}
