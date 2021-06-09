package com.example.final_project;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

public class CountNian {
    MainActivity.Direction nxtDirection, preDirection;      //當下、碰黏前方向
    boolean stop = false;       //當下是否碰到黏
    boolean rand = false;       //是否隨機產生黏
    int countStop = 0;          //倒數暫停秒數
    int countTimes = 0;
    Context c;
    RelativeLayout rel;
    ImageView tako;
    ImageView im;
    int left, top;
    Random random = new Random();
    RelativeLayout.LayoutParams par = new RelativeLayout.LayoutParams(100, 100);
    ItemStruct[] item;

    CountNian(Context c, RelativeLayout rel, ImageView tako, ItemStruct[] item){
        this.c = c;
        this.rel = rel;
        this.tako = tako;
        im = new ImageView(c);
        this.item = item;
    }
    public MainActivity.Direction count( MainActivity.Direction derection) {
        if(stop == false) {     //當下未碰到黏
            nxtDirection = preDirection = derection;        //碰前方向 = 當下
            if(countTimes == 0) {                           //還未出現黏
                if (random.nextInt(3) == 0) {       //隨機
                    im.setImageResource(R.drawable.nian);
                    item[2].im = im;
                    do {
                        left = 100 * (random.nextInt(10));
                        top = 100 * (random.nextInt(10));
                        System.out.println(randomCheck(left, top));
                    }while(left==tako.getX()&&top==tako.getY() || randomCheck(left, top));
                    par.leftMargin = left;
                    par.topMargin = top;
                    rel.addView(im, par);
                    countTimes++;
                    item[2].x = left; item[2].y = top;
                }
            }
            else{                                           //已出現過黏
                if(im.getX()==tako.getX()&&im.getY()==tako.getY()){     //碰到黏
                    stop = true;
                    nxtDirection = MainActivity.Direction.STOP;         //方向暫停
                    im.setX(-100);              //黏放在看不到的地方
                    im.setY(-100);
                    item[2].x = left; item[2].y = top;
                    countStop = 10;
                    rand = false;           //暫停隨機黏
                }
                if(rand == true ){                  //可以隨機黏
                    if (random.nextInt(3) == 0) {
                        do {
                            left = 100 * random.nextInt(10);
                            top = 100 * random.nextInt(10);
                            System.out.println(randomCheck(left, top));
                        }while(left==tako.getX()&&top==tako.getY() || randomCheck(left, top));
                        im.setX(left);
                        im.setY(top);
                        item[2].x = left; item[2].y = top;
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
            stop = false;       //暫停狀態消除
            rand = true;        //可以隨機黏
        }
        return nxtDirection;
    }

    public boolean randomCheck(int randx, int randy){
        boolean bump = false; //無重疊, 檢查通過
        for(int i = 0; i<item.length; i++){
            if(randx == item[i].x || randy == item[i].y)
                bump = true;
        }
        return bump;
    }
}
