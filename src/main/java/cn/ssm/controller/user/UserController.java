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
import org.springframework.util.FileCopyUtils;
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
    public String login(@Valid User user , HttpSession session ,HttpServletRequest request ,HttpServletResponse response) throws IOException {
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
       public int deleteUI(String id){
       return this.userService.deleteByPrimaryKey(id) ;
   }

    @RequestMapping("add")
    public String add(User user) {
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
    public boolean loginNameIsExist(String loginName){
        if(this.userService.NameExist(loginName) == "true"){
            return true ;  //登录名已存在
        }else {
            return false ; //登录名可用
        }
    }



    @RequestMapping("/myProductPage")
    public String showMyProduct(HttpServletRequest request, HttpServletResponse response) {

        Page<User> pageList = null;

        pageList  = userService.showProductsByPage(request, response);

        request.setAttribute("pageList", pageList);

        request.setAttribute("url",  "myProductPage");


        return "showUser";
    }
//
//    @RequestMapping("/write.html")
//    @ResponseBody
//    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception{
//        response.reset();
//        response.setContentType("application/msexcel");
//        response.setContentType("application/octet-stream");
//        String dateStr = DateUtil.getMinute();
//        response.setHeader("Content-disposition","attachment;  filename=\""  + URLEncoder.encode("用户数据汇总" + dateStr + ".xls", "utf-8") + "\"");
//        String templateFileName = request.getSession().getServletContext().getRealPath("/") + "templates/user.xls";
//        System.out.println(templateFileName);
//
//
//        HSSFWorkbook hssfWorkbook = null;
//        InputStream in = null;
//        OutputStream out = null;
//        Map<String, List<User>> map_data = new HashMap<String, List<User>>();
//        List<User> userList =  userService.selectAll();
//        map_data.put("userList", userList);
//       XLSTransformer transformer = new XLSTransformer();
//
//        try {
//            in = new BufferedInputStream(new FileInputStream(templateFileName));
//            hssfWorkbook = (HSSFWorkbook) transformer.transformXLS(in, map_data);
//            out = response.getOutputStream();
//            hssfWorkbook.write(out);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (InvalidFormatException e) {
//            e.printStackTrace();
//        }finally{
//            if(in!=null){
//                in.close();
//            }
//            if(out!=null){
//                out.close();
//            }
//        }
//
//    }
//
//    /**
//     * 执行批量导入操作
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/read.html", method = RequestMethod.POST)
//    public Map<String ,String> read(HttpServletRequest request) {
//        //Map<String ,String> result = new HashMap<String ,String>();
//        Map<String ,String> result = new HashMap<String ,String>();
//        //1、转换文件上传的servlet
//        MultipartHttpServletRequest msRequest = (MultipartHttpServletRequest) request;
//
//        //2、获取文件
//        CommonsMultipartFile cFile = (CommonsMultipartFile) msRequest.getFile("user");
//        //3、判断文件是否是excel文件
//        String origFileName = cFile.getOriginalFilename();
//        if(StringUtils.isNotEmpty(origFileName)) {
//            String suffix = origFileName.substring(origFileName.lastIndexOf("."));
//            if(StringUtils.isNotEmpty(suffix) && (suffix.equals(".xls") || suffix.equals(".xlsx"))) {
//                //4、上传文件
//                String path = request.getSession().getServletContext().getRealPath("/");//获取绝对路径
//                byte[] bfile = cFile.getBytes();
//                String fileName = TimeIdGenerator.getTimeid().substring(0,14) + StringUtil.generateRandomString(4);
//                InputStream inputXML = null;
//                InputStream inputXLS = null;
//                try {
//                    File readFile = new File(path + "/upload/" + fileName + suffix);
//                    FileCopyUtils.copy(bfile, readFile);
//
//                    //5、执行excel文件的读取
//                    String xmlConfig = path + "templates\\xmlConfig\\User.xml";
//                    String dataXLS = path + "/upload/" + fileName + suffix;
//                    inputXML = new FileInputStream(xmlConfig);
//                    XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
//                    inputXLS = new FileInputStream(dataXLS);
//                    List<User> user= new ArrayList<User>();
//                    Map<String, Object> beans = new HashMap<String, Object>();
//                    beans.put("User", user);
//                    mainReader.read(inputXLS, beans);
//                    // 6、删除上传后的文件，这时候没有作用了
//                    File delFile = new File(dataXLS);
//                    if(delFile.exists() && delFile.isFile()) {
//                        delFile.delete();
//                    }
//                    int batchCount = user.size();
//                    if(batchCount == 0) {
//                        result.put("status", "fail");
//                        result.put("message", "不支持导入，数据为空！");
//                        //不支持导入，数据为空！
//                    } else {
//                        //查询所有的数据做对比
//                        User temp= new User();
//                        User ins= new User();
//                        List<User> InfoMobleList=  userService.selectAll();
//                        for(int i = 0; i < batchCount; i++) {
//
//                            ins = user.get(i);
//                            //验证数据库中是否存在数据，若是存在就删除！
//                            for(int j=0;j<InfoMobleList.size();j++){
//                                temp=InfoMobleList.get(j);
//                                if(temp.getId()!=null){
//                                    if(temp.getId().equals(ins.getId())){
//                                        userService.deleteByPrimaryKey(ins.getId());
//                                    }
//                                }
//                            }
//
//                        }
//                    }
//                    //7.验证通过，执行批量插入
//                    userService.batchInsert(user);
//                    result.put("status", "ok");
//                    result.put("message", "批量导入成功！");
//
//                } catch (Exception e) {
//                    result.put("status", "fail");
//                    result.put("message", "批量导入失败！");
//                } finally {
//                    try {
//                        if(inputXML != null) {
//                            inputXML.close();
//                        }
//                        if(inputXLS != null){
//                            inputXLS.close();
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            } else {
//                result.put("status", "fail");
//                result.put("message", "选择要批量导入的文件格式不对！");
//                //选择要批量导入的文件格式不对！
//
//            }
//        } else {
//            result.put("status", "fail");
//            result.put("message", "没有选择要批量导入的excel文件！ ");
//        }
//
//        return result;
//    }


    /**
     * 描述：通过传统方式form表单提交方式导入excel文件
     * @param request
     * @throws Exception
     */
    @RequestMapping(value="upload.do",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public  String  uploadExcel(HttpServletRequest request) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        System.out.println("通过传统方式form表单提交方式导入excel文件！");

        InputStream in =null;
        List<List<Object>> listob = null;
        MultipartFile file = multipartRequest.getFile("upfile");
        if(file.isEmpty()){
            throw new Exception("文件不存在！");
        }
        in = file.getInputStream();
        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());
        in.close();

        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
        for (int i = 0; i < listob.size(); i++) {
            List<Object> lo = listob.get(i);
            User vo = new User();
            vo.setId(Long.valueOf((Long) lo.get(0)));
            vo.setLoginName(String.valueOf(lo.get(1)));
            vo.setPassword(String.valueOf(lo.get(2)));
            vo.setEmail(String.valueOf(lo.get(3)));
            vo.setGender(String.valueOf(lo.get(4)));
            vo.setName(String.valueOf(lo.get(5)));
            vo.setPhoneNumber(String.valueOf(lo.get(6)));
            vo.setAge(String.valueOf(lo.get(7)));

            System.out.println("打印信息-->id:"+vo.getId()+"  账号："+vo.getLoginName()+"   密码："+vo.getPassword());
        }
        return "result";
    }

    /**
     * 描述：通过 jquery.form.js 插件提供的ajax方式上传文件
     * @param request
     * @param response
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value="ajaxUpload.do",method={RequestMethod.GET,RequestMethod.POST})
    public  void  ajaxUploadExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        System.out.println("通过 jquery.form.js 提供的ajax方式上传文件！");

        InputStream in =null;
        List<List<Object>> listob = null;
        MultipartFile  file = multipartRequest.getFile("upfile");
        if(file.isEmpty()){
            throw new Exception("文件不存在！");
        }

        in = file.getInputStream();
        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());

        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
        for (int i = 0; i < listob.size(); i++) {
            List<Object> lo = listob.get(i);
            User vo = new User();
            vo.setId(Long.valueOf((Long) lo.get(0)));
            vo.setLoginName(String.valueOf(lo.get(1)));
            vo.setPassword(String.valueOf(lo.get(2)));

            System.out.println("打印信息-->id:"+vo.getId()+"  账号："+vo.getLoginName()+"   密码："+vo.getPassword());
        }

        PrintWriter out = null;
        response.setCharacterEncoding("utf-8");  //防止ajax接受到的中文信息乱码
        out = response.getWriter();
        out.print("文件导入成功！");
        out.flush();
        out.close();
    }

    @RequestMapping(value="ajaxExport.do",method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public  String  ajaxUploadExcels(HttpServletRequest request,HttpServletResponse response) throws Exception {
        System.out.println("通过 jquery.form.js 提供的ajax方式导出文件！");
        OutputStream os = null;
        Workbook wb = null;    //工作薄

        try {
            //模拟数据库取值
            List<User> lo = new ArrayList<User>();
           lo = this.userService.selectAll();

            //导出Excel文件数据
            ExportExcelUtil util = new ExportExcelUtil();
            File file =util.getExcelDemoFile("/pages/测试模板.xlsx");
            String sheetName="sheet1";
            wb = util.writeNewExcel(file, sheetName,lo);

            String fileName="用户.xlsx";
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode(fileName, "utf-8"));
            os = response.getOutputStream();
            wb.write(os);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            os.flush();
            os.close();
        }
        return null;
    }

}
