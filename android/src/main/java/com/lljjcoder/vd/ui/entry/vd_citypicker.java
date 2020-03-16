package com.lljjcoder.vd.ui.entry;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;

import com.alibaba.fastjson.JSONObject;
import com.lljjcoder.vd.library.city.CityPickerView;
import com.lljjcoder.vd.library.city.bean.CityBean;
import com.lljjcoder.vd.library.city.bean.DistrictBean;
import com.lljjcoder.vd.library.city.bean.ProvinceBean;
import com.lljjcoder.vd.ui.module.WebModule;
import com.lljjcoder.vd.ui.module.WeexModule;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXException;

import java.util.HashMap;
import java.util.Map;

import app.vd.framework.extend.annotation.ModuleEntry;
import app.vd.framework.extend.bean.WebCallBean;
import app.vd.framework.extend.integration.swipebacklayout.BGAKeyboardUtil;
import app.vd.framework.extend.module.vdJson;

@ModuleEntry
public class vd_citypicker {

    /**
     * ModuleEntry
     * @param context
     */
    public void init(Context context) {
        try {
            WXSDKEngine.registerModule("vdCitypicker", WeexModule.class);
        } catch (WXException e) {
            e.printStackTrace();
        }
        WebCallBean.addClassData("vdCitypicker", WebModule.class);
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
        JSONObject json = vdJson.parseObject(object);
        final String province = vdJson.getString(json, "province");
        final String city = vdJson.getString(json, "city");
        final String area = vdJson.getString(json, "area");
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
