package com.lljjcoder.vd.ui.module;

import com.lljjcoder.vd.ui.entry.vd_citypicker;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;


public class WeexModule extends WXModule {

    private static final String TAG = "vdCitypickerModule";

    private vd_citypicker __obj;

    private vd_citypicker myApp() {
        if (__obj == null) {
            __obj = new vd_citypicker();
        }
        return __obj;
    }

    /***************************************************************************************************/
    /***************************************************************************************************/
    /***************************************************************************************************/

    /**
     * 选择地址
     * @param object
     * @param callback
     */
    @JSMethod
    public void select(String object, JSCallback callback) {
        myApp().select(mWXSDKInstance.getContext(), object, callback);
    }
}
