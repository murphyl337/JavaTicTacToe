package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import source.console.ConsoleHelper;

public class ConsoleHelperTest {
	ConsoleHelper consoleHelper;
	Scanner scanner;
	
	@Before
	public void beforeAll(){
		scanner = new Scanner(System.in);
		consoleHelper = new ConsoleHelper(scanner);
	}
	
	
}
