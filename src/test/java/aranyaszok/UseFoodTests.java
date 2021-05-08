package test.java.aranyaszok;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.java.aranyaszok.Food;
import main.java.aranyaszok.Researcher;

public class UseFoodTests {

	Researcher r = new Researcher();
	Food f = new Food();

	
	@BeforeEach
	public void set() {
		r.AddItem(f);
	}
	
	@Test
	@DisplayName("UseFood") 
	public void UseFoods() {
		r.SetBodyHeat(1);
		f.Use(r);
		assertEquals(2, r.GetBodyHeat());   
	}
	
	@Test
	@DisplayName("UseFoodOnMaxBodyHeat") 
	public void UseFoodOnMaxBodyHeat() {
		r.SetBodyHeat(10);
		f.Use(r);
		assertEquals(r.GetBodyHeat(), r.GetBodyHeatBase());   
	}
}
