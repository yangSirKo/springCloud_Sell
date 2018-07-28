package com.ccyang.apigateway.filter;

import com.ccyang.apigateway.enums.ResultStatus;
import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * 限流过滤器
 * @author ccyang
 * @date 2018/7/10 18:08
 */
@Component
public class RateLimiterFilter extends ZuulFilter{

    /**
     * 令牌桶限流， google的 Guava组件已经实现内部逻辑
     * 参数值为 每秒钟放多少个令牌
     */
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        // 比优先级最高的还要高
        return SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        if (!RATE_LIMITER.tryAcquire()){
            RequestContext requestContext = RequestContext.getCurrentContext();
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(ResultStatus.REQUEST_TOO_MUCH.getCode());
        }
        return null;
    }
}
