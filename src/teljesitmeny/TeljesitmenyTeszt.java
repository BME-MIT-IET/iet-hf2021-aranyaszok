package test.java.aranyaszok.teljesitmeny;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;

import main.java.aranyaszok.*;

public class TeljesitmenyTeszt{	
	
	@Rule
	public BenchmarkRule benchmarkRun = new BenchmarkRule();	

	@Test
	@BenchmarkOptions(warmupRounds = 0, benchmarkRounds = 20)
	public void testStartGameManager() throws Exception {		
		GameManager gameManager = new GameManager();
		gameManager.vm.Update();
	}
}

