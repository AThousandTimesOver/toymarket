package com.example.jmy.toy_me_message;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class goumai_yifu_Adapter extends BaseAdapter {
    private List<Map<String, Object>> data;
    private LayoutInflater layoutInflater;
    private Context context;

    public goumai_yifu_Adapter(Context context, List<Map<String, Object>> data) {
        //传入的data，就是我们要在listview中显示的信息
        this.context = context;
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
    }
    //这里定义了一个类，用来表示一个item里面包含的东西，像我的就是一个imageView和三个TextView，按自己需要来
    public class Info {
        public ImageView image;
        public TextView tv_gongsi;
        public TextView tv_wupinming;
        public TextView tv_dangejiaqian;
        public TextView tv_geshu;
        public TextView tv_state;
        public TextView tv_zongjiage;

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
        goumai_yifu_Adapter.Info info = new goumai_yifu_Adapter.Info();
        convertView = layoutInflater.inflate(R.layout.goumai_yifu_item, null);
        info.image = (ImageView) convertView.findViewById(R.id.imageView_headpic2);
        info.tv_gongsi = (TextView) convertView
                .findViewById(R.id.textView_ID_nickname);
        info.tv_dangejiaqian = (TextView) convertView
                .findViewById(R.id.textView_teacher_name);
        info.tv_wupinming = (TextView) convertView
                .findViewById(R.id.textView_teacher_nickname);
        info.tv_geshu = (TextView) convertView
                .findViewById(R.id.textView_university);
        info.tv_state = (TextView) convertView
                .findViewById(R.id.textView_ID_state);
        info.tv_zongjiage = (TextView) convertView
                .findViewById(R.id.textView_zongjiage);

        //设置数据
        info.image.setImageResource((Integer) data.get(position).get("image"));
        info.tv_gongsi.setText((String) data.get(position).get(
                "ID_name"));
        info.tv_dangejiaqian.setText((String) data.get(position).get(
                "teacher_name"));
        info.tv_wupinming.setText((String) data.get(position).get(
                "teacher_nickname"));
        info.tv_geshu.setText((String) data.get(position)
                .get("university"));
        info.tv_state.setText((String) data.get(position)
                .get("state"));
        info.tv_zongjiage.setText((String) data.get(position)
                .get("zongjiage"));
        return convertView;
    }
}
