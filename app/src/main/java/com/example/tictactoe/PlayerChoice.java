package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PlayerChoice extends AppCompatActivity {
    public static final String key="user2";
    public static final String key2="users";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_choice);
    }
    Intent intent;
    String choose;
    String choose2;
    public void choiceO(View view){
        intent=new Intent(this,AiLogic.class);
        choose="0";
        choose2="1";
        intent.putExtra(key,choose);
//        intent.putExtra(key2,choose2);
        startActivity(intent);
    }
    public void choiceX(View view){
        intent=new Intent(this,AiLogic.class);
        choose="1";
        choose2="0";
        intent.putExtra(key,choose);
//        intent.putExtra(key2,choose2);
        startActivity(intent);
    }
}