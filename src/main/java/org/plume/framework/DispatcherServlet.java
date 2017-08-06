package org.plume.framework;

import org.plume.framework.bean.Handler;
import org.plume.framework.helper.ConfigHelper;
import org.plume.framework.helper.ControllerHelper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");
        ServletRegistration defaultServlet = serverContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestPath = request.getPathInfo();
        String requestMethod = request.getMethod();
        //获取action处理器
        Handler handler = ControllerHelper.getHandler(requestMethod,requestPath);

    }
}
