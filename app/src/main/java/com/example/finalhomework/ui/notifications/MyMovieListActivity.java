package com.example.finalhomework.ui.notifications;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.finalhomework.ui.dashboard.MyDataBaseHelper_Movie;
import com.example.finalhomework.ui.dashboard.bean.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.finalhomework.R;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.listener.SaveListener;

public class MyMovieListActivity extends AppCompatActivity {
    List<movie> movieList = new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_movie_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        MyDataBaseHelper_Movie dbHelper = new MyDataBaseHelper_Movie(this, "movie_info.db", null, 1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql3 = "SELECT * FROM movie_info";
        Cursor cursor = db.rawQuery(sql3, null);
        for (int i = 0; i < cursor.getColumnCount(); i++) {
            if (cursor.moveToPosition(i)) {
                String name1 = cursor.getString(0);
                String intro = cursor.getString(1);
                String date = cursor.getString(2);
                double score = cursor.getDouble(3);
                int poster = cursor.getInt(4);

                movie movie = new movie(name1, intro, date, score, poster);
                movieList.add(movie);

            }
        }
        listView =findViewById(R.id.MyMovieList);
        if (movieList.isEmpty()){
            movie movie1 = new movie("请先添加电影","无","无",0,R.drawable.hot1);
            movieList.add(movie1);
        }else {
            listView.setAdapter(new ListViewAdapter_movie(this,movieList));
        }


    }
    public List<movie> SaveMovieList() {

        return movieList;
    }
}
