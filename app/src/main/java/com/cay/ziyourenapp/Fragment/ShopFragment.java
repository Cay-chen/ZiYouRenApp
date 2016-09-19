package com.cay.ziyourenapp.Fragment;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cay.ziyourenapp.Activity.WebActivity;
import com.cay.ziyourenapp.Adapter.DrawerLiseAdapter;
import com.cay.ziyourenapp.Adapter.ShopFragmentGrieViewAdapter;
import com.cay.ziyourenapp.Adapter.ShopRvAdapter;
import com.cay.ziyourenapp.Bean.DrawerLayoutItem;
import com.cay.ziyourenapp.Bean.HomeFragmentListViewBean;
import com.cay.ziyourenapp.Bean.HomeFragmentSliderLayout;
import com.cay.ziyourenapp.Bean.ShopFragmentGrieViewBean;
import com.cay.ziyourenapp.Bean.ShopRvItem1Bean;
import com.cay.ziyourenapp.R;
import com.cay.ziyourenapp.Utils.DataServe;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
public class ShopFragment extends Fragment {
    private List<DrawerLayoutItem> mList;
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private ListView mListView;
    private DrawerLiseAdapter adapter;
    private RelativeLayout mRelativeLayout;
    private ImageButton mImageButton1;
    private ImageButton mImageButton2;
    private View view;
    private ArrayList<HomeFragmentListViewBean> apk_list;
    private List<HomeFragmentSliderLayout> sliderLayouts;
    private SliderLayout sliderShow;
    private ListView listView;
    private GridView mGridView;
    private List<ShopFragmentGrieViewBean> gridList;
    private ShopFragmentGrieViewAdapter adapter1;
    private MarqueeView mMarqueeView;
    private LinearLayout lly1;
    private RecyclerView mRecyclerView;
    private int mCurrentCounter=0;
    private int totalHeight;
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fargment_shop, null);


        initView();
        initShowDrawer();
        initSlider();
        showList(gridList);
        initMarquee();
        return view;

    }

    /**
     * 侧滑菜单的显示
     */

    private void initShowDrawer() {
        adapter = new DrawerLiseAdapter(getActivity(), mList, R.layout.drawer_listview_item);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), mList.get(i).getItemText(), Toast.LENGTH_LONG).show();
            }
        });
        mImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
                    mDrawerLayout.closeDrawer(Gravity.LEFT);

                } else {
                    mDrawerLayout.openDrawer(Gravity.LEFT);

                }

            }
        });
    }


    /**
     * 各种控件初始化
     */
    private void initView() {
        mDrawerLayout = (DrawerLayout) view.findViewById(R.id.drawer_layout);
        //mToolbar = (Toolbar) view.findViewById(R.id.toolbar_c);
        mRelativeLayout = (RelativeLayout) view.findViewById(R.id.reLy);
        mImageButton1 = (ImageButton) view.findViewById(R.id.btn_mes);
        mImageButton2 = (ImageButton) view.findViewById(R.id.btn_fenlei);
        mListView = (ListView) view.findViewById(R.id.list_left_drawer);
        mImageButton1.setBackgroundColor(Color.TRANSPARENT);
        mImageButton2.setBackgroundColor(Color.TRANSPARENT);
        sliderShow = (SliderLayout) view.findViewById(R.id.slider_shop);
        mGridView = (GridView) view.findViewById(R.id.horiz_gridView);
        mMarqueeView = (MarqueeView) view.findViewById(R.id.marqueeView_shop);
        lly1 = (LinearLayout) view.findViewById(R.id.ll_shop1);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.shop_recyclerView);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDrawerDatas();
        setSliderData();
    }

    /**
     * 初始化DrawList的数据
     */
    private void initDrawerDatas() {
        mList = new ArrayList<DrawerLayoutItem>();
        mList.add(new DrawerLayoutItem("热门品牌"));
        mList.add(new DrawerLayoutItem("帐篷、睡袋、防潮垫、充气垫"));
        mList.add(new DrawerLayoutItem("背包、腰包"));
        mList.add(new DrawerLayoutItem("服装、帽子、手套、头巾"));
        mList.add(new DrawerLayoutItem("户外鞋、户外袜"));
        mList.add(new DrawerLayoutItem("灯具、炉具、水具"));
        mList.add(new DrawerLayoutItem("桌椅、烧烤架、烧烤碳"));
        mList.add(new DrawerLayoutItem("登山杖、冰爪、雪套、护膝"));
        mList.add(new DrawerLayoutItem("自行车、工具、拖包"));
        mList.add(new DrawerLayoutItem("配件及其他旅行用品"));
        gridList = new ArrayList<ShopFragmentGrieViewBean>();
        gridList.add(new ShopFragmentGrieViewBean("原价 ￥299", "现价 ￥89", "http://a1.qpic.cn/psb?/V11O7sEU1hxZsb/xnoh8jOQtwq1yPHrrKdEY.mg8GGvh0*cyZ8v1C*Fwx8!/b/dOEAAAAAAAAA&bo=IgIfAgAAAAADBx8!&rf=viewer_4",
                "https://detail.m.tmall.com/item.htm?id=17104748264&spm=a222c.7731663.normal.pcweb-other"));
        gridList.add(new ShopFragmentGrieViewBean("原价 ￥256", "现价 ￥39", "http://a3.qpic.cn/psb?/V11O7sEU1hxZsb/vQd60LCABNSEjhUwpaWUqSpdTPeKaS50KljH3gWghCU!/b/dA0BAAAAAAAA&bo=BAIEAgAAAAADACU!&rf=viewer_4",
                "https://detail.m.tmall.com/item.htm?id=13996223906&spm=a222c.7731663.normal.pcweb-other"));
        gridList.add(new ShopFragmentGrieViewBean("原价 ￥256", "现价 ￥39", "http://a1.qpic.cn/psb?/V11O7sEU1hxZsb/Q2KF7zGQ1ISiv4ry13fbRRKRqRZK7YgcLBSeXEjyqXg!/b/dHEBAAAAAAAA&bo=rwGvAQAAAAADACU!&rf=viewer_4",
                "https://detail.m.tmall.com/item.htm?id=14155348795&spm=a222c.7731663.normal.pcweb-other"));
        gridList.add(new ShopFragmentGrieViewBean("原价 ￥256", "现价 ￥39", "http://a3.qpic.cn/psb?/V11O7sEU1hxZsb/pOnZZBgFn5YwtFjm7ldgI62gQ929Xqbk1DlN3KK8.n0!/b/dI8AAAAAAAAA&bo=BQIEAgAAAAADACQ!&rf=viewer_4",
                "https://detail.m.tmall.com/item.htm?id=44359701868&spm=a222c.7731663.normal.pcweb-other"));
        gridList.add(new ShopFragmentGrieViewBean("原价 ￥256", "现价 ￥39", "http://a2.qpic.cn/psb?/V11O7sEU1hxZsb/xiZ3oMoQj7cwu9x0NquUxsHYICJetXI2lAsRpSK.FU0!/b/dAwBAAAAAAAA&bo=AwIGAgAAAAADACA!&rf=viewer_4",
                "https://detail.m.tmall.com/item.htm?id=525062071330&spm=a222c.7731663.normal.pcweb-other"));
    }


    private void setSliderData() {
        sliderLayouts = new ArrayList<HomeFragmentSliderLayout>();
        sliderLayouts.add(new HomeFragmentSliderLayout("", "http://a3.qpic.cn/psb?/V11O7sEU1hxZsb/S8WUrQlj06AbokJOBioHNm0Sd309swlqyzaZihpP6eI!/b/dA0BAAAAAAAA&bo=7gL0AQAAAAAFADo!&rf=viewer_4",
                "https://pages.tmall.com/wow/act/16190/home?acm=201501051336-1.1003.2.954312&aldid=evYkMmhM&scm=1003.2.201501051336-1.OTHER_1469244405506_954312&pos=1&spm=a1z60.7691149.banner.1&scn=tmallapp&_tmallFoot="));
        sliderLayouts.add(new HomeFragmentSliderLayout("天猫狂暑季-数码会场", "http://a2.qpic.cn/psb?/V11O7sEU1hxZsb/aLcDBQJskCANhyjMNmwdflj8SfnzsG2PZ1owTLHPc88!/b/dI0BAAAAAAAA&bo=7gLCAQAAAAAFAAw!&rf=viewer_4",
                "https://pages.tmall.com/wow/act/16190/3c?acm=201501051336-3.1003.1.937100&aldid=evYkMmhM&gccpm=5589587.818.1.link4xiaoer.813877&scm=1003.1.201501051336-3.OTHER_trafficad1120049665_937100&pos=3&spm=a1z60.7691149.banner.4&scn=tmallapp&_tmallFoot="));
        sliderLayouts.add(new HomeFragmentSliderLayout("洗好大作战-华东", "http://a2.qpic.cn/psb?/V11O7sEU1hxZsb/YtfeZ3kiai0C0p2YqMG8pWvnxz.M*aLwgL5fN5y9.Bo!/b/dG8BAAAAAAAA&bo=7gKuAQAAAAAFAGA!&rf=viewer_4",
                "https://pages.tmall.com/wow/chaoshi/act/xhdzz-hd?t=xxdzz&acm=201501051336-5.1003.1.937109&aldid=evYkMmhM&gccpm=5592913.818.1.link4xiaoer.813877&scm=1003.1.201501051336-5.OTHER_trafficad914422424_937109&pos=5&spm=a1z60.7691149.banner.6&scn=tmallapp&_tmallFoot="));
        sliderLayouts.add(new HomeFragmentSliderLayout("天猫狂暑季-图书乐器会场", "http://a3.qpic.cn/psb?/V11O7sEU1hxZsb/hvVbZzrO6b8DDGEoVb*oNEboLbGj1SRfmAwNGpkWmgk!/b/dHYBAAAAAAAA&bo=7gLCAQAAAAAFAAw!&rf=viewer_4",
                "https://pages.tmall.com/wow/act/16190/tsyq?acm=201501051336-7.1003.1.937134&aldid=evYkMmhM&gccpm=5605397.818.1.link4xiaoer.813877&scm=1003.1.201501051336-7.OTHER_trafficad774607649_937134&pos=7&spm=a1z60.7691149.banner.8&scn=tmallapp&_tmallFoot="));
    }

    public void initSlider() {


        for (int i = 0; i < sliderLayouts.size(); i++) {
            TextSliderView textSliderView = new TextSliderView(this.getActivity());
            textSliderView.description(sliderLayouts.get(i).getDescription());
            final int finalI = i;
            textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    Intent intent = new Intent(getActivity(), WebActivity.class);
                    intent.putExtra("webUrl", sliderLayouts.get(finalI).getWebUrl());
                    startActivity(intent);
                }
            });
            textSliderView.image(sliderLayouts.get(i).getImageUrl());
            sliderShow.addSlider(textSliderView);
        }
        //设置动画
        //sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        // sliderShow.setPresetTransformer(SliderLayout.Transformer.RotateUp);
        sliderShow.setDuration(10000);
    }

    private void showList(final List<ShopFragmentGrieViewBean> apk_list) {

        int size = apk_list.size();
        int length = 100;
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        int gridviewWidth = (int) (size * (length + 4) * density);
        int itemWidth = (int) (length * density);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                gridviewWidth, LinearLayout.LayoutParams.FILL_PARENT);

        mGridView.setLayoutParams(params); // 设置GirdView布局参数,横向布局的关键
        mGridView.setColumnWidth(itemWidth); // 设置列表项宽
        mGridView.setHorizontalSpacing(5); // 设置列表项水平间距
        mGridView.setStretchMode(GridView.NO_STRETCH);
        mGridView.setNumColumns(apk_list.size()); // 设置列数量=列表集合数
        adapter1 = new ShopFragmentGrieViewAdapter(getActivity(), apk_list, R.layout.fragment_shop_gridview_item);
        mGridView.setAdapter(adapter1);
        initRecyclerViewData();
        setListViewHeightBasedOnChildren(mRecyclerView);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra("webUrl", apk_list.get(position).getUrl());
                startActivity(i);
            }
        });

    }

    private void initMarquee() {
        final List<String> info = new ArrayList<>();
        info.add("特价 手机电脑五折、没错 就是五折");
        info.add("火爆 休闲 男装赶快抢 特价 特价");
        info.add("心中有阳光，脚底有力量！ 李宁鞋");
        mMarqueeView.startWithList(info);
        // String notice = "心中有阳光，脚底有力量！心中有阳光，脚底有力量！心中有阳光，脚底有力量！";
        //   mMarqueeView.startWithText(notice);
        mMarqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                //  Log.i("TAG", "内容: " + info.get(position));
            }
        });


    }

    /**
     * ScrollView嵌套ListView只显示一行
     * 解决方法  计算出ListView的总高度
     * 然后设置高度
     *
     * @param recycerView
     */
    public void setListViewHeightBasedOnChildren(RecyclerView recycerView) {
        ShopRvAdapter listAdapter = (ShopRvAdapter) recycerView.getAdapter();


         totalHeight = (listAdapter.getItemCount() / 2) * (300 + 204);
        final float scale = getActivity().getResources().getDisplayMetrics().density;
        ViewGroup.LayoutParams params = recycerView.getLayoutParams();

        params.height = (int) (totalHeight * scale + 0.5f);


        recycerView.setLayoutParams(params);
    }

    private void initRecyclerViewData() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        final ShopRvAdapter adapter = new ShopRvAdapter(DataServe.ShopRvData());
        mRecyclerView.setAdapter(adapter);


        // 设置 每个item中的子菜单的 监听事件。
        adapter.setOnRecyclerViewItemChildClickListener(new BaseQuickAdapter.OnRecyclerViewItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                String content = null;
                ShopRvItem1Bean status = (ShopRvItem1Bean) adapter.getItem(i);

                switch (view.getId()) {
                    case R.id.shoprv_item_image1:
                        Intent intent = new Intent(getActivity(), WebActivity.class);
                        intent.putExtra("webUrl","https://pages.tmall.com/wow/chaoshi/act/xhdzz-hd?t=xxdzz&acm=201501051336-5.1003.1.937109&aldid=evYkMmhM&gccpm=5592913.818.1.link4xiaoer.813877&scm=1003.1.201501051336-5.OTHER_trafficad914422424_937109&pos=5&spm=a1z60.7691149.banner.6&scn=tmallapp&_tmallFoot=");
                        startActivity(intent);
                        break;
                    case R.id.shoprv_item_image2:
                        Intent intent2 = new Intent(getActivity(), WebActivity.class);
                        intent2.putExtra("webUrl","https://pages.tmall.com/wow/chaoshi/act/xhdzz-hd?t=xxdzz&acm=201501051336-5.1003.1.937109&aldid=evYkMmhM&gccpm=5592913.818.1.link4xiaoer.813877&scm=1003.1.201501051336-5.OTHER_trafficad914422424_937109&pos=5&spm=a1z60.7691149.banner.6&scn=tmallapp&_tmallFoot=");
                        startActivity(intent2);
                    case R.id.shoprv_item_image3:
                        Intent intent3 = new Intent(getActivity(), WebActivity.class);
                        intent3.putExtra("webUrl","https://pages.tmall.com/wow/chaoshi/act/xhdzz-hd?t=xxdzz&acm=201501051336-5.1003.1.937109&aldid=evYkMmhM&gccpm=5592913.818.1.link4xiaoer.813877&scm=1003.1.201501051336-5.OTHER_trafficad914422424_937109&pos=5&spm=a1z60.7691149.banner.6&scn=tmallapp&_tmallFoot=");
                        startActivity(intent3);
                    case R.id.shoprv_item_image4:
                        Intent intent4 = new Intent(getActivity(), WebActivity.class);
                        intent4.putExtra("webUrl","https://pages.tmall.com/wow/chaoshi/act/xhdzz-hd?t=xxdzz&acm=201501051336-5.1003.1.937109&aldid=evYkMmhM&gccpm=5592913.818.1.link4xiaoer.813877&scm=1003.1.201501051336-5.OTHER_trafficad914422424_937109&pos=5&spm=a1z60.7691149.banner.6&scn=tmallapp&_tmallFoot=");
                        startActivity(intent4);
                    case R.id.shoprv_item2_image1:
                        Intent intent5 = new Intent(getActivity(), WebActivity.class);
                        intent5.putExtra("webUrl","https://pages.tmall.com/wow/chaoshi/act/xhdzz-hd?t=xxdzz&acm=201501051336-5.1003.1.937109&aldid=evYkMmhM&gccpm=5592913.818.1.link4xiaoer.813877&scm=1003.1.201501051336-5.OTHER_trafficad914422424_937109&pos=5&spm=a1z60.7691149.banner.6&scn=tmallapp&_tmallFoot=");
                        startActivity(intent5);
                    case R.id.shoprv_item2_image2:
                        Intent intent6 = new Intent(getActivity(), WebActivity.class);
                        intent6.putExtra("webUrl","https://pages.tmall.com/wow/chaoshi/act/xhdzz-hd?t=xxdzz&acm=201501051336-5.1003.1.937109&aldid=evYkMmhM&gccpm=5592913.818.1.link4xiaoer.813877&scm=1003.1.201501051336-5.OTHER_trafficad914422424_937109&pos=5&spm=a1z60.7691149.banner.6&scn=tmallapp&_tmallFoot=");
                        startActivity(intent6);
                    case R.id.shoprv_item2_image3:
                        Intent intent7 = new Intent(getActivity(), WebActivity.class);
                        intent7.putExtra("webUrl","https://pages.tmall.com/wow/chaoshi/act/xhdzz-hd?t=xxdzz&acm=201501051336-5.1003.1.937109&aldid=evYkMmhM&gccpm=5592913.818.1.link4xiaoer.813877&scm=1003.1.201501051336-5.OTHER_trafficad914422424_937109&pos=5&spm=a1z60.7691149.banner.6&scn=tmallapp&_tmallFoot=");
                        startActivity(intent7);
                }
               // Toast.makeText(getActivity(), "第" + (i+1) + "个item的"+content+"nneir", Toast.LENGTH_LONG).show();
            }
        });


        //添加数据加载  加载完了 显示 end
        adapter.openLoadMore(2,true);
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                        @Override
            public void onLoadMoreRequested() {
                mRecyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        if (mCurrentCounter >= 12) {

                            adapter.notifyDataChangedAfterLoadMore(false);
                            adapter.addFooterView(LayoutInflater.from(getActivity()).inflate(R.layout.footview,null));//加载完了，显示底部单子 。
                        } else {

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    adapter.notifyDataChangedAfterLoadMore(DataServe.UpdataShopRv(), true);
                                    mCurrentCounter = adapter.getItemCount();
                                    totalHeight+=(300 + 184);
                                    final float scale = getActivity().getResources().getDisplayMetrics().density;
                                    ViewGroup.LayoutParams params = mRecyclerView.getLayoutParams();

                                    params.height = (int) (totalHeight * scale + 0.5f);


                                    mRecyclerView.setLayoutParams(params);
                                }
                            },3000);

                        }
                    }
                });
            }
        });

    }

}
