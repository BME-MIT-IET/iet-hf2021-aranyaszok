package test.java.aranyaszok;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.java.aranyaszok.*;

public class StormOnIceWithIgluTests {
	Ice ice1;
	Ice ice2;
	Eskimo eskimo;
	Iglu iglu;
	
	@BeforeEach
	public void setup() {
		ice1 = new Ice();
		ice2 = new Ice();
		ice1.AddNeighbour(ice2);
		eskimo = new Eskimo();
		iglu = new Iglu(ice1);
		
		ice1.AddSteppable(eskimo);
		eskimo.SetWater(ice1);
		ice1.SetBuilding(iglu);
		ice1.SetSnowLayers(1);
		eskimo.SetBodyHeat(2);
	}
	
	@Test
	@DisplayName("Storm on Ice with Iglu") 
	public void stormOnIceWithIglu() {
		
		ice1.Storm();
		
		assertEquals(2, ice1.GetSnowLayers());
		assertEquals(2, eskimo.GetBodyHeat());
		assertEquals(iglu, ice1.GetBuilding());
	}
}
