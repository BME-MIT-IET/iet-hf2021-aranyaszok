package test.java.aranyaszok;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import main.java.aranyaszok.*;

class DiggingItemTests {
	
	Ice ice = new Ice();
	Researcher player = new Researcher();
	Component c = new Component();
	
	@BeforeEach
	public void setUp() {		
		ice.SetSnowLayers(0);
		player.SetWater(ice);
		ice.AddFrozenItem(c);
	}

	@Test
	void test() {
		player.Digging();
		assertEquals(c,ice.GetFloatingItems().get(0));
	}
		

}
