package com.example.brett.guessinggamecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.*;


public class GuessingGameInterface extends AppCompatActivity {
    GuessingGameRepository game;
    GuessingGameCalculator calculator;
    boolean userLost = false;
    boolean userWon = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing_game_interface);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        int upperBound = 1024;
        int lowerBound = 1;

        String input = intent.getStringExtra(GuessingGameStart.INPUT);

        if( !input.isEmpty() ) {
            upperBound = Integer.parseInt( input );
        }

        game = new GuessingGameRepository(upperBound, lowerBound, upperBound/2);
        calculator = new GuessingGameCalculator(game);

        updateScreen();
    }

    public void clickGreater(View view){
        if (userLost) {
            return;
        }
        calculator.receiveUserInput(2);
        calculator.userSelectsHigh();
        if(!checkUserWon()) {
            this.updateScreen();
        }
    }

    public void clickEqual(View view){
        if (userWon) {
            return;
        }
        calculator.receiveUserInput(3);
        userLost = true;
        ((TextView)findViewById(R.id.guessedNUM)).setTextSize(50);
        ((TextView)findViewById(R.id.guessedNUM)).setText("You Lost!!!");
    }

    public void clickLess(View view){
        if (userLost) {
            return;
        }
        calculator.receiveUserInput(1);
        calculator.userSelectsLow();
        if(!checkUserWon()) {
            this.updateScreen();
        }
    }

    private boolean checkUserWon(){
        if(calculator.getGuessIteration() > calculator.getMaxGuesses()){
            ((TextView)findViewById(R.id.guessedNUM)).setTextSize(50);
            ((TextView)findViewById(R.id.guessedNUM)).setText("You Won!!!");
            userWon = true;
            return true;
        }else{
            return false;
        }
    }

    private void updateScreen(){
        ((TextView)findViewById(R.id.guessedNUM)).setText(String.valueOf(game.getMid()));
        ((TextView)findViewById(R.id.guessAMT)).setText(String.valueOf(calculator.getMaxGuesses()-calculator.getGuessIteration()));
    }

    public void restartGame(View view) {
        Intent intent = new Intent(this, GuessingGameStart.class);
        startActivity(intent);
    }



}
