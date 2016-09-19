package com.cay.ziyourenapp.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.cay.ziyourenapp.R;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Cay on 2016/7/2.
 */
public class OkHttp extends Activity {
    private String json;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.okhttp);
        String url = "http://www.weather.com.cn/data/cityinfo/101010100.html";
        OkHttpClient mOkHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        mOkHttpClient.newCall(request).enqueue(new Callback() {
            //请求不成功返回
            @Override
            public void onFailure(Call call, IOException e) {

            }

            //请求成功返回
            @Override
            public void onResponse(Call call, Response response) throws IOException {
               json = response.body().string();
                Log.i("TAG", "onResponse: " + json);
                JSONObject json = new JSONObject();
               // json.get()
                //Log.i("TAG", "cityID: " + cityID);


            }
        });



    }

}
