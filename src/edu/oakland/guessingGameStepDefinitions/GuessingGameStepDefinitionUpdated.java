package edu.oakland.guessingGameStepDefinitions;

import edu.oakland.production.*;
import edu.oakland.helper.*;

import cucumber.api.java.en.*;
import edu.oakland.helper.*;
import org.junit.*;
import static org.junit.Assert.*;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import static org.hamcrest.CoreMatchers.*;

public class GuessingGameStepDefinitionUpdated{
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
	private int numOfGuesses = 6;

@Given("^the user has chosen a number in their head$")
public void the_user_has_chosen_a_number_in_their_head() throws Throwable {
repository = new GuessingGameRepository(high, low, mid);
        calculator = new GuessingGameCalculator(repository);
        assertThat(calculator.userNumSelect(), is(true));
}

@Then("^the system selects the midpoint of the current range as the next guess$")
public void the_system_selects_the_midpoint_of_the_current_range_as_the_next_guess() throws Throwable {
   assertEquals(calculator.calculateMidPoint(), mid);
}

@Then("^the system displays options to the user on the screen$")
public void the_system_displays_options_to_the_user_on_the_screen() throws Throwable {
    assertThat(calculator.optionsDisplayed(), is(true));
}

@Then("^the user selects either \"(.*?)\" \"(.*?)\" or \"(.*?)\"$")
public void the_user_selects_either_or(String arg1, String arg2, String arg3) throws Throwable {
    	calculator.receiveUserInput(user1);
    	assertThat(calculator.userSelection(), is(true));
    	
        calculator.receiveUserInput(user2);
        assertThat(calculator.userSelection(), is(true));
        
        calculator.receiveUserInput(user3);
        assertThat(calculator.userSelection(), is(true));
}

@When("^the user selects \"(.*?)\"$")
public void the_user_selects(String arg1) throws Throwable {
   	calculator.receiveUserInput(user2);
    	assertThat(calculator.userSelectsHigher(), is(true));
}

@Then("^the system uses the High-range$")
public void the_system_uses_the_High_range() throws Throwable {
    	calculator.receiveUserInput(user2);
    	assertThat(calculator.useHighRange(), is(true));
}

@Then("^the system makes another guess$")
public void the_system_makes_another_guess() throws Throwable {
  calculator.receiveUserInput(user2);
    	assertThat(calculator.makeGuessHigher(), is(true));
}

@Then("^the system uses the Low-Range$")
public void the_system_uses_the_Low_Range() throws Throwable {
  calculator.receiveUserInput(user1);
    	assertThat(calculator.useLowRange(), is(true));
}

@Then("^the system tells the user that he or she has lost the game$")
public void the_system_tells_the_user_that_he_or_she_has_lost_the_game() throws Throwable {
    calculator.receiveUserInput(user3);
    	assertThat(calculator.userLostGameIsDisplayed(), is(true));
}

@When("^the system makes a guess$")
public void the_system_makes_a_guess() throws Throwable {
  calculator.receiveUserInput(user1);
    	assertThat(calculator.systemMakesGuess(), is(true));
    	
    	calculator.receiveUserInput(user2);
    	assertThat(calculator.systemMakesGuess(), is(true));
}

@Then("^the system displays the current guess$")
public void the_system_displays_the_current_guess() throws Throwable {
	calculator.receiveUserInput(user1);
    	assertThat(calculator.displayGuess(), is(true));
    	
    	calculator.receiveUserInput(user2);
    	assertThat(calculator.displayGuess(), is(true));
}

@Then("^the system displays the number of guesses made$")
public void the_system_displays_the_number_of_guesses_made() throws Throwable {
		//calculator.receiveUserInput(user1);
		assertThat(calculator.getGuessIteration(), is(9));
}

@When("^the system exceeds the maximum number of guesses$")
public void the_system_exceeds_the_maximum_number_of_guesses() throws Throwable {
  	calculator.receiveUserInput(user1);
    	assertThat(calculator.exceedsMaxGuesses(), is(true));
    	
    	calculator.receiveUserInput(user2);
    	assertThat(calculator.exceedsMaxGuesses(), is(true));
}

@Then("^the system tells the user that he or she has won the game$")
public void the_system_tells_the_user_that_he_or_she_has_won_the_game() throws Throwable {
  calculator.receiveUserInput(user1);
    	assertThat(calculator.userWinsGameIsDisplayed(), is(true));
    	
    	calculator.receiveUserInput(user2);
    	assertThat(calculator.userWinsGameIsDisplayed(), is(true));
}
}