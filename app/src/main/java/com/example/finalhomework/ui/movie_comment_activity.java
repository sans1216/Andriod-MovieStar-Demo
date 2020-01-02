package com.example.finalhomework.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalhomework.MyDataBaseHelper_comment;
import com.example.finalhomework.R;
import com.example.finalhomework.ui.dashboard.Movie1Activity;

public class movie_comment_activity extends AppCompatActivity {
TextView title,content,score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_comment);
        title = findViewById(R.id.rcw_title);
        content = findViewById(R.id.rcw_content);
        score = findViewById(R.id.rcw_score);

        MyDataBaseHelper_comment dbHelper = new MyDataBaseHelper_comment(this,"comment_info",null,1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        TextView send = findViewById(R.id.rcw_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("title",title.getText().toString());
                values.put("content",content.getText().toString());
                values.put("score",Double.valueOf(score.getText().toString()));
                values.put("icon",R.drawable.icon);
                values.put("username","sans");
                db.insert("comment_info",null,values);
                Toast.makeText(v.getContext(),"发布成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(movie_comment_activity.this, Movie1Activity.class);
                startActivity(intent);
            }
        });
    }
}
