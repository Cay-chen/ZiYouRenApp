package com.cay.ziyourenapp.Utils;

import com.cay.ziyourenapp.Bean.ShopRvItem1Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by C on 2016/7/17.
 */
public class DataServe {

public static List<ShopRvItem1Bean> ShopRvData(){
    List<ShopRvItem1Bean> list = new ArrayList<ShopRvItem1Bean>();
    for (int i = 0; i < 4; i++) {
        ShopRvItem1Bean multipleItem = new ShopRvItem1Bean();
        String str = null;
        multipleItem.setItemType(ShopRvItem1Bean.ONE);
        if (i % 2== 0) {
         //   str = CYM_CHAD;
            multipleItem.setItemType(ShopRvItem1Bean.TWO);
        }


     //   multipleItem.setContent(str);
        list.add(multipleItem);
    }

    return list;
}
public static List<ShopRvItem1Bean> UpdataShopRv(){
    List<ShopRvItem1Bean> list = new ArrayList<ShopRvItem1Bean>();
    for (int i = 0; i < 2; i++) {
        ShopRvItem1Bean multipleItem = new ShopRvItem1Bean();
        String str = null;
        multipleItem.setItemType(ShopRvItem1Bean.ONE);
        if (i % 2== 0) {
            //   str = CYM_CHAD;
            multipleItem.setItemType(ShopRvItem1Bean.TWO);
        }


        //   multipleItem.setContent(str);
        list.add(multipleItem);
    }

    return list;




}



}
