package org.plume.framework;

import com.sun.xml.internal.ws.api.policy.PolicyResolver;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * ����ת����
 * Created by wangpf on 2017/8/4.
 */
@WebServlet(urlPatterns = "/*",loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        //��ʼ�����helper��
        HelperLoader.init();

        //��ȡserverContext��������ע��servlet
        ServletContext serverContext = servletConfig.getServletContext();

        //����jsp��servlet
        ServletRegistration jspServlet = serverContext.getServletRegistration("jsp");
    }
}
