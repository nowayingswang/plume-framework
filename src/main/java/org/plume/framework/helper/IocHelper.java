package org.plume.framework.helper;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang3.ArrayUtils;
import org.plume.framework.annotation.Inject;
import org.plume.framework.utils.CollectionUtil;
import org.plume.framework.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 依赖注入
 * Created by wang on 2017/7/29.
 */
public class IocHelper {

    static {
        //获取所有的bean类与bean实例映射关系
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if(CollectionUtil.isNotEmpty(beanMap)){
            for(Map.Entry<Class<?>,Object> beanEntry : beanMap.entrySet()){
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();

                //获取bean类定义的所有成员方法
                Field[] beanFields = beanClass.getDeclaredFields();
                if(ArrayUtils.isNotEmpty(beanFields)){
                    //遍历bean field
                    for(Field beanField : beanFields){
                        //判断当前bean field是否带有inject注解
                        if(beanField.isAnnotationPresent(Inject.class)){
                            //在bean——map中获取对应实例
                            Object beanFieldInstance = beanMap.get(beanField.getType());
                            if(beanFieldInstance != null){
                                //通过反射初始化bean 的值
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
