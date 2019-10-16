package com.f1reking.flib.base;

import android.app.Application;
import com.squareup.leakcanary.LeakCanary;

/**
 * @author F1ReKing
 * @date 2019/10/16 13:38
 * @Description
 */
public class BaseLibApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
