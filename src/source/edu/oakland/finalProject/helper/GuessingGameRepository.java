package edu.oakland.helper;

import java.math.*;

public class GuessingGameRepository {
	private int upperBound;
	private int guessIteration;
	private int midPoint;
	private int high;
	private int low;
	
	public GuessingGameRepository() {
	}
	
	public void setUpperBound( int upperBound ) {
		this.upperBound = upperBound;
	}
	
	public int getUpperBound() {
		return upperBound;
	}
	
	public void setGuessIteration( int guessIteration ) {
		this.guessIteration = guessIteration;
	}
	
	public int getGuessIteration() {
		return guessIteration;
	}
	
	public void setMidPoint( int midPoint ) {
		this.midPoint = midPoint;
	}
	
	public int getMidPoint() {
		return midPoint;
	}
	
	public int calculateMidPoint( int newHigh, int newLow ) {
		return newLow + ( newHigh - newLow ) / 2;
	}
	
	public void setHigh( int high ) {
		this.high = high;
	}
	
	public int getHigh() {
		return high;
	}
	
	public void setLow( int low ) {
		this.low = low;
	}
	
	public int getLow() {
		return low;
	}
	
	public int getMaxGuesses() {
		return (int) Math.ceil( Math.log( high ) / Math.log( 2 ) );
	}
}