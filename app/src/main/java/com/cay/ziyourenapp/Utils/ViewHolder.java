package com.cay.ziyourenapp.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Cay on 2016/6/13.
 */
public class ViewHolder {
    private SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;
    private Context context;

    /**
     * 创建ViewHolder
     * @param context
     * @param parent
     * @param layoutId
     * @param position
     */
    public ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.mPosition = position;
        this.mViews = new SparseArray<View>();
        this.context = context;

        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);

    }

    /**
     * 在数据中获得converView
     * @return
     */
    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 判断ConvertView是否为空
     * @param context 上下文
     * @param convertView
     * @param parent
     * @param layoutId  LayId
     * @param position
     * @return
     */

    public static ViewHolder get(Context context, View convertView,
                                 ViewGroup parent, int layoutId, int position) {

        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        }else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mPosition = position;
            return holder;
        }


    }

    /**
     * 通过viewId找到控件View 然后存储在mDatas中
     * @param viewId
     * @param <T>
     * @return
     */

    public <T extends  View>T getView(int viewId){
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews
                    .put(viewId,view);
        }
        return (T) view;
    }

    /**
     * 设置TextView的值的方法
     * @param viewId View的R.id.**
     * @param text  设置的内容
     * @return
     */
    public ViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 设置ImageView 图片的方法
     * @param viewId
     * @param imageId
     * @return
     */
    public ViewHolder setImageResource(int viewId, int imageId) {
        ImageView view = getView(viewId);
        view.setImageResource(imageId);
        return this;
    }
    /**
     * 设置ImageView 图片的方法
     * @param viewId
     * @param imageBitampId
     * @return
     */
    public ViewHolder setImageBitamp(int viewId, Bitmap imageBitampId) {
        ImageView view = getView(viewId);
        view.setImageBitmap(imageBitampId);
        return this;
    }
    /**
     * 设置ImageView 图片的方法
     * @param viewId
     * @param url
     * @return
     */
    public ViewHolder setImageURI(int viewId, String url) {
        ImageView view = getView(viewId);
        Glide.with(context).load(url).into(view);
        return this;
    }
}
