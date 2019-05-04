package com.example.jmy.toy_me_message;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.content.Intent;

public class luntan extends AppCompatActivity {

    private ListView lv_teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luntan);
        getSupportActionBar().hide();

        lv_teacher = (ListView) findViewById(R.id.listView_tab_teacher);

        //给链表添加数据
        List<Map<String, Object>> list=getData();
        //适配器，刚刚重写的！
        luntan_Adapter myAdapter = new luntan_Adapter(this.getApplicationContext(), list);
        //设置适配器
        lv_teacher.setAdapter(myAdapter);

        //点论坛任意item跳转
        lv_teacher.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                Intent intent = new Intent();
                intent.setClass(luntan.this, TieziActivity.class);
                startActivity(intent);
            }
        });

        //监听跳转
//        LinearLayout yishou=(LinearLayout) findViewById(R.id.LinearLayout1);
//        yishou.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(luntan.this,TieziActivity.class);
//                startActivity(intent);
//            }
//        });
//        LinearLayout ershou=(LinearLayout) findViewById(R.id.LinearLayout2);
//        ershou.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(luntan.this,TieziActivity.class);
//                startActivity(intent);
//            }
//        });
//        LinearLayout luntan=(LinearLayout) findViewById(R.id.LinearLayout3);
//        luntan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(luntan.this,TieziActivity.class);
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
