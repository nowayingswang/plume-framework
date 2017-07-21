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
     * @return ����һ��jdbc����
     */
    public static String getJdbcDriver(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
    }

    /**
     * ��ȡjdbc url
     * @return ����һ��jdbc url
     */
    public static String getJdbcUrl(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_URL);
    }

    /**
     * ��ȡjdbc�û���
     * @return ����jdbc�û���
     */
    public static String getJdbcUsername(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_USERNAME);
    }

    /**
     * ��ȡjdbc����
     * @return ����jdbc����
     */
    public static String getJdbcPassword(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_PASSWORD);
    }

    /**
     * ��ȡӦ�û�������
     * @return ����Ӧ�û�������
     */
    public static String getAppBasePackage(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_BASE_PACKAGE);
    }

    /**
     * ��ȡӦ��jsp·����Ϣ
     * @return ����Ӧ��jsp·����Ϣ
     */
    public static String getAppJspPath(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_JSP_PATH,"/WEB-INF/view");
    }

    /**
     * ��ȡӦ�þ�̬��Դ·����Ϣ
     * @return ����Ӧ�þ�̬��Դ·����Ϣ
     */
    public static String getAppAssetPath(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_ASSET_PATH,"/asset");
    }

}
