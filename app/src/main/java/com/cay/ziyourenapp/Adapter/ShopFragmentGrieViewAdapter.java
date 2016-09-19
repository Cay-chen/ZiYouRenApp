package com.cay.ziyourenapp.Adapter;

import android.content.Context;

import com.cay.ziyourenapp.Bean.ShopFragmentGrieViewBean;
import com.cay.ziyourenapp.R;
import com.cay.ziyourenapp.Utils.CommonAdapter;
import com.cay.ziyourenapp.Utils.ViewHolder;

import java.util.List;

/**
 * Created by Cay on 2016/7/12.
 */
public class ShopFragmentGrieViewAdapter extends CommonAdapter<ShopFragmentGrieViewBean> {
    public ShopFragmentGrieViewAdapter(Context mContext, List<ShopFragmentGrieViewBean> mDatas, int layoutId) {
        super(mContext, mDatas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, ShopFragmentGrieViewBean shopFragmentGrieViewBean) {
        holder.setImageURI(R.id.shop_gridView_image, shopFragmentGrieViewBean.getImageUrl())
                .setText(R.id.shop_gridView_text1, shopFragmentGrieViewBean.getTeJianNum())
                .setText(R.id.shop_gridView_text2, shopFragmentGrieViewBean.getYuanJianNum());

    }
}
