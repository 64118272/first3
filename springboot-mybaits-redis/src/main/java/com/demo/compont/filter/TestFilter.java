package com.demo.compont.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Administrator on 2018/5/30.
 */

@Component
@WebFilter(urlPatterns = "/*.do", filterName = "test1FilterName")
public class TestFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化。");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //打印相对路径
        System.out.println("doFilter:" + ((HttpServletRequest) request).getRequestURI());

        //绝对路径
        StringBuffer url = ((HttpServletRequest) request).getRequestURL();
        System.out.println("url:"+ ((HttpServletRequest) request).getRequestURL());
        System.out.println("addr:" + request.getRemoteAddr());

        //对于不包括localhost的域名进行过滤，此类应用主要是防止重部署
        if(url.indexOf("localhost") < 0){
            System.out.println("非法访问");
            return ;
        }

        //编码格式
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("销毁过滤器");
    }
}
