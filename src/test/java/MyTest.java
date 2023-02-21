import com.wjx.pojo.User;
import com.wjx.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServiceImpl = (UserService) context.getBean("UserServiceImpl");
        User user = userServiceImpl.getUserByUserName("dxy");
        System.out.println(user);
    }
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServiceImpl = (UserService) context.getBean("UserServiceImpl");
        User user = userServiceImpl.getUserById(1);
        System.out.println(user);
    }
    @Test
    public void test3(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServiceImpl = (UserService) context.getBean("UserServiceImpl");
        User user = new User(0,"temp","This is temp", "Dengxinyi", "dxy@gmail.com", "qqqq", "123456");
        int success = userServiceImpl.addUser(user);
        System.out.println(success);
    }
    @Test
    public void test4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServiceImpl = (UserService) context.getBean("UserServiceImpl");
        User user = new User(2,"tempyes","This is temp", "Dengxinyi", "dxy@gmail.com", "qqqq", "123456");
        int success = userServiceImpl.updateUser(user);
        System.out.println(success);

    }
    @Test
    public void test5(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServiceImpl = (UserService) context.getBean("UserServiceImpl");
        int success = userServiceImpl.deleteUser(2);
        System.out.println(success);
    }
    @Test
    public void test6(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServiceImpl = (UserService) context.getBean("UserServiceImpl");
        List<User> userlist = userServiceImpl.queryAllUser();
        System.out.println(userlist);
    }
}
