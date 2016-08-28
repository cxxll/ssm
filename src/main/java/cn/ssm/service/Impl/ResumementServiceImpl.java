package cn.ssm.service.Impl;

import cn.ssm.dao.ResumementMapper;
import cn.ssm.model.Recruit;
import cn.ssm.model.Resume;
import cn.ssm.model.Resumement;
import cn.ssm.service.BaseService;
import cn.ssm.service.ResumementService;
import cn.ssm.util.BaseMapper;

/**
 * Created by Administrator on 2016/8/9.
 */
public class ResumementServiceImpl extends BaseServiceImpl<Resumement> implements ResumementService {

    private ResumementMapper Resumementmapper;
    @Override
    protected BaseMapper<Resumement> getBaseMapper() {
        return (BaseMapper<Resumement>) Resumementmapper;
    }

    @Override
    public int saveRelativity(Resume resume, Recruit recruit ,Resumement resumement) {
            resumement.setResId(resume.getId());
            resumement.setRecId(recruit.getId());
        return this.insert(resumement);
    }
}
