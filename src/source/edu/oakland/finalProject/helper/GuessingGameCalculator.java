package edu.oakland.production;

import edu.oakland.helper.*;
import java.util.*;
import java.math.*;

public class GuessingGameCalculator {
	GuessingGameRepository game = new GuessingGameRepository();
	Scanner scanner = new Scanner( System.in );
	private int response;
	
	public GuessingGameCalculator( GuessingGameRepository game ) {
		this.game = game;
	}
	
	public void evaluateGuess( int high, int low, int mid ) {
		game.setGuessIteration( game.getGuessIteration() + 1 );
		System.out.println( "Guess number " + game.getGuessIteration() + " is " + mid );
		System.out.println( "If this is your number press 3, otherwise press 1 if your number is lower and 2 if it is higher." );
		response = scanner.nextInt();
		
		if( response == 3 ) {
			System.out.println( "Your number was " + mid + "." );
			System.out.println( "It took me " + game.getGuessIteration() + " guesses to determine your number." );
		} else {
			if( response == 1 ) {
				evaluateGuess( mid, low, game.calculateMidPoint( mid, low ) );
			} else {
				evaluateGuess( high, mid, game.calculateMidPoint( high, mid ) );
			}
		}
	}
}