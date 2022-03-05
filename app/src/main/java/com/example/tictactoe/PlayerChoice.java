package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PlayerChoice extends AppCompatActivity {
    public static final String key="user2";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_choice);
    }
    Intent intent;
    String choose;
    public void choiceO(View view){
        intent=new Intent(this,AiLogic.class);
        choose="1";
        intent.putExtra(key,choose);
        startActivity(intent);
    }
    public void choiceX(View view){
        intent=new Intent(this,AiLogic.class);
        choose="0";
        intent.putExtra(key,choose);
        startActivity(intent);
    }
}