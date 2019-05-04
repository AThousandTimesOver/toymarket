package com.example.jmy.toy_me_message;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import android.graphics.Picture;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Edittiezi2Activity extends AppCompatActivity{

    private GridView gridView;
    private Button fabu;
    private  blogDB blogDB;
    private EditText title;
    private TextView author;
    private TextView time;
    private EditText context;
    int index=0;


    private int[] images=new int[]{
            R.drawable.plus,R.drawable.ic_menu_camera,R.drawable.hamleys,
            R.drawable.hjdzn,R.drawable.side_nav_bar,R.drawable.ic_menu_share,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittiezi2);
        gridView=(GridView)findViewById(R.id.gridView1);
        Picture1Adapter adapter=new Picture1Adapter(images,this);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?>parent,View v,int position,long id){
                Toast.makeText(Edittiezi2Activity.this,"pic"+(position+1),Toast.LENGTH_SHORT).show();
            }
        });

        blogDB = new blogDB(this);
        Calendar calendar = Calendar.getInstance();
        title = (EditText) this.findViewById(R.id.add_content1);
        //author = (TextView) this.findViewById(R.id.textView7);
        //time = (TextView) this.findViewById(R.id.textView8);
        context = (EditText) this.findViewById(R.id.add_content);
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH)+1;
        final int day = calendar.get(Calendar.DAY_OF_MONTH);


        fabu=(Button) findViewById(R.id.button1);
        fabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
//                blogDB.drop();
                blogDB.create();
//                blogDB.deleteall();
//                blogDB.delete(2);
                blogDB.insert(index,title.getText().toString(),year+"年"+month+"月"+day+"日","玩具女孩",context.getText().toString());
                blogDB.select();

                Intent intent = new Intent();
                intent.setClass(Edittiezi2Activity.this,luntan2.class);
                startActivity(intent);
            }
        });
    }
}
class Picture1Adapter extends BaseAdapter{
    private LayoutInflater inflater;
    private List<Picture11>pictures;
    public Picture1Adapter(int[] images,Context context){
        super();
        pictures=new ArrayList<Picture11>();
        inflater=LayoutInflater.from(context);
        for (int i=0;i<images.length;i++){
            Picture11 picture=new Picture11(images[i]);
            pictures.add(picture);
        }
    }
    @Override
    public int getCount(){
        if(null!=pictures){
            return pictures.size();
        }
        else {
            return 0;
        }
    }
    @Override
    public Object getItem(int position){
        return pictures.get(position);
    }
    @Override
    public long getItemId(int position){
        return position;
    }
    @Override
    public View getView(int position,View convertView,ViewGroup parent){
        ViewHolder viewHolder;
        if(convertView == null){
            convertView=inflater.inflate(R.layout.picture_item,null);
            viewHolder=new ViewHolder();
            viewHolder.image=(ImageView)convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.image.setImageResource(pictures.get(position).getImageID());
        return convertView;
    }
}
class ViewHolder{
    public ImageView image;
}
class Picture11{
    private int imageID;
    public Picture11(){
        super();
    }
    public Picture11(int imageID){
        super();
        this.imageID=imageID;
    }
    public int getImageID(){
        return imageID;
    }
    public void setImageID(int imageID){
        this.imageID=imageID;
    }
}
