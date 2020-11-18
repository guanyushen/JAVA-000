package week05.database.src.main.java.user.logic;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import ds.entity.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: guanys
 * @version: V1.0
 * @Package: user.logic
 * @ClassName: HikariPoolLogic
 * @Description: Hikari数据库连接池
 * @Date: 2020/11/18 14:30
 */

public class HikariPoolLogic {


    public static void main(String[] args) throws Exception {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(UserLogic.JDBC_URL);
        config.setUsername(UserLogic.USER_NAME);
        config.setPassword(UserLogic.PASSWORD);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "100");
        config.addDataSourceProperty("maximumPoolSize", "10");
        DataSource ds = new HikariDataSource(config);
        List<User> userList = queryUserList(ds);
        for (User user:userList) {
            System.out.println(user.toString());
        }
    }

    public static List<User> queryUserList(DataSource ds) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<>();

        try {

            conn = ds.getConnection();
            String sql = "select * from t_user";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
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
}
