package com.example.myfirstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(@Nullable Context context) {
        super(context, "StudentDb", null, 1);
    }

    //this is called the first time a database is accessed
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS StudentTable(FirstName VARCHAR(40),LastName VARCHAR(40),Age int,Email VARCHAR(40),Panel varchar(2));");
    }
    //this is called if database version changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insert_values(String firstname,String lastname,String age,String email,String panel){
        ;
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("FirstName",firstname);
        cv.put("LastName",lastname);
        cv.put("Age",age);
        cv.put("Email",email);
        cv.put("Panel",panel);

        long insert=db.insert("StudentTable",null,cv);
        if(insert==-1){
            return false;
        }
        return true;
    }
    public String show_result(){
        SQLiteDatabase db=this.getReadableDatabase();
        String result="\nThe Database\n";

        Cursor resultSet=db.rawQuery("SELECT * FROM StudentTable;",null);
        resultSet.moveToFirst();
        while(!resultSet.isAfterLast()){
            result+="\n"+resultSet.getString(0)+ " \t "+resultSet.getString(1)+ " \t "+resultSet.getString(2)+ " \t "+resultSet.getString(3)+ " \t "+resultSet.getString(4);
            resultSet.moveToNext();
        }
        resultSet.close();
        return result;
    }
    public boolean delete_records(String Email){

        SQLiteDatabase db=this.getWritableDatabase();
        int studentTable = db.delete("StudentTable", "Email=" + "'"+Email+"'", null);
        if(studentTable==0){
            return false;
        }
        return true;
    }

    public boolean update_records(String firstname,String lastname,String age,String email,String panel){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("FirstName",firstname);
        cv.put("LastName",lastname);
        cv.put("Age",age);
        cv.put("Email",email);
        cv.put("Panel",panel);
        int studentTable = db.update("StudentTable",cv, "Email=" + "'"+email+"'", null);
        if(studentTable==0){
            return false;
        }
        return true;
    }
}
