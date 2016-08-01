package cn.ssm.service.Impl;

import cn.ssm.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/7/27.
 */

@Transactional
public abstract class BaseServiceImpl<T> implements BaseService<T> {
}
