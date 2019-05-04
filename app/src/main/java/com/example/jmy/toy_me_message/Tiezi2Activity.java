package com.example.jmy.toy_me_message;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tiezi2Activity extends AppCompatActivity {

    private  shoucangDB shoucangDB;
    private  blogDB blogDB;
    private TextView title;
    private TextView author;
    private TextView time;
    private TextView context;
    private Button myButton;
    int index=0;


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


        shoucangDB = new shoucangDB(this);
        blogDB = new blogDB(this);


        Intent intent =getIntent();
        //getXxxExtra方法获取Intent传递过来的数据
        final Blog b = (Blog) intent.getSerializableExtra("b");

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


    }

}
