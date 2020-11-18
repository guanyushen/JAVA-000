package week05.database.src.main.java.user.logic;

import ds.entity.User;
import user.service.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: guanys
 * @version: V1.0
 * @Package: user.logic
 * @ClassName: UserLogic
 * @Description:
 * @Date: 2020/11/17 20:21
 */

public class UserLogic implements UserService {

    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/study?characterEncoding=utf-8";
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "root";

    //使用Statement方式
    public List<User> query() {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
            Statement Stmt = conn.createStatement();
            String sql = "select * from t_user";
            rs = Stmt.executeQuery(sql);
            while(rs.next()){
                User user = new User(rs.getInt("id"),rs.getString("name"));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                ps.close();
                rs.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    //使用批处理方式
    public void add(List<User> userList) {

        Connection conn = null;
        PreparedStatement ps = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
            String sql = "insert into t_user(id,name)values(?,?) ";
            ps = conn.prepareStatement(sql);

            for (User user:userList) {
                ps.setInt(1, user.getId());
                ps.setString(2, user.getName());
                ps.addBatch();
            }
            ps.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                ps.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //使用prepareStatement方式
    public int delete(int id) {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
            String sql = "delete from t_user where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                ps.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    //使用事务优化
    public int update(User user) {

        Connection conn = null;
        PreparedStatement ps = null;
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
            // 关闭事务自动提交
            conn.setAutoCommit(false);

            String sql = "update t_user set name = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setInt(2, user.getId());

            result = ps.executeUpdate();
            // 提交事务
            conn.commit();

        } catch (Exception e) {
            try
            {
                // 回滚事务
                conn.rollback();
            } catch (SQLException transaction)
            {
                transaction.printStackTrace();
            }
            e.printStackTrace();
        }finally{
            try {
                ps.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
