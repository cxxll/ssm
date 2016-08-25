package cn.ssm.controller.admin;

import cn.ssm.model.Admin;

import cn.ssm.service.AdminService;

import cn.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2016/7/31.
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseAdminController<Admin, String> {

    @Autowired
    private AdminService adminServices;

    @RequestMapping(value = "/first")
    public String first() {
        return TEMPLATE_PATH +"index";
    }

    @RequestMapping(value = "/themes")
    public String themes() {
        return TEMPLATE_PATH +"indexs";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginAdmin(@Valid Admin admin , HttpSession session) {
        try {
            Admin loginAdmin = this.adminServices.loginAdmin(admin);
            if(loginAdmin != null){
                session.setAttribute("loginAdmin",loginAdmin);
                return TEMPLATE_PATH + "indexs" ;
            }else {
                return TEMPLATE_PATH + "index" ;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return TEMPLATE_PATH + "index" ;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutA(HttpSession session) {
        session.removeAttribute("loginAdmin");
        return "/index";
    }

    @RequestMapping("add")
    public String add(Admin admin) {
        this.adminServices.add(admin);

        return TEMPLATE_PATH +"index";


    }

    @RequestMapping(value="/uploadFile",method=RequestMethod.POST)
    @ResponseBody
    public String upload(HttpServletResponse response,HttpServletRequest request) throws IOException{
        String responseStr="";
        MultipartHttpServletRequest multipartRequest =  (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
//String savePath = this.getServletConfig().getServletContext().getRealPath("");
        //savePath = savePath + "/uploads/";
// 文件保存路径  ctxPath本地路径
        String ctxPath=request.getSession().getServletContext().getRealPath("/")+File.separator+"uploadFile";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        String ymd = sdf.format(new Date());
        ctxPath += File.separator + ymd + File.separator;
        System.out.println("ctxpath="+ctxPath);
// 创建文件夹
        File file = new File(ctxPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String fileName = null;
        for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
// 上传文件
            MultipartFile mf = entity.getValue();
            fileName = mf.getOriginalFilename();//获取原文件名
            System.out.println("filename="+fileName);
            File uploadFile = new File(ctxPath + fileName);
            try {
                FileCopyUtils.copy(mf.getBytes(), uploadFile);
                responseStr="上传成功";
            } catch (IOException e) {
                responseStr="上传失败";
                e.printStackTrace();
            }
        }
        return responseStr;
    }

    @RequestMapping("updateEditor")
    public String updateEditor(Long id ,String title ,String textarea){
        this.adminServices.updateEditor(id ,title ,textarea);
        return  TEMPLATE_PATH + "indexs";
    }

    @RequestMapping("showBoard")
    public String showBoard(Long id ,HttpServletRequest request){
       Admin admin = this.adminServices.showBoard(id);
        request.setAttribute("Board" , admin);
        return   "/Boards";
    }


}

