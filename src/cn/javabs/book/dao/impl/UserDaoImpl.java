package cn.javabs.book.dao.impl;

import cn.javabs.book.dao.UserDao;
import cn.javabs.book.entity.User;
import cn.javabs.book.util.DbcpUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    QueryRunner qrUser = new QueryRunner(DbcpUtils.getDataSource());

    @Override
    public User userLogin(String username, String password) {
        try {
            return qrUser.query("select * from user where username = ? and password = ?",new BeanHandler<User>(User.class),username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int userReg(User user) {
        try {
            return qrUser.update("insert into user (name,username,password,birthday,email,phone,type) values ( ?,?,?,?,?,?,?)",
                    user.getName(),user.getUsername(),user.getPassword(),user.getBirthday(),user.getEmail(),user.getPhone(),user.getType());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int addUser(User user) {
        return userReg(user);
    }

    @Override
    public int deleteUser(int id) {
        try {
            return qrUser.update("delete from user where id = ?",id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateUser(User user) {
        try {
            return qrUser.update("update user set name=?,username=?,password=?,birthday=?,email=?,phone=?,type=?",
                    user.getName(),user.getUsername(),user.getPassword(),user.getBirthday(),user.getEmail(),user.getPhone(),user.getType());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAllUsers() {
        try {
            return qrUser.query("select * from user",new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findUserById(int id) {
        return null;
    }
}
