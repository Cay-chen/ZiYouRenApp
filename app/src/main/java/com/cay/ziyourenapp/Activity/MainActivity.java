package com.cay.ziyourenapp.Activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.support.v4.view.ViewPager;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cay.ziyourenapp.Adapter.MainViewPagerAdapter;
import com.cay.ziyourenapp.Fragment.HomeFragment;
import com.cay.ziyourenapp.Fragment.MeFragment;
import com.cay.ziyourenapp.Fragment.NoteFragment;
import com.cay.ziyourenapp.Fragment.ShopFragment;
import com.cay.ziyourenapp.R;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;

public class MainActivity extends AppCompatActivity {
    private MagicIndicator magicIndicator;
    private ViewPager mViewPager;
    private String[] mTitals = {"主页", "装备", "游记", "我"};
    private int[] mTitalImages = {R.drawable.home_selected, R.drawable.shop_selected, R.drawable.note_selected, R.drawable.me_selected};
    private Fragment[] mFragment = {new HomeFragment(), new ShopFragment(), new NoteFragment(), new MeFragment()};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMagicIndicator();
        initViewPagers();
    }

    private void initViewPagers() {
        mViewPager = (ViewPager) findViewById(R.id.man_viewpager);
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager(), mFragment);
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                magicIndicator.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                magicIndicator.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                magicIndicator.onPageScrollStateChanged(state);
            }
        });
    }


    private void initMagicIndicator() {
        magicIndicator = (MagicIndicator) findViewById(R.id.magicindicator);
        final CommonNavigator commonnavigator = new CommonNavigator(this);
        commonnavigator.setAdjustMode(true);
        commonnavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitals.length;
            }

            @Override
            public IPagerTitleView getItemView(Context context, final int index) {
                CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(MainActivity.this);
                commonPagerTitleView.setContentView(R.layout.simple_pager_title_layout);
                final TextView tital = (TextView) commonPagerTitleView.findViewById(R.id.title_text);
                final ImageView image = (ImageView) commonPagerTitleView.findViewById(R.id.title_img);
                tital.setText(mTitals[index]);
                image.setBackgroundResource(mTitalImages[index]);
                commonPagerTitleView.setOnPagerTitleChangeListener(new CommonPagerTitleView.OnPagerTitleChangeListener() {
                    @Override
                    public void onSelected(int index) {
                        image.setSelected(true);
                        tital.setTextColor(Color.parseColor("#3E3E3E"));
                    }

                    @Override
                    public void onDeselected(int index) {
                        image.setSelected(false);
                    }

                    @Override
                    public void onLeave(int index, float leavePercent, boolean leftToRight) {


                    }

                    @Override
                    public void onEnter(int index, float enterPercent, boolean leftToRight) {


                    }
                });
                commonPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewPager.setCurrentItem(index);
                    }
                });

                return commonPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }
        });
        magicIndicator.setNavigator(commonnavigator);
    }
}
