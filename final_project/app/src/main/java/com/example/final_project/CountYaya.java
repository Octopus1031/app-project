package com.example.final_project;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.Random;

public class CountYaya {
    int countTimes = 0;
    int left, top;
    ImageView tako;
    Context c;
    RelativeLayout r;
    Random random = new Random();
    ImageView im;

    CountYaya(Context c, RelativeLayout r, ImageView tako){
        this.c = c;
        this.r =r;
        this.tako = tako;
        im = new ImageView(c);
    }
    public int count(){
        int countAdd = 0;
        if(countTimes!=0){
            if(im.getX()==tako.getX()&&im.getY()==tako.getY()){
                countAdd = 1;
                do{
                    left = 100*random.nextInt(10);
                    top = 100*random.nextInt(10);
                }while(left==tako.getX()&&top==tako.getY());
                im.setX(left);
                im.setY(top);
            }
        }
        else{
            im.setImageResource(R.drawable.yaya);
            RelativeLayout.LayoutParams par = new RelativeLayout.LayoutParams(100, 100);
            do{
                left = 100*random.nextInt(10);
                top = 100*random.nextInt(10);
            }while(left==tako.getX()&&top==tako.getY());
            par.leftMargin = left;
            par.topMargin = top;
            r.addView(im, par);
            countTimes++;
        }
        return countAdd;
    }
}
