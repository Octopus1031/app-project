package com.example.final_project;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class TakoNode {
    int countTimes = 0;
    int x, y;
    Context c;
    RelativeLayout r;
    ImageView im;       //self
    TakoNode pre, next;

    TakoNode(Context c, RelativeLayout r){      //for small
        this.c = c;
        this.r =r;
        pre = null;
        next = null;
        im = new ImageView(c);
    }
    TakoNode(ImageView im){     //for big
        pre = null;
        next = null;
        this.im = im;
    }

    /* 當他扣吃到葉葉走且走到下一步時出現在上一步的位子
    不把tail拉前面
    可能要用一個係數去判斷使用的function
    */
    public void addLittleTako(TakoNode head){
        x = head.x;
        y = head.y;
        pre = head;
        if(head.next!=null){
            next = head.next;
            next.pre = this;
        }
        head.next = this;
//        System.out.println(x + " " + y);
    }

    public TakoNode littleMove(TakoNode head, TakoNode tail){      //把tail移到head後面 並回傳tail 由tail呼叫
        if(tail!=head){
            if(tail!=head.next){
                tail = pre;        //自己(this)不再是tail
                tail.next = null;
                pre = head;
                next = head.next;
                next.pre = this;
                head.next = this;
                x = head.x;
                y = head.y;
            }
            else{
                x = head.x;
                y = head.y;
            }
        }
        return tail;
    }

    /*大章魚移動過後才呼叫顯現小章魚 參數帶head.next
    littleMove後先讓大章魚跑才把小章魚圖片的xy設置下去
     */
    public void show(){          //only for head.next
        im.setImageResource(R.drawable.salmon);
        RelativeLayout.LayoutParams par = new RelativeLayout.LayoutParams(100, 100);
        r.addView(im, par);
        im.setX(x);
        im.setY(y);
    }

    public void showLittleMove(){          //only for head.next
        im.setX(x);
        im.setY(y);
    }

    public void bigMove(MainActivity.Direction direction){          //only for big
        switch(direction){
            case UP:
                y -= 100;
                if(y <= -100)
                    y = 900;
                im.setY(y);
                break;
            case DOWN:
                y += 100;
                if(y >= 1000)
                    y = 0;
                im.setY(y);
                break;
            case LEFT:
                x -= 100;
                if(x <= -100)
                    x = 900;
                im.setX(x);
                break;
            case RIGHT:
                x += 100;
                if(x >= 1000)
                    x = 0;
                im.setX(x);
                break;
            case STOP:
                break;

        }
    }

    public TakoNode delLittleTako(TakoNode tail){//刪掉最後一個node
        tail.im.setImageDrawable(null);//   好像會刪到第一個小章魚
        tail = tail.pre;//tail指向前一個/倒數第二個node
        (tail.next).pre = null;//最後一個.pre = null
        tail.next = null;//倒數第二個.next = null
        return tail;
    }

    public void reset(){
        x = 700;
        y = 300;
        im.setX(x);
        im.setY(y);
        TakoNode temp = next;
        while(temp!=null){
            (temp.im).setImageBitmap(null);
            temp = temp.next;
        }
    }

}