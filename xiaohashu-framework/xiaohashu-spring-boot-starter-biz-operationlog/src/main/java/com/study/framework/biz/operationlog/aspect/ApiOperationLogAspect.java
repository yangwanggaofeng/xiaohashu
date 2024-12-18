package com.study.framework.biz.operationlog.aspect;

import com.study.framework.common.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @ClassName ApiOperationLogAspect
 * @Description TODO
 * @Author zhang
 * @Date 2024/12/17
 * @Version 1.0
 **/
@Aspect
@Slf4j
public class ApiOperationLogAspect {

    /** 以自定义 @ApiOperationLog 注解为切点，凡是添加 @ApiOperationLog 的方法，都会执行环绕中的代码 */
    @Pointcut("@annotation(com.study.framework.biz.operationlog.aspect.ApiOperationLog)")
    public void apiOperationLog(){
    }
    /**
     * 环绕
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("apiOperationLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //开始时间
        long beginTime = System.currentTimeMillis();
        //获取被请求的类和方法
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();

        //请求入参
        Object[] args = joinPoint.getArgs();
        //入参转JSON字符串
        String argsJsonStr = Arrays.stream(args).map(toJsonStr()).collect(Collectors.joining(", "));

        //功能描述信息
        String description = getApiOperationLogDescription(joinPoint);
        //打印相关请求方法
        log.info("====== 请求开始: [{}],  请求类: {}, 请求方法: {}, 入参: {} ======",
                description, className, methodName, argsJsonStr);
        //执行切点方法
        Object result = joinPoint.proceed();

        //执行耗时
        long executionTime = System.currentTimeMillis() - beginTime;
        log.info("====== 请求结束: [{}], 耗时: {}, 出参: {} ======", description, executionTime, JsonUtils.toJsonString(result));
        return result;
    }

    public String getApiOperationLogDescription(ProceedingJoinPoint  joinPoint){
        //1.从ProceedingJoinPoint 获取MethodSignature
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        //2.使用MethodSignature获取当前被注解的Method
        Method method = signature.getMethod();

        //3.从Method中提取ApiOperartionLog注解
        ApiOperationLog apiOperationLog = method.getAnnotation(ApiOperationLog.class);


        //4.从ApiOperationLog注解中获取description属性
        return apiOperationLog.description();
    }

    /**
     * 转JSON字符串
     *
     */
    private Function<Object, String> toJsonStr(){
        return JsonUtils::toJsonString;
    }
}
