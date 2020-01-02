package com.example.finalhomework.ui.home.classify;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.finalhomework.R;
import com.example.finalhomework.ui.home.MyDataBaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


public class home_child_fragment2 extends Fragment {
    ListView listView;
    List<recommend> recommendList = new ArrayList<>();
    FloatingActionButton write;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_child_fragment2, container, false);
        write = view.findViewById(R.id.fab_write);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home_child_fragment2.this.getContext(),write_activity.class);
                startActivity(intent);

            }
        });

        recommendList.add(new recommend("阿宅",R.mipmap.album,"你最喜欢听的歌曲是什么...","<Lover>--Taylor Swift",null,"2019年12月16日"));
        recommendList.add(new recommend("炙烤eri",R.mipmap.album2,"你遇到的有趣验证码","知乎对我的期望有点高.",null,"2019年12月15日"));
        recommendList.add(new recommend("罗拉",R.drawable.icon,"失败厨艺大赛","此刻我们家的烟熏报警器都响了，煮个汤圆也不容易啊.",null,"2019年12月15日"));
        recommendList.add(new recommend("兔几的胡萝卜",R.drawable.icon3,"记录我的周末时光.","周末，太阳，享受自由的时光",null,"2019年12月15日"));
        recommendList.add(new recommend("Moonlight",R.drawable.icon4,"我们该如何与疾病相处？.","怎么能让一个重度抑郁的人开心呢？我是重度抑郁，高一的时候便开始，起初我只是间接性的头疼，耳鸣，心跳加速呼吸困难。失去了所有感觉，不知道别人为什么笑，为什么哭，为什么生气，最基本的情绪都失去了。另外，我觉得这个世界挺好的，只是与我无关。",null,"2019年12月16日"));

        listView = view.findViewById(R.id.rc_listview);
        listView.setAdapter(new ListViewAdapter(view.getContext(),recommendList));
        return view;

    }


}
