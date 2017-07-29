package org.plume.framework;

import org.plume.framework.helper.BeanHelper;
import org.plume.framework.helper.ClassHelper;
import org.plume.framework.helper.ControllerHelper;
import org.plume.framework.helper.IocHelper;
import org.plume.framework.utils.ClassUtil;

/**
 * 加载相关类，执行其static代码块
 * Created by wang on 2017/7/29.
 */
public class HelperLoader {

    public static void init(){
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for(Class<?> cls : classList){
            ClassUtil.loadClass(cls.getName(),true);
        }
    }
}
