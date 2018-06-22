package com.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    //配置扫描路径
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    //配置druid后台监控 servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean =  new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String ,String> initParams = new HashMap<>();

        //常用参数配置
        initParams.put("loginUsername","admin");  //登录用户名
        initParams.put("loginPassword","admin");  //登录密码
        //initParams.put("allow","localhost");      //白名单
        initParams.put("deny","192.168.3.4");     //黑名单
        bean.setInitParameters(initParams);

       return bean;
    }

    //配置web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();

        bean.setFilter(new WebStatFilter());

        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*");

        bean.setInitParameters(initParams);

        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }

}
