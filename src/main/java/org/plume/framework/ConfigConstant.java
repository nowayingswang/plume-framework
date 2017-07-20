package org.plume.framework;

/**
 * 定义配置文件的常量接口类
 * Created by wangpf on 2017/7/20.
 */
public interface ConfigConstant {
    /*定义plume-framework框架的入口配置文件*/
    String CONFIG_FILE = "plume.properties";

    /*定义jdbc连接常量*/
    String JDBC_DRIVER = "plume.framework.jdbc.driver";
    String JDBC_URL = "plume.framework.jdbc.url";
    String JDBC_USERNAME = "plume.framework.jdbc.username";
    String JDBC_PASSWORD = "plume.framework.jdbc.password";

    /*项目基础包名*/
    String APP_BASE_PACKAGE = "plume.framework.app.base_package";

    /*项目jsp基础路径*/
    String APP_JSP_PATH = "plume.framework.app.jsp_path";

    /*项目静态资源文件的基础路径*/
    String APP_ASSET_PATH = "plume.framework.app.asset_path";
}
