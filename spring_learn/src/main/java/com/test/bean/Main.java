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
    }
}
