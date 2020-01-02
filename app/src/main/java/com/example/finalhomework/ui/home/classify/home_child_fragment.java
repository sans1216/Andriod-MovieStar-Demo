package com.example.finalhomework.ui.home.classify;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalhomework.MyViewPagerAdapter;
import com.example.finalhomework.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class home_child_fragment extends Fragment {
    Banner banner;
    ViewPager rc_viewPager;
    View view1,view2,view3,view4;
    private List<View> viewList2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_child_fragment, container, false);



        rc_viewPager = view.findViewById(R.id.rc_viewPager);
        LayoutInflater inflater2 = getLayoutInflater().from(view.getContext());
        view1 = inflater2.inflate(R.layout.fragment_topic1,null);
        view2 = inflater2.inflate(R.layout.fragment_topic2,null);
        view3 = inflater2.inflate(R.layout.fragment_topic3,null);
        view4 = inflater2.inflate(R.layout.fragment_topic4,null);


        TextView tv1 = view1.findViewById(R.id.btn_topic1);
        TextView tv2 = view2.findViewById(R.id.btn_topic2);
        TextView tv3 = view3.findViewById(R.id.btn_topic3);
        TextView tv4 = view4.findViewById(R.id.btn_topic4);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),write_activity.class);
                startActivity(intent);
            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),write_activity.class);
                startActivity(intent);
            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),write_activity.class);
                startActivity(intent);
            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),write_activity.class);
                startActivity(intent);
            }
        });
        viewList2 = new ArrayList<View>();
        viewList2.add(view1);
        viewList2.add(view2);
        viewList2.add(view3);
        viewList2.add(view4);

        rc_viewPager.setAdapter(new MyViewPagerAdapter(viewList2));
        return view;

    }


}
