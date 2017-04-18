package cn.shopin.mydagger2test.di.module;

import android.app.Activity;

import cn.shopin.mydagger2test.di.scope.ActivityScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by zcs on 2017/4/15.
 *
 * @desc
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }

}
