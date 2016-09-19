package com.cay.ziyourenapp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cay.ziyourenapp.R;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by Cay on 2016/7/15.
 */
public class AllScli extends Activity {
    //接受过来图片的URL地址数组
    private String[] imageUrlAll;
    private ViewPager mViewPager;
    private ImageView[] mImageViews;
    private TextView mTextView;
    private String a;
    private String b;
    private PhotoViewAttacher mAttacher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scil);
        mTextView = (TextView) findViewById(R.id.viewpager_text);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        Intent intent = getIntent();//getIntent将该项目中包含的原始intent检索出来，将检索出来的intent赋值给一个Intent类型的变量intent
        Bundle bundle = intent.getExtras();//.getExtras()得到intent所附带的额外数据
        imageUrlAll = bundle.getStringArray("urlImageAll");
        int c = Integer.parseInt(bundle.getString("numBER"));
        Log.i("TAG", "imageUrlAll: " + imageUrlAll);
        mImageViews = new ImageView[imageUrlAll.length];
        String d = (c + 1) + "";
        b = imageUrlAll.length + "";
        mTextView.setText(d + "/" + b);//点击过来显示设置页码显示的第几张
        initSlider();
        mViewPager.setCurrentItem(c);// 设置点击那张图片进来的，就显示那张图片放大。
        mViewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TAG", "instantiateItem:222 ");

            }
        });

    }

    /**
     * 创建ViewAdapter
     */
    public void initSlider() {
        PagerAdapter adapter = new PagerAdapter() {
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                PhotoView mImageView = new PhotoView(getApplicationContext());
                Glide.with(getApplicationContext()).load(imageUrlAll[position]).into(mImageView);
                container.addView(mImageView);
                mImageViews[position] = mImageView;
                mAttacher = new PhotoViewAttacher(mImageView);
                mImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i("TAG", "instantiateItem: ");

                        AllScli.this.finish();

                    }
                });
                return mImageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mImageViews[position]);
            }

            @Override
            public int getCount() {
                return imageUrlAll.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        };
        //绑定ViewParge
        mViewPager.setAdapter(adapter);

        //设置监听
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            /**
             * 滑动的时候显示改变下面页标。
             * @param position
             */
            @Override
            public void onPageSelected(int position) {
                a = (position + 1) + "";
                b = imageUrlAll.length + "";
                mTextView.setText(a + "/" + b);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    /**
     * 按手机返回剑的时候 销毁Activity
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            AllScli.this.finish();
        }

        return false;
    }


}
