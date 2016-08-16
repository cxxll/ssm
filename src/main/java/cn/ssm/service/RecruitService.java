package cn.ssm.service;

import cn.ssm.model.Recruit;
import cn.ssm.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2016/7/31.
 */

public interface RecruitService extends BaseService<Recruit>{
    int updateRecruit(Recruit recruit);

    List<User> getRecListByUid(User user);

    List<Recruit> findRecruitResume(Long id);

    int add(Recruit recruit);
}
