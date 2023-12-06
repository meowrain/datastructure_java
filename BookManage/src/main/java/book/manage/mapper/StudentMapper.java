package book.manage.mapper;

import book.manage.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

public interface StudentMapper {
    @Insert("insert into student(name,sex,grade) values (#{name},#{sex},#{grade})")
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "grade", column = "grade")
    })
    int addStudent(Student student);
}
