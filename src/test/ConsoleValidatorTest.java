package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import source.console.ConsoleValidator;

public class ConsoleValidatorTest {
	ConsoleValidator validator;
	
	@Before
	public void beforeAll(){
		validator = new ConsoleValidator();
	}

	@Test
	public void validatesPlayerConfigInput(){
		assertTrue(validator.isValidPlayerConfig("hvh"));
		assertTrue(validator.isValidPlayerConfig("hVc"));
		assertTrue(validator.isValidPlayerConfig("Cvh"));
		assertTrue(validator.isValidPlayerConfig("cvc"));
		assertFalse(validator.isValidPlayerConfig("hvv"));
	}
	
	@Test
	public void validatesMoveInputAgainstRegex(){
		assertTrue(validator.isValidMoveInput("0,0"));
		assertFalse(validator.isValidMoveInput("3,3"));
		assertFalse(validator.isValidMoveInput("11"));
	}
	
	@Test
	public void validatesDifficultyInput(){
		assertTrue(validator.isValidDifficultyInput("e"));
		assertTrue(validator.isValidDifficultyInput("E"));
		assertTrue(validator.isValidDifficultyInput("I"));
		assertTrue(validator.isValidDifficultyInput("i"));
		assertFalse(validator.isValidDifficultyInput("doop"));
		assertFalse(validator.isValidDifficultyInput("%20"));
	}

}
