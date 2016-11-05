package com.bridgelabz.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bridgeit on 28/10/16.
 */

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Contact.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ID = "key_id";
    private static final String COLUMN_NUMBERS = "numbers";
    public static final int DB_VERSION = 1;

    Database(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
        // 3rd argument is passed is cursorfactory instance
    }

    // creating table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME + " TEXT,"
                +COLUMN_NUMBERS + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    // UPDATING TABLE
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int new_version) {
        // drop older version table if exists
        db.execSQL("DROP THE TABLE IF EXISTS" + TABLE_NAME);

        //CREATES TABLE AGAIN
        onCreate(db);

    }

    // code to add new contacts
    void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, contact.getName()); // contact name
        values.put(COLUMN_NUMBERS, contact.getPhone_num()); // contact number

        // insert into rows
        db.insert(TABLE_NAME, null, values);
        // 2nd argument string containing null columnhack
        db.close();//closing the database connection
    }

    // code to get the single contact info
    Contact getcontact(int Id) {
        Contact contact=null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{COLUMN_ID, COLUMN_NAME, COLUMN_NUMBERS}, COLUMN_ID + "=?",
                new String[]{String.valueOf(Id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        contact = new Contact(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));

        }
        return contact;

    }    // code to get all contacts in listview
        public List<Contact> getAllContacts() {
            List<Contact> contacts = new ArrayList<Contact>();

            // select all query
            String selectQuery="SELECT * FROM "+TABLE_NAME;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(selectQuery, null);
            //looping through all rows and adding to list
            if(cursor.moveToFirst()){
                do {
                    Contact contact = new Contact();
                    contact.setId(Integer.parseInt(cursor.getString(0)));
                    contact.setName(cursor.getString(1));
                    contact.setPhone_num(cursor.getString(2));
                    //Adding contact to list
                    contacts.add(contact);
                }while (cursor.moveToNext());
            }
            // return contacts
            return  contacts;
        }
          //code update the single contact
      public int updateContact(Contact contact){
          SQLiteDatabase db=this.getWritableDatabase();
          ContentValues values = new ContentValues();
          values.put(COLUMN_NAME,contact.getName());
          values.put(COLUMN_NUMBERS,contact.getPhone_num());
          //updating row
          return db.update(TABLE_NAME,values,COLUMN_ID+"=?",
                  new String[]{String.valueOf(contact.getId())});
      }
        // Deleting sing;e contact
    public void deleteContact(Contact contact){
        SQLiteDatabase  db = this.getWritableDatabase();
        db.delete(TABLE_NAME,COLUMN_ID+"=?",
                new String[] {String.valueOf(contact.getId())});
        db.close();
    }
    // getting contacts count
   public int getContactCount(){
       String count ="SELECT * FROM "+TABLE_NAME;
       SQLiteDatabase db = this.getReadableDatabase();
       Cursor cursor = db.rawQuery(count,null);
       cursor.close();
       // return count
       return cursor.getCount();

   }


}
