package com.eric.dao;

import com.eric.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from stu")
    List<Student> getUsers();

    // 方法存在多个参数，所有的参数前面必须加上 @Param("id")注解
    @Select("select * from user where id = #{id}")
    Student getUserByID(@Param("id") int id);


    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{password})")
    int addUser(Student user);


    @Update("update user set name=#{name},pwd=#{password} where id = #{id}")
    int updateUser(Student user);


    @Delete("delete from user where id = #{uid}")
    int deleteUser(@Param("uid") int id);
}