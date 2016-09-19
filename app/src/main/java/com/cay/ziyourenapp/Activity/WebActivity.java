package com.cay.ziyourenapp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.cay.ziyourenapp.R;

/**
 * Created by Administrator on 2016/7/7.
 */
public class WebActivity extends Activity {
    private WebView webView;
    private String webUrl;
    private WebSettings mWebSettings;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView = (WebView) findViewById(R.id.webView);
        Intent intent = getIntent();//getIntent将该项目中包含的原始intent检索出来，将检索出来的intent赋值给一个Intent类型的变量intent
        Bundle bundle = intent.getExtras();//.getExtras()得到intent所附带的额外数据
        webUrl = bundle.getString("webUrl");
        webView.loadUrl(webUrl);
        webView.getSettings().setBlockNetworkImage(false);
        mWebSettings = webView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            this.finish();
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        Log.i("TAG", "onDestroy: ");
        super.onDestroy();
    }
    @Override
    protected void onPause() {
       webView.reload();
       super.onPause();
   }
}
