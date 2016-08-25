package cn.ssm.service.Impl;

import cn.ssm.dao.ResumeMapper;
import cn.ssm.model.Recruit;
import cn.ssm.model.Resume;
import cn.ssm.model.User;
import cn.ssm.service.ResumeService;
import cn.ssm.util.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl  extends BaseServiceImpl<Resume>  implements ResumeService {

    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    protected BaseMapper<Resume> getBaseMapper() {
        return resumeMapper;
    }


    @Override
    public int updateResume(Resume resume) {
        return this.resumeMapper.updateResume(resume);
    }

    @Override
    public int add(Resume resume) {
        return  this.resumeMapper.insert(resume);
    }


    @Override
    public List<User> getResListByUid(User user) {
        return this.resumeMapper.getResListByUid(user);
    }

    @Override
    public List<Resume> findRecruitResume(Long id) {
        return resumeMapper.findRecruitResume(id);
    }

}
