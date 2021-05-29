package com.example.final_project;

import android.os.CountDownTimer;
import android.widget.ImageView;

public class CountTakoRun {
    int time = 10000;  //10s
    ImageView tako;
    CountYaya yaya;
    MainActivity.Derection derection;
    CountDownTimer timer;
    CountTakoRun(MainActivity.Derection d, ImageView iv, CountYaya yaya){
        tako = iv;
        derection = d;
        this.yaya = yaya;
    }
    public void start(){
        timer = new CountDownTimer(time, 200) {
            @Override
            public void onTick(long millisUntilFinished) {
                switch(derection){
                    case UP:
                        tako.setY(tako.getY() - 100);
                        if(tako.getY()<=-100)
                            tako.setY(900);
                        break;
                    case DOWN:
                        tako.setY(tako.getY() + 100);
                        if(tako.getY()>=1000)
                            tako.setY(0);
                        break;
                    case LEFT:
                        tako.setX(tako.getX() - 100);
                        if(tako.getX()<=-100)
                            tako.setX(900);
                        break;
                    case RIGHT:
                        tako.setX(tako.getX() + 100);
                        if(tako.getX()>=1000)
                            tako.setX(0);
                        break;
                }
                yaya.count();
            }
            @Override
            public void onFinish() { }
        }.start();
    }
    public void end() {
        timer.cancel();
    }
}
