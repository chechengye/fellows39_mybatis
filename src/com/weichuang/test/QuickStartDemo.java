package com.weichuang.test;

import com.weichuang.mapper.OrderMapper;
import com.weichuang.mapper.UserMapper;
import com.weichuang.pojo.Order;
import com.weichuang.pojo.User;
import com.weichuang.utils.SqlSessionUtil;
import com.weichuang.vo.QueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class QuickStartDemo {

    @Test
    public void testFn(){

        try {
            //1、获取主配置文件的位置
            String resource = "SqlMapConfig.xml";
            //2、根据文件获取输入流
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            //3、根据输入流获取sql会话工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //4、根据sql会话工厂对象，获取sql会话对象 true: 代表开启事务，可以执行数据库的增删改操作。false：只能进行查询操作
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            //5、从会话对象中获取一个mapper映射
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getAllUser();
            System.out.println(userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFn1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //5、从会话对象中获取一个mapper映射
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUserById(1);
    }

    @Test
    public void testFn2(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //5、从会话对象中获取一个mapper映射
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("zhaoliu");
        user.setSex(1);
        user.setEmail("zhaoliu@126.com");
        userMapper.insertUser(user);
    }
    //需求：根据用户名模糊查询用户信息，查询条件放到QueryVo的user属性中。
    @Test
    public void testFn3(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //5、从会话对象中获取一个mapper映射
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setName("li");
        vo.setUser(user);
        List<User> userList = userMapper.getUsersByQueryVo(vo);
        System.out.println(userList);
    }
    //需求:查询用户表数据条数
    @Test
    public void testFn4(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //5、从会话对象中获取一个mapper映射
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int count = userMapper.getUserCount();
        System.out.println(count);
    }
    //需求：查询订单表order的所有数据
    @Test
    public void testFn5(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //5、从会话对象中获取一个mapper映射
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> orderList = orderMapper.getAllOrder();
        System.out.println(orderList);
    }
    //需求：根据性别和名字查询用户
    @Test
    public void testFn6(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //5、从会话对象中获取一个mapper映射
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
       /* User user = new User();
        user.setSex(1);*/
       String name = "zhaoliu";
       int sex = 1;
        //user.setName("lisi");
        List<User> userList = userMapper.getUsersByNameAndSex(name , sex);
        System.out.println(userList);
    }

    @Test
    public void testFn7(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        //5、从会话对象中获取一个mapper映射
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(2);
        ids.add(3);
        QueryVo vo = new QueryVo();
        vo.setIds(ids);
        Integer[] idArr = {2 , 3};//静态初始化
       /* List<User> userList = userMapper.getUsersByIds(ids);*/
       /* List<User> userList = userMapper.getUsersByQueryVoIds(vo);*/
        List<User> userList = userMapper.getUsersByIds(idArr);

        System.out.println(userList);
    }
}
