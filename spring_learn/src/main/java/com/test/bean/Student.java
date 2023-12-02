package com.test.bean;

import lombok.ToString;

@ToString
public class Student {
    String name = "xiaoming";
    private Teacher teacher;
    public Student(Teacher teacher,String name) {
        this.teacher =teacher;
        this.name = name;
    }

    public void hello() {
        System.out.println("Hello World!");
    }

    //在以前，如果我们需要制定哪个老师教我们，直接new创建对应的对象就可以了
    public void study(){
        teacher.teach();
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
