package com.bridgelabz.dynamicfragment;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity {
    Button b_red,b_yellow,b_green,b_white;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_red= (Button) findViewById(R.id.bt_red);
        b_yellow= (Button) findViewById(R.id.bt_yellow);
        b_green= (Button) findViewById(R.id.bt_green);
        b_white= (Button) findViewById(R.id.bt_white);

    }
    public void click(View v){
        Fragment frag=null;
        if (v==b_white){
            Log.e(TAG,"white");
            frag=new white();
        }
        else if (v==b_red){
            Log.e(TAG,"Red");
            frag=new Red();
        }
        else if(v== b_yellow){
            Log.e(TAG,"Yellow");
            frag=new Yellow();
        }
        else if(v== b_green){
            Log.e(TAG,"green");
            frag=new Green();
        }
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, frag);
        fragmentTransaction.commit();

    }
}
