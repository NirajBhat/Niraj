package com.bridgelabz.contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView= (ListView) findViewById(R.id.listview);
        String string[]={"Yogesh Pujari","Niraj","Dheeraj","vidya"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,string);
        listView.setAdapter(adapter);
        // register the listview for context menu
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select the Option");
        menu.add(0,v.getId(),0,"call");
        menu.add(0,v.getId(),0,"message");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "call") {
            Toast.makeText(this.getApplicationContext(),"calling",Toast.LENGTH_SHORT).show();
        } else if (item.getTitle() == "message") {
            Toast.makeText(this.getApplicationContext(),"SMS Sending",Toast.LENGTH_SHORT).show();
        } else {
            return false;
        }
        return true;



     }
}
