package book.manage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Student {
    int sid;
    final String name;
    final String sex;
    final int grade;
}
