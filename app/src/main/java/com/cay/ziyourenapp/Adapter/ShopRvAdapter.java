package com.cay.ziyourenapp.Adapter;

import android.view.View;

import com.cay.ziyourenapp.Bean.ShopRvItem1Bean;
import com.cay.ziyourenapp.R;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by C on 2016/7/17.
 */
public class ShopRvAdapter extends BaseMultiItemQuickAdapter<ShopRvItem1Bean> {
    public ShopRvAdapter(List<ShopRvItem1Bean> data) {
        super(data);
        addItemType(ShopRvItem1Bean.ONE, R.layout.shop_rv_item1);
        addItemType(ShopRvItem1Bean.TWO, R.layout.shop_rv_item2);

    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ShopRvItem1Bean shopRvItem1Bean) {

        switch (baseViewHolder.getItemViewType()) {
            case ShopRvItem1Bean.ONE:
               /* baseViewHolder.setText(R.id.shoprv_item1_text_one1, shopRvItem1Bean.getItem1OneText1())
                        .setText(R.id.shoprv_item1_text_two1, shopRvItem1Bean.getItem1TwoText1())
                        .setText(R.id.shoprv_item1_text_two2, shopRvItem1Bean.getItem1TwoText2())
                        .setText(R.id.shoprv_item1_text_tre1, shopRvItem1Bean.getItem1TreText1());*/
                baseViewHolder.setOnClickListener(R.id.shoprv_item_image1, new OnItemChildClickListener() )
                        .setOnClickListener(R.id.shoprv_item_image2,new OnItemChildClickListener())
                        .setOnClickListener(R.id.shoprv_item_image3, new OnItemChildClickListener() )
                        .setOnClickListener(R.id.shoprv_item_image4,new OnItemChildClickListener());


                break;
            case ShopRvItem1Bean.TWO:
                baseViewHolder .setOnClickListener(R.id.shoprv_item2_image1, new OnItemChildClickListener() )
                        .setOnClickListener(R.id.shoprv_item2_image2,new OnItemChildClickListener())
                        .setOnClickListener(R.id.shoprv_item2_image3, new OnItemChildClickListener() );
                break;
        }
    }
}
