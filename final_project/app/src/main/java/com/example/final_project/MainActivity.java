package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TextView tvT;
    Button btStart;
//    Timer timer = new Timer();
    int time = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvT = (TextView)findViewById(R.id.tvTime);
        tvT.setText("時間");
        btStart = findViewById(R.id.btStart);
        btStart.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                time = 6;
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            public void run() {
                                time--;
                                if(time<0){
                                    timer.cancel();
                                    tvT.setText("game over");
                                }
                                else{
                                    tvT.setText("" + time);
                                }
                            }
                        });
                    }
                },1000,1000);
            }
        });
    }
}