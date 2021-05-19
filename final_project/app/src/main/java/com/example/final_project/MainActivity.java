package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btnU,btnD,btnL,btnR;
    private TextView text1;
    public enum Derection {UP, DOWN, Left, Right};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Time
        btn1 = (Button) findViewById(R.id.buttonStart);
        text1 = findViewById(R.id.tvTime);
        CountTime count = new CountTime(btn1, text1);
        Button.OnClickListener buttonStartListener =
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(btn1.getText().equals("START"))
                            count.start("easy");
                        else
                            count.end();
                    }
                };
        btn1.setOnClickListener(buttonStartListener);
        
        btnU = (Button)findViewById(R.id.butUp);
        btnD = (Button)findViewById(R.id.butDown);
        btnL = (Button)findViewById(R.id.butLeft);
        btnR = (Button)findViewById(R.id.butRight);

        btnU.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                Derection derection = Derection.UP;
                ImageView tako = findViewById(R.id.tako);
                tako.setY(tako.getY() - 100);
            }
        });
    }
}