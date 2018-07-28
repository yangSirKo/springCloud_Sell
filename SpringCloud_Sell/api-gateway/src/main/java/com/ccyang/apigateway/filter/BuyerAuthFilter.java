package com.ccyang.apigateway.filter;

import com.ccyang.apigateway.constants.CookieConstant;
import com.ccyang.apigateway.constants.RedisConstant;
import com.ccyang.apigateway.utils.CookieUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author ccyang
 * @date 2018/7/10 16:54
 * 下订单权限拦截过滤器。(只能买家访问)
 */
@Component
public class BuyerAuthFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return PRE_TYPE;   // "pre"
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;  // 5 - 1 ,放在优先级为5的过滤器之前
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = new RequestContext();
        HttpServletRequest request = requestContext.getRequest();
        if("/order/order/create".equals(request.getRequestURI())){
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {

        /**
         * 方法执行前，需要涉及到的服务忽略敏感头，使其可以传递 cookie
         * /order/create 只能买家访问 (Cookie 里有 openid)
         */
        RequestContext requestContext = new RequestContext();
        HttpServletRequest request = requestContext.getRequest();
        if("/order/order/create".equals(request.getRequestURI())){
            Cookie cookie = CookieUtil.get(request, request.getParameter(CookieConstant.OPENID));
            if(cookie == null || StringUtils.isEmpty(cookie.getValue())){
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            }
        }
        return null;
    }
}
