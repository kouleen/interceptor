package io.github.kouleen.interceptor.annotations;

import java.lang.annotation.*;

/**
 * @author zhangqing
 * @since 2024/9/14 14:00
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface InterceptorLog {

    String value() default "";
}
