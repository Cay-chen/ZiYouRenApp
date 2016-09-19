package com.cay.ziyourenapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cay.ziyourenapp.R;
import com.cay.ziyourenapp.Bean.HomeFragmentListViewBean;

import java.util.ArrayList;
import java.util.List;

public class HomeFragmentListViewAdapter extends BaseAdapter {
    private List<HomeFragmentListViewBean> zList;
    private LayoutInflater zInflater;
    private Context context;
    
    public HomeFragmentListViewAdapter(Context context, List<HomeFragmentListViewBean> list) {
        zList = list;
        this.context = context;

    }



    @Override
    public int getCount() {
        return zList.size();
    }

    @Override
    public Object getItem(int position) {
        return zList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            zInflater = LayoutInflater.from(context);
            convertView = zInflater.inflate(R.layout.fragment_listview_item, null);
            viewHolder = new ViewHolder();
            viewHolder.mItile = (TextView) convertView
                    .findViewById(R.id.tv_title);
            viewHolder.mContent = (TextView) convertView
                    .findViewById(R.id.tv_content);
            viewHolder.mTime = (TextView) convertView.findViewById(R.id.tv_time);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_icon);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        HomeFragmentListViewBean bean = zList.get(position);
        viewHolder.mItile.setText(bean.getzItile());
        viewHolder.mContent.setText(bean.getzContent());
        viewHolder.mTime.setText(bean.getzTime());
        Glide.with(context).load(bean.getzImage()).into(viewHolder.imageView);
          return convertView;
    }



    private final class ViewHolder {
        TextView mItile;
        TextView mContent;
        TextView mTime;
        ImageView imageView;

    }

    public void onDateChange(ArrayList<HomeFragmentListViewBean> apk_list) {
        this.zList = apk_list;
        this.notifyDataSetChanged();
    }
}
