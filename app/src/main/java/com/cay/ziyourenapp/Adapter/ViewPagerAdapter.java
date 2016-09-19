package com.cay.ziyourenapp.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cay.ziyourenapp.R;

import java.util.List;


public class ViewPagerAdapter extends PagerAdapter {

       private List<View> viewList;
    private Context context;
    private int[] imageViewId;
    private String[] imageUrl;
    public ViewPagerAdapter(List<View> viewList, Context context, int[] imageViewId, String[] imageUrl) {
        this.viewList = viewList;
        this.context = context;
        this.imageViewId = imageViewId;
        this.imageUrl = imageUrl;
    }


    /**
     * 销毁的view
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
		        container.removeView(viewList.get(position));
    }

    /**
     * 加载View
     *
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        //加载网络图片
        Glide.with(context).load(imageUrl[position]).into((ImageView)viewList.get(position).findViewById(imageViewId[position]));
        return viewList.get(position);
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    /**
     * 判断当前是不是我们需要的View
     *
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {

        return (view == object);
    }
}

