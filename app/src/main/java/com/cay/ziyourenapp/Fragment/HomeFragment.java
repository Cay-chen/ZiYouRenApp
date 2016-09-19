package com.cay.ziyourenapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.cay.ziyourenapp.Activity.WebActivity;
import com.cay.ziyourenapp.Adapter.HomeFragmentListViewAdapter;
import com.cay.ziyourenapp.Bean.HomeFragmentListViewBean;
import com.cay.ziyourenapp.Bean.HomeFragmentSliderLayout;
import com.cay.ziyourenapp.R;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/6.
 */
public class HomeFragment extends Fragment {
    private SliderLayout sliderShow;
    private HomeFragmentListViewAdapter listViewAdapter;
    private ArrayList<HomeFragmentListViewBean> apk_list;
    private List<HomeFragmentSliderLayout> sliderLayouts;
    private MarqueeView mMarqueeView;
    private GridView gridView;
    private ListView listView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fargment_home, container, false);
        sliderShow = (SliderLayout) view.findViewById(R.id.slider);
        mMarqueeView = (MarqueeView) view.findViewById(R.id.marqueeView);
        gridView = (GridView) view.findViewById(R.id.gridview_home);
        listView = (ListView) view.findViewById(R.id.listview_home);
        initSlider();
        initGridView();
        showList(apk_list);
        initMarquee();
        return view;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSliderData();
        setListViewData();

    }

    private void initMarquee() {
        final List<String> info = new ArrayList<>();
        info.add("特价 380元牛背山3日游，赶快抢！");
        info.add("火爆 九寨沟跟团游6.0折，速点击！");
        info.add("色达心灵的净土，必去一次！");
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

    private void showList(final ArrayList<HomeFragmentListViewBean> apk_list) {
            listViewAdapter = new HomeFragmentListViewAdapter(this.getActivity(), apk_list);
            listView.setAdapter(listViewAdapter);
            setListViewHeightBasedOnChildren(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), WebActivity.class);
                i.putExtra("webUrl", apk_list.get(position).getzImageUrl());
                startActivity(i);
            }
        });

    }

    private void setListViewData() {
        apk_list = new ArrayList<HomeFragmentListViewBean>();
        apk_list.add(new
                HomeFragmentListViewBean("3/22", "醉美长坪沟穿越毕棚沟", "689浏览", "http://a1.qpic.cn/psb?/V11O7sEU1hxZsb/h8*1FJ9b4Y9o.6dsqIWon9nm9cxvcq*bXBslz2wKf0I!/b/dKsAAAAAAAAA&bo=rQTIAq0EyAIDACU!&rf=viewer_4", "http://e.eqxiu.com/s/7judTQFi?eqrcode=1&from=groupmessage&isappinstalled=0#rd" ));

        apk_list.add(new
                HomeFragmentListViewBean("4/30", "寻找心中的那一片净土", "998浏览", "http://a2.qpic.cn/psb?/V11O7sEU1hxZsb/xWiWzrwJn52RLWUTzbs7vZeMyKCoYbTptHj7XVPaazM!/b/dKYAAAAAAAAA&bo=hAP.AYQD*gEFCSo!&rf=viewer_4",
                "http://mp.weixin.qq.com/s?__biz=MzI2MDE2OTIxOQ==&mid=2649772497&idx=2&sn=bd05e081f218bf449b3e36fb02d4d45c&scene=0#wechat_redirect" ));
        apk_list.add(new
                HomeFragmentListViewBean("5/1", "“五一”假期你可以怎么玩？", "1348浏览", "http://a2.qpic.cn/psb?/V11O7sEU1hxZsb/DH2WvYGREQ.kiXi2w7sONq.Mk*8*BnlRaInHlqCrM8Q!/b/dPoAAAAAAAAA&bo=NAQkAzQEJAMDACU!&rf=viewer_4",
                "http://mp.weixin.qq.com/s?__biz=MjM5NjY1MjkwMA==&mid=2651498057&idx=1&sn=5fd59ed29493f8af790b63b1ef0acaf0&scene=0#wechat_redirect"));
        apk_list.add(new
                HomeFragmentListViewBean("4/12", "希尔基斯朵神山", "2659浏览", "http://a1.qpic.cn/psb?/V11O7sEU1hxZsb/nGY99U2X*ESdpCIyUBD1h8V7qOqwNysF3oNxxjOv53o!/b/dKsAAAAAAAAA&bo=fQJ8AX0CfAEDACU!&rf=viewer_4",
                "http://mp.weixin.qq.com/s?__biz=MzI3NjAyMTc0MA==&mid=2650673143&idx=1&sn=ea76af1ec15bdbc83e73e43a822db5de&scene=0#wechat_redirect"));
        apk_list.add(new
                HomeFragmentListViewBean("4/30", "“五一”推荐。身在四川，哪些路线你去过？", "289浏览", "http://b387.photo.store.qq.com/psb?/V11VsYBN1gHBMm/X8rJbPMT2nkYLFvl4u7l*a2t3Hlc84iB2nGfPRZxIPk!/b/dHWisea7PAAA&bo=wAOAAlYFjwMBCrM!&rf=viewer_4",
                "http://mp.weixin.qq.com/s?__biz=MzI2MDE2OTIxOQ==&mid=2649772506&idx=1&sn=587f1353e614ed47436a91a4d8e8e76a&scene=0#wechat_redirect"));


    }

    private void setSliderData() {
        sliderLayouts = new ArrayList<HomeFragmentSliderLayout>();
        sliderLayouts.add(new HomeFragmentSliderLayout("徒步牛背山", "http://b161.photo.store.qq.com/psb?/V11VsYBN4AHEjb/cnXecK2GMfAyUSTBZCmXNgpEdJG8imJzPqEPtSUTpTs!/b/dKEAAAAAAAAA&bo=hAP7AYQD.wEBCS4!&rf=viewer_4",
                "http://mp.weixin.qq.com/s?__biz=MzI2MDE2OTIxOQ==&mid=2649772497&idx=1&sn=11eafcf77c32ea7f527bd4b2bb337341&scene=0#wechat_redirect"));
        sliderLayouts.add(new HomeFragmentSliderLayout("徒步采樱桃", "http://a3.qpic.cn/psb?/V11O7sEU1hxZsb/jFFagCmtejyvQW32Bfha81safFumeiga*bADHuATp6g!/b/dAoBAAAAAAAA&bo=2wPrAQAAAAAFBxY!&rf=viewer_4",
                "http://mp.weixin.qq.com/s?__biz=MzI2MDE2OTIxOQ==&mid=2649772488&idx=1&sn=f848337bc939f282a54da8c48950eece&scene=0#wechat_redirect"));
        sliderLayouts.add(new HomeFragmentSliderLayout("去梦开始的地方", "http://a2.qpic.cn/psb?/V11O7sEU1hxZsb/2CG*75zkZOHIBHWb8V5tUwccQGz46X0ZfDbmSyvmYGY!/b/dG8BAAAAAAAA&bo=hAP.AYQD*gEFCSo!&rf=viewer_4",
                "http://mp.weixin.qq.com/s?__biz=MzI2MDE2OTIxOQ==&mid=402272445&idx=1&sn=fc8b871e1a9fb3858e37dd3be568dbfa&scene=0#wechat_redirect"));

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
    private void initGridView() {
        final String[] iconName = {"户外", "登山", "徒步", "骑行", "穿越", "自驾", "攀岩", "腐败"};
        int[] icon = {R.mipmap.fuwai,R.mipmap.dengshan,R.mipmap.tubu,R.mipmap.qixing,
                R.mipmap.chuanyue,R.mipmap.zijia,R.mipmap.panyan,R.mipmap.fubai};
         List<Map<String, Object>> data_list =new ArrayList<Map<String, Object>>();
        for(int i=0;i<icon.length;i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }
        //新建适配器
        String [] from ={"image","text"};
        int [] to = {R.id.imageview,R.id.textview};
        SimpleAdapter sim_adapter = new SimpleAdapter(getActivity(), data_list, R.layout.homefrage_gridview_item, from, to);
        //配置适配器
        gridView.setAdapter(sim_adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(),iconName[i],Toast.LENGTH_LONG).show();
            }
        });

    }

    /**
     * ScrollView嵌套ListView只显示一行
     * 解决方法  计算出ListView的总高度
     * 然后设置高度
     * @param listView
     */
    public void setListViewHeightBasedOnChildren(ListView listView) {
        HomeFragmentListViewAdapter listAdapter = (HomeFragmentListViewAdapter) listView.getAdapter();

        // 获取ListView对应的Adapter
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }
}
