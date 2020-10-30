package com.lljjcoder.eco.ui.module;

import com.lljjcoder.eco.ui.entry.eco_citypicker;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;


public class WeexModule extends WXModule {

    private static final String TAG = "ecoCitypickerModule";

    private eco_citypicker __obj;

    private eco_citypicker myApp() {
        if (__obj == null) {
            __obj = new eco_citypicker();
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
