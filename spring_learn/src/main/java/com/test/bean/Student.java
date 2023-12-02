package com.test.bean;

import lombok.ToString;

import java.util.List;
import java.util.Map;

@ToString
public class Student {
    String name = "xiaoming";
    private List<String> list;
    private Map<Integer,String> map;
    private Teacher teacher;
    public Student(Teacher teacher,String name) {
        this.teacher =teacher;
        this.name = name;
    }
    public void init(){
        System.out.println("我是对象初始化时要做的事情！");
    }

    public void destroy(){
        System.out.println("我是对象销毁时要做的事情！");
    }

    public void hello() {
        System.out.println("Hello World!");
    }

    //在以前，如果我们需要制定哪个老师教我们，直接new创建对应的对象就可以了
    public void study(){
        teacher.teach();
    }

    public void outputList() {
        for(String str : list) {
            System.out.println(str);
        }
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<Integer, String> map) {
        this.map = map;
    }
}
