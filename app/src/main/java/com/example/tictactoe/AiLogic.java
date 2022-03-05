package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class AiLogic extends AppCompatActivity {

    Intent intent;
    int choice;
    int occupied;
    int player;
    int count,ra;
    int winningPlace[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
//    int comp=Integer.parseInt(intent.getStringExtra(PlayerChoice.key2).toString());
    Random rand;
    int []place={2,2,2,2,2,2,2,2,2};
    int[] viewId={R.id.imageView0,R.id.imageView1,R.id.imageView2,R.id.imageView3,R.id.imageView4,R.id.imageView5,R.id.imageView6,R.id.imageView7,R.id.imageView8};
    //1-x and 0-O
    int turn;
    boolean thinking;
    boolean occupiedAll,isStart,ResetGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ai_logic);

        TextView textView=findViewById(R.id.status);
        textView.setText("O's turn");
        intent=getIntent();
        choice=Integer.parseInt(intent.getStringExtra(PlayerChoice.key).toString());
        player=choice;
        rand=new Random();
        turn=0;
        occupied=0;
        count=0;
        thinking=false;
        isStart=true;

    }
    public void logic(View  view){

        ImageView view1=(ImageView) view;
        TextView tview=findViewById(R.id.status);
        int box=Integer.parseInt(view1.getTag().toString());
        if(occupiedAll){

            reset(view);
        }
        if(ResetGame){
            reset(view);
        }
       if(!isStart && player==0) {
//          view1.setImageResource(R.drawable.o);
//          tview.setText("X's turn");
//          int ra= rand.nextInt(8);
//
           if(place[box]==2 && !thinking && !occupiedAll){
               place[box]=0;
               view1.setImageResource(R.drawable.o);
               occupied++;
               if(occupied>=8){
                   occupiedAll=true;
               }
               tview.setText("X's turn");
//               while(count!=10 || place[ra]!=2) {
               ra = rand.nextInt(8);
               if(place[ra]==2 && !occupiedAll) {
                   place[ra] = 1;
                   occupied++;
                   ImageView img = findViewById(viewId[ra]);
                   img.setImageResource(R.drawable.x);
                   tview.setText("O's turn");
                   thinking = false;
               }
               else if(!occupiedAll){
                   thinking=true;
                   tview.setText("Thinking");
                   while(place[ra]!=2){
                       ra= rand.nextInt(8);
                       tview.setText("thinking for"+ra);

                   }
                   occupied++;
                   place[ra]=1;
                   ImageView img = findViewById(viewId[ra]);
                   img.setImageResource(R.drawable.x);
                   tview.setText("O's turn");
                   thinking = false;

               }
           }
           else{
               tview.setText("Box is alredy occupied");
           }
           for(int[] winning:winningPlace){
               if(place[winning[0]]==place[winning[1]] && place[winning[1]]==place[winning[2]] && place[winning[2]]==place[winning[0]] && place[winning[0]]!=2){
//                occupied=9;
                   ResetGame=true;
//                   isStart=true;
                   if(place[winning[0]]==0){
                       tview.setText("O wins the game!!!\nbox cleared "+(winning[0]+1)+","+(winning[1]+1)+","+(winning[2]+1));
                       break;
                   }
                   else{
                       tview.setText("X wins the game!!!\nbox cleared "+(winning[0]+1)+","+(winning[1]+1)+","+(winning[2]+1));
                       break;
                   }
               }
           }

//           if(thinking && !occupiedAll) {
//               ra = rand.nextInt(8);
//               if(place[ra]==2 && occupied<9) {
//                   place[ra] = 1;
//                   occupied++;
//                   ImageView img = findViewById(viewId[ra]);
//                   img.setImageResource(R.drawable.x);
//                   tview.setText("O's turn");
//                   thinking = false;
//               }
//               else{
//                   tview.setText("Thinking");
//                   thinking=true;
//               }
//           }

           if(occupied>=9){
               occupiedAll=true;
//               reset(view);
           }
       }
       if(isStart){
           isStart=false;
       }
       if(occupiedAll){
           tview.setText("Match Draw");
       }
    }
    public void reset(View view){
        isStart=true;
        ResetGame=false;
        occupiedAll=false;
        occupied=0;
        for(int i=0;i<9;i++){
            place[i]=2;
        }
        thinking=false;
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }

}