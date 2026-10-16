package com.sonnet.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类
 */
@Component
@Aspect // 标识当前类是一个切面类
public class MyAspect {

    // 定义切点
    @Pointcut(value = "execution(* com.sonnet.service.impl.UserServiceImpl.deleteUser(..))")
    public void pointCut1() {

    }

    // 权限校验的方法 @Before注解：前置通知的注解
    @Before(value = "execution(* com.sonnet.service.impl.UserServiceImpl.deleteUser(..))")
    public void checkPrivilege() {
        System.out.println("开启了权限校验");
    }

    // 打印日志的方法 @AfterReturning：后置通知的注解
    //@AfterReturning(value = "execution(* com.sonnet.service.impl.UserServiceImpl.findAll(..))")
    @Before(value = "pointCut1()")
    public void printLog() {
        System.out.println("开启日志打印功能");
    }

    // 开启环绕通知的方法 环绕通知就是在目标方法前后都执行的方法 @Around：环绕通知的注解
    @Around(value = "execution(* com.sonnet.service.impl.UserServiceImpl.updateUser(..))")
    public void around(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("开启了环绕通知1");
            joinPoint.proceed();
            System.out.println("开启了环绕通知2");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    // 抛出异常方法的通知 只有目标方法出现异常之后，才会执行的方法 @AfterThrowing：抛出异常通知的注解
    @AfterThrowing(value = "execution(* com.sonnet.service.impl.UserServiceImpl.addUser(..))")
    public void throwing() {
        System.out.println("抛出了异常");
    }

    // 最终通知 不管目标方法有没有出现异常 都会执行该方法 @After：最终通知的注解
    @After(value = "execution(* com.sonnet.service.impl.UserServiceImpl.addUser(..))")
    public void after() {
        System.out.println("最终通知方法执行了");
    }
}
