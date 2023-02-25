import com.wjx.pojo.Post;
import com.wjx.pojo.User;
import com.wjx.service.PostService;
import com.wjx.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Test
    public void test7() throws ParseException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PostService postServiceImpl = (PostService) context.getBean("PostServiceImpl");

        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        Date time = sdf.parse( nowTime );

        Post post = new Post(1,"http://www.baiu.com","正常","111","http:123","标题","2",time,"1");

        int status = postServiceImpl.addPost(post);
        System.out.println(status);

    }
}
