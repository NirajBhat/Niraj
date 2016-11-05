package com.bridgelabz.startactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText et1;
    Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        et1= (EditText) findViewById(R.id.et1);
        bt1= (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String messsage=et1.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("Message",messsage);
                setResult(2,intent);
                finish(); // activity is finished

            }
        });
    }
}
