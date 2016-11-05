package com.bridgelabz.preferencedemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button bt, bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= (TextView) findViewById(R.id.tv);
        bt= (Button) findViewById(R.id.bt);
        bt1= (Button) findViewById(R.id.bt1);

        View.OnClickListener listener= new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.bt:
                        Intent intent=new Intent(MainActivity.this,Preference.class);
                        startActivity(intent);
                        break;
                    case R.id.bt1:
                        diplaySharedPreferences();
                        break;
                }
            }
        };
                 bt.setOnClickListener(listener);
                 bt1.setOnClickListener(listener);

    }

    private void diplaySharedPreferences() {
        SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        String username = s.getString("Username","Default nick name");
        String password = s.getString("Password","Default password");
        boolean checkBox =s.getBoolean("checkBox",false);
        String listprefernce = s.getString("list preference","Default");
        StringBuilder builder=new StringBuilder();
        builder.append("username:"+username+"\n");
        builder.append("password"+password+"\n");
        builder.append("Keep me logged in: " + String.valueOf(checkBox) + "\n");
        builder.append("List preference: " + listprefernce);
        tv.setText(builder.toString());

    }
}


