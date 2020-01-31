package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Arrays;




public class MainActivity extends AppCompatActivity implements Button.OnClickListener
{
    int turn=0;
    Button[][] btn=new Button[3][3];
    int[][] mark=new int[3][3];


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn[0][0]=findViewById(R.id.f00);
        btn[0][1]=findViewById(R.id.f01);
        btn[0][2]=findViewById(R.id.f02);
        btn[1][0]=findViewById(R.id.f10);
        btn[1][1]=findViewById(R.id.f11);
        btn[1][2]=findViewById(R.id.f12);
        btn[2][0]=findViewById(R.id.f20);
        btn[2][1]=findViewById(R.id.f21);
        btn[2][2]=findViewById(R.id.f22);

        btn[0][0].setOnClickListener(this);
        btn[0][1].setOnClickListener(this);
        btn[0][2].setOnClickListener(this);
        btn[1][0].setOnClickListener(this);
        btn[1][1].setOnClickListener(this);
        btn[1][2].setOnClickListener(this);
        btn[2][0].setOnClickListener(this);
        btn[2][1].setOnClickListener(this);
        btn[2][2].setOnClickListener(this);

        for(int i=0;i<=2;i++)
        {
            for(int j=0;j<=2;j++)
                mark[i][j]=-1;
        }

    }


    @Override
    public void onClick(View v)
    {
        Button btnnew=(Button)v;

        switch (v.getId())
        {
            case R.id.f00:
                btnnew.setClickable(false);
                mark[0][0]=turn;
                if(turn==1)
                {
                    btnnew.setText("X");
                }
                else
                {
                    btnnew.setText("O");
                }
                checkBoard(0,0);
                break;

            case R.id.f01:
                btnnew.setClickable(false);
                mark[0][1]=turn;
                if(turn==1)
                {
                    btnnew.setText("X");
                }
                else
                {
                    btnnew.setText("O");
                }
                checkBoard(0,1);
                break;

            case R.id.f02:
                btnnew.setClickable(false);
                mark[0][2]=turn;
                if(turn==1)
                {
                    btnnew.setText("X");
                }
                else
                {
                    btnnew.setText("O");
                }
                checkBoard(0,2);
                break;

            case R.id.f10:
                btnnew.setClickable(false);
                mark[1][0]=turn;
                if(turn==1)
                {
                    btnnew.setText("X");
                }
                else
                {
                    btnnew.setText("O");
                }
                checkBoard(1,0);
                break;

            case R.id.f11:
                btnnew.setClickable(false);
                mark[1][1]=turn;
                if(turn==1)
                {
                    btnnew.setText("X");
                }
                else
                {
                    btnnew.setText("O");
                }
                checkBoard(1,1);
                break;

            case R.id.f12:
                btnnew.setClickable(false);
                mark[1][2]=turn;
                if(turn==1)
                {
                    btnnew.setText("X");
                }
                else
                {
                    btnnew.setText("O");
                }
                checkBoard(1,2);
                break;

            case R.id.f20:
                btnnew.setClickable(false);
                mark[2][0]=turn;
                if(turn==1)
                {
                    btnnew.setText("X");
                }
                else
                {
                    btnnew.setText("O");
                }
                checkBoard(2,0);
                break;
            case R.id.f21:
                btnnew.setClickable(false);
                mark[2][1]=turn;
                if(turn==1)
                {
                    btnnew.setText("X");
                }
                else
                {
                    btnnew.setText("O");
                }
                checkBoard(2,1);
                break;

            case R.id.f22:
                btnnew.setClickable(false);
                mark[2][2]=turn;
                if(turn==1)
                {
                    btnnew.setText("X");
                }
                else
                {
                    btnnew.setText("O");
                }
                checkBoard(2,2);
                break;

        }
    }

    public void checkBoard(int i,int j)
    {
        int won=0;
        if(mark[0][0]==turn && mark[0][1]==turn && mark[0][2]==turn)
        {
            Toast.makeText(this,mark[0][0]+" won",Toast.LENGTH_LONG).show();
            won=1;
        }
        if(mark[0][0]==turn && mark[1][0]==turn && mark[2][0]==turn)
        {
            Toast.makeText(this,mark[0][0]+" won",Toast.LENGTH_LONG).show();
            won=1;
        }

        if(mark[0][0]==turn && mark[1][1]==turn && mark[2][2]==turn)
        {
            Toast.makeText(this,mark[0][0]+" won",Toast.LENGTH_LONG).show();
            won=1;
        }

        if(mark[0][1]==turn && mark[1][1]==turn && mark[2][1]==turn)
        {
            Toast.makeText(this,mark[1][1]+" won",Toast.LENGTH_LONG).show();
            won=1;
        }

        if(mark[2][0]==turn && mark[1][1]==turn && mark[0][2]==turn)
        {
            Toast.makeText(this,mark[1][1]+" won",Toast.LENGTH_LONG).show();
            won=1;
        }

        if(mark[1][2]==turn && mark[2][2]==turn && mark[0][2]==turn)
        {
            Toast.makeText(this,mark[2][2]+" won",Toast.LENGTH_LONG).show();
            won=1;
        }
        if(mark[1][0]==turn && mark[1][1]==turn && mark[1][2]==turn)
        {
            Toast.makeText(this,mark[1][1]+" won",Toast.LENGTH_LONG).show();
            won=1;
        }
        if(mark[2][0]==turn && mark[2][1]==turn && mark[2][2]==turn)
        {
            Toast.makeText(this,mark[2][2]+" won",Toast.LENGTH_LONG).show();
            won=1;
        }

        if(won==1)
        {
            Runnable obj=new Runnable() {
                @Override
                public void run() {
                    for(int m=0;m<=2;m++)
                    {
                        for(int n=0;n<=2;n++)
                        {
                            mark[m][n]=-1;
                            btn[m][n].setText("");
                            btn[m][n].setClickable(true);
                        }

                    }

                }
            };
            Handler handler=new Handler();
            handler.postDelayed(obj,2000);
        }
        turn=(turn+1)%2;
    }

}
