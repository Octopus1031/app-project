package com.example.final_project;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

public class PeipeiFish {
    int countTimes = 0;
    int left, top;
    ImageView tako;
    Context c;
    RelativeLayout r;
    Random random = new Random();
    ImageView im;
    int rand;
    ItemStruct[] item;

    PeipeiFish(Context c , RelativeLayout r , ImageView tako, ItemStruct[] item){
        this.c = c;
        this.r = r;
        this.tako = tako;
        im = new ImageView(c);
        this.item = item;
    }

    public void appear()
    {
       rand = random.nextInt(5);
        if (rand == 1) {
            if(countTimes!=0){
                do {
                    left = 100 * random.nextInt(10);
                    top = 100 * random.nextInt(10);
                    System.out.println(randomCheck(left, top));
                }while(left==tako.getX()&&top==tako.getY() || randomCheck(left, top));
                im.setX(left);
                im.setY(top);
                item[3].x = left; item[3].y = top;
            }
            else {
                im.setImageResource(R.drawable.fish);
                item[3].im = im;
                RelativeLayout.LayoutParams par = new RelativeLayout.LayoutParams(100, 100);
                do {
                    left = 100 * random.nextInt(10);
                    top = 100 * random.nextInt(10);
                    System.out.println(randomCheck(left, top));
                }while(left==tako.getX()&&top==tako.getY() || randomCheck(left, top));
                par.leftMargin = left;
                par.topMargin = top;
                r.addView(im, par);
                item[3].x = left; item[3].y = top;
                countTimes++;
            }
        }
    }

    public int count() {
        int countAdd = 0;

        if (countTimes != 0) {
            if (im.getX() == tako.getX() && im.getY() == tako.getY()) {
                do {
                    left = 100 * random.nextInt(10);
                    top = 100 * random.nextInt(10);
                    System.out.println(randomCheck(left, top));
                }while(left==tako.getX()&&top==tako.getY() || randomCheck(left, top));
                im.setX(left);
                im.setY(top);
                item[3].x = left; item[3].y = top;
                countAdd = 1;
            }
        }
        return countAdd;
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
