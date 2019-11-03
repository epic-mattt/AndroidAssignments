package com.example.acer.androidassignments;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ChatDatabaseHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "myDatabase.db";
    private static int VERSION_NUMBER = 1;
    private static String DATABASE_HELPER_NAME = "CHAT_DATABASE_HELPER";

    static final String TABLE_NAME = "Messages";
    static final String COLUMN1 = "Key_Id";
    static final String COLUMN2 = "message";
    private static final String DATABASE_CREATE = "create table " + TABLE_NAME + " ( " + COLUMN1 + " integer primary key autoincrement, " + COLUMN2 + " text not null);";
    private static final String DATABASE_DROP = "drop table if exists " + TABLE_NAME;

    public ChatDatabaseHelper(Context ctx) {
        super(ctx, DATABASE_NAME, null, VERSION_NUMBER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
        Log.i(DATABASE_HELPER_NAME, "Calling onCreate()");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (VERSION_NUMBER == oldVersion) {
            VERSION_NUMBER = newVersion;
            db.execSQL(DATABASE_DROP);
            onCreate(db);
            Log.i(DATABASE_HELPER_NAME, "Calling onUpgrade old version = " + oldVersion + " , new version = " + newVersion);
        }
    }
}
