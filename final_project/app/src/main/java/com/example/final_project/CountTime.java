package com.example.final_project;

import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

public class CountTime {
    int time = 0;
    Button btn;
    TextView txt;
    CountDownTimer timer;
    CountTime(Button button, TextView textView){
        this.btn = button;
        this.txt = textView;
    }
    public void start(String mode){
        btn.setText("END");
        switch(mode){
            case "easy":
                time = 60000;
                break;
            case "normal":
                time = 30000;
                break;
            case "hard":
                time = 20000;
                break;
            default:
                time = 60000;
        }
        timer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                txt.setText("" + millisUntilFinished / 1000);
            }
            //                        結束提示
            @Override
            public void onFinish() {
                txt.setText("遊戲結束!!");
            }
        }.start();
    }

    public void end() {
        btn.setText("START");
        timer.cancel();
        txt.setText("60");
    }
}
