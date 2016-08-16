package cn.ssm.service.Impl;

import cn.ssm.dao.RecruitMapper;
import cn.ssm.model.Recruit;
import cn.ssm.model.User;
import cn.ssm.service.RecruitService;
import cn.ssm.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/7/31.
 */
@Service
public class RecruitServiceImpl extends BaseServiceImpl<Recruit>  implements RecruitService {

    @Autowired
    private RecruitMapper recruitMapper;


    @Override
    protected BaseMapper<Recruit> getBaseMapper() {
        return recruitMapper;
    }

    @Override
    public int updateRecruit(Recruit recruit) {
        return this.recruitMapper.updateRecruit(recruit);
    }

    @Override
    public List<User> getRecListByUid(User user) {
        return this.recruitMapper.getRecListByUid(user);
    }

    @Override
    public List<Recruit> findRecruitResume(Long id) {
        return this.recruitMapper.findRecruitResume(id);
    }

    @Override
    public int add(Recruit recruit) {
            recruit.setName(recruit.getName().trim());
        recruit.setIndustry(recruit.getIndustry());
        recruit.setNature(recruit.getNature());
        recruit.setCompanySize(recruit.getCompanySize());
        recruit.setCompanyProfile(recruit.getCompanyProfile());
        recruit.setContacts(recruit.getContacts());
        recruit.setRecruitmentTelephone(recruit.getRecruitmentTelephone());
        recruit.setCompanyAddress(recruit.getCompanyAddress());
        return this.recruitMapper.insert(recruit);
    }
}
