package com.example.jmy.toy_me_message;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Tiezi2Activity extends AppCompatActivity {

    private  shoucangDB shoucangDB;
    private  blogDB blogDB;
    private Cursor myCursor;
    private ListView myListView;
    private EditText myEditText;
    private Button myButton;
    private TextView myButton1;
    private int _id;
    private TextView title;
    private TextView author;
    private TextView time;
    private TextView context;
    int index=0;
    private ImageView handImage,shoucangImage;
    private TextView zannum,shoucangnum;
    private Animation animation;

    boolean isChanged = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiezi2);
        getSupportActionBar().hide();


        title = (TextView) this.findViewById(R.id.textView_teacher_nickname);
        author = (TextView) this.findViewById(R.id.textView7);
        time = (TextView) this.findViewById(R.id.textView8);
        context = (TextView) this.findViewById(R.id.textView10);
        myButton = (Button) this.findViewById(R.id.guanzhubutton);


        handImage = (ImageView) findViewById(R.id.zan_img);
        shoucangImage = (ImageView) findViewById(R.id.shoucan_img);
        zannum=(TextView) findViewById(R.id.zan_num) ;
        shoucangnum=(TextView) findViewById(R.id.shoucan_num) ;
        animation = AnimationUtils.loadAnimation(this,R.anim.welcome_loading);


        Intent intent =getIntent();
        //getXxxExtra方法获取Intent传递过来的数据
        final Blog b = (Blog) intent.getSerializableExtra("b");

        shoucangDB = new shoucangDB(this);
        blogDB = new blogDB(this);

        title.setText(b.title);
        author.setText(b.author);
        time.setText(b.time);
        context.setText(b.context);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                shoucangDB.create();
//                shoucangDB.drop();
//                shoucangDB.deleteall();
//                for (int i=1;i<11;i++){
//                    shoucangDB.delete(i);
//                }
//                shoucangDB.deleteAll();
//                shoucangDB.insert(index,b._id);
                shoucangDB.select();
            }
        });

        context.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                blogDB.create();
//                shoucangDB.drop();
//                shoucangDB.deleteall();
//                blogDB.delete(4);
//                for (int i=1;i<11;i++){
//                    shoucangDB.delete(i);
//                }
//                shoucangDB.deleteAll();
//                blogDB.insert(index,title.getText().toString(),time.getText().toString(),author.getText().toString(),context.getText().toString());
                blogDB.select();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent =getIntent();
        //getXxxExtra方法获取Intent传递过来的数据
        final Blog b = (Blog) intent.getSerializableExtra("b");

        if(shoucangDB.ifhavesc(b._id)==0){
            shoucangnum.setText(0 + "");
            shoucangImage.setImageDrawable(getResources().getDrawable(R.drawable.bstar));
        }else{
            shoucangnum.setText(1 + "");
            shoucangImage.setImageDrawable(getResources().getDrawable(R.drawable.ystar));
        }
        handImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(v == handImage) {
                    if(isChanged){
                        zannum.setText(0 + "");
                        handImage.setImageDrawable(getResources().getDrawable(R.drawable.bheart));
                    }else {
                        Log.i("debug", "click");
                        handImage.startAnimation(animation);
                        handImage.setImageDrawable(getResources().getDrawable(R.drawable.reheart));
                        zannum.setText(1 + "");
                    }
                    isChanged = !isChanged;
                }
            }
        });
        shoucangImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(v == shoucangImage) {
                    if(shoucangDB.ifhavesc(b._id)==0){
                        shoucangnum.setText(1 + "");
                        shoucangImage.startAnimation(animation);
                        shoucangImage.setImageDrawable(getResources().getDrawable(R.drawable.ystar));
                        shoucangDB.insert(b._id);
                        //改ort=1;收藏数据库
                    }else {
                        Log.i("debug", "click");

                        shoucangImage.setImageDrawable(getResources().getDrawable(R.drawable.bstar));
                        shoucangnum.setText(0 + "");
                        shoucangDB.delete(b._id);

                        //    ort=0;删除数据库；
                    }
                }
            }
        });
    }

}
