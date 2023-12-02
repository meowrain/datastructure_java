package com.test.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        ArtStudent student = (ArtStudent) context.getBean("art");
        student.art();
        Student student1 = (Student) context.getBean("student");
        Student student2 = (Student) context.getBean("student");
        System.out.println(student1 == student2);   //默认为单例模式，对象始终为同一个
        student1.study();
        System.out.println(student1);
        //当容器创建时，默认情况下Bean都是单例的，那么都会在一开始就加载好，对象构造完成后，会执行init-method
        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("application.xml");
//我们可以调用close方法关闭容器，此时容器内存放的Bean也会被一起销毁，会执行destroy-method
        context2.close();
    }
}
