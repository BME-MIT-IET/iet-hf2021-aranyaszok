package test.java.aranyaszok;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.aranyaszok.Component;
import main.java.aranyaszok.Ice;
import main.java.aranyaszok.Item;
import main.java.aranyaszok.Researcher;

class DiggingItemWithEmptyFrozenItemsListTests {

	Ice ice = new Ice();
	Researcher player = new Researcher();
	
	@BeforeEach
	public void setUp() {		
		ice.SetSnowLayers(0);
		player.SetWater(ice);
	}

	@Test
	void test() {
		player.Digging();
		assertEquals(0,ice.GetFloatingItems().size());
	}

}
