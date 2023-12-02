package org.example.pojo;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Alias("user")
public class User {
    String name;
    String pwd;
}
