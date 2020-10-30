package com.lljjcoder.eco.ui.entry;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;

import com.alibaba.fastjson.JSONObject;
import com.lljjcoder.eco.library.city.CityPickerView;
import com.lljjcoder.eco.library.city.bean.CityBean;
import com.lljjcoder.eco.library.city.bean.DistrictBean;
import com.lljjcoder.eco.library.city.bean.ProvinceBean;
import com.lljjcoder.eco.ui.module.WebModule;
import com.lljjcoder.eco.ui.module.WeexModule;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXException;

import java.util.HashMap;
import java.util.Map;

import app.eco.framework.extend.annotation.ModuleEntry;
import app.eco.framework.extend.bean.WebCallBean;
import app.eco.framework.extend.integration.swipebacklayout.BGAKeyboardUtil;
import app.eco.framework.extend.module.ecoJson;

@ModuleEntry
public class eco_citypicker {

    /**
     * ModuleEntry
     * @param context
     */
    public void init(Context context) {
        try {
            WXSDKEngine.registerModule("ecoCitypicker", WeexModule.class);
        } catch (WXException e) {
            e.printStackTrace();
        }
        WebCallBean.addClassData("ecoCitypicker", WebModule.class);
    }

    /****************************************************************************************/
    /****************************************************************************************/
    /****************************************************************************************/

    private CityPickerView cityPicker;

    /**
     * 选择地址
     * @param object
     * @param callback
     */
    public void select(Context context, Object object, final JSCallback callback) {
        JSONObject json = ecoJson.parseObject(object);
        final String province = ecoJson.getString(json, "province");
        final String city = ecoJson.getString(json, "city");
        final String area = ecoJson.getString(json, "area");
        //
        if (cityPicker == null) {
            cityPicker = new CityPickerView.Builder(context)
                    .textSize(17)
                    .areaOther(json.getBooleanValue("areaOther"))
                    .titleTextColor("#000000")
                    .confirTextColor("#333333")
                    .cancelTextColor("#333333")
                    .backgroundPop(0xa0000000)
                    .province(province)
                    .city(city)
                    .district(area)
                    .textColor(Color.parseColor("#000000"))
                    .provinceCyclic(false)
                    .cityCyclic(false)
                    .districtCyclic(false)
                    .visibleItemsCount(8)
                    .itemPadding(10)
                    .build();
        }
        cityPicker.setOnCityItemClickListener(new CityPickerView.OnCityItemClickListener() {
            @Override
            public void onSelected(ProvinceBean province, CityBean city, DistrictBean district) {
                if (callback != null) {
                    Map<String, Object> data = new HashMap<>();
                    data.put("province", province.getName());
                    data.put("city", city.getName());
                    data.put("area", district != null ? district.getName() : "");
                    callback.invoke(data);
                }
            }

            @Override
            public void onCancel() {

            }
        });
        cityPicker.setProvince(province);
        cityPicker.setCity(city);
        cityPicker.setDistrict(area);
        cityPicker.show();
        BGAKeyboardUtil.closeKeyboard((Activity) context);
    }
}
