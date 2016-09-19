package com.cay.ziyourenapp.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

import com.cay.ziyourenapp.Bean.DrawerLayoutItem;
import com.cay.ziyourenapp.R;
import com.cay.ziyourenapp.Utils.CommonAdapter;
import com.cay.ziyourenapp.Utils.ViewHolder;

import java.util.List;

/**
 * Created by Cay on 2016/7/12.
 */
public class DrawerLiseAdapter extends CommonAdapter<DrawerLayoutItem> {
    public DrawerLiseAdapter(Context mContext, List<DrawerLayoutItem> mDatas, int layoutId) {
        super(mContext, mDatas, layoutId);
    }




    @Override
    public void convert(ViewHolder holder, DrawerLayoutItem drawerLayoutItem) {
        holder.setText(R.id.tv_drawer_listView, drawerLayoutItem.getItemText());
    }
}
