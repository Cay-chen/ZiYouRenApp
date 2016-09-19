package com.cay.ziyourenapp.Adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cay.ziyourenapp.Bean.SpaceRvItemBean;
import com.cay.ziyourenapp.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Cay on 2016/7/14.
 */
public class SpaceRvAdapter extends RecyclerView.Adapter<SpaceRvAdapter.ViewHdider> {
    private List<SpaceRvItemBean> mDatas;
    private Context context;
    private String[][] urlTwoData;
    private RecyclerView mRecyclerView;

    public SpaceRvAdapter(List<SpaceRvItemBean> mDatas, Context context, String[][] urlTwoData) {
        this.mDatas = mDatas;
        this.context = context;
        this.urlTwoData = urlTwoData;
    }

    @Override
    public ViewHdider onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHdider(LayoutInflater.from(parent.getContext()).inflate(R.layout.space_recyclerview_item, null));
    }

    @Override
    public void onBindViewHolder(ViewHdider holder, int position) {
        String[] urlData = urlTwoData[position];
        holder.mName.setText((CharSequence) mDatas.get(position).getmName());
        holder.mContext.setText((CharSequence) mDatas.get(position).getmContext());
        holder.mAdress.setText((CharSequence) mDatas.get(position).getmAdress());
        holder.mTime.setText((CharSequence) mDatas.get(position).getmTime());
        Glide.with(context).load(mDatas.get(position).getHeadImageUrl()).into(holder.mHeadImage);
        mRecyclerView = holder.contentRecyclerView;
        GridLayoutManager layoutManager = new GridLayoutManager(context, 3);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        NineRvAdapter adapter = new NineRvAdapter(urlData, context);
        mRecyclerView.setAdapter(adapter);
        setGridViewHeightBasedOnChild(mRecyclerView);


    }

    /**
     * 计算GridView的高度
     *
     * @param recycerView 要计算的GridView
     */
    public void setGridViewHeightBasedOnChild(RecyclerView recycerView) {
        int childs = recycerView.getAdapter().getItemCount();
        int abc = childs / 3;// 高好行数
        int qwe = childs % 3;//余数
        int totalHeight = 0;
        if (qwe == 0) {
            totalHeight = abc * 92;
            final float scale = context.getResources().getDisplayMetrics().density;


            ViewGroup.LayoutParams params = recycerView.getLayoutParams();
//            gridView.getVerticalSpacing()
            //  + (gridView.getRequestedHorizontalSpacing() * (gridView.getAdapter().getCount() - 1))
            params.height = (int) (totalHeight * scale + 0.5f);
            recycerView.setLayoutParams(params);
        } else {
            totalHeight = (abc + 1) * 92;
            final float scale = context.getResources().getDisplayMetrics().density;

            ViewGroup.LayoutParams params = recycerView.getLayoutParams();
//            gridView.getVerticalSpacing()
            //  + (gridView.getRequestedHorizontalSpacing() * (gridView.getAdapter().getCount() - 1))
            params.height = (int) (totalHeight * scale + 0.5f);
            recycerView.setLayoutParams(params);

        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHdider extends RecyclerView.ViewHolder {
        RecyclerView contentRecyclerView;
        CircleImageView mHeadImage;
        TextView mName, mContext, mAdress, mTime;

        public ViewHdider(View itemView) {
            super(itemView);
            mHeadImage = (CircleImageView) itemView.findViewById(R.id.headimage);
            contentRecyclerView = (RecyclerView) itemView.findViewById(R.id.space_rvitem_rv);
            mName = (TextView) itemView.findViewById(R.id.space_rvitem_name);
            mContext = (TextView) itemView.findViewById(R.id.space_rvitem_context);
            mAdress = (TextView) itemView.findViewById(R.id.space_rvitem_address);
            mTime = (TextView) itemView.findViewById(R.id.space_rvitem_time);

        }
    }
}
