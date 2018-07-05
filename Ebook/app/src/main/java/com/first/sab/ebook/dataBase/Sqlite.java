package com.first.sab.ebook.dataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.first.sab.ebook.R;
import com.first.sab.ebook.modeles.ModelDetails;

import java.util.ArrayList;

/**
 * Created by Sab on 25/03/2018.
 */

public class Sqlite  extends SQLiteOpenHelper{

    private static final String DATA_BASE = "Book_Date_Base";
    private static final int DATE_VERSION = 1;
    public Sqlite(Context context) {
        super(context, "Book_Date_Base", null, 1);
    }

    //-----------------------------------------------------------------------------------------------
    // Create table in the Data Base

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE BookTable (id Integer primary key AUTOINCREMENT,  book_name text,  author_name text)";
        sqLiteDatabase.execSQL(sql);
    }

    //-----------------------------------------------------------------------------------------------
    // to Drop Table From the Data Base


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop Table  BookTable");
        this.onCreate(sqLiteDatabase);



    }

    //-----------------------------------------------------------------------------------------------
        // to add books in the data base


    public void addData( String bookName, String authorName){

       SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("book_name",bookName);
        values.put("author_name",authorName);

        sqLiteDatabase.insert("BookTable", null, values);

    }

    //-----------------------------------------------------------------------------------------------
    // to show all the data of books in the database

    public ArrayList<ModelDetails>  retriveData(){
        ArrayList<ModelDetails> arrayList;
        arrayList = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        ModelDetails modelDetails;

        Cursor cursor = database.rawQuery("SELECT * FROM BookTable", null);

        if (cursor.moveToFirst()){
            do {
                modelDetails= new ModelDetails();
                modelDetails.setTxt2(cursor.getString(cursor.getColumnIndex("author_name")));
                modelDetails.setTxt1(cursor.getString(cursor.getColumnIndex("book_name")));
                modelDetails.setImg(R.drawable.allbook);
                 arrayList.add(modelDetails);
            }while (cursor.moveToNext());
        }

        return arrayList;
    }

    //-----------------------------------------------------------------------------------------------
    // Delete Row From The Date base

    public void deleteOneBook(int position){
        SQLiteDatabase sqLiteDatabase1 = getWritableDatabase();
        sqLiteDatabase1.delete("bookTable","Id = ?" , new String[]{String.valueOf(position)});
    }


}
