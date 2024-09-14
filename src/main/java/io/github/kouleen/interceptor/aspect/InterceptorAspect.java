package io.github.kouleen.interceptor.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author zhangqing
 * @since 2024/9/14 14:01
 */
@Aspect
public class InterceptorAspect {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Around("@annotation(io.github.kouleen.interceptor.annotations.InterceptorLog)")
    public Object interceptorAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object proceed = null;
        Signature signature = proceedingJoinPoint.getSignature();
        if(signature instanceof MethodSignature methodSignature){
            Method method = methodSignature.getMethod();
            Object[] requestBodyArgs = proceedingJoinPoint.getArgs();
            log.info("InterceptorAspect methodName={},request={}",method.getName(), JSON.toJSONString(requestBodyArgs));
            proceed = proceedingJoinPoint.proceed();
            log.info("InterceptorAspect methodName={},response={}",method.getName(), JSON.toJSONString(proceed));
        }
        return proceed;
    }
}
