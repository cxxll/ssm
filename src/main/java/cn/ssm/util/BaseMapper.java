package cn.ssm.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by Administrator on 2016/7/27.
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {


}
