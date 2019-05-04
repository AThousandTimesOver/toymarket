package com.example.jmy.toy_me_message;

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

public class me_dingdan_zulin extends AppCompatActivity implements View.OnClickListener{

    private TextView title, item_weixin, item_tongxunlu, item_faxian, item_me,item_daifanhuan,item_fanhuanzhong;
    private ViewPager vp;
    private One1Fragment oneFragment;
    private Two2Fragment twoFragment;
    private Three3Fragment threeFragment;
    private Four4Fragment fouthFragmen;
    private Five5Fragment fiveFragmen;
    private Six6Fragment sixFragmen;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private FragmentAdapter mFragmentAdapter;

    String[] titles = new String[]{"微信", "通讯录", "发现", "我"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me_dingdan_zulin);
        getSupportActionBar().hide();

        initViews();

        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(), mFragmentList);
        vp.setOffscreenPageLimit(6);//ViewPager的缓存为4帧
        vp.setAdapter(mFragmentAdapter);
        vp.setCurrentItem(0);//初始设置ViewPager选中第一帧
        item_weixin.setTextColor(Color.parseColor("#FFFFBB33"));

        //ViewPager的监听事件
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                /*此方法在页面被选中时调用*/
                //
                // title.setText(titles[position]);
                changeTextColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                /*此方法是在状态改变的时候调用，其中arg0这个参数有三种状态（0，1，2）。
                arg0 ==1的时辰默示正在滑动，
                arg0==2的时辰默示滑动完毕了，
                arg0==0的时辰默示什么都没做。*/
            }
        });

    }

    public void onFragmentInteraction(Uri uri) {
        Log.e("Debug", "-------------10");
    }

    /**
     * 初始化布局View
     */
    private void initViews() {
        //title = (TextView) findViewById(R.id.title);
        item_weixin = (TextView) findViewById(R.id.item_weixin);
        item_tongxunlu = (TextView) findViewById(R.id.item_tongxunlu);
        item_faxian = (TextView) findViewById(R.id.item_faxian);
        item_me = (TextView) findViewById(R.id.item_me);
        item_daifanhuan = (TextView) findViewById(R.id.item_daifanhuan);
        item_fanhuanzhong = (TextView) findViewById(R.id.item_fanhuanzhong);


        item_weixin.setOnClickListener(this);
        item_tongxunlu.setOnClickListener(this);
        item_faxian.setOnClickListener(this);
        item_me.setOnClickListener(this);
        item_daifanhuan.setOnClickListener(this);
        item_fanhuanzhong.setOnClickListener(this);


        vp = (ViewPager) findViewById(R.id.mainViewPager);
        oneFragment = new One1Fragment();
        twoFragment = new Two2Fragment();
        threeFragment = new Three3Fragment();
        fouthFragmen = new Four4Fragment();
        fiveFragmen = new Five5Fragment();
        sixFragmen = new Six6Fragment();

        //给FragmentList添加数据
        mFragmentList.add(oneFragment);
        mFragmentList.add(twoFragment);
        mFragmentList.add(threeFragment);
        mFragmentList.add(fouthFragmen);
        mFragmentList.add(fiveFragmen);
        mFragmentList.add(sixFragmen);
    }

    /**
     * 点击底部Text 动态修改ViewPager的内容
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_weixin:
                vp.setCurrentItem(0, true);
                break;
            case R.id.item_tongxunlu:
                vp.setCurrentItem(1, true);
                break;
            case R.id.item_faxian:
                vp.setCurrentItem(2, true);
                break;
            case R.id.item_me:
                vp.setCurrentItem(3, true);
                break;
            case R.id.item_daifanhuan:
                vp.setCurrentItem(4, true);
                break;
            case R.id.item_fanhuanzhong:
                vp.setCurrentItem(5, true);
                break;
        }
    }

    public class FragmentAdapter extends FragmentPagerAdapter {

        List<Fragment> fragmentList = new ArrayList<Fragment>();

        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

    }

    /*
     *由ViewPager的滑动修改底部导航Text的颜色
     */
    private void changeTextColor(int position) {
        if (position == 0) {
            item_weixin.setTextColor(Color.parseColor("#ffffbb33"));
            item_tongxunlu.setTextColor(Color.parseColor("#000000"));
            item_faxian.setTextColor(Color.parseColor("#000000"));
            item_me.setTextColor(Color.parseColor("#000000"));
            item_daifanhuan.setTextColor(Color.parseColor("#000000"));
            item_fanhuanzhong.setTextColor(Color.parseColor("#000000"));
        } else if (position == 1) {
            item_tongxunlu.setTextColor(Color.parseColor("#ffffbb33"));
            item_weixin.setTextColor(Color.parseColor("#000000"));
            item_faxian.setTextColor(Color.parseColor("#000000"));
            item_me.setTextColor(Color.parseColor("#000000"));
            item_daifanhuan.setTextColor(Color.parseColor("#000000"));
            item_fanhuanzhong.setTextColor(Color.parseColor("#000000"));

        } else if (position == 2) {
            item_faxian.setTextColor(Color.parseColor("#ffffbb33"));
            item_weixin.setTextColor(Color.parseColor("#000000"));
            item_tongxunlu.setTextColor(Color.parseColor("#000000"));
            item_me.setTextColor(Color.parseColor("#000000"));
            item_daifanhuan.setTextColor(Color.parseColor("#000000"));
            item_fanhuanzhong.setTextColor(Color.parseColor("#000000"));

        } else if (position == 3) {
            item_me.setTextColor(Color.parseColor("#ffffbb33"));
            item_weixin.setTextColor(Color.parseColor("#000000"));
            item_tongxunlu.setTextColor(Color.parseColor("#000000"));
            item_faxian.setTextColor(Color.parseColor("#000000"));
            item_daifanhuan.setTextColor(Color.parseColor("#000000"));
            item_fanhuanzhong.setTextColor(Color.parseColor("#000000"));

        } else if (position == 4) {
            item_daifanhuan.setTextColor(Color.parseColor("#ffffbb33"));
            item_weixin.setTextColor(Color.parseColor("#000000"));
            item_tongxunlu.setTextColor(Color.parseColor("#000000"));
            item_faxian.setTextColor(Color.parseColor("#000000"));
            item_me.setTextColor(Color.parseColor("#000000"));
            item_fanhuanzhong.setTextColor(Color.parseColor("#000000"));

        } else if (position == 5) {
            item_fanhuanzhong.setTextColor(Color.parseColor("#ffffbb33"));
            item_weixin.setTextColor(Color.parseColor("#000000"));
            item_tongxunlu.setTextColor(Color.parseColor("#000000"));
            item_faxian.setTextColor(Color.parseColor("#000000"));
            item_daifanhuan.setTextColor(Color.parseColor("#000000"));
            item_me.setTextColor(Color.parseColor("#000000"));

        }
    }
}
