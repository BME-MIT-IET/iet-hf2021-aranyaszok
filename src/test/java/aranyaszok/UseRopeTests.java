package test.java.aranyaszok;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.java.aranyaszok.Ice;
import main.java.aranyaszok.Researcher;
import main.java.aranyaszok.Rope;
import main.java.aranyaszok.Water;

public class UseRopeTests {
	
	Researcher r1 = new Researcher();
	Researcher r2 = new Researcher();
	
	Ice i = new Ice();
	Water w = new Water();
	
	Rope r = new Rope();

	
	@BeforeEach
	public void set() {
		i.AddNeighbour(w);
		w.AddNeighbour(i);
		i.AddSteppable(r1);
		w.AddSteppable(r2);
		r1.AddItem(r);
	}
	
	@Test
	@DisplayName("UseRope") 
	public void UseRopes() {
		r.Use(r1);
		assertEquals(i.getClass(), r2.GetWater().getClass());   
	}
}
