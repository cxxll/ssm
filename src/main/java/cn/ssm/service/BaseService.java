package cn.ssm.service;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by Administrator on 2016/7/27.
 */
public interface BaseService <T>{
     int delete(T t) ;
     int deleteByExample(Object o) ;
     int deleteByPrimaryKey(Object o) ;
     int insert(T t) ;
     int insertList(List<T> list) ;
     int insertSelective(T t) ;
     int insertUseGeneratedKeys(T t) ;
     List<T> select(T t) ;
     T selectOne(T t);
     List<T> selectAll() ;
     List<T> selectByExample(Object o);
     List<T> selectByExampleAndRowBounds(Object o, RowBounds r);
     T selectByPrimaryKey(Object o);
     List<T> selectByRowBounds(T t, RowBounds r);
     int selectCount(T t);
     int selectCountByExample(Object o);
     int updateByExampleSelective(@Param("record") T t, @Param("example") Object o);
     int updateByExample(@Param("record") T t, @Param("example") Object o);
     int updateByPrimaryKey(T t);
     int updateByPrimaryKeySelective(T t);
}
