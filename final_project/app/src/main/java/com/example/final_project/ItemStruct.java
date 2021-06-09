package com.example.final_project;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ItemStruct {
    int x, y;
    Context c;
    RelativeLayout r;
    ImageView im;
    public ItemStruct(Context c, RelativeLayout r, int x, int y){
        this.c = c;
        this.r = r;
        this.x = x;
        this.y = y;
        im = new ImageView(c);
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
