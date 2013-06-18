package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import source.ConsoleHelper;

public class ConsoleHelperTest {
	ConsoleHelper consoleHelper;
	
	@Before
	public void beforeAll(){
		consoleHelper = new ConsoleHelper();
	}
	
	@Test
	public void validatesPlayerConfigInput(){
		assertTrue(consoleHelper.isValidPlayerConfig("hvh"));
		assertTrue(consoleHelper.isValidPlayerConfig("hVc"));
		assertTrue(consoleHelper.isValidPlayerConfig("Cvh"));
		assertTrue(consoleHelper.isValidPlayerConfig("cvc"));
		assertFalse(consoleHelper.isValidPlayerConfig("hvv"));
	}
	
	@Test
	public void validatesMoveInput(){
		assertTrue(consoleHelper.isValidMoveInput("0,0"));
		assertFalse(consoleHelper.isValidMoveInput("3,3"));
		assertFalse(consoleHelper.isValidMoveInput("11"));
	}
}
