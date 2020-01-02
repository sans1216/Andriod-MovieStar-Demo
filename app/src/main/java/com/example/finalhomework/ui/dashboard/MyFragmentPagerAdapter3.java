package com.example.finalhomework.ui.dashboard;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.finalhomework.ui.home.HomeFragment;
import com.example.finalhomework.ui.notifications.NotificationsFragment;

public class MyFragmentPagerAdapter3 extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"近期热门","即将上映"};
    public MyFragmentPagerAdapter3(FragmentManager fm){
        super(fm);
    }
    public Fragment getItem(int position) {
        if (position == 0)
            return new movie_fragment1();
        else
            return new movie_fragment2();

    }

    public int getCount(){
        return mTitles.length;
    }

    public CharSequence getPageTitle(int position){
        return mTitles[position];
    }
}
