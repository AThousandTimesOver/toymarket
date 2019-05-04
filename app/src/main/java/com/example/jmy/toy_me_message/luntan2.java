package com.example.jmy.toy_me_message;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
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

public class luntan2 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView lv_teacher;
    private LinearLayout ll;
    private shoucangDB shoucangDB;
    private  blogDB blogDB;
    private int _id;
    private ArrayList<Blog> blogs;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luntan2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lv_teacher = (ListView) findViewById(R.id.listView_tab_teacher);

        shoucangDB = new shoucangDB(this);
        blogDB = new blogDB(this);



        //给链表添加数据
        List<Map<String, Object>> list=getData();
        //适配器，刚刚重写的！
        luntan2_Adapter myAdapter = new luntan2_Adapter(this.getApplicationContext(), list);
        //设置适配器
        lv_teacher.setAdapter(myAdapter);

        //点论坛任意item跳转
        lv_teacher.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {
                Intent intent = new Intent();
                Blog b = blogs.get(arg2);
                intent.setClass(luntan2.this, TieziActivity.class);
                intent.putExtra("b", b);
                startActivity(intent);
               // Log.e("1",""+arg2+","+arg3);

            }
        });

        ll=(LinearLayout) findViewById(R.id.LinearLayout1);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(luntan2.this,firsthand.class);
                startActivity(intent);
            }
        });

        ll=(LinearLayout) findViewById(R.id.LinearLayout2);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(luntan2.this,MainActivity.class);
                startActivity(intent);
            }
        });






//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        LinearLayout butt = navigationView.getHeaderView(0).findViewById(R.id.butt);


        class MyListener implements View.OnClickListener {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(luntan2.this,shoucang.class);
                startActivity(intent);
            }
        };

        View.OnClickListener listener0 = new  MyListener();
        butt.setOnClickListener(listener0);




        LinearLayout butt2 = navigationView.getHeaderView(0).findViewById(R.id.butt2);

        class MyListener1 implements View.OnClickListener {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(luntan2.this,Edittiezi2Activity.class);
                startActivity(intent);
            }
        };

        View.OnClickListener listener1 = new  MyListener1();
        butt2.setOnClickListener(listener1);






    }

    public int get_id(){
        _id = shoucangDB.selectAllid();
        return _id;
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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.luntan2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent=new Intent(luntan2.this,me_tie.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            Intent intent=new Intent(luntan2.this,me_qianbao.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {
            Intent intent=new Intent(luntan2.this,me_dingdan.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage) {
            Intent intent=new Intent(luntan2.this,me_message.class);
            startActivity(intent);
        } /*else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
