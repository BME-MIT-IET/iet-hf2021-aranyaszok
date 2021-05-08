package test.java.aranyaszok;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.aranyaszok.*;

class ResearcherSkillTests {
	
	Researcher player = new Researcher();
	Ice ice = new Ice();
	
	@BeforeEach
	public void setUp() {	
		player.SetFacing(ice);				
	}


	@Test
	void test() {
		player.Skill();
		assertEquals(true,ice.isResearched());
	}

}
