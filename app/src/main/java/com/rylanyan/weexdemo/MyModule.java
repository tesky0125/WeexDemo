package com.rylanyan.weexdemo;

import android.widget.Toast;

import com.taobao.weex.bridge.WXBridgeManager;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.common.WXModuleAnno;

import java.util.HashMap;
import java.util.Map;

/**
 * 见：
 *  https://github.com/weexteam/article/issues/27
 *
 * Created by rylanyan on 14/11/2016.
 */

public class MyModule extends WXModule {

    @WXModuleAnno(runOnUIThread = true)
    public void showToast(String url) {
        Toast.makeText(mWXSDKInstance.getContext(), url, Toast.LENGTH_SHORT).show();
    }

    @WXModuleAnno(runOnUIThread = true)
    public void runAsync(String url, String callbackId) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("ts", url);
        result.put("sin", "i m sin.");
        WXBridgeManager.getInstance().callback(mWXSDKInstance.getInstanceId(), callbackId, result);
    }
}
