package com.example.assignment07;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class LibraryDB {

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    private ArrayList<String> districtList;

    public LibraryDB(Context context) {
        databaseHelper=new DatabaseHelper(context,"library.db");
        database=databaseHelper.getReadableDatabase();
    }

    //Example of getting a list from database
    public ArrayList<String> getDistrictList() {
        districtList=new ArrayList<>();

        String query="SELECT * FROM districtName ";
        Cursor cursor=database.rawQuery(query,null);

        if (cursor.moveToFirst())
        {
            do {
                districtList.add(cursor.getString(cursor.getColumnIndex("name")));
            }while (cursor.moveToNext());
        }
        return districtList;
    }
}