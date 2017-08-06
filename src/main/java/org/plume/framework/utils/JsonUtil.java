package org.plume.framework.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * json和pojo之间的转化
 * Created by wang on 2017/8/7.
 */
public class JsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 将pojo转换为json
     * @param obj pojo
     * @param <T> pojo类型
     * @return json字符串
     */
    public static <T> String toJson(T obj){
        String json;
        try {
            json = OBJECT_MAPPER.writeValueAsString(obj);
        }catch (Exception e){
            LOGGER.error("convert pojo to json failure!");
            throw new RuntimeException(e);
        }
        return json;
    }

    /**
     * 将json转换为pojo
     * @param json  被转化的json字符串
     * @param type 目标pojo类型
     * @param <T> 返回T类型pojo
     * @return 返回T类型pojo
     */
    public static <T> T fromJson(String json,Class<T> type){
        T pojo;
        try {
            pojo = OBJECT_MAPPER.readValue(json,type);
        } catch (IOException e) {
            LOGGER.error("convert json to pojo failure");
            throw new RuntimeException(e);
        }
        return pojo;
    }

}
