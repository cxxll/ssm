package cn.ssm.controller.admin;

import cn.ssm.model.Admin;
import cn.ssm.model.Board;
import cn.ssm.model.User;
import cn.ssm.service.AdminService;
import cn.ssm.service.BoardService;
import cn.ssm.service.UserService;
import cn.ssm.util.ExportExcelUtil;
import cn.ssm.util.ImportExcelUtil;
import cn.ssm.util.Page;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/8/23.
 */
@RequestMapping("/file")
@Controller
public class FileController {

    @Autowired
    private UserService userService;

    @Autowired
    private BoardService boardService;
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

//
//    /**
//     * 描述：通过传统方式form表单提交方式导入excel文件
//     * @param request
//     * @throws Exception
//     */
//    @RequestMapping(value="upload.do",method={RequestMethod.GET,RequestMethod.POST})
//    @ResponseBody
//    public  String  uploadExcel(HttpServletRequest request) throws Exception {
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//        System.out.println("通过传统方式form表单提交方式导入excel文件！");
//
//        InputStream in =null;
//        List<List<Object>> listob = null;
//        MultipartFile file = multipartRequest.getFile("upfile");
//        if(file.isEmpty()){
//            throw new Exception("文件不存在！");
//        }
//        in = file.getInputStream();
//        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());
//        in.close();
//
//        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
//        for (int i = 0; i < listob.size(); i++) {
//            List<Object> lo = listob.get(i);
//            User vo = new User();
//            vo.setId(Long.valueOf((Long) lo.get(0)));
//            vo.setLoginName(String.valueOf(lo.get(1)));
//            vo.setPassword(String.valueOf(lo.get(2)));
//            vo.setEmail(String.valueOf(lo.get(3)));
//            vo.setGender(String.valueOf(lo.get(4)));
//            vo.setName(String.valueOf(lo.get(5)));
//            vo.setPhoneNumber(String.valueOf(lo.get(6)));
//            vo.setAge(String.valueOf(lo.get(7)));
//
//        }
//        return "result";
//    }
//
//    /**
//     * 描述：通过 jquery.form.js 插件提供的ajax方式上传文件
//     * @param request
//     * @param response
//     * @throws Exception
//     */
//    @ResponseBody
//    @RequestMapping(value="ajaxUpload.do",method={RequestMethod.GET,RequestMethod.POST})
//    public  void  ajaxUploadExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//
//        System.out.println("通过 jquery.form.js 提供的ajax方式上传文件！");
//
//        InputStream in =null;
//        List<List<Object>> listob = null;
//        MultipartFile  file = multipartRequest.getFile("upfile");
//        if(file.isEmpty()){
//            throw new Exception("文件不存在！");
//        }
//
//        in = file.getInputStream();
//        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());
//
//        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
//        for (int i = 0; i < listob.size(); i++) {
//            List<Object> lo = listob.get(i);
//            User vo = new User();
//            vo.setId(Long.valueOf((Long) lo.get(0)));
//            vo.setLoginName(String.valueOf(lo.get(1)));
//            vo.setPassword(String.valueOf(lo.get(2)));
//
//            System.out.println("打印信息-->id:"+vo.getId()+"  账号："+vo.getLoginName()+"   密码："+vo.getPassword());
//        }
//
//        PrintWriter out = null;
//        response.setCharacterEncoding("utf-8");  //防止ajax接受到的中文信息乱码
//        out = response.getWriter();
//        out.print("文件导入成功！");
//        out.flush();
//        out.close();
//    }
//
//    @RequestMapping(value="ajaxExport.do",method={RequestMethod.GET,RequestMethod.POST})
//    @ResponseBody
//    public  String  ajaxUploadExcels(HttpServletRequest request,HttpServletResponse response) throws Exception {
//        System.out.println("通过 jquery.form.js 提供的ajax方式导出文件！");
//        OutputStream os = null;
//        Workbook wb = null;    //工作薄
//
//        try {
//            //模拟数据库取值
//            List<User> lo = new ArrayList<User>();
//            lo = this.userService.selectAll();
//
//            //导出Excel文件数据
//            ExportExcelUtil util = new ExportExcelUtil();
//            File file =util.getExcelDemoFile("/pages/测试模板.xlsx");
//            String sheetName="sheet1";
//            wb = util.writeNewExcel(file, sheetName,lo);
//
//            String fileName="用户.xlsx";
//            response.setContentType("application/vnd.ms-excel");
//            response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode(fileName, "utf-8"));
//            os = response.getOutputStream();
//            wb.write(os);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        finally{
//            os.flush();
//            os.close();
//        }
//        return null;
//    }

    @RequestMapping("UserPage")
    public String UserProduct(HttpServletRequest request, HttpServletResponse response) {

        Page<User> pageList = null;

        pageList  = userService.showUserByPage(request, response);

        request.setAttribute("pageList", pageList);

        request.setAttribute("url",  "UserPage");


        return "/WEB-INF/admin/showUser";
    }

    @RequestMapping("/upload.do")
    public String upload(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        // 这里我用到了jar包
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                MultipartFile file = multiRequest.getFile((String) iter.next());
                if (file != null) {
                    String fileName = file.getOriginalFilename();

                    String path1 = Thread.currentThread().getContextClassLoader()
                            .getResource("").getPath();

                    //  下面的加的日期是为了防止上传的名字一样
                    String path = path1
                            + new SimpleDateFormat("yyyyMMddHHmmss")
                            .format(new Date()) + fileName;

                    File localFile = new File(path);

                    file.transferTo(localFile);
                }

            }

        }
        return "/WEB-INF/user/user/index";

    }
    @RequestMapping("/toUpload.do")
    public String toUpload() {
        return "upload";
    }

    @RequestMapping("/download")
    public String download(String fileName, HttpServletRequest request,
                           HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + fileName);
        try {
            String path = Thread.currentThread().getContextClassLoader()
                    .getResource("").getPath()
                    + "pages";//这个download目录为啥建立在classes下的
            InputStream inputStream = new FileInputStream(new File(path
                    + File.separator + fileName));

            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }

            // 这里主要关闭。
            os.close();

            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //  返回值要注意，要不然就出现下面这句错误！
        //java+getOutputStream() has already been called for this response
        return null;
    }

    @RequestMapping("/selectTitleByPage")
    public String selectTitleByPage(HttpServletRequest request, HttpServletResponse response) {

        Page<Board> pageList = null;


        pageList  = boardService.selectTitleByPage(request, response);

        request.setAttribute("pageList", pageList);

        request.setAttribute("url",  "selectTitleByPage");


        return  "/board";
    }
}
