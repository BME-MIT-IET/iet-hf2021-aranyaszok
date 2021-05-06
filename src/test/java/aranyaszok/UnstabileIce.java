package test.java.aranyaszok;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import main.java.aranyaszok.*;
import main.java.aranyaszok.gui.FieldView;

import org.junit.jupiter.api.Test;

class UnstabileIce {

	Ice ice = new Ice();
	UnstableIce ice2 = new UnstableIce(1);
	Eskimo eskimo = new Eskimo();
	Seal seal2 = new Seal();
	
	@BeforeEach
	void setup() {
		ice.AddNeighbour(ice2);
		ice2.AddNeighbour(ice);
		
		FieldView view = new FieldView(0,0,0,0);
		ice2.AddView(view);
		
		ice.AddSteppable(eskimo);
		ice.AddSteppable(seal2);
	}	
	
	@Test
	void test() {
		eskimo.Move(ice2);
		
		assertEquals(false, eskimo.GetSafe());
	}

}
