package com.example.final_project;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.Random;

public class CountGrass {
    int countTimes = 0;//已出現的次數
    int left,top;
    int i=0;
    ImageView tako;
    Context c;
    RelativeLayout r;
    Random random = new Random();
    ImageView im;
    ItemStruct[] item;
    CountGrass(Context c, RelativeLayout r, ImageView tako, ItemStruct[] item){
        this.c = c;
        this.r = r;
        this.tako = tako;
        im = new ImageView(c);
        this.item = item;
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
                    System.out.println(randomCheck(left, top));
                }while(left==tako.getX()&&top==tako.getY() || randomCheck(left, top));
                im.setX(left);
                im.setY(top);
                item[0].x = left; item[0].y = top;// item[0].im.setImageResource(R.drawable.grass);//0609
            }
        }
        else{//第一次出現,只是讓它不出現在tako位置
            im.setImageResource(R.drawable.grass);
            item[0].im = im;
            RelativeLayout.LayoutParams par = new RelativeLayout.LayoutParams(100,100);
            do{
                left = 100*random.nextInt(10);
                top = 100*random.nextInt(10);
                i++;
//                System.out.println("grass2a"+!randomCheck(left, top));
//                System.out.println("grass2b"+ (left==tako.getX()&&top==tako.getY()));
//                System.out.println("grass2c"+(left==tako.getX()&&top==tako.getY() || randomCheck(left, top)));
                System.out.println(randomCheck(left, top));
            }while(left==tako.getX()&&top==tako.getY() || randomCheck(left, top));
            par.leftMargin = left;
            par.topMargin = top;
            r.addView(im,par);
            item[0].x = left; item[0].y = top;
            countTimes++;
        }
        return countSub;
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
