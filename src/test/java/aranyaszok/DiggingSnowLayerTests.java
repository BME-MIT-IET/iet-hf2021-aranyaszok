package test.java.aranyaszok;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import main.java.aranyaszok.*;

class DiggingSnowLayerTests {

	Ice ice = new Ice();
	Researcher player = new Researcher();
	
	@BeforeEach
	public void setUp() {		
		ice.SetSnowLayers(2);
		player.SetWater(ice);
	}
	
	@Test
	@DisplayName("DiggingSnowLayer")
	void testDiggingSnow() {		
		player.Digging();
		assertEquals(1,ice.GetSnowLayers(),"Csokkent");
	}

}
