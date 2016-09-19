package com.cay.ziyourenapp.Bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.lang.reflect.Type;

/**
 * Created by C on 2016/7/17.
 */
public class ShopRvItem1Bean extends MultiItemEntity {
    public static final int ONE = 1;
    public static final int TWO = 2;
    private Type type;
    private String item1Image1Url;
    private String item1Image2Url;
    private String item1Image3Url;
    private String item1Image4Url;
    private String item1OneText1;
    private String item1OneText2;
    private String item1TwoText1;
    private String item1TwoText2;
    private String item1TreText1;
    private String item1TreText2;

    public ShopRvItem1Bean() {

    }

    public ShopRvItem1Bean(Type type, String item1Image1Url, String item1Image2Url, String item1Image3Url, String item1Image4Url, String item1OneText1, String item1OneText2, String item1TwoText1, String item1TwoText2, String item1TreText1, String item1TreText2) {
        this.type = type;
        this.item1Image1Url = item1Image1Url;
        this.item1Image2Url = item1Image2Url;
        this.item1Image3Url = item1Image3Url;
        this.item1Image4Url = item1Image4Url;
        this.item1OneText1 = item1OneText1;
        this.item1OneText2 = item1OneText2;
        this.item1TwoText1 = item1TwoText1;
        this.item1TwoText2 = item1TwoText2;
        this.item1TreText1 = item1TreText1;
        this.item1TreText2 = item1TreText2;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getItem1Image1Url() {
        return item1Image1Url;
    }

    public void setItem1Image1Url(String item1Image1Url) {
        this.item1Image1Url = item1Image1Url;
    }

    public String getItem1Image2Url() {
        return item1Image2Url;
    }

    public void setItem1Image2Url(String item1Image2Url) {
        this.item1Image2Url = item1Image2Url;
    }

    public String getItem1Image3Url() {
        return item1Image3Url;
    }

    public void setItem1Image3Url(String item1Image3Url) {
        this.item1Image3Url = item1Image3Url;
    }

    public String getItem1Image4Url() {
        return item1Image4Url;
    }

    public void setItem1Image4Url(String item1Image4Url) {
        this.item1Image4Url = item1Image4Url;
    }

    public String getItem1OneText1() {
        return item1OneText1;
    }

    public void setItem1OneText1(String item1OneText1) {
        this.item1OneText1 = item1OneText1;
    }

    public String getItem1OneText2() {
        return item1OneText2;
    }

    public void setItem1OneText2(String item1OneText2) {
        this.item1OneText2 = item1OneText2;
    }

    public String getItem1TwoText1() {
        return item1TwoText1;
    }

    public void setItem1TwoText1(String item1TwoText1) {
        this.item1TwoText1 = item1TwoText1;
    }

    public String getItem1TwoText2() {
        return item1TwoText2;
    }

    public void setItem1TwoText2(String item1TwoText2) {
        this.item1TwoText2 = item1TwoText2;
    }

    public String getItem1TreText1() {
        return item1TreText1;
    }

    public void setItem1TreText1(String item1TreText1) {
        this.item1TreText1 = item1TreText1;
    }

    public String getItem1TreText2() {
        return item1TreText2;
    }

    public void setItem1TreText2(String item1TreText2) {
        this.item1TreText2 = item1TreText2;
    }
}
