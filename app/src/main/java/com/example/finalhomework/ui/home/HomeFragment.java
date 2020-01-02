package com.example.finalhomework.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;


import com.example.finalhomework.ui.home.classify.ListViewAdapter;
import com.example.finalhomework.ui.home.classify.recommend;
import com.google.android.material.tabs.TabLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.ViewModelProviders;


import com.example.finalhomework.R;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private String context="xxxxxxxxxxxxx";
    private TextView mTextView;
    //要显示的页面
    private int FragmentPage;
 //   private HomeViewModel homeViewModel;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    MyFragmentPagerAdapter myFragmentAdapter;
    private TabLayout.Tab one;
    private TabLayout.Tab two;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //homeViewModel =ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        myFragmentAdapter =new MyFragmentPagerAdapter(getChildFragmentManager());
        mTabLayout = root.findViewById(R.id.tabLayout);
        mViewPager = root.findViewById(R.id.sy_viewPager);

        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);
        mViewPager.setAdapter(myFragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);


        return root;
    }




}