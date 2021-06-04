package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btnU,btnD,btnL,btnR;
    private TextView text1;
    public enum Direction {UP, DOWN, LEFT, RIGHT, STOP};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Time
        btn1 = (Button) findViewById(R.id.buttonStart);
        text1 = findViewById(R.id.tvTime);
        ImageView takoIm = findViewById(R.id.tako);
        TextView scoreT = findViewById(R.id.score);
        RelativeLayout rel = findViewById(R.id.gameRel);
        Context context = getApplicationContext();
        PeipeiFish fish = new PeipeiFish(context, rel, takoIm);
        CountTime count = new CountTime(btn1, text1, fish);
        TakoNode tako = new TakoNode(takoIm);
        CountYaya yaya = new CountYaya(context, rel, takoIm);
        CountGrass grass = new CountGrass(context, rel, takoIm);
        CountNian nian = new CountNian(context, rel, takoIm);

        CountTakoRun ctr = new CountTakoRun(context, rel, Direction.LEFT, tako, yaya, scoreT, grass,fish, nian);
        Button.OnClickListener buttonStartListener =
                new Button.OnClickListener() {
                    @SuppressLint("ResourceType")
                    @Override
                    public void onClick(View v) {
                        if(btn1.getText().equals("START")){
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
    }
}