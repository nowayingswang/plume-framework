package org.plume.framework;

import org.plume.framework.bean.Handler;
import org.plume.framework.helper.BeanHelper;
import org.plume.framework.helper.ConfigHelper;
import org.plume.framework.helper.ControllerHelper;
import org.plume.framework.utils.CodecUtil;
import org.plume.framework.utils.StreamUtil;
import org.plume.framework.utils.StringUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 璇锋眰杞彂鍣�
 * Created by wangpf on 2017/8/4.
 */
@WebServlet(urlPatterns = "/*",loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //初始化相关helper类
        HelperLoader.init();

        //获取servletContext对象，用于注册servlet
        ServletContext serverContext = servletConfig.getServletContext();

        //处理jsp的servlet
        ServletRegistration jspServlet = serverContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");

        //注册用于处理静态资源的默认servlet
        ServletRegistration defaultServlet = serverContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestPath = request.getPathInfo();
        String requestMethod = request.getMethod();
        //获取action处理器
        Handler handler = ControllerHelper.getHandler(requestMethod,requestPath);
        if(handler != null){
            //获取controller类和bean实例
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);
            //创建请求参数对象
            Map<String, Object> paramMap = new HashMap<String, Object>();
            Enumeration<String> paramNames = request.getParameterNames();
            while (paramNames.hasMoreElements()){
                String paramName = paramNames.nextElement();
                String paramValue = request.getParameter(paramName);
                paramMap.put(paramName,paramValue);
            }
            String body = CodecUtil.decodeURL(StreamUtil.getString(request.getInputStream()));
            if(StringUtil.isNotEmpty(body)){
                //TODO body閫昏緫澶勭悊鍒ゆ柇
            }
        }
    }
}
