package com.eric;

import com.eric.dao.UserMapper;
import com.eric.pojo.Student;
import com.eric.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<Student> stuList = userDao.getUsers();

        for (Student stu : stuList) {
            System.out.println(stu);
        }

        //关闭SqlSession
        sqlSession.close();
    }

}
