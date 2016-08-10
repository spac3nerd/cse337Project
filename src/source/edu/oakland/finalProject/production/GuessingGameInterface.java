package edu.oakland.production;

import edu.oakland.production.*;
import edu.oakland.helper.*;
import java.util.*;

public class GuessingGameInterface {
	
	public static void main( String[] args ) {
		int upperBound = 1024;
		String input;
		
		GuessingGameRepository game = new GuessingGameRepository();
		Scanner scanner = new Scanner( System.in );
		GuessingGameCalculator calculator;
		
		System.out.println( "Welcome to the Guessing Game." );
		System.out.println( "Please enter your desired upper bound or press enter for the default (1024)" );
		input = scanner.nextLine();
		
		if( !input.isEmpty() ) {
			upperBound = Integer.parseInt( input );
		}
		
		game.setUpperBound( upperBound );
		game.setHigh( upperBound );
		game.setLow( 1 );
		game.setMidPoint( upperBound / 2 );
		
		System.out.println( "Please pick a number between 1 and " + upperBound + "." );
		System.out.println( "I will guess your number in " + game.getMaxGuesses() + " guesses or less." );
		
		calculator = new GuessingGameCalculator( game );
		
		calculator.evaluateGuess( game.getHigh(), game.getLow(), game.getMidPoint() );
	}
}