package com.bridgelabz.autocomplete;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    String[] language = {"C","C++","JAVA","Android","Python","Swift","Objective C"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating the instance of array adapter contains the list of languages
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item,language);
               //Getting the instance of AutoComplete Text View

        AutoCompleteTextView actv =(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        actv.setThreshold(1); // will startworking from first character
        actv.setAdapter(adapter); // setting the adapter data to AutoCompleteTextView
        actv.setTextColor(Color.RED);

    }
}
