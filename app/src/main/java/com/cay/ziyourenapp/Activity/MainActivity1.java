package com.cay.ziyourenapp.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.cay.ziyourenapp.Fragment.HomeFragment;
import com.cay.ziyourenapp.Fragment.MapFragment;
import com.cay.ziyourenapp.Fragment.MeFragment;
import com.cay.ziyourenapp.Fragment.NoteFragment;
import com.cay.ziyourenapp.Fragment.ShopFragment;
import com.cay.ziyourenapp.R;
import com.cay.ziyourenapp.Bean.Tap;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity1 extends FragmentActivity {
    private FragmentTabHost mTabhost;
    private LayoutInflater mInflater;
    private static Boolean isExit = false;
    private List<Tap> mTaps = new ArrayList<Tap>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        initTab();
    }

    private void initTab() {
        mTaps.add(new Tap(0, R.drawable.selector_home, HomeFragment.class, R.string.home));
        mTaps.add(new Tap(22, R.drawable.selector_huodong, ShopFragment.class,R.string.shop));
      //  mTaps.add(new Tap(0, R.drawable.selector_map, MapFragment.class, R.string.map));
     //   mTaps.add(new Tap(1, R.drawable.selector_youji, NoteFragment.class, R.string.youji));
        mTaps.add(new Tap(12, R.drawable.selector_me, MeFragment.class, R.string.me));
        mInflater = LayoutInflater.from(this);
        mTabhost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabhost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        for (Tap tap : mTaps) {
            TabHost.TabSpec tabSpec = mTabhost.newTabSpec(getString(tap
                    .getTitle()));
            tabSpec.setIndicator(buildIndicator(tap));
            mTabhost.addTab(tabSpec, tap.getFragement(), null);

        }
       /* mTabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                for (int i=0;i<mTaps.size();i++) {
                    String tatil = getString(mTaps.get(i).getTitle());
                    Log.i("TAG", "tatil"+ tatil);

                }

            }


        });*/
        //去掉分割线
        mTabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        mTabhost.setCurrentTab(0);

    }

    private View buildIndicator(Tap tap) {
        View view = mInflater.inflate(R.layout.tabhost_item, null);
        ImageView img = (ImageView) view.findViewById(R.id.imageview);
        TextView text = (TextView) view.findViewById(R.id.textview);
        img.setBackgroundResource(tap.getIcon());
        text.setText(tap.getTitle());
        return view;


    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click();

        }

        return false;

    }

    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_LONG).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 1500); // 如果1..5秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
            finish();

        }
    }
}
