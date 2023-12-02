package org.example.entity;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@ToString
public class Student {
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
        teacher.teach();
    }
}
