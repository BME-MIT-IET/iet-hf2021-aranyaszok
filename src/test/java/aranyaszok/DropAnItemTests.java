package test.java.aranyaszok;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.aranyaszok.Component;
import main.java.aranyaszok.Ice;
import main.java.aranyaszok.Researcher;

class DropAnItemTests {

	Ice ice = new Ice();
	Researcher player = new Researcher();
	Component c = new Component();
	
	@BeforeEach
	public void setUp() {	
		player.SetWater(ice);
		player.AddItem(c);				
	}

	@Test
	void test() {
		player.DropItem(c);
		assertEquals(0,player.GetItems().size());
	}

}
