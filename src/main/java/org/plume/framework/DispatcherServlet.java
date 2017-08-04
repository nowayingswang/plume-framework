package org.plume.framework;

import com.sun.xml.internal.ws.api.policy.PolicyResolver;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * 请求转发器
 * Created by wangpf on 2017/8/4.
 */
@WebServlet(urlPatterns = "/*",loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //初始化相关helper类
        HelperLoader.init();

        //获取serverContext对象，用于注册servlet
        ServletContext serverContext = servletConfig.getServletContext();

        //处理jsp的servlet
        ServletRegistration jspServlet = serverContext.getServletRegistration("jsp");
    }
}
