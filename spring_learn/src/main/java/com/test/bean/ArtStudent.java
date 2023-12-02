package com.test.bean;

public class ArtStudent extends Student{
    public ArtStudent(Teacher teacher, String name) {
        super(teacher, name);
    }

    public void art(){
        System.out.println("我爱画画");
    }
}