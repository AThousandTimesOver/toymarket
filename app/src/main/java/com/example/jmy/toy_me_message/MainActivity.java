package com.example.jmy.toy_me_message;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.Group;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private Button button33;
    private Button button34;
    private Button button12;
    private Button button13;
    private Button button18;
    private Button button19;
    private Button button20;
    private Button button21;
    private Button button22;
    private Button button23;
    private Button button31;
    private LinearLayout yishou;
    private LinearLayout luntan;
//    private TextView title, item_weixin, item_tongxunlu, item_faxian, item_me,item_daifanhuan,item_fanhuanzhong;
//    private ViewPager vp;
//    private firsthand1 oneFragment;
//    private secondhand twoFragment;
//    private luntan1 threeFragment;
////    private Four4Fragment fouthFragmen;
////    private Five5Fragment fiveFragmen;
////    private Six6Fragment sixFragmen;
//    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
//    private FragmentAdapter mFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        yishou=(LinearLayout)findViewById(R.id.LinearLayout1);
        luntan=(LinearLayout)findViewById(R.id.LinearLayout3);
        //button33=(Button) findViewById(R.id.button33);
        button12=(Button)findViewById(R.id.button12);
        button13=(Button)findViewById(R.id.button13);
        button18=(Button)findViewById(R.id.button18);
        button19=(Button)findViewById(R.id.button19);
        button20=(Button)findViewById(R.id.button20);
        button21=(Button)findViewById(R.id.button21);
        button22=(Button)findViewById(R.id.button22);
        button23=(Button)findViewById(R.id.button23);
        button31=(Button)findViewById(R.id.button31);
        button31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,secondhandsell8.class);
                startActivity(intent);
            }
        });
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,secondhandsell7.class);
                startActivity(intent);
            }
        });
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,secondhandsell6.class);
                startActivity(intent);
            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,secondhandsell5.class);
                startActivity(intent);
            }
        });
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,secondhandsell4.class);
                startActivity(intent);
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,secondhandsell3.class);
                startActivity(intent);
            }
        });
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,secondhandsell2.class);
                startActivity(intent);
            }
        });
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,secondhandsell1.class);
                startActivity(intent);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this,secondhandsell.class);
                startActivity(intent);
            }
        });
        yishou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,firsthand.class);
                startActivity(intent);
            }
        });

        //button34=(Button) findViewById(R.id.button34);
        luntan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,luntan2.class);
                startActivity(intent);
            }
        });

//        initViews();
//
//        mFragmentAdapter = new MainActivity.FragmentAdapter(this.getSupportFragmentManager(), mFragmentList);
//        vp.setOffscreenPageLimit(3);//ViewPager的缓存为4帧
//        vp.setAdapter(mFragmentAdapter);
//        vp.setCurrentItem(1);//初始设置ViewPager选中第一帧
//        item_weixin.setTextColor(Color.parseColor("#FFFFBB33"));
//
//        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                /*此方法在页面被选中时调用*/
//                //
//                // title.setText(titles[position]);
//                changeTextColor(position);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                /*此方法是在状态改变的时候调用，其中arg0这个参数有三种状态（0，1，2）。
//                arg0 ==1的时辰默示正在滑动，
//                arg0==2的时辰默示滑动完毕了，
//                arg0==0的时辰默示什么都没做。*/
//            }
//        });











//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });



//        LinearLayout butt=(LinearLayout)findViewById(R.id.nav_view).findViewById(R.id.butt);
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
//                startActivity(intent);
//
//            }
//        });





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();





        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        LinearLayout butt = navigationView.getHeaderView(0).findViewById(R.id.butt);

        class MyListener implements View.OnClickListener {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(MainActivity.this,shoucang.class);
                startActivity(intent);
            }
        };

        View.OnClickListener listener0 = new  MyListener();
        butt.setOnClickListener(listener0);




//        LinearLayout butt2 = navigationView.getHeaderView(0).findViewById(R.id.butt2);
//
//        class MyListener1 implements View.OnClickListener {
//            @Override
//            public void onClick(View v){
//                Intent intent=new Intent(MainActivity.this,Edittiezi2Activity.class);
//                startActivity(intent);
//            }
//        };
//
//        View.OnClickListener listener1 = new  MyListener1();
//        butt2.setOnClickListener(listener1);




//        LinearLayout butt3 = navigationView.getHeaderView(0).findViewById(R.id.butt3);
//
//        class MyListener2 implements View.OnClickListener {
//            @Override
//            public void onClick(View v){
//                Intent intent=new Intent(MainActivity.this,TieziActivity.class);
//                startActivity(intent);
//            }
//        };
//
//        View.OnClickListener listener2 = new  MyListener2();
//        butt3.setOnClickListener(listener2);









        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_settings).setOnMenuItemClickListener
                (new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
//                        Intent intent = new Intent(MainActivity.this ,
//                                Edittiezi2Activity.class);
//                        startActivity(intent);
                        return true;
                    }
                });
        return super.onPrepareOptionsMenu(menu);
    }


    public void onFragmentInteraction(Uri uri) {
        Log.e("Debug", "-------------10");
    }

    /**
     * 初始化布局View
     */
//    private void initViews() {
//        //title = (TextView) findViewById(R.id.title);
//        item_weixin = (TextView) findViewById(R.id.item_weixin);
//        item_tongxunlu = (TextView) findViewById(R.id.item_tongxunlu);
//        item_faxian = (TextView) findViewById(R.id.item_faxian);
////        item_me = (TextView) findViewById(R.id.item_me);
////        item_daifanhuan = (TextView) findViewById(R.id.item_daifanhuan);
////        item_fanhuanzhong = (TextView) findViewById(R.id.item_fanhuanzhong);
//
//
//        item_weixin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        item_weixin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
//
//        item_tongxunlu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
//
////        item_faxian.setOnClickListener(new View.OnClickListener() {
////            public void onClick(View v) {
////            }
////        });
////
////        item_me.setOnClickListener(new View.OnClickListener() {
////            public void onClick(View v) {
////            }
////        });
////
////        item_daifanhuan.setOnClickListener(new View.OnClickListener() {
////            public void onClick(View v) {
////            }
////        });
////
////        item_fanhuanzhong.setOnClickListener(new View.OnClickListener() {
////            public void onClick(View v) {
////            }
////        });
//
//
//        vp = (ViewPager) findViewById(R.id.mainViewPager);
//        oneFragment = new firsthand1();
//        twoFragment = new secondhand();
//        threeFragment = new luntan1();
//
//        //给FragmentList添加数据
//        mFragmentList.add(oneFragment);
//        mFragmentList.add(twoFragment);
//        mFragmentList.add(threeFragment);
//    }
//
//    /**
//     * 点击底部Text 动态修改ViewPager的内容
//     */
//
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.item_weixin:
//                vp.setCurrentItem(0, true);
//                break;
//            case R.id.item_tongxunlu:
//                vp.setCurrentItem(1, true);
//                break;
//            case R.id.item_faxian:
//                vp.setCurrentItem(2, true);
//                break;
////            case R.id.item_me:
////                vp.setCurrentItem(3, true);
////                break;
////            case R.id.item_daifanhuan:
////                vp.setCurrentItem(4, true);
////                break;
////            case R.id.item_fanhuanzhong:
////                vp.setCurrentItem(5, true);
////                break;
//        }
//    }
//
//
//
//    public class FragmentAdapter extends FragmentPagerAdapter {
//
//        List<Fragment> fragmentList = new ArrayList<Fragment>();
//
//        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
//            super(fm);
//            this.fragmentList = fragmentList;
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return fragmentList.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return fragmentList.size();
//        }
//
//    }
//
//
//    private void changeTextColor(int position) {
//        if (position == 0) {
//            item_weixin.setTextColor(Color.parseColor("#ffffbb33"));
//            item_tongxunlu.setTextColor(Color.parseColor("#000000"));
//            item_faxian.setTextColor(Color.parseColor("#000000"));
////            item_me.setTextColor(Color.parseColor("#000000"));
////            item_daifanhuan.setTextColor(Color.parseColor("#000000"));
////            item_fanhuanzhong.setTextColor(Color.parseColor("#000000"));
//        } else if (position == 1) {
//            item_tongxunlu.setTextColor(Color.parseColor("#ffffbb33"));
//            item_weixin.setTextColor(Color.parseColor("#000000"));
//            item_faxian.setTextColor(Color.parseColor("#000000"));
////            item_me.setTextColor(Color.parseColor("#000000"));
////            item_daifanhuan.setTextColor(Color.parseColor("#000000"));
////            item_fanhuanzhong.setTextColor(Color.parseColor("#000000"));
//
//        } else if (position == 2) {
//            item_faxian.setTextColor(Color.parseColor("#ffffbb33"));
//            item_weixin.setTextColor(Color.parseColor("#000000"));
//            item_tongxunlu.setTextColor(Color.parseColor("#000000"));
////            item_me.setTextColor(Color.parseColor("#000000"));
////            item_daifanhuan.setTextColor(Color.parseColor("#000000"));
////            item_fanhuanzhong.setTextColor(Color.parseColor("#000000"));
//
////        } else if (position == 3) {
////            item_me.setTextColor(Color.parseColor("#ffffbb33"));
////            item_weixin.setTextColor(Color.parseColor("#000000"));
////            item_tongxunlu.setTextColor(Color.parseColor("#000000"));
////            item_faxian.setTextColor(Color.parseColor("#000000"));
////            item_daifanhuan.setTextColor(Color.parseColor("#000000"));
////            item_fanhuanzhong.setTextColor(Color.parseColor("#000000"));
////
////        } else if (position == 4) {
////            item_daifanhuan.setTextColor(Color.parseColor("#ffffbb33"));
////            item_weixin.setTextColor(Color.parseColor("#000000"));
////            item_tongxunlu.setTextColor(Color.parseColor("#000000"));
////            item_faxian.setTextColor(Color.parseColor("#000000"));
////            item_me.setTextColor(Color.parseColor("#000000"));
////            item_fanhuanzhong.setTextColor(Color.parseColor("#000000"));
////
////        } else if (position == 5) {
////            item_fanhuanzhong.setTextColor(Color.parseColor("#ffffbb33"));
////            item_weixin.setTextColor(Color.parseColor("#000000"));
////            item_tongxunlu.setTextColor(Color.parseColor("#000000"));
////            item_faxian.setTextColor(Color.parseColor("#000000"));
////            item_daifanhuan.setTextColor(Color.parseColor("#000000"));
////            item_me.setTextColor(Color.parseColor("#000000"));
//
//        }
//    }











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
        getMenuInflater().inflate(R.menu.main, menu);
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
            Intent intent=new Intent(MainActivity.this,me_tie.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            Intent intent=new Intent(MainActivity.this,me_qianbao.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {
            Intent intent=new Intent(MainActivity.this,me_dingdan.class);
            startActivity(intent);

        } else if (id == R.id.nav_manage) {
            Intent intent=new Intent(MainActivity.this,me_message.class);
            startActivity(intent);
        } /*else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
