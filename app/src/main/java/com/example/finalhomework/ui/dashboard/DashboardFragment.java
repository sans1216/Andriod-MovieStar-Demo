package com.example.finalhomework.ui.dashboard;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.finalhomework.MyViewPagerAdapter;
import com.example.finalhomework.R;
import com.example.finalhomework.ui.home.MyFragmentPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {
    Banner banner;
    List<View> viewList3;
    private ViewPager mViewPager;
    private ViewPager vp_rank;
    private TabLayout mTabLayout;
    MyFragmentPagerAdapter3 myFragmentAdapter;
    private TabLayout.Tab one;
    private TabLayout.Tab two;

    TextView sc13,sc14,sc15,sc16,sc17,sc18;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        banner = root.findViewById(R.id.banner);
        myFragmentAdapter =new MyFragmentPagerAdapter3(getFragmentManager());
        mTabLayout = root.findViewById(R.id.tab_movie);
        mViewPager = root.findViewById(R.id.vp_movie);
        vp_rank = root.findViewById(R.id.mv_rank);
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);

        mViewPager.setAdapter(myFragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        LayoutInflater inflater2 = getLayoutInflater().from(root.getContext());
        View view1 = inflater2.inflate(R.layout.rank1,null);
        View view2 = inflater2.inflate(R.layout.rank2,null);
        View view3 = inflater2.inflate(R.layout.rank3,null);


        viewList3 = new ArrayList<View>();
        viewList3.add(view1);
        viewList3.add(view2);
        viewList3.add(view3);
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view2.getContext(),movieRankActivity.class);
                startActivity(intent);
            }
        });

        vp_rank.setAdapter(new MyViewPagerAdapter(viewList3));

        sc13 = root.findViewById(R.id.sc13);
        sc14 = root.findViewById(R.id.sc14);
        sc15 = root.findViewById(R.id.sc15);
        sc16 = root.findViewById(R.id.sc16);
        sc17 = root.findViewById(R.id.sc17);
        sc18 = root.findViewById(R.id.sc18);
        MyDataBaseHelper_Movie dbHelper = new MyDataBaseHelper_Movie(root.getContext(),"movie_info.db",null,1);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        sc13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("m_name","这个杀手不太冷");
                values.put("intro","里昂（让·雷诺饰）是名孤独的职业杀手，受人雇佣。一天，邻居家小姑娘马蒂尔达（纳塔丽·波特曼饰)敲开他的房门，要求在他那里暂避杀身之祸。原来邻居家的主人是警方缉毒组的眼线，只因贪污了一小包毒品而遭恶警（加里·奥德曼饰）杀害全家的惩罚。马蒂尔达得到里昂的留救，幸免于难，并留在里昂那里。里昂教小女孩使枪，她教里昂法文，两人关系日趋亲密，相处融洽。");
                values.put("date","1994.09.14");
                values.put("poster",R.drawable.hot1);
                values.put("score",9.5);
                db.insert("movie_info",null,values);
                Toast.makeText(v.getContext(),"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });
        sc14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("m_name","千与千寻");
                values.put("intro","千寻和爸爸妈妈一同驱车前往新家，在郊外的小路上不慎进入了神秘的隧道——他们去到了另外一个诡异世界—一个中世纪的小镇。远处飘来食物的香味，爸爸妈妈大快朵颐，孰料之后变成了猪！这时小镇上渐渐来了许多样子古怪、半透明的人。");
                values.put("date","2009.02.23");
                values.put("poster",R.drawable.hot2);
                values.put("score",9.3);
                db.insert("movie_info",null,values);
                Toast.makeText(v.getContext(),"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });
        sc15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("m_name","霸王别姬");
                values.put("intro","段小楼（张丰毅）与程蝶衣（张国荣）是一对打小一起长大的师兄弟，两人一个演生，一个饰旦，一向配合天衣无缝，尤其一出《霸王别姬》，更是誉满京城，为此，两人约定合演一辈子《霸王别姬》。但两人对戏剧与人生关系的理解有本质不同，段小楼深知戏非人生，程蝶衣则是人戏不分。");
                values.put("date","1993.01.01");
                values.put("poster",R.drawable.hot3);
                values.put("score",9.6);
                db.insert("movie_info",null,values);
                Toast.makeText(v.getContext(),"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });
        sc16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("m_name","盗梦空间");
                values.put("intro","道姆·柯布（莱昂纳多·迪卡普里奥 Leonardo DiCaprio 饰）与同事阿瑟（约瑟夫·戈登-莱维特 Joseph Gordon-Levitt 饰）和纳什（卢卡斯·哈斯 Lukas Haas 饰）在一次针对日本能源大亨齐藤（渡边谦 饰）的盗梦行动中失败，反被齐藤利用。");
                values.put("date","2010.09.01");
                values.put("poster",R.drawable.hot4);
                values.put("score",9.3);
                db.insert("movie_info",null,values);
                Toast.makeText(v.getContext(),"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });
        sc17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("m_name","阿甘正传");
                values.put("intro","阿甘（汤姆·汉克斯 饰）于二战结束后不久出生在美国南方阿拉巴马州一个闭塞的小镇，他先天弱智，智商只有75，然而他的妈妈是一个性格坚强的女性，她常常鼓励阿甘“傻人有傻福”，要他自强不息。");
                values.put("date","1994.06.23");
                values.put("poster",R.drawable.hot5);
                values.put("score",9.6);
                db.insert("movie_info",null,values);
                Toast.makeText(v.getContext(),"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });
        sc18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("m_name","我不是药神");
                values.put("intro","普通中年男子程勇（徐峥 饰）经营着一家保健品店，失意又失婚。不速之客吕受益（王传君 饰）的到来，让他开辟了一条去印度买药做“代购”的新事业，虽然困难重重，但他在这条“买药之路”上发现了商机，一发不可收拾地做起了治疗慢粒白血病的印度仿制药独家代理商。");
                values.put("date","2018.07.05");
                values.put("poster",R.drawable.hot6);
                values.put("score",9.0);
                db.insert("movie_info",null,values);
                Toast.makeText(v.getContext(),"收藏成功",Toast.LENGTH_SHORT).show();
            }
        });

        initBanner(banner);
        return root;
    }






    private void initBanner(Banner banner) {

        ArrayList<Integer> imgs = new ArrayList<>();
        imgs.add(R.mipmap.album);
        imgs.add(R.mipmap.album2);
        imgs.add(R.drawable.icon2);

        ArrayList<String> titles = new ArrayList<>();
        titles.add("Thank u,Next");
        titles.add("Lover");
        titles.add("Modern Family");

        banner.setBannerTitles(titles);
        banner.setImages(imgs);
        banner.setDelayTime(1500);
        banner.isAutoPlay(true);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.setBannerAnimation(Transformer.Accordion);
        banner.setImageLoader(new ImageLoadBanner());
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.start();
    }
    class ImageLoadBanner extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            imageView.setImageResource(Integer.parseInt(path.toString()));
        }
    }
}