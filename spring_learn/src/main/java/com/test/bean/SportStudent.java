package com.test.bean;

public class SportStudent extends Student{
    public SportStudent(Teacher teacher, String name) {
        super(teacher, name);
    }

    public void sport(){
        System.out.println("我爱运动");
    }
}