package com.example.jmy.toy_me_message;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.service.autofill.Transformation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class TieziActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_tiezi);
        getSupportActionBar().hide();

        myButton = (Button) this.findViewById(R.id.guanzhubutton);
        title = (TextView) this.findViewById(R.id.textView_teacher_nickname);
        author = (TextView) this.findViewById(R.id.textView7);
        time = (TextView) this.findViewById(R.id.textView8);
        context = (TextView) this.findViewById(R.id.textView10);
        myButton1 = (TextView) this.findViewById(R.id.textView11);

        handImage = (ImageView) findViewById(R.id.zan_img);
        shoucangImage = (ImageView) findViewById(R.id.shoucan_img);
        zannum=(TextView) findViewById(R.id.zan_num) ;
        shoucangnum=(TextView) findViewById(R.id.shoucan_num) ;
        animation = AnimationUtils.loadAnimation(this,R.anim.welcome_loading);





        myListView = (ListView) this.findViewById(R.id.shoucanglist);



        Intent intent =getIntent();
        //getXxxExtra方法获取Intent传递过来的数据
        final Blog b = (Blog) intent.getSerializableExtra("b");

        shoucangDB = new shoucangDB(this);
        blogDB = new blogDB(this);
//        myCursor = shoucangDB.select();

        myButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                blogDB.create();
//                shoucangDB.drop();
//                shoucangDB.deleteall();
//                for (int i=1;i<11;i++){
//                    shoucangDB.delete(i);
//                }
//                shoucangDB.deleteAll();
                blogDB.insert(index,title.getText().toString(),time.getText().toString(),author.getText().toString(),context.getText().toString());
                blogDB.select();
            }
        });

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




    }


    @Override
    protected void onResume() {
        super.onResume();
        Intent intent =getIntent();
        //getXxxExtra方法获取Intent传递过来的数据
        final Blog b = (Blog) intent.getSerializableExtra("b");

        handImage.setOnClickListener(new OnClickListener() {
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
        shoucangImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(v == shoucangImage) {
                    if(isChanged){
                        shoucangnum.setText(0 + "");
                        shoucangImage.setImageDrawable(getResources().getDrawable(R.drawable.bstar));
                    }else {
                        Log.i("debug", "click");
                        shoucangImage.startAnimation(animation);
                        shoucangImage.setImageDrawable(getResources().getDrawable(R.drawable.ystar));
                        shoucangnum.setText(1 + "");
                    }
                    isChanged = !isChanged;
                }
            }
        });
    }



}
