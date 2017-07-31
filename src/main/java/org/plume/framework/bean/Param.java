package org.plume.framework.bean;

import org.plume.framework.utils.CastUtil;

import java.util.Map;

/**
 * 封装请求参数对象
 * Created by wang on 2017/8/1.
 */
public class Param {
    private Map<String,Object> paramMap;

    public Param(Map<String,Object> paramMap){
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获取long类型的参数值
     * @param name 参数名
     * @return 参数值
     */
    public long getLong(String name){
        return CastUtil.castLong(paramMap.get(name));
    }

    /**
     * 获取所有字段信息
     * @return map对象
     */
    public Map<String,Object> getMap(){
        return paramMap;
    }
}
