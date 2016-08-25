package cn.ssm.controller.user;

import cn.ssm.model.Recruit;
import cn.ssm.model.User;
import cn.ssm.service.UserService;
import cn.ssm.util.*;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
//import net.sf.jxls.reader.ReaderBuilder;
//import net.sf.jxls.reader.XLSReader;
//import net.sf.jxls.transformer.XLSTransformer;
import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReader;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.commons.lang3.StringUtils;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2016/8/1.
 */

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseUserController<User, Long> {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/theme")
    public String theme() {
        return TEMPLATE_PATH +"index";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@Valid User user , BindingResult result, HttpSession session , HttpServletRequest request , HttpServletResponse response) throws IOException {
        try {
            User loginUsers = this.userService.login(user);
            if(loginUsers != null){
                 session = request.getSession();
                response.setContentType("text/html;charset=UTF-8");
                if(request.getParameter("code").length() == 4){
                    if(request.getParameter("code").equalsIgnoreCase(session.getAttribute("code").toString())){
                        response.getWriter().write("验证码输入正确");
                        session.setAttribute("loginUser",loginUsers);
                        return TEMPLATE_PATH +"index";
                    }else{
                        response.getWriter().write("验证码输入错误，请重新输入");
                        return "index";
                    }
                }else{
                    response.getWriter().write("请输入四位验证码，不区分大小写");
                    return "index";
                }
            }else {
                return "index" ;
            }
        } catch (Exception e){
            e.printStackTrace();
            return  "500";
        }
    }

    @RequestMapping(value = "/loginout", method = RequestMethod.GET)
    public String loginout(HttpSession session) {
        session.removeAttribute("loginUser");
        return "index";
    }

    @RequestMapping("delete")
       public String deleteUI(Long id){
        this.userService.deleteByPrimaryKey(id) ;
        return  "redirect:/file/UserPage";
   }

    @RequestMapping("add")
    public String add(@Valid User user , BindingResult result) {
        this.userService.add(user);
        return "index";

    }

    @RequestMapping("updateUI")
    public String updateUI(Long id){
        this.userService.selectByPrimaryKey(id);
        return TEMPLATE_PATH +"updateUI";
    }


    @RequestMapping("update")
    public String update(User user ,HttpSession session) {
            try {
                this.userService.updateUser(user);
                Long ids =  user.getId();
                User loginUsers =  this.userService.selectByPrimaryKey(ids);
                session.setAttribute("loginUser",loginUsers);
                return TEMPLATE_PATH +"updateUI";
            }catch (Exception e){
                e.printStackTrace();
            }
            return TEMPLATE_PATH +"updateUI";
        }





    @RequestMapping("passwordUI")
    public String passwordUI(Long id){
        this.userService.selectByPrimaryKey(id);
        return TEMPLATE_PATH +"passwordUI";
    }

    @RequestMapping("updatePassword")
    public String updatePassword(Long id , String oldPassword , String newPassword){
        this.userService.updatePassword(id , oldPassword , newPassword);
        return  TEMPLATE_PATH +"passwordUI";
    }

    @RequestMapping("findUser")
    public List<Recruit> findUser(Long id) {
        return this.userService.findUser(id);
    }

    @RequestMapping("loginNameIsExist")
    @ResponseBody               //如果不使用ResponseBody  则不是返回文字，而是返回地址。由于用异步刷新，所以，需要返回文字，而不是地址。 会显示 Unknow java.lang.boolean
    public String loginNameIsExist(String loginName){
        if(this.userService.NameExist(loginName) == "true"){
            return "true" ;  //登录名已存在
        }else {
            return "false" ; //登录名可用
        }
    }


    @RequestMapping("showUser")
    public String showUser(Model model){
        model.addAttribute("users",this.userService.selectAll());
        return  "/WEB-INF/admin/showUser";
    }


}
