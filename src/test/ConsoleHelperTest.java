package test;

import java.util.Scanner;

import org.junit.Before;

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
