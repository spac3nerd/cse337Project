package com.example.brett.guessinggamecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class GuessingGameStart extends AppCompatActivity {
    public final static String INPUT = "com.example.brett.guessinggamecalculator";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geussing_game_start);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void startGame(View view){
        Intent intent = new Intent(this, GuessingGameInterface.class);
        EditText editText = (EditText) findViewById(R.id.upperLimit);
        String input = editText.getText().toString();
        intent.putExtra(INPUT, input);

        startActivity(intent);
    }
}
