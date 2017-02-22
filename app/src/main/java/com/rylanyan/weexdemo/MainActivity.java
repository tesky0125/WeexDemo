package com.rylanyan.weexdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.utils.WXFileUtils;
import com.taobao.weex.utils.WXViewUtils;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    RelativeLayout viewGroup;
    private static final String DEFAULT_IP = "172.19.16.74";
    private static String CURRENT_IP= DEFAULT_IP; // your_current_IP
//    private static final String WEEX_INDEX_URL = "http://"+CURRENT_IP+":3000/examples/build/index.js";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewGroup = (RelativeLayout)findViewById(R.id.viewGroup);
        WXSDKInstance mInstance = new WXSDKInstance(this);
        mInstance.registerRenderListener(new IWXRenderListener() {
            @Override
            public void onViewCreated(WXSDKInstance instance, View view) {
                viewGroup.addView(view);
            }

            @Override
            public void onRenderSuccess(WXSDKInstance instance, int width, int height) {

            }

            @Override
            public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {

            }

            @Override
            public void onException(WXSDKInstance instance, String errCode, String msg) {

            }
        });

        Map<String, Object> options = new HashMap<>();
//        options.put(WXSDKInstance.BUNDLE_URL, WEEX_INDEX_URL);

        // 网络加载
//        mInstance.renderByUrl(
//                getPackageName(),
//                WEEX_INDEX_URL,
//                options,
//                null,
//                WXViewUtils.getScreenWidth(this),
//                WXViewUtils.getScreenHeight(this),
//                WXRenderStrategy.APPEND_ASYNC);

        // 本地加载
        // 编译：weex app.we -o app.js
        // 监听刷新：weex app.we --watch -o app.js
        mInstance.render(
                getPackageName(),
                WXFileUtils.loadFileContent("app.js", this),
                options,
                null,
                WXViewUtils.getScreenWidth(this),
                WXViewUtils.getScreenHeight(this),
                WXRenderStrategy.APPEND_ASYNC);
    }

}
