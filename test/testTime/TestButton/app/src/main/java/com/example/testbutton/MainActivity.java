package com.example.testbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.buttonStart);
        text1 = findViewById(R.id.view);
        Button.OnClickListener buttonStartListener =
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CountTime count = new CountTime(btn1, text1);
                    }
                };
        btn1.setOnClickListener(buttonStartListener);
    }
}