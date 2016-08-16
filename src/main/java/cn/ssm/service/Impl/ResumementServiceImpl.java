package cn.ssm.service.Impl;

import cn.ssm.dao.ResumementMapper;
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
}
