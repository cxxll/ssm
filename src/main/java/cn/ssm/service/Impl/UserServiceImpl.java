package cn.ssm.service.Impl;

import cn.ssm.dao.UserMapper;
import cn.ssm.model.User;
import cn.ssm.model.UserExample;
import cn.ssm.service.BaseService;
import cn.ssm.service.UserService;
import cn.ssm.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/7/31.
 */

@Service
public class UserServiceImpl extends BaseServiceImpl<User>  implements UserService {

    @Autowired
    private UserMapper userMapper;



    @Override
    public User login(User user) {
        user.setPassword(user.getPassword().trim());
        return this.userMapper.login(user);
    }

    @Override
    public int add(User user) {
        user.setLoginName(user.getLoginName().trim());
        user.setPassword(user.getPassword().trim());
        return this.userMapper.insert(user);
    }

    @Override
    public User NameIsExit(String name) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginNameEqualTo(name) ;
        List<User> usersExampleList = this.userMapper.selectByExample(userExample);
        return usersExampleList.get(0);
    }

    @Override
    public int updatePassword(String id, String oldPassword, String newPassword) {
        oldPassword = oldPassword.trim();
        newPassword = newPassword.trim();
        User u = this.userMapper.confirmPassword(id) ;
        if (u.getPassword().equals(oldPassword)){
            this.userMapper.updatePassword(id , newPassword) ;
            return 0 ;
        }
        return -1 ;    }

    @Override
    public int updateUser(User user) {
        return this.userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(String id) {
        return 0;
    }

    @Override
    public List<User> findUser(String id) {
        return null;
    }


    @Override
    protected BaseMapper<User> getBaseMapper() {
        return null;
    }
}
