package test.java.aranyaszok;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.aranyaszok.Component;
import main.java.aranyaszok.Ice;
import main.java.aranyaszok.Researcher;

class PickUpAnItemTests {

	Ice ice = new Ice();
	Researcher player = new Researcher();
	Component c = new Component();
	
	@BeforeEach
	public void setUp() {	
		player.SetWater(ice);
		ice.AddFloatingItem(c);				
	}

	@Test
	void test() {
		player.PickUpItem(c);
		assertEquals(c,player.GetItems().get(0));
	}

}
