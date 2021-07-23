package ding.local.services.imp;

import config.Myconfig;
import ding.local.dao.Student;
import ding.local.dao.mm;
import ding.local.hub.dao.Student2;
import ding.local.services.SomeServices;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.File;

@Repository
@Component
@Service
@Controller
public class SomeServicesImplTest {

    @Test
    public void testA() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("web.xml");
        Student2 bean = (Student2) applicationContext.getBean("student2");
        bean.call();
        System.out.println(bean);
    }

    @Test
    public void testB() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Myconfig.class);
        mm bean = (mm) applicationContext.getBean("student");
        Object a = null;
        try {
            a = bean.call();
        } catch (Exception e) {
//            e.printStackTrace();
        }
        System.out.println(a);
        System.out.println(bean);
    }

}
