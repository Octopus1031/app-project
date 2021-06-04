package com.example.final_project;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.Random;

public class Grass {
    int countTimes = 0;//已出現的次數
    int left,top;
    int i=0;
    ImageView tako;
    Context c;
    RelativeLayout r;
    Random random = new Random();
    ImageView im;

    Grass(Context c, RelativeLayout r, ImageView tako){
        this.c = c;
        this.r = r;
        this.tako = tako;
        im = new ImageView(c);
    }
    public int appear(){//海草出現
        int countSub = 0;//回傳給CountTakoRun 0不變 -1減分
        if(countTimes!=0){//grass已出現過至少1次了,判斷tako有沒有碰到,若有則換位置
            if(im.getX()==tako.getX()&&im.getY()==tako.getY()){
                //countAdd = 2;
                countSub = -1;
                do{
                    left = 100*random.nextInt(10);
                    top = 100*random.nextInt(10);
                    i++;
                }while(left==tako.getX()&&top==tako.getY());
                im.setX(left);
                im.setY(top);
            }
        }
        else{//第一次出現,只是讓它不出現在tako位置
            im.setImageResource(R.drawable.grass);
            RelativeLayout.LayoutParams par = new RelativeLayout.LayoutParams(100,100);
            do{
                left = 100*random.nextInt(10);
                top = 100*random.nextInt(10);
                i++;
            }while(left==tako.getX()&&top==tako.getY());
            par.leftMargin = left;
            par.topMargin = top;
            r.addView(im,par);
            countTimes++;
        }
        return countSub;
    }
}
