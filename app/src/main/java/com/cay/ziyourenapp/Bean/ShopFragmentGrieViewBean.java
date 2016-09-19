package com.cay.ziyourenapp.Bean;

/**
 * Created by Cay on 2016/7/12.
 */
public class ShopFragmentGrieViewBean {
    private String yuanJianNum;
    private String teJianNum;
    private String imageUrl;
    private String url;

    public ShopFragmentGrieViewBean(String yuanJianNum, String teJianNum, String imageUrl, String url) {
        this.yuanJianNum = yuanJianNum;
        this.teJianNum = teJianNum;
        this.imageUrl = imageUrl;
        this.url = url;
    }

    public String getYuanJianNum() {
        return yuanJianNum;
    }

    public void setYuanJianNum(String yuanJianNum) {
        this.yuanJianNum = yuanJianNum;
    }

    public String getTeJianNum() {
        return teJianNum;
    }

    public void setTeJianNum(String teJianNum) {
        this.teJianNum = teJianNum;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
