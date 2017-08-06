package org.plume.framework.utils;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 流操作工具类
 * Created by wang on 2017/8/6.
 */
public class StreamUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamUtil.class);

    /**
     * 从输入流中获取字符串
     * @param is 输入流
     * @return 输入流里的字符串
     */
    public static String getString(InputStream is){
        StringBuilder sb = new StringBuilder(); //不是线程安全的
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null){
                sb.append(line);
            }
        }catch (IOException e){
            LOGGER.error("get string failure!");
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
