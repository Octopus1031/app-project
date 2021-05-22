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
    public enum Derection {UP, DOWN, LEFT, RIGHT};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Time
        btn1 = (Button) findViewById(R.id.buttonStart);
        text1 = findViewById(R.id.tvTime);
        ImageView tako = findViewById(R.id.tako);
        CountTime count = new CountTime(btn1, text1);
        CountTakoRun ctr = new CountTakoRun(Derection.Left, tako);
        Button.OnClickListener buttonStartListener =
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(btn1.getText().equals("START")){
                            count.start("easy");
                            ctr.start();
                        }
                        else{
                            count.end();
                            ctr.end();
                        }
                    }
                };
        btn1.setOnClickListener(buttonStartListener);
        
        btnU = (Button)findViewById(R.id.butUp);
        btnD = (Button)findViewById(R.id.butDown);
        btnL = (Button)findViewById(R.id.butLeft);
        btnR = (Button)findViewById(R.id.butRight);

        btnU.setOnClickListener(v -> ctr.derection = Derection.UP);
        btnD.setOnClickListener(v -> ctr.derection = Derection.DOWN);
        btnL.setOnClickListener(v -> ctr.derection = Derection.LEFT);
        btnR.setOnClickListener(v -> ctr.derection = Derection.RIGHT);
    }
}