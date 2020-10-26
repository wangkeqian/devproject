package org.javaboy.vhr.service.person;

import org.javaboy.vhr.mapper.person.EmployeeecMapper;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.model.person.Employeeec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 奖惩service
 *
 * @author wangkq
 * @date 2020/10/15
 */
@Service
public class PersonEcService {
    @Autowired
    EmployeeecMapper employeeecMapper;

    public int insertRecord(Employeeec employeeec){
        return null == employeeec.getId()?
                employeeecMapper.insert(employeeec): employeeecMapper.updateByPrimaryKeySelective(employeeec);
    }

    public RespPageBean getEmployeeecNoArgs(Employeeec searchParams){
        if (null == searchParams) searchParams = new Employeeec();
        Integer page = searchParams.getPage();
        Integer size = searchParams.getSize();
        RespPageBean bean = new RespPageBean();
        if (page != null && size != null) {
            page= (page - 1) * size;
        }
        bean.setData(employeeecMapper.getEmployeeecNoArgs(page,size,searchParams));
        bean.setTotal(employeeecMapper.getTotal(searchParams));
        return bean;
    }
}
