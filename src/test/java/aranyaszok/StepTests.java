package test.java.aranyaszok;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.java.aranyaszok.*;
import main.java.aranyaszok.gui.BuildingView;
import main.java.aranyaszok.gui.FieldView;
import main.java.aranyaszok.gui.View;

public class StepTests {
	
	Ice centralIce;
	Ice ice;
	Water water;
	UnstableIce unstableIce;
	Eskimo eskimo;
	Seal seal;
	
	
	@BeforeEach
	public void setup() {
		centralIce = new Ice();
		ice = new Ice();
		water = new Water();
		unstableIce = new UnstableIce(1);
		eskimo = new Eskimo();
		seal = new Seal();
		
		centralIce.AddNeighbour(ice);
		centralIce.AddNeighbour(water);
		centralIce.AddNeighbour(unstableIce);
		ice.AddNeighbour(centralIce);
		water.AddNeighbour(centralIce);
		unstableIce.AddNeighbour(centralIce);
		
		centralIce.AddSteppable(eskimo);
		unstableIce.AddSteppable(seal);
	}
	
	@Test
	@DisplayName("Step onto ice") 
	public void testStepOntoIce() {
		eskimo.Move(ice);
		
		assertEquals(ice, eskimo.GetWater());
	}
	
	@Test
	@DisplayName("Step onto water") 
	public void testStepOntoWater() {
		eskimo.Move(water);
		
		assertEquals(water, eskimo.GetWater());
		assertEquals(false, eskimo.GetSafe());
	}
}
