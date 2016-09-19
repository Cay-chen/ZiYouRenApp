package com.cay.ziyourenapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cay.ziyourenapp.Activity.AllScli;
import com.cay.ziyourenapp.R;

/**
 * Created by C on 2016/7/14.
 */
public class NineRvAdapter extends RecyclerView.Adapter<NineRvAdapter.ViewHolder> {

    String[] mImagUrl;
    private Context context;

    public NineRvAdapter(String[] mImagUrl, Context context) {
        this.mImagUrl = mImagUrl;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.nine_rv_item, null, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Glide.with(context).load(mImagUrl[position]).into(holder.mImageView);
        holder.mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AllScli.class);
                intent.putExtra("urlImageAll",mImagUrl);
                String a = position + "";
                intent.putExtra("numBER", a);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mImagUrl.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.nine_imag);
        }
    }
}
