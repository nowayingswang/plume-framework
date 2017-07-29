package org.plume.framework.helper;

import org.plume.framework.utils.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * bean辅助类
 * Created by wang on 2017/7/29.
 */
public class BeanHelper {
    /**
     * 定义bean映射，用于存放bean类和bean实例的映射关系
     */
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>,Object>();

    //静态代码块，该类被类加载器装载的时候自动调用
    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for(Class<?> beanClass : beanClassSet){
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass,obj);
        }

    }

    /**
     * 获取bean_map映射
     * @return bean_map映射对象
     */
    public static Map<Class<?>,Object> getBeanMap(){
        return BEAN_MAP;
    }

    /**
     * 获取一个bean实例
     * @param cls bean实例类
     * @return 返回实例对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> cls){
        if(!BEAN_MAP.containsKey(cls)){
            throw new RuntimeException("can not get bean by class : " + cls);
        }
        return (T) BEAN_MAP.get(cls);
    }

}
