package com.bridgelabz.customtoast;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // creating the Layout inflater instance
        LayoutInflater li = getLayoutInflater();

        //getting the view object as defined in the customlayout.xml

        View layout = li.inflate(R.layout.customlayout,
                (ViewGroup)findViewById(R.id.linear ));

        // creating the toaast object
        Toast toast=new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setView(layout);  // setting the view to customlayout
        toast.show();
    }
}
