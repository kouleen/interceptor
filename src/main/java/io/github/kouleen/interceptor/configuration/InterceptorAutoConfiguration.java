package io.github.kouleen.interceptor.configuration;


import io.github.kouleen.interceptor.aspect.InterceptorAspect;
import org.springframework.context.annotation.Bean;

/**
 * @author zhangqing
 * @since 2024/9/14 13:50
 */
public class InterceptorAutoConfiguration {

    @Bean
    public InterceptorAspect interceptorAspect(){
        return new InterceptorAspect();
    }
}
