package edu.oakland.production;

import edu.oakland.helper.*;
import java.util.*;


public class GuessingGameInterface{


	public static void main( String[] args){
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please choose a number");
		int input = scanner.nextInt();
			
		GuessingGameRepository repo = new GuessingGameRepository();
		repo.setLow(1);
		
		if ( input >  0){
			repo.setHigh(input);
		}
		else{
			repo.setHigh(1024);
		}
				
		GuessingGameCalculator calculator = new GuessingGameCalculator(repo);
		
		System.out.println("The max number of guesses it will take is ");
		System.out.println(calculator.getMaxGuesses());
		
		// Loop through until guessing is complete
		for (int i=1; i < calculator.getMaxGuesses(); i++){
			
		System.out.println("Your current guess number is:");
		calculator.getGuessIteration();
		
			
		System.out.println(calculator.calculateMidPoint());
		
		input = scanner.nextInt();
		calculator.receiveUserInput(input);
		
		}

		System.out.println("You should have won");
		
		
		
	}

}