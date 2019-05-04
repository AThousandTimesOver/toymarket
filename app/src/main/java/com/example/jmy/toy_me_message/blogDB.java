package com.example.jmy.toy_me_message;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class blogDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "scdb";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "blogtable";
    public static final String FIELD_id = "_id";
    public static final String FIELD_TEXT1 = "title";
    public static final String FIELD_TEXT2 = "author";
    public static final String FIELD_TEXT3 = "time";
    public static final String FIELD_TEXT4 = "context";

    public blogDB(Context context) {
        super(context, "scdb", (SQLiteDatabase.CursorFactory)null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        String sql = "DROP TABLE IF EXISTS blogtable";
//        db.execSQL(sql);
//        this.onCreate(db);
    }

    public void create(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "CREATE TABLE IF NOT EXISTS blogtable (_id INTEGER primary key autoincrement,  title text,   time text,  author text,  context text)";
        db.execSQL(sql);
    }

    public void drop(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "DROP TABLE IF EXISTS blogtable";
        db.execSQL(sql);
    }

    public ArrayList select() {
        ArrayList<Blog> blogs = new ArrayList<>();
        Blog blog = null;
        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query("blogtable", (String[])null, (String)null, (String[])null, (String)null, (String)null, (String)null);
//        return cursor;
        String selectSQL = "select * from blogtable order by _id desc";
        Cursor cursor = db.rawQuery(selectSQL,null);
        while (cursor.moveToNext()){
            blog = new Blog();
            blog._id = cursor.getInt(0);;
            blog.title = cursor.getString(1);
            blog.time = cursor.getString(2);
            blog.author = cursor.getString(3);
            blog.context = cursor.getString(4);

            blogs.add(blog);

            Integer _id = cursor.getInt(0);
            String title = cursor.getString(1);
            Log.e("1",_id.toString()+","+title);
        }
        return blogs;
    }

    public void deleteAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        String delSQL = "delete from blogtable";
        db.execSQL(delSQL);
    }

    public int selectAllid() {
        int i=0;
        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query("blogtable", (String[])null, (String)null, (String[])null, (String)null, (String)null, (String)null);
//        return cursor;
        String selectSQL = "select _id from blogtable";
        Cursor cursor = db.rawQuery(selectSQL,null);
        while (cursor.moveToNext()){
            Integer _id = cursor.getInt(0);
            //String title = cursor.getString(1);
            Log.e("1",_id.toString());
            i++;
        }
        return i;
    }



    public String selectTitle(int i) {
        SQLiteDatabase db = this.getReadableDatabase();
        String context = "";
        String selectSQL = "select title from blogtable where _id = " + i;
        Cursor cursor = db.rawQuery(selectSQL,null);
        while (cursor.moveToNext()){
            context = cursor.getString(0);
            //String title = cursor.getString(1);
            Log.e("1",context);
        }
        return context;
    }

    public String selectAuthor(int i) {
        SQLiteDatabase db = this.getReadableDatabase();
        String context = "";
        String selectSQL = "select author from blogtable where _id = " + i;
        Cursor cursor = db.rawQuery(selectSQL,null);
        while (cursor.moveToNext()){
            context = cursor.getString(0);
            //String title = cursor.getString(1);
            Log.e("1",context);
        }
        return context;
    }

    public String selectTime(int i) {
        SQLiteDatabase db = this.getReadableDatabase();
        String time = "";
        String selectSQL = "select time from blogtable where _id = " + i;
        Cursor cursor = db.rawQuery(selectSQL,null);
        while (cursor.moveToNext()){
            time = cursor.getString(0);
            //String title = cursor.getString(1);
            Log.e("1",time);
        }
        return time;
    }

    public String selectContext(int i) {
        SQLiteDatabase db = this.getReadableDatabase();
        String context = "";
        String selectSQL = "select context from blogtable where _id = " + i;
        Cursor cursor = db.rawQuery(selectSQL,null);
        while (cursor.moveToNext()){
            context = cursor.getString(0);
            //String title = cursor.getString(1);
            Log.e("1",context);
        }
        return context;
    }

    public long insert(Integer text0,String text1,String text2,String text3,String text4) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        //cv.put("_id",text0);
        cv.put("title", text1);
        cv.put("time", text2);
        cv.put("author", text3);
        cv.put("context", text4);
        long row = db.insert("blogtable", (String)null, cv);
        return row;
    }

    public void delete(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String where = "_id = ?";
        String[] whereValue = new String[]{Integer.toString(id)};
        db.delete("blogtable", where, whereValue);
    }

    public void deleteall() {
        SQLiteDatabase db = this.getWritableDatabase();
//        String where = "_id = ?";
//        String[] whereValue = new String[]{Integer.toString(id)};
        db.delete("blogtable", null, null);
    }
    
    
    
    
    
    
}
