package cn.javabs.book.dao;

import cn.javabs.book.entity.User;

import java.util.List;

public interface UserDao {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    User userLogin(String username, String password);

    /**
     * 用户注册
     * @param user
     * @return
     */
    int userReg(User user);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUser(int id);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 查询全部用户
     * @return
     */
    List<User> findAllUsers();

    /**
     * 根据Id查询用户
     * @param id
     * @return
     */
    User findUserById(int id);

}
