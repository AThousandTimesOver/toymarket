package com.example.jmy.toy_me_message;

import android.widget.BaseAdapter;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class luntan2_Adapter extends BaseAdapter {
    private List<Map<String, Object>> data;
    private LayoutInflater layoutInflater;
    private Context context;

    public luntan2_Adapter(Context context, List<Map<String, Object>> data) {
        //传入的data，就是我们要在listview中显示的信息
        this.context = context;
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
    }
    //这里定义了一个类，用来表示一个item里面包含的东西，像我的就是一个imageView和三个TextView，按自己需要来
    public class Info {
        public ImageView image;
        public ImageView image1;
        public TextView tv_teacher_nickname;
        public TextView tv_teacher_name;
        public TextView tv_university;
        public TextView tv_time;
    }
    //所有要返回的数量，Id，信息等，都在data里面，从data里面取就好

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    //跟actvity中的oncreat()差不多，目的就是给item布局中的各个控件对应好，并添加数据
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        luntan2_Adapter.Info info = new luntan2_Adapter.Info();
        convertView = layoutInflater.inflate(R.layout.luntan2_item, null);
        info.image = (ImageView) convertView.findViewById(R.id.imageView_headpic);
        info.image = (ImageView) convertView.findViewById(R.id.imageView_yhheadpic);
        info.tv_teacher_name = (TextView) convertView
                .findViewById(R.id.textView_teacher_name);
        info.tv_teacher_nickname = (TextView) convertView
                .findViewById(R.id.textView_teacher_nickname);
        info.tv_university = (TextView) convertView
                .findViewById(R.id.textview_yhname);
        info.tv_time = (TextView) convertView.findViewById(R.id.textview_time);


        //设置数据
//        info.image.setImageResource((Integer) data.get(position).get("image"));
        info.image.setImageResource((Integer) data.get(position).get("image1"));
        info.tv_teacher_name.setText((String) data.get(position).get(
                "teacher_name"));
        info.tv_teacher_nickname.setText((String) data.get(position).get(
                "teacher_nickname"));
        info.tv_university.setText((String) data.get(position)
                .get("university"));
        info.tv_time.setText((String) data.get(position)
                .get("time"));
        return convertView;
    }
}
