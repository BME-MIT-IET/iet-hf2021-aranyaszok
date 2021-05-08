package test.java.aranyaszok;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.java.aranyaszok.Food;
import main.java.aranyaszok.Ice;
import main.java.aranyaszok.Item;
import main.java.aranyaszok.Researcher;
import main.java.aranyaszok.Shovel;

public class UseShovelTests {

	Researcher r1 = new Researcher();
	Shovel s1 = new Shovel(1);
	Ice i1 = new Ice();
	
	Researcher r2 = new Researcher();
	Shovel s2 = new Shovel(1);
	Shovel s3 = new Shovel(1);
	Ice i2 = new Ice();

	
	@BeforeEach
	public void set() {
		r1.AddItem(s1);
		i1.SetSnowLayers(3);
		r1.SetWater(i1);
		
		r2.AddItem(s2);
		i2.SetSnowLayers(0);
		r2.SetWater(i2);
		i2.AddFrozenItem(s3);
	}
	
	@Test
	@DisplayName("UseShovelToDigSnowLayer") 
	public void UseShovelToDigSnowLayer() {
		int original = i1.GetSnowLayers();
		s1.Use(r1);
		assertEquals(original - 2, i1.GetSnowLayers());   
	}
	
	@Test
	@DisplayName("UseShovelToDigItem") 
	public void UseShovelToDigItem() {
		s2.Use(r2);
		Item item = i2.GetFloatingItems().get(0);

		assertEquals(item.getClass(), s3.getClass());   
	}
}
