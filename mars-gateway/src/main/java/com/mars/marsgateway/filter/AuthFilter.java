package com.mars.marsgateway.filter;

import com.mars.marsgateway.utils.JWTUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class AuthFilter extends ZuulFilter {

    /**
     * 过滤器类型 pre前置(表示在路由之前执行过滤器 ), post后置
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器的执行顺序
     */
    @Override
    public int filterOrder() {
        return FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER+1;
    }

    /**
     * 是否开启当前过滤器 true开启，false关闭
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器业务
     * @throws ZuulException
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        //得到request对象
        HttpServletRequest request = ctx.getRequest();
        //得到response
        HttpServletResponse response = ctx.getResponse();
        //得到当前的请求url
        String requestURI = request.getRequestURI();
        //判断当前请求是否在白名单内
        List<String> whiteList = new ArrayList<>();
            whiteList.add("/mars/users/register");
            whiteList.add("/mars/users/login");

        for (String whiteUrl: whiteList){
            if (whiteUrl.equals(requestURI)){
                return null;
            }
        }

        //得到token
        String loginToken = request.getHeader("Authorization");
        //判断token是否存在
        if(StringUtils.isBlank(loginToken)){
            //阻止当前访问继续
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("token auth fail");
            ctx.setResponseStatusCode(400);
        }

        //jwt验证，获取userId
        try {
            String userId = JWTUtil.getVal(loginToken, "userId").toString();
            //token值有问题拒绝请求
            if (StringUtils.isEmpty(userId)) {
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
                ctx.setResponseBody("token auth fail");
                return null;
            }
            //token过期拒绝请求
            else if (JWTUtil.isExpiration(loginToken)) {
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
                ctx.setResponseBody("token expired");
                return null;
            }
        }
        catch (Exception e) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            ctx.setResponseBody("token auth fail");
        }


        //return null表示终止当前方法业务的继续，但是还是会通过网关。
        return null;
    }

    //获取客户端ip
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
