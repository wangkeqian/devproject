package org.javaboy.vhr.mapper.person;

import org.apache.ibatis.annotations.Param;
import org.javaboy.vhr.model.person.Employeeec;

import java.util.List;

public interface EmployeeecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employeeec record);

    int insertSelective(Employeeec record);

    Employeeec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employeeec record);

    int updateByPrimaryKey(Employeeec record);

    Long getTotal(@Param("params") Employeeec params);

    List<Employeeec> getEmployeeecNoArgs(@Param("page") Integer page, @Param("size") Integer size, @Param("params") Employeeec params);
}