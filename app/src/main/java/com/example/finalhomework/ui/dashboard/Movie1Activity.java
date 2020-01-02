package com.example.finalhomework.ui.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.finalhomework.MyDataBaseHelper_comment;
import com.example.finalhomework.MyViewPagerAdapter;
import com.example.finalhomework.R;
import com.example.finalhomework.ui.dashboard.bean.comment;
import com.example.finalhomework.ui.home.classify.ListViewAdapter;
import com.example.finalhomework.ui.home.classify.recommend;
import com.example.finalhomework.ui.home.classify.write_activity;
import com.example.finalhomework.ui.movie_comment_activity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Movie1Activity extends AppCompatActivity {
    ViewPager vp_actor;
    View view1,view2,view3,view4,view5,view6;
    List<View> viewList2;
    List<comment> commentList = new ArrayList<>();
    FloatingActionButton mc_write;
    ImageView btn_back;
    Double score;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie1);
        videoView = findViewById(R.id.videoView);
        mc_write = findViewById(R.id.mc_write);
        btn_back = findViewById(R.id.btn_back);
        mc_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Movie1Activity.this, movie_comment_activity.class);
                startActivity(intent);
            }
        });

        String uri = "android.resource://" + getPackageName() + "/" + R.raw.video;
        videoView.setVideoURI(Uri.parse(uri));

        videoView.setMediaController(new MediaController(this));

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.i("tag", "--------------视频准备完毕,可以进行播放.......");
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.i("tag", "------------------视频播放完毕..........");
                /**播放完成时，再次循环播放*/
                videoView.start();
            }
        });

        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Log.i("tag", "---------------------视频播放失败...........");
                return false;
            }
        });

        videoView.start();


        LayoutInflater inflater2 = getLayoutInflater().from(this);

        vp_actor = findViewById(R.id.vp_actor);
        view1 = inflater2.inflate(R.layout.actor1,null);
        view2 = inflater2.inflate(R.layout.actor2,null);
        view3 = inflater2.inflate(R.layout.actor3,null);
        view4 = inflater2.inflate(R.layout.actor4,null);
        view5 = inflater2.inflate(R.layout.actor5,null);
        view6 = inflater2.inflate(R.layout.actor6,null);
        viewList2 = new ArrayList<View>();
        viewList2.add(view1);
        viewList2.add(view2);
        viewList2.add(view3);
        viewList2.add(view4);
        viewList2.add(view5);
        viewList2.add(view6);

        vp_actor.setAdapter(new MyViewPagerAdapter(viewList2));

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Movie1Activity.this.finish();
            }
        });
        MyDataBaseHelper_comment dbHelper = new MyDataBaseHelper_comment(this,"comment_info",null,1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM comment_info";
        Cursor cursor = db.rawQuery(sql, null);
        for (int i = 0; i < cursor.getColumnCount(); i++) {
            if (cursor.moveToPosition(i)) {
                String nickname1 = cursor.getString(0);
                String title  = cursor.getString(1);
                String content1 = cursor.getString(2);
                double score = cursor.getDouble(3);
                int icon = cursor.getInt(3);
                comment comment = new comment(nickname1,title,content1,score,icon );
                commentList.add(comment);


            }
        }
        String sql2 = "SELECT score FROM comment_info WHERE username = 'sans'";
//        ContentValues values = new ContentValues();
//        values.put("title","南方车站的聚会");
//        values.put("content","《南方车站的聚会》是由和力辰光国际文化传媒股份有限公司出品的剧情片，由刁亦男执导，胡歌、桂纶镁领衔主演，廖凡、万茜特别出演。该片于2019年5月18日在戛纳电影节首映。");
//        values.put("score","0");
//        values.put("icon",R.drawable.icon);
//        values.put("username","Sans");
//        db.insert("movie_info",null,values);


        Cursor cursor2 = db.rawQuery(sql2, null);
        cursor2.moveToPosition(0);
        if (cursor2.getCount()==0) {
            score = 0.0;

        }else {
            score = cursor2.getDouble(0);
        }
        TextView myScore = findViewById(R.id.MyScore);
        myScore.setText(String.valueOf(score));



        ListView lv = findViewById(R.id.lv_movie_comments);

            comment comment1 = new comment("阿迪斯","还可以","对于国内观众或许是一次挑战，但对于雷弗恩粉丝来讲，这种视觉系的视听和留白的叙事正好符合我的节奏，手部特写借鉴布列松，追踪戏看出《M就是凶手》，潮湿黑暗的环境和紧窄的巷道也是黑色电影的元素传承，另外还贡献了几场华语电影少有的情欲戏和斩杀戏。",7.1,R.drawable.icon4);
            comment comment2 = new comment("倪太红","啊","电影没有沉浸在传统中国电影模式中，在美学上有创新。也被角色吸引，胡歌作为电影新人这份答卷交得不错。",7.6,R.drawable.icon3);

            Log.d("icon_info",String.valueOf(comment1.getIcon()));

            commentList.add(comment1);
            commentList.add(comment2);
            lv.setAdapter(new ListViewAdapter_comments(this, commentList));

        }

}
