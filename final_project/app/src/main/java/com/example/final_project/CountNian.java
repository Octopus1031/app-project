package com.example.final_project;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

public class CountNian {
    MainActivity.Direction nxtDirection, preDirection;
    boolean stop = false;
    boolean rand= false;
    int countStop = 0;
    int countTimes = 0;
    Context c;
    RelativeLayout rel;
    ImageView tako;
    ImageView im;
    int left, top;
    Random random = new Random();
    RelativeLayout.LayoutParams par = new RelativeLayout.LayoutParams(100, 100);
    CountNian(Context c, RelativeLayout rel, ImageView tako){
        this.c = c;
        this.rel = rel;
        this.tako = tako;
        im = new ImageView(c);
    }
    public MainActivity.Direction count( MainActivity.Direction derection) {
        if(stop == false) {
            nxtDirection = preDirection = derection;
            if(countTimes == 0) {
                if (random.nextInt(3) == 0) {
                    im.setImageResource(R.drawable.nian);
                    do {
                        left = 100 * (random.nextInt(10));
                        top = 100 * (random.nextInt(10));
                    } while (left == tako.getX() && top == tako.getY());
                    par.leftMargin = left;
                    par.topMargin = top;
                    rel.addView(im, par);
                    countTimes++;
                }
            }
            else{
                if(im.getX()==tako.getX()&&im.getY()==tako.getY()){
                    stop = true;
                    nxtDirection = MainActivity.Direction.STOP;
                    im.setX(-100);
                    im.setY(-100);
                    countStop = 10;
                    rand = false;
                }
                if(rand == true ){
                    if (random.nextInt(3) == 0) {
                        do {
                            left = 100 * random.nextInt(10);
                            top = 100 * random.nextInt(10);
                        } while (left == tako.getX() && top == tako.getY());
                        im.setX(left);
                        im.setY(top);
                        rand = false;
                    }
                }
            }
        }
        else if(countStop!=0){
            countStop--;
            nxtDirection = MainActivity.Direction.STOP;
        }
        else if(stop) {
            nxtDirection = preDirection;
            stop = false;
            rand = true;
        }

        return nxtDirection;
    }
}
