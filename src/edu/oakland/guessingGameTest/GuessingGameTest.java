	package edu.oakland.guessingGameTest;
	
	import cucumber.api.junit.Cucumber;
	import cucumber.api.CucumberOptions;
	import org.junit.runner.RunWith;

	import edu.oakland.production.*;
	import edu.oakland.helper.*;

	import org.junit.*;
	import static org.junit.Assert.*;

	@RunWith(Cucumber.class)
	@CucumberOptions(
		glue="edu.oakland.guessingGameStepDefinitions",
		features="src/edu/oakland/guessingGameTest")
	public class GuessingGameTest{
	

	
	//reference variables for the System classes;
	private GuessingGameCalculator calculator;
	private GuessingGameInterface Interface;
	private GuessingGameRepository repository;
	private int high = 1024;
	private int high2 = 24;
	private int low = 1;
	private int low2 = 22;
	private int mid = 512;
	private int mid2 = 23;
	private int user1 = 1;
	private int user2 = 2;
	private int user3 = 3;
	private int maxGuess = 10;
	
	 @Before
	public void initializeSystem() {
		repository = new GuessingGameRepository(high, low, mid);
		calculator = new GuessingGameCalculator(repository);
}
	@Test
	public void testInitializationHigh() {
	//retrieve stored date & compare with submitted;
	assertEquals(repository.getHigh(), high );
}
	@Test
	public void testInitializationLow() {
	//retrieve stored date & compare with submitted;
	assertEquals(repository.getLow(), low );
}
	@Test
	public void testInitializationMid() {
	//retrieve stored date & compare with submitted;
	assertEquals(repository.getMid(), mid );
}
	@Test
	public void testUserEntry() {
	//retrieve stored date & compare with submitted;
	
	calculator.receiveUserInput(user1);
	assertEquals(calculator.getUserInput(), user1);
	
	calculator.receiveUserInput(user2);
	assertEquals(calculator.getUserInput(), user2);
	
	calculator.receiveUserInput(user3);
	assertEquals(calculator.getUserInput(), user3);
}
	@Test
	public void testCalculateMidPoint() {
		//repository.setHigh(high2);
		//repository.setLow(low2);
		assertEquals(calculator.calculateMidPoint(), mid);
	}
	@Test
	public void testMaxGuesses() {
		assertEquals(calculator.getMaxGuesses(), maxGuess);
	}
	
	}
	