package com.example.finalhomework.ui.dashboard;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalhomework.R;


public class movie_fragment2 extends Fragment {
    TextView sc7,sc8,sc9,sc10,sc11,sc12;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_fragment2, container, false);
        sc7 = view.findViewById(R.id.sc7);
        sc8 = view.findViewById(R.id.sc8);
        sc9 = view.findViewById(R.id.sc9);
        sc10 = view.findViewById(R.id.sc10);
        sc11 = view.findViewById(R.id.sc11);
        sc12 = view.findViewById(R.id.sc12);
        MyDataBaseHelper_Movie dbHelper = new MyDataBaseHelper_Movie(view.getContext(),"movie_info.db",null,1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        sc7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("m_name","星球大战9：天行者崛起 ");
                values.put("intro","本片为2017年电影《星球大战：最后的绝地武士》的续集，“星球大战后传三部曲”的第三部作品，同时是“天行者传奇”的第九部作品以及最终章。在卢克·天行者化为绝地英灵的一年后，残存的抵抗势力将再次面对第一秩序。同时，绝地和西斯之间的大战将天行者的传奇带到最后。");
                values.put("date","2019.12.18上映");
                values.put("poster",R.drawable.um1);
                values.put("score",7.4);
                db.insert("movie_info",null,values);
                Toast.makeText(v.getContext(),"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });

        sc8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("m_name","若能与你共乘海浪之上");
                values.put("intro","　夏天、阳光，沙滩、海浪，青年消防员雏罂粟港和爱好冲浪的向水日菜子相遇并迅速展开热恋。看似命中注定的这对恋人，却不幸遭遇生死别离。无法接受港已经离世的雏子，某天突然发现，只要唱起属于两个人的那首歌，港就会从水中出现……");
                values.put("date","2019.12.07上映");
                values.put("poster",R.drawable.um2);
                values.put("score",7.3);
                db.insert("movie_info",null,values);
                Toast.makeText(v.getContext(),"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });

        sc9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("m_name","天·火");
                values.put("intro","天火岛美得如同世外桃源，几乎让人忘记它位于“Ring of Fire”——全球知名的环太平洋火山带。年轻的地质学家李晓梦为了研发首个火山监测系统“朱雀”，带着团队来到了这里。李晓梦的父亲、隐退多年的火山专家李文涛得知后赶到火山口，力图劝说她离开。与此同时，探险专家正楠在美轮美奂的水下溶洞潜水，准备给女友佳慧一个浪漫的求婚……");
                values.put("date","2019.12.12上映");
                values.put("poster",R.drawable.um3);
                values.put("score",4.7);
                db.insert("movie_info",null,values);
                Toast.makeText(v.getContext(),"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });
        sc10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("m_name","星际探索");
                values.put("intro","地球上接连出现神秘怪象，科学家发现某种失控的反物质反应正在威胁整个太阳系，人类生存极度堪忧……地球生死攸关之际，天才航天工程师罗伊（布拉德·皮特 饰）被派往外太空，试图揭开谜团拯救人类。这是一场横跨地球、月球、火星、海王星，穿越整个太阳系的硬核冒险，一路危机重重险象环生，罗伊直面爆炸、陨石、月球飙车枪战、神秘生物等意想不到的考验，还找回了失联20年的父亲！");
                values.put("date","2019.12.05上映");
                values.put("poster",R.drawable.um4);
                values.put("score",7.0);
                db.insert("movie_info",null,values);
                Toast.makeText(v.getContext(),"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });
        sc11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("m_name","教授与疯子");
                values.put("intro","　影片故事根据真实事件改编，詹姆斯·默里博士（梅尔·吉布森饰演）领导下的编委会要进行新版本的《牛津英语字典》的编辑，以当时的人力科技水平，完成字典的编撰要一个世纪才能完成，詹姆斯·默里博士开创性的采用了全民参与的方式，让全英使用英语的人一起为字典收集词条定义，并通过寄信的方式发送给编撰组。");
                values.put("date","2019.12.24上映");
                values.put("poster",R.drawable.um5);
                values.put("score",7.5);
                db.insert("movie_info",null,values);
                Toast.makeText(v.getContext(),"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });
        sc12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("m_name","Micc Americana");
                values.put("intro","您已读过头条，听过传闻，而现在她将用红唇唱出真相。泰勒·斯威夫特将赠予全世界观众近距离观赏“泰勒·斯威夫特的名誉体育场巡回演唱会”在美国最后一场表演的机会，该巡回演唱会是美国历史以来销售额最高的巡演，现在仅在 Netflix 上放映！这部传奇的演唱会电影将展示火焰特技、烟花、数个场景以及 63 英尺的眼镜蛇卡林。《泰勒·斯威夫特的名誉体育场巡回演唱会》将从 12 月 31 日起在 Netflix 上面向全球上线，您可以随处观看这场销售一空并囊括 6 万人的表演——无论是在家庭聚会上，东区的酒吧里，还是在沙发上和猫一起看。无论如何，这都将是一个最佳的新年夜计划。你准备好了吗？");
                values.put("date","2019.12.31");
                values.put("poster",R.drawable.m5);
                values.put("score",9.3);
                db.insert("movie_info",null,values);
                Toast.makeText(v.getContext(),"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });
        return view;

    }
}
