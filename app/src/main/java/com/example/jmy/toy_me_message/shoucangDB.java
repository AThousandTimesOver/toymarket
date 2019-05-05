package com.example.jmy.toy_me_message;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;


public class shoucangDB extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "scdb";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "sctable";
    public static final String FIELD_id = "_id";
    public static final String FIELD_TEXT1 = "title";
    public static final String FIELD_TEXT2 = "author";
    public static final String FIELD_TEXT3 = "time";
    public static final String FIELD_TEXT4 = "context";
    int i=0;
    private  blogDB blogDB;





    public shoucangDB(Context context) {
        super(context, "scdb", (SQLiteDatabase.CursorFactory)null, 1);
        blogDB = new blogDB(context);
    }

    public void onCreate(SQLiteDatabase db) {

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        String sql = "DROP TABLE IF EXISTS sctable";
//        db.execSQL(sql);
//        this.onCreate(db);
    }

    public void drop(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "DROP TABLE IF EXISTS sctable";
        db.execSQL(sql);
    }

    public void create(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "CREATE TABLE IF NOT EXISTS sctable (_id INTEGER primary key autoincrement,  blogid int)";
        db.execSQL(sql);
    }

    public ArrayList select() {
        ArrayList<Blog> blogs = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
////        Cursor cursor = db.query("sctable", (String[])null, (String)null, (String[])null, (String)null, (String)null, (String)null);
////        return cursor;
        String selectSQL = "select * from blogtable where _id in (select blogid from sctable) order by _id desc";
//        String selectSQL = "select * from sctable";
        Cursor cursor = db.rawQuery(selectSQL,null);
        while (cursor.moveToNext()){
            Blog blog = new Blog();
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

    public int ifhavesc(int blogid){
        Integer _id=0;
        SQLiteDatabase db = this.getReadableDatabase();
        String selectSQL = "select _id from sctable where blogid = " + blogid;
        Cursor cursor = db.rawQuery(selectSQL,null);
        while (cursor.moveToNext()) {
            _id = cursor.getInt(0);
        }
        return _id;
    }

    public int selectscnum(int blogid){
        Integer scnum=0;
        SQLiteDatabase db = this.getReadableDatabase();
        String selectSQL = "select scnum from sctable where blogid = " + blogid;
        Cursor cursor = db.rawQuery(selectSQL,null);
        return scnum;
    }

    public void deleteAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        String delSQL = "delete from sctable";
        db.execSQL(delSQL);
    }

    public void deletesc(int blogid){
        SQLiteDatabase db = this.getReadableDatabase();
        String delSQL = "delete from sctable where blogid = " + blogid;
        Cursor cursor = db.rawQuery(delSQL,null);
    }

    public int selectAllid() {
        int i=0;
        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.query("sctable", (String[])null, (String)null, (String[])null, (String)null, (String)null, (String)null);
//        return cursor;
        String selectSQL = "select _id from sctable";
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
//        SQLiteDatabase db = this.getReadableDatabase();
//        String context = "";
//        String selectSQL = "select title from sctable where _id = " + i;
//        Cursor cursor = db.rawQuery(selectSQL,null);
//        while (cursor.moveToNext()){
//            context = cursor.getString(0);
//            //String title = cursor.getString(1);
//            Log.e("1",context);
//        }
//        return context;
        return blogDB.selectTitle(i);
    }

    public String selectAuthor(int i) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String context = "";
//        String selectSQL = "select author from sctable where _id = " + i;
//        Cursor cursor = db.rawQuery(selectSQL,null);
//        while (cursor.moveToNext()){
//            context = cursor.getString(0);
//            //String title = cursor.getString(1);
//            Log.e("1",context);
//        }
//        return context;
        return blogDB.selectAuthor(i);
    }

    public String selectTime(int i) {
//        SQLiteDatabase db = this.getReadableDatabase();
////        Cursor cursor = db.query("sctable", (String[])null, (String)null, (String[])null, (String)null, (String)null, (String)null);
////        return cursor;
//        String selectSQL = "select time from sctable";
//        Cursor cursor = db.rawQuery(selectSQL,null);
//        return cursor;
        return blogDB.selectTime(i);
    }

    public String selectContext(int i) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String context = "";
//        String selectSQL = "select context from sctable where _id = " + i;
//        Cursor cursor = db.rawQuery(selectSQL,null);
//        while (cursor.moveToNext()){
//            context = cursor.getString(0);
//            //String title = cursor.getString(1);
//            Log.e("1",context);
//        }
//        return context;
        return blogDB.selectContext(i);
    }


    public long insert(Integer text0,Integer text1) {
        //i++;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        //cv.put("_id",text0);
        cv.put("blogid", text1);
        long row = db.insert("sctable", (String)null, cv);
        return row;
    }


    public void delete(int blogid) {
        SQLiteDatabase db = this.getWritableDatabase();
        String where = "blogid = ?";
        String[] whereValue = new String[]{Integer.toString(blogid)};
        db.delete("sctable", where, whereValue);
    }

    public void deleteall() {
        SQLiteDatabase db = this.getWritableDatabase();
//        String where = "_id = ?";
//        String[] whereValue = new String[]{Integer.toString(id)};
        db.delete("sctable", null, null);
    }

    public void update(int id, String text) {
        SQLiteDatabase db = this.getWritableDatabase();
        String where = "_id = ?";
        String[] whereValue = new String[]{Integer.toString(id)};
        ContentValues cv = new ContentValues();
        cv.put("title", text);
        db.update("sctable", cv, where, whereValue);
    }

    public void updatesc(int blogid,int scnum){
        SQLiteDatabase db = this.getReadableDatabase();
        String delSQL = "update scnum = " + scnum + "from sctable where blogid = " + blogid;
        db.execSQL(delSQL);
    }
}



