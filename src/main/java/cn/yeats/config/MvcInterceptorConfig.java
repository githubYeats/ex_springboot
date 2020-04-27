package cn.yeats.config;

import cn.yeats.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author fyyang
 * @since  2019/9/4 15:16
 * Desc: SpringMVC拦截器的配置类
 */
@Configuration
public class MvcInterceptorConfig implements WebMvcConfigurer {
    /**
     * 将拦截器注册到Spring容器
     *
     * @return 响应
     */
    @Bean
    public MyInterceptor myInterceptor() {
        return new MyInterceptor();
    }

    /**
     * 添加拦截器到spring mvc拦截器链
     * @param registry  拦截器链
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 通过registry添加myInterceptor拦截器，并设置拦截器路径为 /* 或 /**
        /*
            "/*" : 拦截路径类型  一层  http://localhost/hello
            "/**" : 拦截路径类型  多层  http://localhost/hello/hello1
            "/" 表示项目的根目录
                一个*，表示只拦截根目录下内容
                两个*，表示拦截根目录及其子目录下的内容
            拦截的是请求资源的http请求。
         */
        registry.addInterceptor(myInterceptor()).addPathPatterns("/**");
    }
}
