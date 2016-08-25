package cn.ssm.controller.recruit;

import cn.ssm.model.Recruit;
import cn.ssm.model.User;
import cn.ssm.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */

@Controller
@RequestMapping(value = "recruit")
public class RecruitController extends BaseRecruitController<Recruit , Long> {

    @Autowired
    private RecruitService recruitService;

    @RequestMapping(value = "/list")
    public String list() {
        return TEMPLATE_PATH +"list";
    }

    @RequestMapping(value = "/listA")
    public String listA() {
        return TEMPLATE_PATH +"addRecruit";
    }

    @RequestMapping("updateRec")
    public String updateRec(Long id, Model model){
        model.addAttribute("recs",this.recruitService.selectByPrimaryKey(id));
        return TEMPLATE_PATH +"updateRec";
    }

    @RequestMapping("update")
    public String updateRecruit(Recruit recruit) {
        this.recruitService.updateRecruit(recruit);
        Long id =recruit.getId();
        return "redirect:/recruit/updateRec?id=" +id;

    }

    @RequestMapping("getRecListByUid")              //model 减少侵入性，代替ServletRequest  request
    public String getRecListByUid(User user, Model model) {
      model.addAttribute("recruits",this.recruitService.getRecListByUid(user));
        return TEMPLATE_PATH +"list";
    }

    @RequestMapping("findRecruitResume")
    List<Recruit> findRecruitResume(Long id) {
        return this.recruitService.findRecruitResume(id);
    }


    //为了不想在controller层上加太多东西，选择返回主页
    @RequestMapping("delete")
    public String deleteRec(Long id){
        this.recruitService.deleteByPrimaryKey(id) ;
        return "redirect:/user/theme" ;
    }


    @RequestMapping("add")
    public String add(Recruit recruit) {
        this.recruitService.add(recruit);
        Long id = recruit.getuId();
        return "redirect:/recruit/getRecListByUid?id=" +id;

    }
}
