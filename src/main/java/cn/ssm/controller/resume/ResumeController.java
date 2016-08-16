package cn.ssm.controller.resume;

import cn.ssm.model.Recruit;
import cn.ssm.model.Resume;
import cn.ssm.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */

@Controller
@RequestMapping(value = "/resume")
public class ResumeController extends BaseResumeController<Resume, Long> {

    @Autowired
    private ResumeService resumeService;

    @RequestMapping(value = "/lists")
    public String lists() {
        return TEMPLATE_PATH +"lists";
    }

    @RequestMapping("updateRes")
    @ResponseBody
    public Resume updateRes(Long id){
        return this.resumeService.selectByPrimaryKey(id);
    }

    @RequestMapping("update")
    @ResponseBody
    public int updateResume(Resume resume) {
        return this.resumeService.updateResume(resume);

    }

    @RequestMapping("delete")
    @ResponseBody
    public int deleteRes(Long id){
        return this.resumeService.deleteByPrimaryKey(id) ;
    }

    @RequestMapping("add")
    @ResponseBody
    public int add(Resume resume) {
        return this.resumeService.add(resume);

    }
}
