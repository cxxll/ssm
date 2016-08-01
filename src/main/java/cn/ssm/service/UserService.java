package cn.ssm.service;

import cn.ssm.model.User;

import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */
public interface UserService extends BaseService<User>{
    public  User login(User user);

    public int add(User user);

    public User NameIsExit(String name);

    int updatePassword(String id, String oldPassword, String newPassword);

    int updateUser(User user);

    int deleteUser(String id);

    List<User> findUser(String id);

}
