package com.example.tictactoe;

        import androidx.appcompat.app.AppCompatActivity;

        import android.media.Image;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.TextView;

public class Home_Page extends AppCompatActivity {
    public int GameStat[]={2,2,2,2,2,2,2,2,2};
    public int player=0;
    public  String winnerStr;
    public boolean ResetGame=false;
    public boolean justReset=false;
    public int occupied=0;
    public int winningPlace[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void logic(View view){
        ImageView img=(ImageView)view;

        TextView status = findViewById(R.id.status);

        int box=Integer.parseInt(img.getTag().toString());
//        if(GameStat[winningPlace[0]]==GameStat[winningPlace[1]]
        if(ResetGame){
            reset(view);
        }
        if(GameStat[box]==2 && !ResetGame && !justReset){
            if(player==0){
                occupied++;
                GameStat[box]=0;
                player=1;
                img.setImageResource(R.drawable.x);
                status.setText("0's Turn");
            }
            else{
                GameStat[box]=1;
                occupied++;
                player=0;
                img.setImageResource(R.drawable.o);
                status.setText("X's Turn");
            }
        }
        else if(GameStat[box]!=2 && !ResetGame && !justReset){
            status.setText("Wrong box-already occupied");
        }
        for(int[] winning:winningPlace){
            if(GameStat[winning[0]]==GameStat[winning[1]] && GameStat[winning[1]]==GameStat[winning[2]] && GameStat[winning[2]]==GameStat[winning[0]] && GameStat[winning[0]]!=2){
//                occupied=9;
                ResetGame=true;
                justReset=true;
                if(GameStat[winning[0]]==0){
                    status.setText("X wins the game!!!\nbox cleared "+(winning[0]+1)+","+(winning[1]+1)+","+(winning[2]+1));
                    break;
                }
                else{
                    status.setText("0 wins the game!!!\nbox cleared "+(winning[0]+1)+","+(winning[1]+1)+","+(winning[2]+1));
                    break;
                }
            }
            if(justReset){
                justReset=false;
            }

        }
        if(occupied==9 && !ResetGame){
            ResetGame=true;
            justReset=true;
            status.setText("Match Draw !!!");
//            reset(view);
        }

//        System.out.println("clicked box"+img.getTag().toString());


    }
    public  void reset(View view){
        ResetGame=false;
        justReset=true;
//        GameStat[]={2,2,2,2,2,2,2,2,2};
        for(int i=0;i<9;i++){
            GameStat[i]=2;
        }
        player=0;
        occupied=0;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        System.out.println("working");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}