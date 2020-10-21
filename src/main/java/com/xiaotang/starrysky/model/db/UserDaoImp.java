package com.xiaotang.starrysky.model.db;


import com.xiaotang.starrysky.model.dao.Userdatadb;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 文件名: MysqlData
 * 创建者: 友
 * 创建日期: 2020/9/30 17:01
 * 邮箱: 1738743304.com !
 * 描述: TODO
 */
public class UserDaoImp {


        public static List<Userdatadb> findUserByAll(JdbcTemplate jdbcTemplate) {
        //String sql = "select * from user ORDER BY ID desc  LIMIT 10 ";
        String sql = "select * from user";
        List<Userdatadb> userdatadbList = jdbcTemplate.query(sql, new RowMapper<Userdatadb>() {
            Userdatadb userdatadb = null;

            @Override
            public Userdatadb mapRow(ResultSet resultSet, int i) throws SQLException {
              //  int id = Integer.valueOf(resultSet.getString(1));
                String name = resultSet.getString(2);
                String accout = resultSet.getString(3);
                String password = resultSet.getString(4);
               // String datatime = resultSet.getString(5);

                userdatadb = new Userdatadb(name, accout, password);
               // System.out.println(tempHumi);
                return userdatadb;
            }
        });
        return userdatadbList;
    }
    /**
     * 查询用户
     * @param accout 查询对象
     */
    public  static Userdatadb findUserById(String accout,JdbcTemplate jdbcTemplate) {
        String sql = "select * from user where accout=?";
        //创建一个新的BeanPropertyRowMapper对象，将结果集通过Java的反射机制映射到Java对象中
        RowMapper<Userdatadb> rowMapper = new BeanPropertyRowMapper<Userdatadb>(Userdatadb.class);
        return (Userdatadb) jdbcTemplate.queryForObject(sql, rowMapper, accout);
    }

    /**
     * 增加用户
     * @param userdatadb 增加用户
     */
    public static int  addUser(Userdatadb userdatadb,JdbcTemplate jdbcTemplate) {
        String sql = "insert into user(name,accout,password) values(?,?,?)";
        //使用数组存储SQL语句中的参数
        //名字 账号 密码
        Object[] objects = new Object[]{userdatadb.getName(),userdatadb.getAccout(),userdatadb.getPassword()};
        int result = jdbcTemplate.update(sql, objects);
        return result;
    }


    /**
     * 删除用户
     * @param accout 删除对象
     */
    public  static int deleteUser(String accout,JdbcTemplate jdbcTemplate) {
        String sql = "delete from user where accout=?";
        int result = jdbcTemplate.update(sql, accout);
        System.out.println(result);
        return result;
    }

    /**
     * 修改
     * @param userdatadb 修改对象
     */
    public static int updateUser(Userdatadb userdatadb,JdbcTemplate jdbcTemplate) {
        String sql = "update user set  password=?  ,name=? where accout=?";
        System.out.println(userdatadb.toString());
        Object[] objects = new Object[]{userdatadb.getName(),userdatadb.getPassword(),userdatadb.getAccout()};
        int result = jdbcTemplate.update(sql, objects);
        return result;

    }


}
