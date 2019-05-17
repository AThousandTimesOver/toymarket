package com.example.jmy.toy_me_message;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.content.Intent;


public class me_tie extends AppCompatActivity {


    private ListView lv_teacher;
    private LinearLayout ll;
    private shoucangDB shoucangDB;
    private  blogDB blogDB;
    private int _id;
    private ArrayList<Blog> blogs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_tie);
        getSupportActionBar().hide();

        //View view = inflater.inflate(R.layout.tab_teacher, null);
        setContentView(R.layout.activity_me_tie);
        lv_teacher = (ListView)findViewById(R.id.list);

        shoucangDB = new shoucangDB(this);
        blogDB = new blogDB(this);

        //给链表添加数据
        List<Map<String, Object>> list=getData();
        //适配器，刚刚重写的！
        luntan2_Adapter myAdapter = new luntan2_Adapter(this.getApplicationContext(),list);
        //设置适配器
        lv_teacher.setAdapter(myAdapter);

        //点论坛任意item跳转
        lv_teacher.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                Intent intent = new Intent();
                if(blogs.size()-arg2==1) {
                    Blog b = blogs.get(arg2);
                    intent.setClass(me_tie.this, TieziActivity.class);
                    intent.putExtra("b", b);
                    startActivity(intent);
                }
                else {
                    Blog b = blogs.get(arg2);
                    intent.setClass(me_tie.this, Tiezi2Activity.class);
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

    }

    //填充数据
    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        blogs = blogDB.select();
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

