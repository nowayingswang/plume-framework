package org.plume.framework;

/**
 * ���������ļ��ĳ����ӿ���
 * Created by wangpf on 2017/7/20.
 */
public interface ConfigConstant {
    /*����plume-framework��ܵ���������ļ�*/
    String CONFIG_FILE = "plume.properties";

    /*����jdbc���ӳ���*/
    String JDBC_DRIVER = "plume.framework.jdbc.driver";
    String JDBC_URL = "plume.framework.jdbc.url";
    String JDBC_USERNAME = "plume.framework.jdbc.username";
    String JDBC_PASSWORD = "plume.framework.jdbc.password";

    /*��Ŀ��������*/
    String APP_BASE_PACKAGE = "plume.framework.app.base_package";

    /*��Ŀjsp����·��*/
    String APP_JSP_PATH = "plume.framework.app.jsp_path";

    /*��Ŀ��̬��Դ�ļ��Ļ���·��*/
    String APP_ASSET_PATH = "plume.framework.app.asset_path";
}
