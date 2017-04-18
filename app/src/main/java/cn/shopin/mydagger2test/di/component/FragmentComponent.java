package cn.shopin.mydagger2test.di.component;

import android.support.v4.app.Fragment;

import cn.shopin.mydagger2test.di.module.FragmentModule;
import cn.shopin.mydagger2test.di.scope.FragmentScope;
import cn.shopin.mydagger2test.ui.gank.GankMainFragment;
import dagger.Component;

/**
 * Created by zcs on 2017/4/15.
 *
 * @desc
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = {FragmentModule.class})
public interface FragmentComponent {
    Fragment getFragments();

    void inject(GankMainFragment gankMainFragment);
}
