package cn.shopin.mydagger2test.di.component;

import android.app.Activity;

import cn.shopin.mydagger2test.di.module.ActivityModule;
import cn.shopin.mydagger2test.di.scope.ActivityScope;
import cn.shopin.mydagger2test.ui.main.MainActivity;
import dagger.Component;

/**
 * Created by zcs on 2017/4/15.
 *
 * @desc
 */

/*
* Component有个属性是dependencies，用以指定依赖的Component。
* 那么组件依赖有什么用处呢？想象这样一个场景，有一个MainModule
* 里面的实例化方法需要一个参数假设为Context，现在无法获得这个Context，
* 但是在另一个组件AppComponent里面有，现在我们只需要让管理MainModule
* 的MainComponent组件依赖APPComponent就可以轻松实现。也就是说组件
* 依赖可以让子组件获得父组件暴露出来的对象。
* */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();

    void inject(MainActivity mainActivity);
}
