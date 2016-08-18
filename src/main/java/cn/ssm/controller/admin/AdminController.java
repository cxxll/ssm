package cn.ssm.controller.admin;

import cn.ssm.model.Admin;

import cn.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Administrator on 2016/7/31.
 */

@Controller
@RequestMapping(value = "admin")
public class AdminController extends BaseAdminController<Admin, String> {

    @Autowired
    private AdminService adminServices;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Admin loginAdmin(@Valid Admin admin , HttpSession session) {
        try {
            Admin loginAdmin = this.adminServices.loginAdmin(admin);
            if(loginAdmin != null){
                session.setAttribute("loginAdmin",loginAdmin);
                return loginAdmin ;
            }else {
                return null ;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null ;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public int logoutA(HttpSession session) {
        session.removeAttribute("loginAdmin");
        return 0;
    }

    @RequestMapping("add")
    public int add(Admin admin) {
        return this.adminServices.add(admin);

    }

}
