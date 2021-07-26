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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    @Test
    void testAddUser() throws IOException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserService service = (UserService) applicationContext.getBean("userService");
        System.out.println(service.getClass().getName());
//        List<User> list = userDao.selectUser();
//        list.stream().forEach(System.out::println);
        User user = new User();
        user.setName("zhangsan1");
        user.setAddress("zhangs1an");
        user.setEmail("zhangsa1n");
        user.setId(2);
        service.addUser(user);
    }



    @Test
    @Transactional(
            propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            rollbackFor = {RuntimeException.class}
    )
    void testSelect() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        UserService service = (UserService) applicationContext.getBean("userService");
        System.out.println(service.getClass().getName());
        service.selectUser().stream().forEach(System.out::println);
    }
}