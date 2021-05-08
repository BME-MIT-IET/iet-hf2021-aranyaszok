package test.java.aranyaszok;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.aranyaszok.*;

class ITManSkillTests {

	Ice ice = new Ice();
	Ice ice2 = new Ice();
	ITMan player1 = new ITMan();
	Eskimo player2 = new Eskimo();
	Palesz p = new Palesz(); 
	
	@BeforeEach
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
	void test() {
		p.Use(player1);
		assertEquals(player2.GetBodyHeatBase(), player2.GetBodyHeat());
		assertEquals(player1.GetBodyHeatBase(), player1.GetBodyHeat());
	}

}
