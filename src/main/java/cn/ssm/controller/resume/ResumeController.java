package cn.ssm.controller.resume;

import cn.ssm.model.Resume;
import cn.ssm.model.User;
import cn.ssm.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;


/**
 * Created by Administrator on 2016/8/2.
 */

@Controller
@RequestMapping(value = "/resume")
public class ResumeController extends BaseResumeController<Resume, Long> {

    @Autowired
    private ResumeService resumeService;

//    @RequestMapping(value = "/list")
//    public String list(Model model) {
//        model.addAttribute("resumes",this.resumeService.selectAll());
//        return TEMPLATE_PATH +"list";
//    }

    @RequestMapping(value = "/listA")
    public String listA() {
        return TEMPLATE_PATH +"addResume";
    }

    @RequestMapping("updateRes")
    public String updateRes(Long id,Model model){
        model.addAttribute("res",this.resumeService.selectByPrimaryKey(id));
        return TEMPLATE_PATH +"updateRes";
    }

    @RequestMapping("update")
    public String updateResume(@Valid Resume resume , BindingResult result ,Long id,Model model) {
        if(result.hasErrors()){
            List<ObjectError> ls=result.getAllErrors();
            for (int i = 0; i < ls.size(); i++) {
                System.out.println("error:"+ls.get(i));
            }
            model.addAttribute("res",this.resumeService.selectByPrimaryKey(id));
            return "redirect:/resume/updateRes?id=" +id ;
        }
         this.resumeService.updateResume(resume);
        return  "redirect:/resume/updateRes?id=" +id;

    }

    @RequestMapping("delete")
    public String deleteRes(Long id){
     this.resumeService.deleteByPrimaryKey(id);
        return "redirect:/user/theme" ;
    }

    @RequestMapping("add")
    public String add(@Valid Resume resume , BindingResult result) {
        if(result.hasErrors()){
            List<ObjectError> ls=result.getAllErrors();
            for (int i = 0; i < ls.size(); i++) {
                System.out.println("error:"+ls.get(i));
            }
            return TEMPLATE_PATH +"addResume";
        }
        this.resumeService.add(resume);
        Long id = resume.getuId();
        return "redirect:/resume/getResListByUid?id=" +id;
    }

    @RequestMapping("getResListByUid")              //model 减少侵入性，代替ServletRequest  request
    public String getResListByUid(User user, Model model) {
        model.addAttribute("resumes",this.resumeService.getResListByUid(user));
        return TEMPLATE_PATH +"list";
    }
}
