import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.example.dao.UserMapper;
import org.example.pojo.User;
import org.example.util.MyBatisUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class TestMyBatis {
    static Logger logger = Logger.getLogger(TestMyBatis.class);

    @Test
    public void testLog4j() {
        logger.info("info: 进入了testLog4j");
        logger.debug("debug: 进入了testLog4j");
        logger.error("error: 进入了error");
    }

    @Test
    public void getUserList() {
        System.out.println("----------------------getUserList---------------------------");
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getUserList();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserListByLimit() {
        System.out.println("----------------------getUserListByLimit---------------------------");
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put("startIndex",0);
        map.put("pageSize",3);
        List<User> userList = userMapper.getUserListByLimit(map);
        for(User user : userList) {
            System.out.println(user);
        }

    }
    @Test
    public void getUserById() {
        System.out.println("----------------------getUserById---------------------------");
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.getUserById(3);
        System.out.println(user);
        session.close();
    }

    @Test
    public void addUser() {
        System.out.println("----------------------addUser---------------------------");
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User toInsertUser = new User("meowrain", "34324");
        int isSuccess = userMapper.addUser(toInsertUser);
        if (isSuccess == 1) {
            System.out.println("插入成功！");
        }
        session.commit();
        session.close();
    }

    @Test
    public void deleteUser() {
        System.out.println("----------------------deleteUser---------------------------");
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        int isSuccess = userMapper.deleteUserById(2);
        if (isSuccess == 1) {
            System.out.println("删除成功！");
        }
        session.commit();
        session.close();
    }

    @Test
    public void updateUser() {
        System.out.println("----------------------updateUser---------------------------");
        SqlSession session = MyBatisUtils.getSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User("meow", "sdffsssfdsfsdfsdfasdfasfsdf");
        int isSuccess = userMapper.updateUser(user, 3);
        if (isSuccess == 1) {
            System.out.println("更新成功！");
        }
        session.commit();
        session.close();
    }
}
