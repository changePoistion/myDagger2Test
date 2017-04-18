package cn.shopin.mydagger2test.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by zcs on 2017/4/16.
 *
 * @desc
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface GankUrl {

}
