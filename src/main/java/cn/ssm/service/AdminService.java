package cn.ssm.service;

import cn.ssm.model.Admin;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/7/31.
 */

public interface AdminService extends BaseService<Admin>{
    Admin loginAdmin(Admin admin);
     int add(Admin admin) ;

    }
