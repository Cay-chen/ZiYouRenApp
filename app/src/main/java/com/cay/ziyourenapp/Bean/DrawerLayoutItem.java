package com.cay.ziyourenapp.Bean;

/**
 * Created by Cay on 2016/7/12.
 */
public class DrawerLayoutItem {
   // private int itemIcon;
    private String itemText;

    public DrawerLayoutItem(String itemText) {
        this.itemText = itemText;
    }

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }
}
