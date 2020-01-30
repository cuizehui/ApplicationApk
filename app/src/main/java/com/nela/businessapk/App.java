package com.nela.businessapk;

import android.app.Application;

import com.nela.common.tools.CallWrapper;
import com.nela.common.tools.ServiceManager;

public class App extends Application {

    ServiceManager.IServiceManagerCallback sManagerCallback = new ServiceManager.IServiceManagerCallback() {
        @Override
        public void onConnectedChange(boolean connected, String name) {
            super.onConnectedChange(connected, name);
            CallWrapper.setMessagingUse(true);
        }

        @Override
        public void onOthersChange() {
            super.onOthersChange();
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        ServiceManager.init(getApplicationContext());
        ServiceManager.addCallBack(sManagerCallback);

    }
}
