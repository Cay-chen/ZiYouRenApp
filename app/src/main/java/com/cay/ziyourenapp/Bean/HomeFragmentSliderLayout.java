package com.cay.ziyourenapp.Bean;

/**
 * Created by Administrator on 2016/7/7.
 */
public class HomeFragmentSliderLayout {
    private String description;
    private String imageUrl;
    private String webUrl;

    public HomeFragmentSliderLayout(String description, String imageUrl, String webUrl) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.webUrl = webUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
