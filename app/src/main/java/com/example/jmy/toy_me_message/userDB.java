package com.example.jmy.toy_me_message;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class userDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "scdb";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "usertable";
    public static final String FIELD_id = "_id";
    public static final String FIELD_TEXT1 = "name";

    public userDB(Context context) {
        super(context, "scdb", (SQLiteDatabase.CursorFactory)null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        String sql = "DROP TABLE IF EXISTS usertable";
//        db.execSQL(sql);
//        this.onCreate(db);
    }

    public void create(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "CREATE TABLE IF NOT EXISTS usertable (_id INTEGER primary key autoincrement,  title text,   time text,  author text,  context text)";
        db.execSQL(sql);
    }

    public long insert() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("_id",1);
        cv.put("name", "玩具女孩");
        long row = db.insert("usertable", (String)null, cv);
        return row;
    }
    
}
