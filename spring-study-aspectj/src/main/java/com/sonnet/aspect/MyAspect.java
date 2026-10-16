package com.sonnet.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类
 */
public class MyAspect {

    // 权限校验的方法
    public void checkPrivilege() {
        System.out.println("开启了权限校验");
    }

    // 打印日志的方法
    public void printLog() {
        System.out.println("开启日志打印功能");
    }

    // 开启环绕通知的方法 环绕通知就是在目标方法前后都执行的方法
    public void around(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("开启了环绕通知1");
            joinPoint.proceed();
            System.out.println("开启了环绕通知2");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    // 抛出异常方法的通知 只有目标方法出现异常之后，才会执行的方法
    public void throwing() {
        System.out.println("抛出了异常");
    }

    // 最终通知 不管目标方法有没有出现异常 都会执行该方法
    public void after() {
        System.out.println("最终通知方法执行了");
    }
}
