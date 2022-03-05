package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String key="user";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }
    public void pvp(View view){
        Intent intent=new Intent(this,Home_Page.class);
        startActivity(intent);
    }
    public void comp(View view){
        Intent intent=new Intent(this,PlayerChoice.class);
        startActivity(intent);
    }
}