package org.plume.framework.bean;

/**
 * 数据对象
 * Created by wang on 2017/8/1.
 */
public class Data {
    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model){
        this.model = model;
    }

    public Object getModel(){
        return model;
    }
}
