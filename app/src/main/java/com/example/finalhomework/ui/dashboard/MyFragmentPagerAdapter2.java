package com.example.finalhomework.ui.dashboard;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.finalhomework.ui.home.HomeFragment;
import com.example.finalhomework.ui.home.classify.home_child_fragment;
import com.example.finalhomework.ui.home.classify.home_child_fragment2;
import com.example.finalhomework.ui.notifications.NotificationsFragment;

public class MyFragmentPagerAdapter2 extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"首页","影音","我的"};
    public MyFragmentPagerAdapter2(FragmentManager fm){
        super(fm);
    }
    public Fragment getItem(int position){
        if (position==0)
            return new HomeFragment();
        if (position==1)
            return new DashboardFragment();
        else
            return new NotificationsFragment();
    }
    public int getCount(){
        return mTitles.length;
    }

    public CharSequence getPageTitle(int position){
        return mTitles[position];
    }
}
