package com.cay.ziyourenapp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
        webView.setWebViewClient( new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.i("TAG", url);
                if (url.startsWith("http:") || url.startsWith("https:")) {
                    view.loadUrl(url);
                    return false;
                }
             /*   Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent2);*/
                return true;
            }
        });
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
