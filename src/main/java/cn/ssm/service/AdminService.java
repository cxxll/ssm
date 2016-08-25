package cn.ssm.service;

import cn.ssm.model.Admin;
import cn.ssm.util.Page;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/7/31.
 */

public interface AdminService extends BaseService<Admin>{
    Admin loginAdmin(Admin admin);

    int add(Admin admin) ;

    void updateEditor(Long id,String title ,String textarea);

    Admin showBoard(Long id);

    Page<Admin> selectTitleByPage(HttpServletRequest request, HttpServletResponse response);
}
