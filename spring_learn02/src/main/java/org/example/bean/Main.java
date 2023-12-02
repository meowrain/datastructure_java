package org.example.bean;

import org.example.config.MainConfiguration;
import org.example.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        Student student = (Student) context.getBean("student");
        student.study();
        System.out.println(student);
    }
}
