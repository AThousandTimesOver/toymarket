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
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.content.Intent;


public class me_tie extends AppCompatActivity {


    private ListView lv_teacher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_tie);
        getSupportActionBar().hide();

        //View view = inflater.inflate(R.layout.tab_teacher, null);
        setContentView(R.layout.activity_me_tie);
        lv_teacher = (ListView)findViewById(R.id.list);

        //给链表添加数据
        List<Map<String, Object>> list=getData();
        //适配器，刚刚重写的！
        MyAdapter myAdapter = new MyAdapter(this.getApplicationContext(),list);
        //设置适配器
        lv_teacher.setAdapter(myAdapter);

        //点论坛任意item跳转
        lv_teacher.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                Intent intent = new Intent();
                intent.setClass(me_tie.this, TieziActivity.class);
                startActivity(intent);
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
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", R.drawable.hamleys);
            map.put("image1",R.drawable.bptx);
            map.put("teacher_name", "第一：Hamleys玩具城");
            map.put("teacher_nickname", "盘点南京最受欢迎的玩具城");
            map.put("university", "第二：皇家迪智尼玩具");
            list.add(map);
        }
        return list;
    }

}

