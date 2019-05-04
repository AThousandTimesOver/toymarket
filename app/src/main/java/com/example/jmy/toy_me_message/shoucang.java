package com.example.jmy.toy_me_message;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class shoucang extends AppCompatActivity {

    private ListView lv_teacher;
    private shoucangDB shoucangDB;
    private  blogDB blogDB;
    private Cursor myCursor;
    private ListView myListView;
    private EditText myEditText;
    private Button myButton;
    private int _id;
    private TextView title;
    private TextView author;
    private TextView time;
    private TextView context;
    private ArrayList<Blog> blogs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoucang);
        getSupportActionBar().hide();

        //View view = inflater.inflate(R.layout.tab_teacher, null);
        setContentView(R.layout.activity_shoucang);
        lv_teacher = (ListView)findViewById(R.id.shoucanglist);

        shoucangDB = new shoucangDB(this);
        blogDB = new blogDB(this);


        //给链表添加数据
        List<Map<String, Object>> list=getData();
        //适配器，刚刚重写的！
        luntan2_Adapter myAdapter = new luntan2_Adapter(this.getApplicationContext(),list);
        //设置适配器
        lv_teacher.setAdapter(myAdapter);

        //点论坛任意item跳转
        lv_teacher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Intent intent = new Intent();
                if(blogs.size()-arg2==1) {
                    intent.setClass(shoucang.this, TieziActivity.class);
                    startActivity(intent);
                }
                else {
                    Blog b = blogs.get(arg2);
                    intent.setClass(shoucang.this, Tiezi2Activity.class);
                    intent.putExtra("b", b);
                    startActivity(intent);
                    // Log.e("1",""+arg2+","+arg3);
                }
            }
        });


//        lv_teacher.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
//                Intent intent = new Intent();
//                intent.setClass(me_tie.this, me_qianbao.class);
//                startActivity(intent);
//            }
//        });












//        myCursor = shoucangDB.select();
//
//        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,R.layout.luntan2_item,myCursor,new String[]
//                {shoucangDB.FIELD_TEXT1,shoucangDB.FIELD_TEXT2,shoucangDB.FIELD_TEXT3,shoucangDB.FIELD_TEXT4},new int[]
//                {R.id.textview_yhname,R.id.textView_teacher_nickname,R.id.textView_teacher_name,R.id.textView_university});
//        myListView.setAdapter(adapter);

//        myListView.setOnItemClickListener(
//                new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//                        myCursor.moveToPosition(arg2);
//                        _id=myCursor.getInt(0);
//                        myEditText.setText(myCursor.getString(1));
//                    }
//                }
//        );
//        myListView.setOnItemSelectedListener(
//                new AdapterView.OnItemSelectedListener() {
//                    @Override
//                    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//                        SQLiteCursor sc = (SQLiteCursor) arg0.getSelectedItem();
//                        _id = sc.getInt(0);
//                        myEditText.setText(sc.getString(1));
//                    }
//
//                    @Override
//                    public void onNothingSelected(AdapterView<?> arg0){}
//                }
//        );


    }




    public int get_id(){
        _id = shoucangDB.selectAllid();
        return _id;
    }

    //填充数据
    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        blogs = shoucangDB.select();
        for (int i = 0; i < blogs.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            Blog b = blogs.get(i);
            //map.put("image", R.drawable.hamleys);
            map.put("image1",R.drawable.bptx);
            map.put("teacher_name", b.context);
            map.put("teacher_nickname", b.title);
            map.put("university", b.author);
            map.put("time", b.time);
            list.add(map);
        }
        return list;
    }




}
