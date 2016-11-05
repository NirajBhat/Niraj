package com.bridgelabz.timepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    Button button;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker=(TimePicker)findViewById(R.id.timePicker);
        button=(Button)findViewById(R.id.button);
        textView=(TextView)findViewById(R.id.textView);

        timePicker.setIs24HourView(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(getCurrentTime());

            }
        });

    }
    public String getCurrentTime(){
        String currentTime = "Current Time:" +timePicker.getCurrentHour()+ ":"+timePicker.getCurrentMinute();
        return currentTime;
    }
}
