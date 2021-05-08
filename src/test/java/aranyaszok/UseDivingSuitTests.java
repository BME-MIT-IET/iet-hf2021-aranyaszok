package test.java.aranyaszok;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.java.aranyaszok.*;

public class UseDivingSuitTests {
	Researcher researcher = new Researcher();
	DivingSuit divingSuit = new DivingSuit();

	
	@BeforeEach
	public void setup() {
		researcher.AddItem(divingSuit);
	}
	
	@Test
	@DisplayName("Use DivingSuit") 
	public void UseDivingSuit() {
		researcher.SetSafe(false);
		divingSuit.Use(researcher);
		
		assertEquals(false, researcher.IsInventoryItem(divingSuit));
		assertEquals(true, researcher.GetSafe());
	}
	
	@Test
	@DisplayName("Use DivingSuit with safe attribute set to True") 
	public void UseDivingSuitWithSafeAttributeTrue() {
		researcher.SetSafe(true);
		divingSuit.Use(researcher);
		
		assertEquals(false, researcher.IsInventoryItem(divingSuit));
		assertEquals(true, researcher.GetSafe());
	}
}
