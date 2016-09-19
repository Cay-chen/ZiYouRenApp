package com.cay.ziyourenapp.Bean;

public class HomeFragmentListViewBean {
	public String zItile;
	public String zContent;
	public String zTime;
	public String zImage;
	public String zImageUrl;

	public HomeFragmentListViewBean(String zTime, String zItile, String zContent, String zImage,String zImageUrl) {
		this.zTime = zTime;
		this.zItile = zItile;
		this.zContent = zContent;
		this.zImage = zImage;
		this.zImageUrl = zImageUrl;
	}

	public String getzImageUrl() {
		return zImageUrl;
	}

	public void setzImageUrl(String zImageUrl) {
		this.zImageUrl = zImageUrl;
	}

	public String getzImage() {
		return zImage;
	}

	public void setzImage(String zImage) {
		this.zImage = zImage;
	}

	public String getzItile() {
		return zItile;
	}

	public void setzItile(String zItile) {
		this.zItile = zItile;
	}

	public String getzContent() {
		return zContent;
	}

	public void setzContent(String zContent) {
		this.zContent = zContent;
	}

	public String getzTime() {
		return zTime;
	}

	public void setzTime(String zTime) {
		this.zTime = zTime;
	}
}
