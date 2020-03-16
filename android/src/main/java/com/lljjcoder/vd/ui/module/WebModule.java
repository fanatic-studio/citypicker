package com.lljjcoder.vd.ui.module;


import com.lljjcoder.vd.ui.entry.vd_citypicker;

import app.vd.framework.extend.view.ExtendWebView;
import app.vd.framework.extend.view.webviewBridge.JsCallback;
import app.vd.framework.ui.vd;

public class WebModule {

    private static vd_citypicker __obj;

    private static vd_citypicker myApp() {
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
    public static void select(ExtendWebView webView, String object, JsCallback callback) {
        myApp().select(webView.getContext(), object, vd.MCallback(callback));
    }
}
