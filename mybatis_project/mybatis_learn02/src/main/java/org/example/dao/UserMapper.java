package org.example.dao;

import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUserList();

    @Select("select * from user limit ${startIndex},${pageSize}")
    List<User> getUserListByLimit(Map<String,Integer> map);
    User getUserById(int id);

    int addUser(User user);

    int deleteUserById(int id);

    int updateUser(@Param("user") User user,@Param("id") int id);



}
