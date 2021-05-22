package com.example.final_project;

import android.os.CountDownTimer;
import android.widget.ImageView;

public class CountTakoRun {
    int time = 10000;  //10s
    ImageView tako;
    MainActivity.Derection derection;

    CountDownTimer timer;
    CountTakoRun(MainActivity.Derection d, ImageView iv){
        tako = iv;
        derection = d;
    }
    public void start(){
        timer = new CountDownTimer(time, 200) {
            @Override
            public void onTick(long millisUntilFinished) {
                switch(derection){
                    case UP:
                        tako.setY(tako.getY() - 100);
                        if(tako.getY()<0)
                            tako.setY(1000);
                        break;
                    case DOWN:
                        tako.setY(tako.getY() + 100);
                        if(tako.getY()>1000)
                            tako.setY(-100);
                        break;
                    case LEFT:
                        tako.setX(tako.getX() - 100);
                        if(tako.getX()<0)
                            tako.setX(1000);
                        break;
                    case RIGHT:
                        tako.setX(tako.getX() + 100);
                        if(tako.getX()>1000)
                            tako.setX(-100);
                        break;
                }
            }
            @Override
            public void onFinish() { }
        }.start();
    }
    public void end() {
        timer.cancel();
    }
}
