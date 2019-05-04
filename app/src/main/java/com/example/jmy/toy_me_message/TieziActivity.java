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
                shoucangDB.insert(index,b._id);
                shoucangDB.select();
            }
        });








    }
}
