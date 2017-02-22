package com.rylanyan.weexdemo;

import android.app.Application;

import com.taobao.weex.InitConfig;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;
import com.taobao.weex.utils.WXLogUtils;

/**
 * Created by rylanyan on 16/7/3.
 */
public class WXApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        WXEnvironment.addCustomOptions("appName","TBSample");
        WXSDKEngine.initialize(this,
                new InitConfig.Builder()
                        .setImgAdapter(new ImageAdapter())
//                        .setDebugAdapter(new PlayDebugAdapter())
                        .build()

        );
        try {
//            WXSDKEngine.registerComponent("wtRichText", WTRichText.class);

            WXSDKEngine.registerModule("myModule", MyModule.class);
        } catch (WXException e) {
            WXLogUtils.e(e.getMessage());
        }

    }
}
