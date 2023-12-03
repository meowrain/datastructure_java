package org.example.entity;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentAOP {
    @After("execution(public void org.example.entity.Student.study())")
    public void after(JoinPoint point) {
        System.out.println("我是后置方法");
    }

    @Before("execution(public void org.example.entity.Student.study())")
    public void before() {
        System.out.println("我是前置方法");
    }
}
