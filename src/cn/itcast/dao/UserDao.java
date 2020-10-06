package cn.itcast.dao;

import cn.itcast.Util.JDBCUtils;
import cn.itcast.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

//操作数据库中User表的类
public class UserDao {
    //声明JDBC Temple对象来共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource()); //new需要一个数据库连接池
    /**
     * 登录方法
     * @param  //login 只有用户名与密码
     * @return 包含用户全部数据
     */
    public User login(User loginUser){
        try {
            //1.编写sql
            String sql = "select * from user where username = ? and password = ?";
            //2.调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return  user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
