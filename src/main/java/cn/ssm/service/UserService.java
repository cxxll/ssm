package cn.ssm.service;

import cn.ssm.model.Recruit;
import cn.ssm.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */

public interface UserService extends BaseService<User>{
     public  User login(User user);

     int add(User user);

     String NameExist(String loginName);

     void updatePassword(Long id, String oldPassword, String newPassword);

     int updateUser(User user);

      List<Recruit> findUser(Long id);


}
