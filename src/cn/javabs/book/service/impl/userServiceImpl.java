package cn.javabs.book.service.impl;

import cn.javabs.book.dao.UserDao;
import cn.javabs.book.dao.impl.UserDaoImpl;
import cn.javabs.book.entity.User;
import cn.javabs.book.service.UserService;

import java.util.List;

public class userServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public User userLogin(String username,String password) {
        return userDao.userLogin(username,password);
    }

    @Override
    public int userReg(User user) {
        return userDao.userReg(user);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }
}
