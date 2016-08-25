package cn.ssm.service;

import cn.ssm.model.Recruit;
import cn.ssm.model.User;
import cn.ssm.util.Page;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


     Page<User> showUserByPage(HttpServletRequest request, HttpServletResponse response);


     void batchInsert(List<User> userList);

     List<Recruit> deletes(Long id);
}
