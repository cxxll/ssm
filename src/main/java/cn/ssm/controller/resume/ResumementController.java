package cn.ssm.controller.resume;

import cn.ssm.model.Recruit;
import cn.ssm.model.Resume;
import cn.ssm.model.Resumement;
import cn.ssm.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/8/28.
 */

@RequestMapping("/resumement")
@Controller
public class ResumementController extends BaseResumeController<Resumement, String>{

    @Autowired
    private ResumeService resumeService;

    @RequestMapping(value = "/SearchRecruit")
    public String SearchRecruit() {
        return  "redirect:/recruit/show";
    }

    @RequestMapping(value = "save")
    public String saveRelativity(Resume resume, Recruit recruit , Resumement resumement ,Long id1 , Long id2){

            System.out.println(id1);
        System.out.println(id2);
        System.out.println("---------------------------");

        System.out.println(recruit.getId());
        System.out.println(resume.getId());
        System.out.println("---------------------------");
        System.out.println(resumement.getRecId());
        System.out.println(resumement.getResId());

        return "/1";
    }
}
