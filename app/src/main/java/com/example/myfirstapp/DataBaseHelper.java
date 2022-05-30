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
    String Name,Email,MotherName,FatherName,AdmissionMode,PreferredBranch;
    int Contact,Percentile;
    selectData(String f,String e,int c,String mn,String fn,String pb,String am,int p){
        Name=f;
        PreferredBranch=pb;
        Contact=c;
        Percentile=p;

        Email=e;
        MotherName=mn;
        FatherName=fn;
        AdmissionMode=am;


    }
}
public class DataBaseHelper extends SQLiteOpenHelper {
    public DataBaseHelper(@Nullable Context context) {
        super(context, "StudentDb", null, 1);
    }

    //this is called the first time a database is accessed
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS CSE(Name VARCHAR(40),Email VARCHAR(40),Contact int,MotherName VARCHAR(40),FatherName varchar(40),PreferredBranch varchar(40),AdmissionMode varchar(40),Percentile int);");
        db.execSQL("CREATE TABLE IF NOT EXISTS MECH(Name VARCHAR(40),Email VARCHAR(40),Contact int,MotherName VARCHAR(40),FatherName varchar(40),PreferredBranch varchar(40),AdmissionMode varchar(40),Percentile int);");
        db.execSQL("CREATE TABLE IF NOT EXISTS ECE(Name VARCHAR(40),Email VARCHAR(40),Contact int,MotherName VARCHAR(40),FatherName varchar(40),PreferredBranch varchar(40),AdmissionMode varchar(40),Percentile int);");
        db.execSQL("CREATE TABLE IF NOT EXISTS CIVIL(Name VARCHAR(40),Email VARCHAR(40),Contact int,MotherName VARCHAR(40),FatherName varchar(40),PreferredBranch varchar(40),AdmissionMode varchar(40),Percentile int);");
        db.execSQL("CREATE TABLE IF NOT EXISTS LAW(Name VARCHAR(40),Email VARCHAR(40),Contact int,MotherName VARCHAR(40),FatherName varchar(40),PreferredBranch varchar(40),AdmissionMode varchar(40),Percentile int);");

    }
    //this is called if database version changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insert_values(String TableName,String name,String email,int contact,String mothername,String fathername,String preferredname,String admissionmode,int percentile){
        ;
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("Name",name);
        cv.put("Email",email);
        cv.put("Contact",contact);
        cv.put("MotherName",mothername);
        cv.put("FatherName",fathername);
        cv.put("PreferredBranch",preferredname);
        cv.put("AdmissionMode",admissionmode);
        cv.put("Percentile",percentile);

        long insert=db.insert(TableName,null,cv);
        if(insert==-1){
            return false;
        }
        return true;
    }
    public List<selectData> show_result(String TableName){

        List<selectData> ourList=new ArrayList<selectData>();

        SQLiteDatabase db=this.getReadableDatabase();

        db.execSQL("CREATE TABLE IF NOT EXISTS CSE(Name VARCHAR(40),Email VARCHAR(40),Contact int,MotherName VARCHAR(40),FatherName varchar(40),PreferredBranch varchar(40),AdmissionMode varchar(40),Percentile int);");
        db.execSQL("CREATE TABLE IF NOT EXISTS MECH(Name VARCHAR(40),Email VARCHAR(40),Contact int,MotherName VARCHAR(40),FatherName varchar(40),PreferredBranch varchar(40),AdmissionMode varchar(40),Percentile int);");
        db.execSQL("CREATE TABLE IF NOT EXISTS ECE(Name VARCHAR(40),Email VARCHAR(40),Contact int,MotherName VARCHAR(40),FatherName varchar(40),PreferredBranch varchar(40),AdmissionMode varchar(40),Percentile int);");
        db.execSQL("CREATE TABLE IF NOT EXISTS CIVIL(Name VARCHAR(40),Email VARCHAR(40),Contact int,MotherName VARCHAR(40),FatherName varchar(40),PreferredBranch varchar(40),AdmissionMode varchar(40),Percentile int);");
        db.execSQL("CREATE TABLE IF NOT EXISTS LAW(Name VARCHAR(40),Email VARCHAR(40),Contact int,MotherName VARCHAR(40),FatherName varchar(40),PreferredBranch varchar(40),AdmissionMode varchar(40),Percentile int);");



        Cursor resultSet=db.rawQuery("SELECT * FROM "+"'"+TableName+"'"+" ;",null);

        resultSet.moveToFirst();
        while(!resultSet.isAfterLast()){

            selectData data=new selectData(resultSet.getString(0),resultSet.getString(1),resultSet.getColumnIndex("Contact"),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getColumnIndex("Percentile"));
            ourList.add(data);
            resultSet.moveToNext();
        }
        resultSet.close();
        return ourList;
    }

}


