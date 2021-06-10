package com.example.final_project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btnU,btnD,btnL,btnR;
    private TextView text1;
    public enum Direction {UP, DOWN, LEFT, RIGHT, STOP};
    PeipeiFish fish;
    CountTime count;
    TakoNode tako ;
    CountYaya yaya;
    CountGrass grass;
    CountNian nian;
    CountTakoRun ctr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Time

        ItemStruct[] item = new ItemStruct[4]; //fish, nian, yaya, grass
        btn1 = (Button) findViewById(R.id.buttonStart);
        text1 = findViewById(R.id.tvTime);
        ImageView takoIm = findViewById(R.id.tako);
        TextView scoreT = findViewById(R.id.score);
        RelativeLayout rel = findViewById(R.id.gameRel);
        Context context = getApplicationContext();

        Button.OnClickListener buttonStartListener =
                new Button.OnClickListener() {
                    @SuppressLint("ResourceType")
                    @Override
                    public void onClick(View v) {
                        if(btn1.getText().equals("START")){
                            fish = new PeipeiFish(context, rel, takoIm, item);
                            count = new CountTime(btn1, text1, fish);
                            tako = new TakoNode(takoIm);
                            yaya = new CountYaya(context, rel, takoIm, item);
                            grass = new CountGrass(context, rel, takoIm, item);
                            nian = new CountNian(context, rel, takoIm, item);
                            ctr = new CountTakoRun(context, rel, Direction.LEFT, tako, yaya, scoreT, grass, fish, nian, item, count);

                            count.start("easy");
                            ctr.start();
                        }
                        else{
                            count.end();
                            ctr.end();
                        }
                    }
                };
        btn1.setOnClickListener(buttonStartListener);

        btnU = (Button)findViewById(R.id.butUp);
        btnD = (Button)findViewById(R.id.butDown);
        btnL = (Button)findViewById(R.id.butLeft);
        btnR = (Button)findViewById(R.id.butRight);

        btnU.setOnClickListener(v -> ctr.direction = Direction.UP);
        btnD.setOnClickListener(v -> ctr.direction = Direction.DOWN);
        btnL.setOnClickListener(v -> ctr.direction = Direction.LEFT);
        btnR.setOnClickListener(v -> ctr.direction = Direction.RIGHT);

        Button ruleB = findViewById(R.id.rule);
        Button.OnClickListener bslRule = new Button.OnClickListener(){
            LayoutInflater inf = getLayoutInflater();
            View view = inf.inflate(R.layout.alert_dialog_layout, null);
            @Override
            public void onClick(View v){
                new AlertDialog.Builder(MainActivity.this)
                    .setTitle("遊戲規則")
                    .setView(view)
                    .setNegativeButton("關閉規則", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            //null
                        }
                    })
                    .show();
            }
        };
        ruleB.setOnClickListener(bslRule);
    }
}