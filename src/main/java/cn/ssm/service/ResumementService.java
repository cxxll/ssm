package cn.ssm.service;

import cn.ssm.model.Recruit;
import cn.ssm.model.Resume;
import cn.ssm.model.Resumement;

/**
 * Created by Administrator on 2016/8/9.
 */
public interface ResumementService  extends BaseService<Resumement>{

    int saveRelativity(Resume resume, Recruit recruit ,Resumement resumement);
}
