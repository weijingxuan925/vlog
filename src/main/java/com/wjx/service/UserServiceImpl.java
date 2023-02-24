package com.wjx.service;

import com.wjx.dao.UserMapper;
import com.wjx.pojo.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        return userMapper.queryUserByUsernameAndPassword(username,password);
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
