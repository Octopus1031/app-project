package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
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
    }
}