package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import source.ConsoleHelper;

public class ConsoleHandlerTest {
	ConsoleHelper consoleHelper;
	
	@Before
	public void before(){
		consoleHelper = new ConsoleHelper();
	}
	
	@Test
	public void determinePlayerTypeHandlesCorrectInput(){
		String type = consoleHelper.determinePlayerType("y");
		assertEquals("human", type);
	}
	
	@Test
	public void isValidTypeInputReturnsTrueForYorN(){
		boolean valid = consoleHelper.isValidTypeInput("y");
		assertEquals(true, valid);
	}

}
