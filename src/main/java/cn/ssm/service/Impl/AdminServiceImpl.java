package cn.ssm.service.Impl;

import cn.ssm.dao.AdminMapper;
import cn.ssm.model.Admin;
import cn.ssm.service.AdminService;
import cn.ssm.util.BaseMapper;
import cn.ssm.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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
    public void updateEditor(Long id,String title ,String textarea) {
         this.adminMapper.updateEditor(id,title ,textarea);
    }

    @Override
    public Admin showBoard(Long id) {
        return  this.adminMapper.showBoard(id);
    }

    @Override
    public Page<Admin> selectTitleByPage(HttpServletRequest request, HttpServletResponse response) {

        String pageNow = request.getParameter("pageNow");

        Page<Admin> page = null;

        List<Admin> titles = new ArrayList<Admin>();

        int totalCount =  adminMapper.getTitleCount();

        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
            titles = this.adminMapper.selectTitleByPage(page.getStartPos(), page.getPageSize());
        } else {
            page = new Page(totalCount, 1);
            titles = this.adminMapper.selectTitleByPage(page.getStartPos(), page.getPageSize());
        }

        request.setAttribute("titles", titles);
        request.setAttribute("page", page);

        page.setRecordList(titles);

        return page;

    }

    @Override
    protected BaseMapper<Admin> getBaseMapper() {
        return adminMapper;
    }
}
