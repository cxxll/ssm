package cn.ssm.service;

import cn.ssm.model.Resume;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2016/7/31.
 */

public interface ResumeService extends BaseService<Resume>{
    
    int updateResume(Resume resume);

    int add(Resume resume);

}
