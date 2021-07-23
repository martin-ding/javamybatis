package ding.local.services.imp;

import ding.local.dao.UserDao;
import ding.local.entity.User;
import ding.local.services.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @Test
    void testAddUser() throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
//        List<User> list = userDao.selectUser();
//        list.stream().forEach(System.out::println);
        User user = new User();
        user.setName("zhangsan1");
        user.setAddress("zhangs1an");
        user.setEmail("zhangsa1n");
        user.setId(2);
        userDao.insertUser(user);
    }

    @Test
    void testSelect() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.selectUser().stream().forEach(System.out::println);
    }
}