package org.example.entity;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;

@ToString
public class Student implements BeanNameAware, BeanClassLoaderAware {

    @Getter
    String name;

    @Resource(name = "artteacher")
    private Teacher teacher;

    @PostConstruct
    public void init(){
        System.out.println("我是对象初始化时要做的事情！");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("我是对象销毁时要做的事情！");
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void study(){
        System.out.println("学生学习");
        teacher.teach();
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("现阶段获得了bean得名字：" + name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println(classLoader);
    }
    public void syncTest() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"我是同步执行的方法，开始...");
        Thread.sleep(3000);
        System.out.println("我是同步执行的方法，结束！");
    }
    @Async
    public void asyncTest() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"我是异步执行的方法，开始...");
        Thread.sleep(3000);
        System.out.println("我是异步执行的方法，结束！");
    }
}
