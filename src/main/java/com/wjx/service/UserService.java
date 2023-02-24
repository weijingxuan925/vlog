package com.wjx.service;

import com.wjx.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //通过用户名获取用户
    User getUserByUserName(String userName);
    //通过id获取用户
    User getUserById(int id);
    //添加用户
    int addUser(User user);
    //删除用户
    int deleteUser(int id);
    //修改用户
    int updateUser(User user);
    //查询全部用户
    List<User> queryAllUser();
    //根据用户名和密码查找用户
    User queryUserByUsernameAndPassword(String username,String password);
}
