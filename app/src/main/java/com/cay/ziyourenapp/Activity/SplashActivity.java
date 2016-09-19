package com.cay.ziyourenapp.Activity;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.cay.ziyourenapp.R;


public class SplashActivity extends Activity{
	private static final int TIME = 3000;
	private static final int GO_HOME = 1000;
	private static final int GO_GUIDE = 1001;
	private boolean isFirstIn = false;

	private Handler mHander = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case GO_HOME:
				goHome();

				break;

			case GO_GUIDE:
				goGuide();
				break;
			}
		};
		
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_splash);
		init();
	}



	private void init(){
		SharedPreferences per = getSharedPreferences("ziyouren", MODE_PRIVATE);
		isFirstIn = per.getBoolean("isFirstIn", true);
		if (!isFirstIn) {
			mHander.sendEmptyMessageDelayed(GO_HOME, TIME);
		}else {
			mHander.sendEmptyMessageDelayed(GO_GUIDE, TIME);
			Editor editor = per.edit();
			editor.putBoolean("isFirstIn", false);
			editor.commit();
		}
	}
  private void goHome(){
	  Intent i = new Intent(SplashActivity.this,LoginActivity.class);
	startActivity(i);
	  finish();
	
  }
  private void goGuide(){
	  Intent i = new Intent(SplashActivity.this,GuideActivity.class);
	  startActivity(i);
	  finish();
	
  }
}
