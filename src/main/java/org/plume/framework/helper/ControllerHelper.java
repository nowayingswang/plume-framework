package org.plume.framework.helper;

import org.apache.commons.lang3.ArrayUtils;
import org.plume.framework.annotation.Action;
import org.plume.framework.bean.Handler;
import org.plume.framework.bean.Request;
import org.plume.framework.utils.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 控制器助手类
 * Created by wang on 2017/7/29.
 */
public class ControllerHelper {
    private static final Map<Request,Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if(CollectionUtil.isNotEmpty(controllerClassSet)){
            //遍历controll类
            for(Class<?> controllerClass : controllerClassSet){
                //获取controller中定义的方法
                Method[] methods = controllerClass.getDeclaredMethods();
                if(ArrayUtils.isNotEmpty(methods)){
                    //判断当前方法是否含有action注解
                    for(Method method : methods){
                        if(method.isAnnotationPresent(Action.class)){
                            Action action = method.getAnnotation(Action.class);
                            //获取url映射规则
                            String mapping = action.value();
                            if(mapping.matches("\\w+:/\\w*")){
                                String[] array = mapping.split(":");
                                if(ArrayUtils.isNotEmpty(array) && array.length == 2){
                                    //获取请求方法和请求路径
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod,requestPath);
                                    Handler handler = new Handler(controllerClass,method);

                                    //放入映射map中
                                    ACTION_MAP.put(request,handler);
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    /**
     * 获取请求handler
     * @param requestMethod 请求方法
     * @param requestPath 请求路径
     * @return 请求handler
     */
    public static Handler getHandler(String requestMethod,String requestPath){
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }
}
