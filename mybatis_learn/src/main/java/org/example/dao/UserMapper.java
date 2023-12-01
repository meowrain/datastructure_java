package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int deleteUserById(int id);


    int updateUser(@Param("user") User user,@Param("id") int id);

}
