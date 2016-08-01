package cn.ssm.controller.user;

import cn.ssm.model.User;
import cn.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2016/8/1.
 */

@Controller
@RequestMapping(value = "admin/user")
public class UserController extends BaseUserController<User, String> {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public User login(@Valid User user , HttpSession session) {
        try {
            User loginUser = this.userService.login(user);
            if(loginUser != null){
                session.setAttribute("loginUser",loginUser);
                return loginUser ;
            }else {
                return null ;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }

    /**
     * 用户登出
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public int logout(HttpSession session) {
        session.removeAttribute("loginUser");
        return 0;
    }

    @RequestMapping("delete")
    @ResponseBody
       public int deleteUI(String id){
       return this.userService.deleteByPrimaryKey(id) ;
   }

    @RequestMapping("add")
    @ResponseBody
    public int add(User user) {
        return this.userService.add(user);

    }

    @RequestMapping("updateUI")
    @ResponseBody
    public User updateUI(String id){
        return (User) this.userService.selectByPrimaryKey(id);
    }

    /**
     * 用户->个人主页->个人信息->修改信息
     * @param user
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public int update(User user) {
        return this.userService.updateUser(user);

    }

    @RequestMapping("updatePassword")
    @ResponseBody
    public int updatePassword(String id , String oldPassword , String newPassword){
        return this.userService.updatePassword(id , oldPassword , newPassword) ;
    }

    @RequestMapping("findUser")
    @ResponseBody
    public List<User> findUser(String id) {
        return this.userService.findUser(id);
    }


}
