package org.example.bean;

import org.example.config.MainConfiguration;
import org.example.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        Student student = (Student) context.getBean("student");
        student.study();
        System.out.println(student);
//        student.asyncTest();
//        student.syncTest();    //同步执行
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name");   //继续访问数组的length属性
        exp.setValue(student, "刻师傅");
        System.out.println(exp.getValue(student));
        student.study();
    }
}
