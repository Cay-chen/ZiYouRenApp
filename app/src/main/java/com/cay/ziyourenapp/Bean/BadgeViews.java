package com.cay.ziyourenapp.Bean;

import com.readystatesoftware.viewbadger.BadgeView;

/**
 * Created by C on 2016/7/7.
 */
public class BadgeViews {
    private BadgeView badgeView;
    private String nameaa;

    public BadgeViews(BadgeView badgeView, String nameaa) {
        this.badgeView = badgeView;
        this.nameaa = nameaa;
    }

    public BadgeView getBadgeView() {
        return badgeView;
    }

    public void setBadgeView(BadgeView badgeView) {
        this.badgeView = badgeView;
    }

    public String getNameaa() {
        return nameaa;
    }

    public void setNameaa(String nameaa) {
        this.nameaa = nameaa;
    }
}
