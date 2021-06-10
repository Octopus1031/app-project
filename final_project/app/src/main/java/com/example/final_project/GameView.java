package com.example.final_project;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class GameView extends View {
    public GameView(Context context) {
        super(context);
    }
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw (Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        for(int i=0;i<=1000;i+=100){
            canvas.drawLine(i,0, i, 1000, paint);
            canvas.drawLine(0,i,1000, i, paint);
        }
    }
}