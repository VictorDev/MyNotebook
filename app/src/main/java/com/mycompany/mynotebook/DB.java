package com.mycompany.mynotebook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DB {

    private static final String DB_NAME = "mydb";
    private static final int DB_VERSION = 1;
    private static final String DB_TABLE = "notes";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_TEXT = "text";

    private static final String DB_CREATE =
            "create table " + DB_TABLE + "(" +
                    COLUMN_ID + " integer primary key autoincrement, " +
                    COLUMN_TITLE + " integer, " +
                    COLUMN_TEXT + " text" +
                    ");";

    private final Context mCtx;

    private DBHelper mDBHelper;
    private SQLiteDatabase mDB;

    public DB(Context ctx){
        mCtx = ctx;
    }

    public void open(){
        mDBHelper = new DBHelper(mCtx, DB_NAME , null, DB_VERSION);
        mDB = mDBHelper.getWritableDatabase();
    }

    public void close(){
        if(mDBHelper!=null) mDBHelper.close();
    }

    public Cursor getAllData(){
        return mDB.query(DB_TABLE,null,null,null,null,null,null);
    }

    public void addRec(String title, String text){
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITLE,title);
        cv.put(COLUMN_TEXT, text);
        mDB.insert(DB_TABLE, null,cv);
    }

    public void deleteRec(long id){
        mDB.delete(DB_TABLE,COLUMN_ID + " = " + id, null);
    }



}
