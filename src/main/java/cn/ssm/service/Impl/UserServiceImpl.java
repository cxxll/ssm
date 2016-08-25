package cn.ssm.service.Impl;

import cn.ssm.dao.UserMapper;
import cn.ssm.model.Recruit;
import cn.ssm.model.User;
import cn.ssm.model.UserExample;
import cn.ssm.service.BaseService;
import cn.ssm.service.UserService;
import cn.ssm.util.BaseMapper;
import cn.ssm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/31.
 */

@Service
public class  UserServiceImpl extends BaseServiceImpl<User>  implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    protected BaseMapper<User> getBaseMapper() {
        return userMapper;
    }

    @Override
    public User login(User user) {
        user.setLoginName(user.getLoginName());
        user.setPassword(user.getPassword());
        return this.userMapper.login(user);
    }

    @Override
    public int add(User user) {
        user.setLoginName(user.getLoginName().trim());
        user.setPassword(user.getPassword().    trim());
        return this.userMapper.insert(user);
    }

    @Override
    public String NameExist(String loginName) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andLoginNameEqualTo(loginName) ;
        List<User> usersExampleList = this.userMapper.selectByExample(userExample);
        if(usersExampleList.size()>0){
        return "true";
        }else {
            return  "false";
        }
        }

    @Override
    public void updatePassword(Long id, String oldPassword, String newPassword) {
        oldPassword = oldPassword.trim();
        newPassword = newPassword.trim();
        User user = this.userMapper.confirmPassword(id) ;
        if (user.getPassword().equals(oldPassword)){
            this.userMapper.updatePassword(id , newPassword) ;
        }
          }

    @Override
    public int updateUser(User user) {

        return this.userMapper.updateUser(user);
    }

    @Override
    public List<Recruit> findUser(Long id) {
      return   this.userMapper.findUser(id);
    }

    @Override
    public Page<User> showUserByPage(HttpServletRequest request, HttpServletResponse response) {

            String pageNow = request.getParameter("pageNow");

            Page<User> page = null;

            List<User> users = new ArrayList<User>();

            int totalCount =  userMapper.getUserCount();

            if (pageNow != null) {
                page = new Page(totalCount, Integer.parseInt(pageNow));
                users = this.userMapper.selectUserByPage(page.getStartPos(), page.getPageSize());
            } else {
                page = new Page(totalCount, 1);
                users = this.userMapper.selectUserByPage(page.getStartPos(), page.getPageSize());
            }

            request.setAttribute("user", users);
            request.setAttribute("page", page);

            page.setRecordList(users);

            return page;

        }

    @Override
    public void batchInsert(List<User> userList) {
        userMapper.batchInsert(userList);
    }

    @Override
    public List<Recruit> deletes(Long id) {
        return  userMapper.deletes(id);
    }


}
