package test.java.aranyaszok;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import main.java.aranyaszok.*;

class EskimoSkillOnIceWhitTentTests {
	
	Ice ice = new Ice();
	Tent tent = new Tent(ice);
	Eskimo player = new Eskimo();
	
	@BeforeEach
	public void setUp() {	
		player.SetWater(ice);			
	}

	@Test
	void test() {
		player.Skill();
		assertNotEquals(tent, ice.GetBuilding());
	}

}
