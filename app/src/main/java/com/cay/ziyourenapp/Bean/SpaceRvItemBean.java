package com.cay.ziyourenapp.Bean;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

/**
 * Created by Cay on 2016/7/14.
 */
public class SpaceRvItemBean {
    String mName;
    String mContext;
    String mAdress;
    String mTime;
String headImageUrl;

    public String getHeadImageUrl() {
        return headImageUrl;
    }

    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl;
    }

    public SpaceRvItemBean(String mName, String mContext, String mAdress, String mTime, String headImageUrl) {
        this.mName = mName;
        this.mContext = mContext;
        this.mAdress = mAdress;
        this.mTime = mTime;
        this.headImageUrl = headImageUrl;


    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmContext() {
        return mContext;
    }

    public void setmContext(String mContext) {
        this.mContext = mContext;
    }

    public String getmAdress() {
        return mAdress;
    }

    public void setmAdress(String mAdress) {
        this.mAdress = mAdress;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }


}
