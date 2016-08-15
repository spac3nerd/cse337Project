package edu.oakland.helper;

import edu.oakland.production.*;
import edu.oakland.helper.*;

import java.util.*;
import java.math.*;


public class GuessingGameCalculator{

	private GuessingGameRepository repository;
	private boolean userNum = true;
	private boolean displayOptions = true;
	private boolean currentGuessIsDisplayed;
	private int input;
	private int guessIteration;
	private boolean selection;
	
		public GuessingGameCalculator(GuessingGameRepository repository){
			
			this.repository = repository;
		
		}
		
		public GuessingGameRepository getRepository(){
			
			return repository;
			
		}
				
		public void receiveUserInput(int input){
			
			this.input = input;
		}	
		
		public  int getUserInput(){
		    return input;
		}
		
			
		public int calculateMidPoint(){
			
			int expectedValue;
			int highValue = repository.getHigh();
			int lowValue = repository.getLow();
			
			guessIteration = guessIteration + 1;
			
			repository.setGuess(guessIteration);
			
			expectedValue = lowValue + (highValue - lowValue) / 2;
			
			repository.setMid(expectedValue);
			
			return expectedValue;
			
		}	
		
		public int getMaxGuesses(){
			
			int highValue = repository.getHigh();
			
			int maxGuesses = (int) Math.ceil( Math.log( highValue ) / Math.log( 2 ) );
			return maxGuesses;
			
		}
		
		public int getGuessIteration(){
			return repository.getGuess();
		}
		
		public boolean userNumSelect() {
			if(userNum == true) {
				return true;
			}
			else
				return false;
		}

		public boolean optionsDisplayed() {
			if(userNum == true && displayOptions == true) {
				return true;
			}
			else
				return false;
		}
		
		public boolean userSelection() {
			if(input == 1 || input == 2 || input == 3) {
				selection = true;
				return true;
			}
			else
				return false;
		}
		
		public boolean userSelectsHigher() {
			if(input == 2) {
				selection = true;
				return true;
			}
			else
				return false;
		}
		
		public boolean useHighRange() {
			if(selection == true && input == 2) {
				return true;
			}
			else
				return false;
		}
		
		public boolean makeGuessHigher() {
			if(useHighRange() == true) {
				calculateMidPoint();
				return true;
			}
			else
				return false;
		}
		
		public boolean userSelectsLower() {
			if(input == 1) {
				selection = true;
				return true;
			}
			else
				return false;
		}
		
		public boolean useLowRange() {
			if(selection == true && input == 1) {
				return true;
			}
			else
				return false;
		}
		
		public boolean makeGuessLower() {
			if(useLowRange() == true && input == 1) {
				calculateMidPoint();
				return true;
			}
			else
				return false;
		}
		
		public boolean userSelectsEqual() {
			if(input == 3) {
				selection = true;
				return true;
			}
			else
				return false;
		}
		
		public boolean userLostGameIsDisplayed() {
			if(selection == true && input == 3 && userSelectsEqual() == true) {
				return true;
			}
			else
				return false;
		}
		
		public boolean exceedsMaxGuesses() {
			int maxGuesses = getMaxGuesses() + 1;
			if(input == 1 && maxGuesses > 10 || input == 2 && maxGuesses > 10) {
				return true;
			}
			else
				return false;
		}
		
		public boolean systemMakesGuess() {
			if(userNum == true && optionsDisplayed() == true && userSelection() == true && input == 1 || userNum == true && optionsDisplayed() == true && userSelection() == true && input == 2 || userNum == true && optionsDisplayed() == true && userSelection() == true) {
                calculateMidPoint();
                return true;
            }
            else
            	return false;
        }
        
        public boolean displayGuess() {
        	if(userNum == true && optionsDisplayed() == true && userSelection() == true && systemMakesGuess() == true) {
        		calculateMidPoint();
        		currentGuessIsDisplayed = true;
        		return true;
        	}
        	else
        		return false;
        }
        
        public boolean userWinsGameIsDisplayed() {
        	if(selection == true && exceedsMaxGuesses() == true) {
        		return true;
        	}
        	else
        		return false;
        }
			
		
		
}