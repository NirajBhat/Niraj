package com.bridgelabz.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Database db = new Database(this);
        // inserting contacts
        Log.d("Insert:","Inserting..");
        db.addContact(new Contact("Niraj","9482466662"));
        db.addContact(new Contact("Kartik","9844765795"));
        //Reading contacts
        Log.d("reading:","Read all contacts");
        List<Contact> contacts = db.getAllContacts();

        for (Contact contact:contacts){
            String log = "Id:" +contact.getId()+",Name"+contact.getName()+",Phone:"+
                    contact.getPhone_num();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }

    }





}
