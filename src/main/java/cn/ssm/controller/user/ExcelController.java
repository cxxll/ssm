package cn.ssm.controller.user;

import cn.ssm.model.User;
import cn.ssm.service.UserService;
import cn.ssm.util.ExportExcel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/24.
 */
@Controller
@RequestMapping(value = "/excel")
public class ExcelController {

    @Autowired
    private UserService userService;

    /**
     * Excel数据导入
     * @param excel
     * @return
     */
    @RequestMapping(value = "/upload")
    public String upload(MultipartFile excel) throws IOException {
        RequestAttributes ar = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) ar).getRequest();
        String uploadPath =request.getSession().getServletContext().getRealPath("") + "/resources/upload";

        //文件流指向excel文件
        InputStream fin= excel.getInputStream();
        HSSFWorkbook workbook=new HSSFWorkbook(fin);//创建工作薄
        HSSFSheet sheet=workbook.getSheetAt(0);//得到工作表
        HSSFRow row=null;//对应excel的行
        HSSFCell cell=null;//对应excel的列

        int totalRow=sheet.getLastRowNum();//得到excel的总记录条数
        //以下的字段一一对应数据库表的字段
        Long id= null;
        String loginName="";
        String password="";
        String email="";
        String gender="";
        String name = "";
        String phoneNumber="";
        String age="";

        for(int i=1;i<=totalRow;i++){
            row=sheet.getRow(i);
            if(row.getCell(0)!=null){
                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                id=Long.parseLong(row.getCell(0).getStringCellValue());
            }
            System.out.println(id);
            cell=row.getCell(1);
            loginName =cell.getRichStringCellValue().toString();
            System.out.println(loginName);
            cell=row.getCell(2);
            password=cell.getRichStringCellValue().toString();
            System.out.println(password);
            cell=row.getCell(3);
            email=cell.getRichStringCellValue().toString();
            System.out.println(email);
            cell=row.getCell(4);
            gender=cell.getRichStringCellValue().toString();
            System.out.println(gender);
            cell=row.getCell(5);
            name=cell.getRichStringCellValue().toString();
            System.out.println(name);
            cell=row.getCell(6);
            phoneNumber=cell.getRichStringCellValue().toString();
            System.out.println(phoneNumber);
            cell=row.getCell(7);
            age=cell.getRichStringCellValue().toString();
            System.out.println(age);

            User user = new User(id ,loginName,password,email,gender,name,phoneNumber,age);
            userService.insert(user);
        }

        return "redirect:/file/UserPage";
    }

    /**
     * Excel数据导出
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/download")
    public String download(HttpSession session, HttpServletResponse response) throws IOException{
        List<User> users = userService.selectAll();
        //调用ExportExcel构建一张Excel表
        ExportExcel<User> ee = new ExportExcel<User>();
        response.setContentType("octets/stream");
        response.addHeader("Content-Disposition","attachment;filename=users.xlsx");
        String[] headers = { "id", "登录账号", "登录密码", "邮箱","性别", "姓名","电话号码" ,"年龄"};
        //存储每一行的表中数据
        List<User> dataset = new ArrayList<User>();
        OutputStream out = response.getOutputStream();
        for(User u:users){
            dataset.add(new User(u.getId(),u.getLoginName(),u.getPassword(),u.getEmail(),u.getGender(),u.getName(),u.getPhoneNumber(),u.getAge()));
        }
        ee.exportExcel(headers, dataset, out);
        out.close();

        return "/admin/themes";
    }


}
