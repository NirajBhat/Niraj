package com.bridgelabz.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText= (EditText) findViewById(R.id.et);
        button= (Button) findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url=editText.getText().toString();

                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("http://www."+ url+".com"));
               // intent.setData(Uri.parse("http://www.javatpoint.com"));
                //intent.setData(Uri.parse("http://www.facebook.com"));
                //intent.setData(Uri.parse("http://www.BridgeLabz.com"));
                startActivity(intent);
            }
        });


    }
}
