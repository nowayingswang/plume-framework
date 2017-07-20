package org.plume.framework.helper;

import org.plume.framework.ConfigConstant;
import org.plume.framework.utils.PropsUtil;

import java.util.Properties;

/**
 * �����ļ�������
 * Created by wangpf on 2017/7/20.
 */
public class ConfigHelper {
    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * ��ȡjdbc����
     */
    public static String getJdbcDriver(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
    }

    /**
     * ��ȡjdbc url
     */
    public static String getJdbcUrl(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_URL);
    }

}
