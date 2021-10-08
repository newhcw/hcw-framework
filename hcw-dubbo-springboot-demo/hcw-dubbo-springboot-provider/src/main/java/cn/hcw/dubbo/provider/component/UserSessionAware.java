package cn.hcw.dubbo.provider.component;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValues;
import org.springframework.web.bind.ServletRequestParameterPropertyValues;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserSessionAware extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
       UserSession userSession = new UserSession();
        BeanWrapper wrapper = new BeanWrapperImpl(userSession);
        PropertyValues pvs = new ServletRequestParameterPropertyValues(request);
        wrapper.setPropertyValues(pvs, true);
        UserSessionHolder.setUserSession(userSession);
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserSessionHolder.clearSession();
        super.afterCompletion(request, response, handler, ex);
    }
}
