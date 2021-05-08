package com.example.final_project;

import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

public class CountTime {

    CountTime(Button btn, TextView txt){
        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                txt.setText("" + millisUntilFinished / 1000);
            }

            //                        結束提示
            public void onFinish() {
                txt.setText("遊戲結束!!");
            }
        }.start();
    }
}
