package org.examle.entity;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class StudentAOP {
    public void afterStudy(JoinPoint point) {
        System.out.println("我是后置方法" + point.getArgs()[0]);
    }
    public void beforeStudy() {
        System.out.println("我是前置方法");
    }

    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("方法开始之前");
        String arg = joinPoint.getArgs()[0] + "伞兵一号";
        Object value = joinPoint.proceed(new Object[]{arg});
        System.out.println("方法执行完成，结果为："+value);
        return value;
    }
}
