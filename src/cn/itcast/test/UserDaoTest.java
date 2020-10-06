package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("lisi");
        loginuser.setPassword("123456");
        UserDao dao = new UserDao();
        User user = dao.login(loginuser);
        System.out.println(user);

    }
}
