package com.lljjcoder.eco.ui.module;


import com.lljjcoder.eco.ui.entry.eco_citypicker;

import app.eco.framework.extend.view.ExtendWebView;
import app.eco.framework.extend.view.webviewBridge.JsCallback;
import app.eco.framework.ui.eco;

public class WebModule {

    private static eco_citypicker __obj;

    private static eco_citypicker myApp() {
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
    public static void select(ExtendWebView webView, String object, JsCallback callback) {
        myApp().select(webView.getContext(), object, eco.MCallback(callback));
    }
}
