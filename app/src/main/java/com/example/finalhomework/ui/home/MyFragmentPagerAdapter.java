package com.example.finalhomework.ui.home;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.finalhomework.ui.home.classify.home_child_fragment;
import com.example.finalhomework.ui.home.classify.home_child_fragment2;
import com.example.finalhomework.ui.home.classify.home_child_fragment3;

public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private String[] mTitles = new String[]{"动态","收藏","推荐"};
    public MyFragmentPagerAdapter(FragmentManager fm){
        super(fm);
    }
    public Fragment getItem(int position){
        if (position==1)
            return new home_child_fragment();
        else if (position==2)
            return new home_child_fragment2();
        else
            return new home_child_fragment3();
    }
    public int getCount(){
        return mTitles.length;
    }

    public CharSequence getPageTitle(int position){
        return mTitles[position];
    }
}
