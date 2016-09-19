package com.cay.ziyourenapp.Adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by Administrator on 2016/7/6.
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private Fragment[] mFragment;

    public MainViewPagerAdapter( FragmentManager fm, Fragment[] mFragment) {
        super(fm);
        this.mFragment = mFragment;

    }



    @Override
    public Fragment getItem(int position) {

        return mFragment[position];
    }

    @Override
    public int getCount() {
        return mFragment.length;
    }
}
