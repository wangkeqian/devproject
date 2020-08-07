package com.qianma.community.mapper;

import com.qianma.community.Model.Question;
import com.qianma.community.dto.QueUsrDTO;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {
    Question getById(@Param("id") String id);
    void insert(Question question);

    List<QueUsrDTO> selectForIndex();

    QueUsrDTO getQueUsrById(@Param("id")String id);

    void update(Question question);
}
