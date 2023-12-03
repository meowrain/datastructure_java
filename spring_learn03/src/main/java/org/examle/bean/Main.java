package org.examle.bean;

import org.examle.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Student student = context.getBean(Student.class);
        student.study("java");
        System.out.println(student.getClass());
    }
}
