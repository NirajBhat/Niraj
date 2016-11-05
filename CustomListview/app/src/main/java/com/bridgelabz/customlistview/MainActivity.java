package com.bridgelabz.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String[] item = {"Safari", "Firefox", "Global", "Cold war", "UC Broser", "Camera","Mobile","Watch","Train","Airplane","jet",
                      "Barbie","Burbon","Gun","Metro"};
    Integer[] integers = {R.drawable.safari,
            R.drawable.firefox,
            R.drawable.global,
            R.drawable.cold, R.drawable.uc, R.drawable.camera, R.drawable.mobile,
            R.drawable.watch, R.drawable.train, R.drawable.airplane, R.drawable.jet, R.drawable.barbie, R.drawable.bourbon,
            R.drawable.gun, R.drawable.metro};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list =(ListView)findViewById(R.id.list);
         CustomList adapter = new CustomList(this,item,integers);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selecteditem = item[+i];
                Toast.makeText(MainActivity.this,selecteditem ,Toast.LENGTH_SHORT).show();
            }
        });
}
}