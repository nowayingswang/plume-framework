package org.plume.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 编码和解码操作工具类
 * Created by wang on 2017/8/7.
 */
public class CodecUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(StreamUtil.class);

    /**
     * 将url编码
     * @param source url字符串
     * @return 编码之后的url
     */
    public static String encodeURL(String source){
        String target;

        try {
            target = URLEncoder.encode(source,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("encode url failure!");
            throw new RuntimeException(e);
        }
        return target;
    }

    /**
     * 将url解码
     * @param source url字符串
     * @return 解码之后的url
     */
    public static String decodeURL(String source){
        String target;

        try {
            target = URLDecoder.decode(source,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("decode url failure!");
            throw new RuntimeException(e);
        }
        return target;
    }
}
