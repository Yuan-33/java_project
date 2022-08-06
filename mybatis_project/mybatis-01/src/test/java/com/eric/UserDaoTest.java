package com.eric;

import com.eric.dao.UserDao;
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
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<Student> stuList = userDao.getStuList();

        for (Student stu : stuList) {
            System.out.println(stu);
        }

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Student stu = userDao.getUserById(1);
        System.out.println(stu);

        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void insertStu(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int val = userDao.insertStu(new Student(5,"老六","123456"));
        if (val>0){
            System.out.println("插入成功");
        }
        // 增删改需要commit事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void updateStu(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        userDao.updateStu(new Student(3,"小四","1234567"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteStu(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.deleteStu(1);
        // 增删改需要commit事务
        sqlSession.commit();
        //关闭SqlSession
        sqlSession.close();
    }



}
