package org.plume.framework.helper;

import org.plume.framework.ConfigConstant;
import org.plume.framework.utils.PropsUtil;

import java.util.Properties;

/**
 * 属性文件助手类
 * Created by wangpf on 2017/7/20.
 */
public class ConfigHelper {
    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * 获取jdbc驱动
     * @return 返回一个jdbc驱动
     */
    public static String getJdbcDriver(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
    }

    /**
     * 获取jdbc url
     * @return 返回一个jdbc url
     */
    public static String getJdbcUrl(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_URL);
    }

    /**
     * 获取jdbc用户名
     * @return 返回jdbc用户名
     */
    public static String getJdbcUsername(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_USERNAME);
    }

    /**
     * 获取jdbc密码
     * @return 返回jdbc密码
     */
    public static String getJdbcPassword(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_PASSWORD);
    }

    /**
     * 获取应用基础包名
     * @return 返回应用基础包名
     */
    public static String getAppBasePackage(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_BASE_PACKAGE);
    }

    /**
     * 获取应用jsp路径信息
     * @return 返回应用jsp路径信息
     */
    public static String getAppJspPath(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_JSP_PATH,"/WEB-INF/view");
    }

    /**
     * 获取应用静态资源路径信息
     * @return 返回应用静态资源路径信息
     */
    public static String getAppAssetPath(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_ASSET_PATH,"/asset");
    }

}
