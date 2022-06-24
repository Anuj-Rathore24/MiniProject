package com.example.myfirstapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.Serializable;
import java.util.List;

import androidx.annotation.Nullable;

import java.util.ArrayList;

class selectData implements Serializable {
    String Name,Email,detailed,input1,input2,input3,time,date,additional;
    int prn;
    int Contact,Percentile;

    selectData(String n,String e,int p,String i1,String i2,String i3,String d){
        Name=n;
        prn=p;
        Email=e;
        detailed=d;
        input1=i1;
        input2=i2;
        input3=i3;
    }
    selectData(String n,String e,int p,String t,String d){
        Name=n;
        prn=p;
        Email=e;
        time=t;
        date=d;
    }
    selectData(String n,String e,int p,String a){
        Name=n;
        prn=p;
        Email=e;
        additional=a;
    }
    selectData(){

    }
}
public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(@Nullable Context context) {
        super(context, "StudentDb", null, 1);
    }

    //this is called the first time a database is accessed
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS computerScience(Name VARCHAR(40),Email VARCHAR(40),prn int,input1 VARCHAR(40),input2 varchar(40),input3 varchar(40),detailed varchar(40));");
        db.execSQL("CREATE TABLE IF NOT EXISTS Mechanical(Name VARCHAR(40),Email VARCHAR(40),prn int,Time VARCHAR(40),Date varchar(40));");
        db.execSQL("CREATE TABLE IF NOT EXISTS ENTC(Name VARCHAR(40),Email VARCHAR(40),prn int,additional VARCHAR(40));");

    }
    //this is called if database version changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    public boolean insert_values_cse(String name,String email,int prn,String input1,String input2,String input3,String additional){
        ;


        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS computerScience(Name VARCHAR(40),Email VARCHAR(40),prn int,input1 VARCHAR(40),input2 varchar(40),input3 varchar(40),detailed varchar(40));");

        ContentValues cv=new ContentValues();
        cv.put("Name",name);
        cv.put("Email",email);
        cv.put("prn",prn);
        cv.put("input1",input1);
        cv.put("input2",input2);
        cv.put("input3",input3);
        cv.put("detailed",additional);
//        Log.d("Testing",name+" "+email+" "+prn+" "+input1+" "+input2+" "+input3);


        long insert=db.insert("computerScience",null,cv);
        if(insert==-1){
            return false;
        }
        return true;
    }

    public boolean insert_values_mech(String name,String email,int prn,String time,String date){
        ;
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS Mechanical(Name VARCHAR(40),Email VARCHAR(40),prn int,Time VARCHAR(40),Date varchar(40));");

        ContentValues cv=new ContentValues();
        cv.put("Name",name);
        cv.put("Email",email);
        cv.put("prn",prn);
        cv.put("Time",time);
        cv.put("Date",date);

        long insert=db.insert("Mechanical",null,cv);
        if(insert==-1){
            return false;
        }
        return true;
    }

    public boolean insert_values_entc(String name,String email,int prn,String additional){
        ;
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("CREATE TABLE IF NOT EXISTS ENTC(Name VARCHAR(40),Email VARCHAR(40),prn int,additional VARCHAR(40));");

        ContentValues cv=new ContentValues();
        cv.put("Name",name);
        cv.put("Email",email);
        cv.put("prn",prn);
        cv.put("additional",additional);

        long insert=db.insert("ENTC",null,cv);
        if(insert==-1){
            return false;
        }
        return true;
    }


    public List<selectData> show_result(String TableName){

        List<selectData> ourList=new ArrayList<selectData>();

        SQLiteDatabase db=this.getReadableDatabase();

        db.execSQL("CREATE TABLE IF NOT EXISTS computerScience(Name VARCHAR(40),Email VARCHAR(40),prn int,input1 VARCHAR(40),input2 varchar(40),input3 varchar(40),detailed varchar(40));");
        db.execSQL("CREATE TABLE IF NOT EXISTS Mechanical(Name VARCHAR(40),Email VARCHAR(40),prn int,Time VARCHAR(40),Date varchar(40));");
        db.execSQL("CREATE TABLE IF NOT EXISTS ENTC(Name VARCHAR(40),Email VARCHAR(40),prn int,additional VARCHAR(40));");



        Cursor resultSet=db.rawQuery("SELECT * FROM "+"'"+TableName+"'"+" ;",null);

        resultSet.moveToFirst();
        while(!resultSet.isAfterLast()){

            selectData data=new selectData();
            if(TableName=="computerScience"){

                data=new selectData(resultSet.getString(0),resultSet.getString(1),resultSet.getColumnIndex("prn"),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6));
            }
            else if(TableName=="Mechanical"){
                 data=new selectData(resultSet.getString(0),resultSet.getString(1),resultSet.getColumnIndex("prn"),resultSet.getString(3),resultSet.getString(4));
            }else if(TableName=="ENTC"){
                 data=new selectData(resultSet.getString(0),resultSet.getString(1),resultSet.getColumnIndex("prn"),resultSet.getString(3));
            }
            ourList.add(data);
            resultSet.moveToNext();
        }
        resultSet.close();
        return ourList;
    }

}


