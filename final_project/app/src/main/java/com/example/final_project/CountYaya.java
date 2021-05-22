package com.example.final_project;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class CountYaya {
    int time = 10000;
    CountDownTimer timer;
    Context c;
    RelativeLayout r;
    int i = 0;                  //位移量
    CountYaya(Context c, RelativeLayout r){
        this.c = c;
        this.r =r;
    }
    public void start(){
    timer = new CountDownTimer(time, 200) {
        @Override
        public void onTick(long millisUntilFinished) {

                ImageView im = new ImageView(c);
                im.setImageResource(R.drawable.yaya);
                RelativeLayout.LayoutParams par = new RelativeLayout.LayoutParams(100, 100);
                par.leftMargin = 100+100*i;
                par.rightMargin = 100+100*i;
                i++;
                r.addView(im, par);
        }
            @Override
            public void onFinish() { }
        }.start();
    }
    public void end() {
        timer.cancel();
    }
}
