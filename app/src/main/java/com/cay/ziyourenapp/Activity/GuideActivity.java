package com.cay.ziyourenapp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cay.ziyourenapp.Adapter.ViewPagerAdapter;
import com.cay.ziyourenapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cay on 2016/7/2.
 */
public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener {
    private ViewPager vp;
    private ViewPagerAdapter vpAdapter;
    private List<View> views;
    private Button stratbtn;
    private ImageView[] dots;
    private String[] imageUrl = {"http://a3.qpic.cn/psb?/V11O7sEU1hxZsb/Lbg1H797WKDtNR99eEsYtsB9XTgURT*sU3fu1cbqKZ8!/b/dHABAAAAAAAA&bo=gAJwBIACcAQFCSo!&rf=viewer_4",
            "http://a2.qpic.cn/psb?/V11O7sEU1hxZsb/m.Tr3ixt0jDagO34pFijxQ0L.zou18vg69Gw95ahx4c!/b/dI0BAAAAAAAA&bo=XAK9A1wCvQMDACU!&rf=viewer_4",
            "http://a1.qpic.cn/psb?/V11O7sEU1hxZsb/wyyvzXOM0buAbdypGfjxZAaL*4vpjiiSgmGjHonc4L8!/b/dAsBAAAAAAAA&bo=4AH9AuAB*QIFACM!&rf=viewer_4"};
    private int[] ids = {R.id.iv1, R.id.iv2, R.id.iv3};
    private int[] imageViewId = {R.id.guide_image1, R.id.guide_image2, R.id.guide_image3};

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_guide);
        initViews();
        initDots();
    }

    /**
     * 初始化
     */
    private void initViews() {
        LayoutInflater inflater = LayoutInflater.from(this);
        views = new ArrayList<View>();
        views.add(inflater.inflate(R.layout.guide_one, null));
        views.add(inflater.inflate(R.layout.guide_two, null));
        views.add(inflater.inflate(R.layout.guide_thr, null));

        vpAdapter = new ViewPagerAdapter(views,this, imageViewId,imageUrl);
        vp = (ViewPager) findViewById(R.id.guide_viewpager);

        stratbtn = (Button) views.get(2).findViewById(R.id.start);
        stratbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(GuideActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
        vp.setAdapter(vpAdapter);
        vp.addOnPageChangeListener(this);

    }

    /**
     * 小圆点View
     */
    private void initDots() {
        dots = new ImageView[views.size()];
        for (int i = 0; i < views.size(); i++) {
            dots[i] = (ImageView) findViewById(ids[i]);

        }

    }

    /**
     * 挡滑动状态改变的时候调用
     */
    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub

    }

    /**
     * 挡页面被滑动时调用
     */
    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub

    }

    /**
     * 当前新的页面被选中时调用
     * 更改小圆点图标
     */
    @Override
    public void onPageSelected(int arg0) {
        for (int i = 0; i < ids.length; i++) {
            if (arg0 == i) {
                dots[i].setImageResource(R.mipmap.guide_point_selected);

            } else {
                dots[i].setImageResource(R.mipmap.guide_point);
            }

        }

    }

}
