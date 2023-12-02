package org.example.config;

import org.example.entity.ArtTeacher;
import org.example.entity.ProgramTeacher;
import org.example.entity.Student;
import org.example.entity.Teacher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@Lazy(value = true)
@Scope(scopeName = "prototype")
@PropertySource("classpath:application.properties")
public class MainConfiguration {
    @Bean(name = "teacher")
    public Teacher teacher() {
        return new ProgramTeacher();
    }

    @Bean(name = "artteacher")
    public Teacher artTeacher(){
        return new ArtTeacher();
    }

    @DependsOn("teacher")
    @Bean(name = "student")
    public Student student(@Value("${student.name}") String name){
        Student student = new Student();
        student.setName(name);
        return student;
    }

    //TODO 要在这里写student得具体实现

}
