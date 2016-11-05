package com.bridgelabz.startactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.tv);
        bt = (Button) findViewById(R.id.bt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent,2); // Activity started with request code 2


            }
        });
    }
    //call back message from another activity
    @Override
    public void onActivityResult(int requestcode,int result,Intent data){
        super.onActivityResult(requestcode,result,data);
        //checking for the given request code is same as the code passed
        if(requestcode==2){
            String message=data.getStringExtra("Message");
            tv.setText(message);
        }

    }
}
