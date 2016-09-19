package com.cay.ziyourenapp.Activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.ImageView;

import com.cay.ziyourenapp.Adapter.SpaceRvAdapter;
import com.cay.ziyourenapp.Bean.SpaceRvItemBean;
import com.cay.ziyourenapp.R;

import java.util.ArrayList;

/**
 * Created by Cay on 2016/7/14.
 */
public class SpaceActivity extends AppCompatActivity {
    private CoordinatorLayout mCoordinatorLayout;
    private RecyclerView mContentRV;
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;
    private int downY;
    private int upY;
    private ImageView mMImageView;
    private ImageView mImageView;
    private String[][]  nineImageUrls ={

            {},{},
            {},
            {"http://b367.photo.store.qq.com/psb?/V11VsYBN0CEYE3/m*Wl4XXSFsgjjN8m4ImCZ8q*83jdkUN*Us1bYpRqMDY!/b/dG8BAAAAAAAA&bo=wAOAAgAAAAAFB2U!&rf=viewer_4","http://b396.photo.store.qq.com/psb?/V11VsYBN0CEYE3/*9ht2t8eoC9itsUhGpWCLKOJDKAEXkADV9AY0z0sz0s!/b/dIwBAAAAAAAA&bo=tQOAAgAAAAAFABc!&rf=viewer_4","http://b369.photo.store.qq.com/psb?/V11VsYBN0CEYE3/XmgIYALtoqQQSfqI2j76VVpK7rmeHwXgb0Uayu882OE!/b/dHEBAAAAAAAA&bo=wAOAAgAAAAAFAGI!&rf=viewer_4","http://b383.photo.store.qq.com/psb?/V11VsYBN0CEYE3/fGH0Jo*2Fdmk1k3jhAaqk6OUvz3vNdXlkqLlvjp4oWE!/b/dH8BAAAAAAAA&bo=wgOAAgAAAAAFAGA!&rf=viewer_4",
            "http://b369.photo.store.qq.com/psb?/V11VsYBN0CEYE3/E.bRghc.iq3iZuSLN5n1fju9JoVLYbMJUHgJhVgKCEE!/b/dHEBAAAAAAAA&bo=wAOAAgAAAAAFAGI!&rf=viewer_4"},
            {"http://b387.photo.store.qq.com/psb?/V11VsYBN1gHBMm/7RitNZo.LBoPAJNEGccousZLdh9t6f0w.NJYvD2OVpY!/b/dBPXuua6PAAA&bo=JAOAAlYFPwQBCuA!&rf=viewer_4","http://b387.photo.store.qq.com/psb?/V11VsYBN1gHBMm/56VU1v*VlYNbSSFbOuCDbCzk3Idvkj*5tFK528kQ5zA!/b/dFuxtOajPAAA&bo=wAOAAlYFjwMBALk!&rf=viewer_4","http://b386.photo.store.qq.com/psb?/V11VsYBN1gHBMm/JlamWHmo6IJC8KzU8gDjmE86y0dHOXjXJS0BIV.FQ9w!/b/dMAgHOY*NAAA&bo=wgSAAlYFzgIBAPw!&rf=viewer_4",
                    "http://b382.photo.store.qq.com/psb?/V11VsYBN1gHBMm/K92kl0btmjFUimgVZjMD07SY68wNuTEvrfEcXNG7Jq4!/b/dNdavuMnEgAA&bo=xQSAAlYFzAIBAPk!&rf=viewer_4","http://b385.photo.store.qq.com/psb?/V11VsYBN1gHBMm/DviQa6d2x25nONCxOXo.ssLgCx*MNkWqi9eflUfLYiU!/b/dO2IgOXlOQAA&bo=*AOAAlYFWQMBAFM!&rf=viewer_4","http://b386.photo.store.qq.com/psb?/V11VsYBN1gHBMm/Enee2tgBFYCsWGfjZguMFkhOuk9LnDjsAH80X6SVWnU!/b/dLiOGuZMNAAA&bo=VgVoAlYFaAIBACc!&rf=viewer_4",
                    "http://b387.photo.store.qq.com/psb?/V11VsYBN1gHBMm/X8rJbPMT2nkYLFvl4u7l*a2t3Hlc84iB2nGfPRZxIPk!/b/dHWisea7PAAA&bo=wAOAAlYFjwMBALk!&rf=viewer_4","http://b382.photo.store.qq.com/psb?/V11VsYBN1gHBMm/b.IKTNputd5SsP0SsqO.1GshW58SMsRzsm238Zl6lKw!/b/dADzvOMbEgAA&bo=wAOAAlYFjwMBALk!&rf=viewer_4","http://b384.photo.store.qq.com/psb?/V11VsYBN1gHBMm/OfLiA8PhdGQLTxnhF2I8mp6IZQ6RoxPJQEksccJeRe0!/b/dJ0m8eQALAAA&bo=7gOAAlYFZQMBAH0!&rf=viewer_4"},
            {"http://b367.photo.store.qq.com/psb?/V11VsYBN4AHEjb/pRw6m7jH5S7CBMmi.5EtkHwwg.8eBsIW5SV6EPdvATw!/b/dG8BAAAAAAAA&bo=VQOAAkAGsAQBCgs!&rf=viewer_4","http://b370.photo.store.qq.com/psb?/V11VsYBN4AHEjb/77gAsxwaxKuvHr.edpkWSdt*1jUH3BTzolAcFPyNK*U!/b/dHIBAAAAAAAA&bo=VQOAAgAFwAMBADU!&rf=viewer_4","http://b367.photo.store.qq.com/psb?/V11VsYBN4AHEjb/59MKi4dSZQTq6lB9tO5Unfw6GB45JZplVMSDcWxUWbs!/b/dG8BAAAAAAAA&bo=VQOAAgAFwAMBADU!&rf=viewer_4",
                    "http://b370.photo.store.qq.com/psb?/V11VsYBN4AHEjb/zGQRNM2r.IbsDO.gYYnvAkZwlnK1pb8oPJ*tVT7xijE!/b/dHIBAAAAAAAA&bo=VQOAAlUDgAIBACc!&rf=viewer_4"},{},
            {"http://b227.photo.store.qq.com/psb?/V11VsYBN4XDfG5/EvIBonkrTUC2R9EW70E53GJmf6onycB3XKv1wvqrUV0!/b/dOMAAAAAAAAA&bo=sAQgA7AEIAMBCS4!&rf=viewer_4","http://b368.photo.store.qq.com/psb?/V11VsYBN4XDfG5/QX8oHE47UkqXXR0cf.z1lUhmTN8ya3KNzeowXraopw0!/b/dHABAAAAAAAA&bo=sAQgA7AEIAMBACc!&rf=viewer_4","http://b227.photo.store.qq.com/psb?/V11VsYBN4XDfG5/vAjRDzn6GEgjQd4sObXjxWEabcnnILEv3NFBVKL2oM8!/b/dOMAAAAAAAAA&bo=AAVWAwAFVgMBACc!&rf=viewer_4"},
            {},{}
    };



    {}
    {}






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_space);

        initView();


        initData();
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.tb_title);
        mCoordinatorLayout = (CoordinatorLayout) findViewById(R.id.cl_root);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        mContentRV = (RecyclerView) findViewById(R.id.rv_content);
        mMImageView = (ImageView) findViewById(R.id.imagessss);
        mImageView = (ImageView) findViewById(R.id.image_toolbar);
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.ctl_title);
       /* collapsingToolbar.setTitle("美好的一天");
        collapsingToolbar.setCollapsedTitleTextColor(Color.parseColor("#FFFFFF"));
        collapsingToolbar.setExpandedTitleColor(Color.parseColor("#FFFFFF"));*/

    }

    private void initData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //  设置布局管理器
        mContentRV.setLayoutManager(layoutManager);
        ArrayList<SpaceRvItemBean> dataList = new ArrayList<SpaceRvItemBean>();

        dataList.add(new SpaceRvItemBean("江源","莹莹，无节制的饮食，让她体重飙升，使用营养餐一个月减重21斤，三个月减重49斤，累计减重80斤。从204斤到124斤，她减掉的是体重，增加的是幸福感，从此，和自卑说再见，和过去说再见。宛如重生的少女，重新焕发了青春靓丽。[玫瑰][玫瑰][玫瑰]",
                "成都·天府广场","一天前","http://a2.qpic.cn/psb?/V11O7sEU1hxZsb/NjrRopE7Qc*TvJ5S3calPgV.jwdO3bPLZhN3jGAqO7E!/b/dAwBAAAAAAAA&bo=jACMAIwAjAAFCSo!&rf=viewer_4"));
        dataList.add(new SpaceRvItemBean("何是西","谢谢赞助商每次新款上架都会准时寄给我。[呲牙]如果朋友们有需要可以直接订购。黑白两款/百搭",
                "成都·宽窄巷子","25分钟前","http://a2.qpic.cn/psb?/V11O7sEU1hxZsb/uoSkHqz1okXxBm.kz5BlBZPzkhT2aWzpLtVgJGo2b04!/b/dG8BAAAAAAAA&bo=JgEmASYBJgEFACM!&rf=viewer_4"));
        dataList.add(new SpaceRvItemBean("蒋俊淘","莹莹，无节制的饮食，让她体重飙升，使用营养餐一个月减重21斤，三个月减重49斤，累计减重80斤。从204斤到124斤，她减掉的是体重，增加的是幸福感，从此，和自卑说再见，和过去说再见。宛如重生的少女，重新焕发了青春靓丽。[玫瑰][玫瑰][玫瑰]",
                "成都·天府广场","一天前","http://a1.qpic.cn/psb?/V11O7sEU1hxZsb/3fskOGLO*grk5AlwA5.Eh2LBzWmgqe3DKzLyXqaPJYw!/b/dH0BAAAAAAAA&bo=ZABkAGQAZAAFACM!&rf=viewer_4"));
        dataList.add(new SpaceRvItemBean("魏玔","莹莹，无节制的饮食，让她体重飙升，使用营养餐一个月减重21斤，三个月减重49斤，累计减重80斤。从204斤到124斤，她减掉的是体重，增加的是幸福感，从此，和自卑说再见，和过去说再见。宛如重生的少女，重新焕发了青春靓丽。[玫瑰][玫瑰][玫瑰]",
                "成都·天府广场","一天前","http://a1.qpic.cn/psb?/V11O7sEU1hxZsb/zIKPmPvugl*eohCpz*lYV70zjKftBaK*CpIYOkm4qZE!/b/dAsBAAAAAAAA&bo=fgJ.An4CfgIFACM!&rf=viewer_4"));
        dataList.add(new SpaceRvItemBean("张三","莹莹，无节制的饮食，让她体重飙升，使用营养餐一个月减重21斤，三个月减重49斤，累计减重80斤。从204斤到124斤，她减掉的是体重，增加的是幸福感，从此，和自卑说再见，和过去说再见。宛如重生的少女，重新焕发了青春靓丽。[玫瑰][玫瑰][玫瑰]",
                "成都·天府广场","一天前","http://b229.photo.store.qq.com/psb?/040c6570-43a3-4c44-96d2-4793aad02a09/1xCl2g8sD1hnJt9qQmfMxjt4wqd6yC48JznmRKiDmHo!/b/dOUAAAAAAAAA&bo=YAHuAQAAAAABB64!&rf=viewer_4"));
        dataList.add(new SpaceRvItemBean("李凯红","莹莹，无节制的饮食，让她体重飙升，使用营养餐一个月减重21斤，三个月减重49斤，累计减重80斤。从204斤到124斤，她减掉的是体重，增加的是幸福感，从此，和自卑说再见，和过去说再见。宛如重生的少女，重新焕发了青春靓丽。[玫瑰][玫瑰][玫瑰]",
                "成都·天府广场","一天前","http://b229.photo.store.qq.com/psb?/040c6570-43a3-4c44-96d2-4793aad02a09/1xCl2g8sD1hnJt9qQmfMxjt4wqd6yC48JznmRKiDmHo!/b/dOUAAAAAAAAA&bo=YAHuAQAAAAABB64!&rf=viewer_4"));
        dataList.add(new SpaceRvItemBean("魏玔","莹莹，无节制的饮食，让她体重飙升，使用营养餐一个月减重21斤，三个月减重49斤，累计减重80斤。从204斤到124斤，她减掉的是体重，增加的是幸福感，从此，和自卑说再见，和过去说再见。宛如重生的少女，重新焕发了青春靓丽。[玫瑰][玫瑰][玫瑰]",
                "成都·天府广场","一天前","http://a1.qpic.cn/psb?/V11O7sEU1hxZsb/zIKPmPvugl*eohCpz*lYV70zjKftBaK*CpIYOkm4qZE!/b/dAsBAAAAAAAA&bo=fgJ.An4CfgIFACM!&rf=viewer_4"));
        dataList.add(new SpaceRvItemBean("张三","莹莹，无节制的饮食，让她体重飙升，使用营养餐一个月减重21斤，三个月减重49斤，累计减重80斤。从204斤到124斤，她减掉的是体重，增加的是幸福感，从此，和自卑说再见，和过去说再见。宛如重生的少女，重新焕发了青春靓丽。[玫瑰][玫瑰][玫瑰]",
                "成都·天府广场","一天前","http://b229.photo.store.qq.com/psb?/040c6570-43a3-4c44-96d2-4793aad02a09/1xCl2g8sD1hnJt9qQmfMxjt4wqd6yC48JznmRKiDmHo!/b/dOUAAAAAAAAA&bo=YAHuAQAAAAABB64!&rf=viewer_4"));
        dataList.add(new SpaceRvItemBean("李凯红","莹莹，无节制的饮食，让她体重飙升，使用营养餐一个月减重21斤，三个月减重49斤，累计减重80斤。从204斤到124斤，她减掉的是体重，增加的是幸福感，从此，和自卑说再见，和过去说再见。宛如重生的少女，重新焕发了青春靓丽。[玫瑰][玫瑰][玫瑰]",
                "成都·天府广场","一天前","http://b229.photo.store.qq.com/psb?/040c6570-43a3-4c44-96d2-4793aad02a09/1xCl2g8sD1hnJt9qQmfMxjt4wqd6yC48JznmRKiDmHo!/b/dOUAAAAAAAAA&bo=YAHuAQAAAAABB64!&rf=viewer_4"));
        dataList.add(new SpaceRvItemBean("李凯红","莹莹，无节制的饮食，让她体重飙升，使用营养餐一个月减重21斤，三个月减重49斤，累计减重80斤。从204斤到124斤，她减掉的是体重，增加的是幸福感，从此，和自卑说再见，和过去说再见。宛如重生的少女，重新焕发了青春靓丽。[玫瑰][玫瑰][玫瑰]",
                "成都·天府广场","一天前","http://b229.photo.store.qq.com/psb?/040c6570-43a3-4c44-96d2-4793aad02a09/1xCl2g8sD1hnJt9qQmfMxjt4wqd6yC48JznmRKiDmHo!/b/dOUAAAAAAAAA&bo=YAHuAQAAAAABB64!&rf=viewer_4"));


        SpaceRvAdapter adapter = new SpaceRvAdapter(dataList,this,nineImageUrls);
        mContentRV.setAdapter(adapter);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            this.finish();
        }
        return false;
    }
}
