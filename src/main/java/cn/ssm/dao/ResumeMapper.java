package cn.ssm.dao;

import cn.ssm.model.Resume;
import cn.ssm.model.ResumeExample;
import java.util.List;

import cn.ssm.util.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface ResumeMapper extends BaseMapper<Resume>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_resume
     *
     * @mbggenerated
     */
    int countByExample(ResumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_resume
     *
     * @mbggenerated
     */
    int deleteByExample(ResumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_resume
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_resume
     *
     * @mbggenerated
     */
    int insert(Resume record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_resume
     *
     * @mbggenerated
     */
    int insertSelective(Resume record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_resume
     *
     * @mbggenerated
     */
    List<Resume> selectByExample(ResumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_resume
     *
     * @mbggenerated
     */
    Resume selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_resume
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Resume record, @Param("example") ResumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_resume
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Resume record, @Param("example") ResumeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_resume
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Resume record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ssm_resume
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Resume record);

    int updateResume(Resume resume);
}