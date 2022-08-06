package com.eric.dao;

import com.eric.pojo.Student;

import java.util.List;

public interface UserDao {
    List<Student> getStuList();
    Student getUserById(int id);
    int insertStu(Student stu);
    int updateStu(Student stu);
    int deleteStu(int id);
}
