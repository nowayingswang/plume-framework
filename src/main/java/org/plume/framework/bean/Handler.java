package org.plume.framework.bean;

import java.lang.reflect.Method;

/**
 * 封装action信息
 * Created by wang on 2017/7/29.
 */
public class Handler {
    /**
     * controller类
     */
    private Class<?> controllerClass;
    /**
     * Action方法
     */
    private Method actionMethod;

    public Handler(Class<?> controllerClass,Method actionMethod){
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
