package com.example.finalhomework.ui.dashboard;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.DrawableRes;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalhomework.MyViewPagerAdapter;
import com.example.finalhomework.R;
import com.example.finalhomework.ui.home.MyDataBaseHelper;

import java.util.ArrayList;


public class movie_fragment1 extends Fragment  {
    TextView sc1,sc2,sc3,sc4,sc5,sc6;
    ImageView m1,m2;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_fragment1, container, false);
        m1 = view.findViewById(R.id.m1);
        sc1 = view.findViewById(R.id.sc1);
        sc2 = view.findViewById(R.id.sc2);
        sc3 = view.findViewById(R.id.sc3);
        sc4 = view.findViewById(R.id.sc4);
        sc5 = view.findViewById(R.id.sc5);
        sc6 = view.findViewById(R.id.sc6);
        MyDataBaseHelper_Movie dbHelper = new MyDataBaseHelper_Movie(view.getContext(),"movie_info.db",null,1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        m1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),Movie1Activity.class);
                startActivity(intent);
            }
        });
        sc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("m_name","南方车站的聚会");
                values.put("intro","《南方车站的聚会》是由和力辰光国际文化传媒股份有限公司出品的剧情片，由刁亦男执导，胡歌、桂纶镁领衔主演，廖凡、万茜特别出演。该片于2019年5月18日在戛纳电影节首映。");
                values.put("date","2019.12.04");
                values.put("poster",R.drawable.m1);
                values.put("score",7.5);
                db.insert("movie_info",null,values);
                Toast.makeText(v.getContext(),"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });

        sc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("m_name","小丑");
                values.put("intro","电影《小丑》以同名DC漫画角色为基础，由华纳兄弟影业公司发行，计划于2019年10月4日上映。本片的故事将独立于DCEU之外，故事背景设置在20世纪80年代，讲述了一位生活陷入困境的脱口秀喜剧演员渐渐走向精神的崩溃，在哥谭市开始了疯狂的犯罪生涯，最终成为了蝙蝠侠的宿敌“小丑”的故事。");
                values.put("date","2019.8.31");
                values.put("poster",R.drawable.m2);
                values.put("score",8.8);
                db.insert("movie_info",null,values);
                Toast.makeText(v.getContext(),"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });

        sc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("m_name","少年的你");
                values.put("intro","陈念（周冬雨 饰）是一名即将参加高考的高三学生，同校女生胡晓蝶（张艺凡 饰）的跳楼自杀让她的生活陷入了困顿之中。胡晓蝶死后，陈念遭到了以魏莱（周也 饰）为首的三人组的霸凌，魏莱虽然表面上看来是乖巧的优等生，实际上却心思毒辣，胡晓蝶的死和她有着千丝万缕的联系。");
                values.put("date","2019.10.25");
                values.put("poster",R.drawable.m3);
                values.put("score","8.3");
                db.insert("movie_info",null,values);
                Toast.makeText(v.getContext(),"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });
        sc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("m_name","爱尔兰人");
                values.put("intro","《爱尔兰人》为马丁·斯科塞斯执导的传奇巨制，罗伯特·德尼罗、阿尔·帕西诺和乔·佩西主演。通过二战老兵弗兰克·希兰的视角，讲述了战后美国有组织犯罪的故事。弗兰克·希兰是一名骗子和杀手，曾经在 20 世纪最恶名昭彰的人物身边工作。该电影跨越数十年，记录了美国历史上最大的悬案之一，即传奇工会领袖吉米·霍法失踪案，以宏大的故事之旅，展现有组织犯罪的隐秘通道：其内部运作、仇敌以及与主流政治的瓜葛。");
                values.put("date","2019.11.27");
                values.put("poster",R.drawable.m4);
                values.put("score",9.0);
                db.insert("movie_info",null,values);
                Toast.makeText(v.getContext(),"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });
        sc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("m_name","海上钢琴师");
                values.put("intro","1900年，Virginian号豪华邮轮上，一个孤儿被遗弃在头等舱，由船上的水手抚养长大，取名1900（蒂姆•罗斯 饰）。1900慢慢长大，显示出了无师自通的非凡钢琴天赋，在船上的乐队表演钢琴，每个听过他演奏的人，都被深深打动。爵士乐鼻祖杰尼听说了1900的高超技艺，专门上船和他比赛，最后自叹弗如，黯然离去。");
                values.put("date","2019.11.15");
                values.put("poster",R.drawable.m5);
                values.put("score",9.3);
                db.insert("movie_info",null,values);
                Toast.makeText(v.getContext(),"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });
        sc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("m_name","利刃出鞘");
                values.put("intro","　富豪小说家哈兰·斯隆比在自己85岁生日第二天，被发现在自家庄园离奇自杀，遗留了亿万遗产。久负盛名的大侦探布兰科（丹尼尔·克雷格饰）突然被匿名人士雇佣调查此案真相。同时，哈兰的孙子兰森（克里斯·埃文斯饰）也正在秘密调查此案。当布兰科和哈兰·斯隆比家族的其他人对谈时， 他发现事情并没有想象中那么简单。");
                values.put("date","2019.11.15");
                values.put("poster",R.drawable.m6);
                values.put("score",8.3);
                db.insert("movie_info",null,values);
                Toast.makeText(v.getContext(),"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });
        return view;

    }
}
