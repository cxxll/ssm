package cn.ssm.controller.admin;

import cn.ssm.model.Admin;
import cn.ssm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/7/31.
 */

@Controller
@RequestMapping(value = "admin/admin")
public class AdminController extends BaseAdminController<Admin, String> {

    @Autowired
    private AdminService adminService;


}
