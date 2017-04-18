package cn.shopin.mydagger2test.di.module;


import android.support.v4.app.Fragment;

import cn.shopin.mydagger2test.di.scope.FragmentScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by zcs on 2017/4/15.
 *
 * @desc
 */
@Module
public class FragmentModule {
    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @FragmentScope
    public Fragment provideFragment() {
        return mFragment;
    }
}
