package cn.ssm.service.Impl;

import cn.ssm.dao.AdminMapper;
import cn.ssm.model.Admin;
import cn.ssm.service.AdminService;
import cn.ssm.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/7/31.
 */
@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin>  implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public Admin loginAdmin(Admin admin) {
        admin.setAdminPassword(admin.getAdminPassword().trim());
        return this.adminMapper.loginAdmin(admin);
    }

    public int add(Admin admin) {
        admin.setAdminUser(admin.getAdminUser().trim());
        admin.setAdminPassword(admin.getAdminPassword().trim());
        return this.adminMapper.insert(admin);
    }

    @Override
    protected BaseMapper<Admin> getBaseMapper() {
        return adminMapper;
    }
}
