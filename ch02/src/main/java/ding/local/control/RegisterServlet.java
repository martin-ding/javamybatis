package ding.local.control;

import ding.local.entity.User;
import ding.local.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Stream;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

//        servletContext.setAttribute(, this.context);

        //old
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ap plication.xml");

        //优化之后
//        ServletContext servletContext = getServletContext();
//        String key =  WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
//        ApplicationContext applicationContext = (ApplicationContext) servletContext.getAttribute(key);

        //使用框架提供的方法
        ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        // 获取service
        UserService service = (UserService) applicationContext.getBean("userService");
        System.out.println(service.getClass().getName());
        // List<User> list = userDao.selectUser();
        // list.stream().forEach(System.out::println);
        User user = new User();
        user.setName(name);
        user.setAddress(address);
        user.setEmail(email);
        user.setId(id);
        service.addUser(user);

        //给一个页面
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
