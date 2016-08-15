package edu.oakland.helper;

import edu.oakland.production.*;



public class GuessingGameRepository{


	private int high;
	private int low;
	private int mid;
	private int guessIteration;


	public GuessingGameRepository(int high, int low, int mid){
		
		this.high = high;
		this.low = low;
		this.mid = mid;
	
	}
	
	public GuessingGameRepository(){
		
	}
	
	public int getHigh(){
		
		return high;
	}
	
	public int getLow(){
		
		return low;
	}

	
	public int getMid(){
		return mid;
	}
	
	
	public void setLow(int low){
		this.low = low;
	}
	
	public void setHigh(int high){
		
		this.high = high;
	}
	
	public void setMid(int mid){
	this.mid = mid;	
	}
	
	public void setGuess(int guess){
		guessIteration = guess;
	}
	
	public int getGuess(){
		
		return guessIteration;
}
	
}