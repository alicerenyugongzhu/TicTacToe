package com.alice.tictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    View.OnClickListener l00, l01, l02, l10, l11, l12, l20, l21, l22, lre;
    Button b00, b01, b02, b10, b11, b12, b20, b21, b22, bre;
    int[] record = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    boolean player = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l00 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeColore(b00, 0);
            }
        };
        l01 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeColore(b01, 1);
            }
        };
        l02 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeColore(b02, 2);
            }
        };
        l10 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeColore(b10, 3);
            }
        };
        l11 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeColore(b11, 4);
            }
        };
        l12 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeColore(b12, 5);
            }
        };
        l20 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeColore(b20, 6);
            }
        };
        l21 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeColore(b21, 7);
            }
        };
        l22 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeColore(b22, 8);
            }
        };
        lre = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b00.setBackgroundColor(Color.GRAY);
                b01.setBackgroundColor(Color.GRAY);
                b02.setBackgroundColor(Color.GRAY);
                b10.setBackgroundColor(Color.GRAY);
                b11.setBackgroundColor(Color.GRAY);
                b12.setBackgroundColor(Color.GRAY);
                b20.setBackgroundColor(Color.GRAY);
                b21.setBackgroundColor(Color.GRAY);
                b22.setBackgroundColor(Color.GRAY);
                for(int num = 0; num < record.length; num++){
                    record[num] = 0;
                }
            }
        };
        b00 = (Button) findViewById(R.id.p00);
        b00.setOnClickListener(l00);
        b01 = (Button) findViewById(R.id.p01);
        b01.setOnClickListener(l01);
        b02 = (Button) findViewById(R.id.p02);
        b02.setOnClickListener(l02);
        b10 = (Button) findViewById(R.id.p10);
        b10.setOnClickListener(l10);
        b11 = (Button) findViewById(R.id.p11);
        b11.setOnClickListener(l11);
        b12 = (Button) findViewById(R.id.p12);
        b12.setOnClickListener(l12);
        b20 = (Button) findViewById(R.id.p20);
        b20.setOnClickListener(l20);
        b21 = (Button) findViewById(R.id.p21);
        b21.setOnClickListener(l21);
        b22 = (Button) findViewById(R.id.p22);
        b22.setOnClickListener(l22);
        bre = (Button) findViewById(R.id.restart);
        bre.setOnClickListener(lre);
    }

    private void ChangeColore(Button button, int i) {
        boolean result = false;
        if(record[i] == 0) {
            if (player) {
                button.setBackgroundColor(Color.BLUE);
                record[i] = 1;
            } else {
                button.setBackgroundColor(Color.RED);
                record[i] = 2;
            }
            result = CheckWin(i);
            if(result) {
                Toast.makeText(MainActivity.this, "the winner is player " + (player? "BLUE": "RED"), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "RESTART AGAIN ", Toast.LENGTH_SHORT).show();
                b00.setBackgroundColor(Color.GRAY);
                b01.setBackgroundColor(Color.GRAY);
                b02.setBackgroundColor(Color.GRAY);
                b10.setBackgroundColor(Color.GRAY);
                b11.setBackgroundColor(Color.GRAY);
                b12.setBackgroundColor(Color.GRAY);
                b20.setBackgroundColor(Color.GRAY);
                b21.setBackgroundColor(Color.GRAY);
                b22.setBackgroundColor(Color.GRAY);
                for(int num = 0; num < record.length; num++){
                    record[num] = 0;
                }
            }
            player = !player;
        }

    }

    private boolean CheckWin(int position) {
        if(player) {  ///Blue one
           if((position%3) == 0) {
               if((record[position+1] == 1) && (record[position+2] == 1)){
                   return true;
               } else if ((record[0] == 1) && (record[3] == 1) && (record[6] == 1)) {
                   return true;
               } else if((position == 1) && (record[4] == 1) && (record[8] == 1)){
                   return true;
               } else if((position == 6) && (record[4] == 1) && (record[2] == 1)){
                   return true;
               }
           } else if((position%3) == 1) {
               if((record[position-1] == 1) && (record[position+1] == 1)){
                   return true;
               } else if((record[1] == 1) && (record[4] == 1) && (record[7] == 1)){
                   return true;
               }
           } else {
               if((record[position-1] == 1) && (record[position-2] == 1)){
                   return true;
               } else if ((record[2] == 1) && (record[5] == 1) && (record[8] == 1)) {
                   return true;
               } else if((position == 2) && (record[4] == 1) && (record[6] == 1)){
                   return true;
               } else if((position == 8) && (record[4] == 1) && (record[0] == 1)){
                   return true;
               }
           }
        } else {  ///Red one
            if((position%3) == 0) {
                if((record[position+1] == 2) && (record[position+2] == 2)){
                    return true;
                } else if ((record[0] == 2) && (record[3] == 2) && (record[6] == 2)) {
                    return true;
                } else if((position == 1) && (record[4] ==2) && (record[8] == 2)){
                    return true;
                } else if((position == 6) && (record[4] == 2) && (record[2] == 2)){
                    return true;
                }
            } else if((position%3) == 1) {
                if((record[position-1] == 2) && (record[position+1] == 2)){
                    return true;
                } else if((record[1] == 2) && (record[4] == 2) && (record[7] == 2)){
                    return true;
                }
            } else {
                if((record[position-1] == 2) && (record[position-2] == 2)){
                    return true;
                } else if ((record[2] == 2) && (record[5] == 2) && (record[8] == 2)) {
                    return true;
                } else if((position == 2) && (record[4] == 2) && (record[6] == 2)){
                    return true;
                } else if((position == 8) && (record[4] == 2) && (record[0] == 2)){
                    return true;
                }
            }
        }
        return false;
    }
}
