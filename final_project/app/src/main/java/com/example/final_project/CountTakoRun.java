package com.example.final_project;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CountTakoRun {
    int score = 0;
    int time = 40000;//10000;  //10s
    TakoNode tako, tail;
    CountYaya yaya;
    CountNian nian;
    Grass grass;//0603
    PeipeiFish fish;
    MainActivity.Direction direction;
    Context c;
    RelativeLayout r;
    TextView scoreT;
    CountDownTimer timer;
    int countAdd = 0;       //0不變 1增加 (2減少)
    int countSub = 0;      //0不變 -1減少

    int countFish = 0;
    int countyaya = 0;

    CountTakoRun(Context c, RelativeLayout r, MainActivity.Direction d, TakoNode tako, CountYaya yaya, TextView scareT, Grass grass,PeipeiFish fish, CountNian nian){
        this.c = c;
        this.r = r;
        direction = d;
        this.tako = tako;
        this.yaya = yaya;
        this.scoreT = scareT;
        this.grass = grass;
        this.fish = fish;
        this.nian = nian;
    }
    public void start(){
        tako.x = (int)tako.im.getX();
        tako.y = (int)tako.im.getY();
        tail = tako;
        timer = new CountDownTimer(time, 200) {
            @Override
            public void onTick(long millisUntilFinished) {
                direction = nian.count(direction);
                if(countAdd==0 && countSub==0){
                    if(tail!=tako) {
                        tail = tail.littleMove(tako, tail);
                    }
                    tako.bigMove(direction);
                    if(tako.next!=null){ (tako.next).showLittleMove(); }

                    countFish = fish.count();
                    countyaya = yaya.count();
                    countAdd = countFish + countyaya;
                    countSub = grass.appear();

                }
                else if(countAdd==1 && countSub==0) {//Add = 0不變 1增加 Sub = 0不變 -1減少

                    if (countyaya == 1) {

                        System.out.println("I touch yaya");
                        setScore(1);
                        new TakoNode(c, r).addLittleTako(tako);
                        while (tail.next != null) {
                            tail = tail.next;
                        }
                        tako.bigMove(direction);
                        countAdd = yaya.count();
                        (tako.next).show();

                    } else {
                        System.out.println("I touch fish");
                        setScore(1);
                        new TakoNode(c, r).addLittleTako(tako);
                        while (tail.next != null) {
                            tail = tail.next;
                        }
                        tako.bigMove(direction);
                        (tako.next).show();

                        setScore(1);
                        new TakoNode(c, r).addLittleTako(tako);
                        while (tail.next != null) {
                            tail = tail.next;
                        }
                        tako.bigMove(direction);
                        countAdd = fish.count();
                        (tako.next).show();
                    }
                }
                else if(countAdd==0 && countSub==-1){//Add = 0不變 1增加 Sub = 0不變 -1減少
                    setScore(-1);
                    //while(tail.next!=null){
                    //    tail = tail.next;
                    //}
                    tail = tako.delLittleTako(tail);
                    if(tail!=tako) {
                        tail = tail.littleMove(tako, tail);
                    }
                    tako.bigMove(direction);
                    countAdd = yaya.count();
                    countSub = grass.appear();
                    (tako.next).showLittleMove();
                }
            }
            @Override
            public void onFinish() { }
        }.start();
    }
    public void end() {
        timer.cancel();
    }
    public void setScore(int s){
        if(s == 1){
            scoreT.setText("" + ++score);
        }
        else if(s == -1) {
            scoreT.setText("" + --score);
        }
    }
}
