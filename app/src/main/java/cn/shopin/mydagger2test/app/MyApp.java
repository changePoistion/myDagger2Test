package cn.shopin.mydagger2test.app;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import cn.shopin.mydagger2test.di.component.AppComponent;
import cn.shopin.mydagger2test.di.component.DaggerAppComponent;
import cn.shopin.mydagger2test.di.module.AppModule;

/**
 * Created by zcs on 2017/4/15.
 *
 * @desc
 */
public class MyApp extends Application {
    private Set<Activity> allActivities;
    private static MyApp instance;
    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static synchronized MyApp getInstance() {
        return instance;
    }

    public static AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(instance))
                    .build();
        }
        return appComponent;
    }

    public void addActivity(Activity act) {
        try {
            if (allActivities == null) {
                allActivities = new HashSet<>();
            }
            allActivities.add(act);
        } catch (Exception e) {
            Log.d("lloogg", e.getMessage());
        }
    }

    public void removeActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
