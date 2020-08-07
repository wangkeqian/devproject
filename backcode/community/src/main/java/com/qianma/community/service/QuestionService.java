package com.qianma.community.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qianma.community.Model.Question;
import com.qianma.community.common.DataEntity;
import com.qianma.community.dto.QueUsrDTO;
import com.qianma.community.dto.QuestionCountDTO;
import com.qianma.community.mapper.QuestionMapper;
import com.qianma.community.utils.DtoToPo;
import com.qianma.community.utils.RedisUtil;
import com.qianma.community.utils.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/4/18
 */
@Service
public class QuestionService {
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    RedisUtil redisUtil;

    public Question getById(String id){
        return questionMapper.getById(id);
    }
    @Transactional
    public String createOrUpdate(Question question){
        if (question.getId()== null || question.getId().isEmpty()){
            question.setUUID();
            /*String id = SystemUtil.getLoginUser().getId();*/
            String id = UUID.randomUUID().toString();
            question.setCreator(id);
            /**
             * 把评论数等数据放到Redis上
             */
            Map<String, Object> countMap = new HashMap<>();
            countMap.put(question.getId(), new QuestionCountDTO());
            redisUtil.hmset("question",countMap);
            questionMapper.insert(question);
            System.out.println("FAIL");
            int i  = 10/0;
            System.out.println(i);
        }else {
            questionMapper.update(question);
        }
        return question.getId();
    }

    public List<QueUsrDTO> selectForIndex() {
        return questionMapper.selectForIndex();
    }

    public PageInfo<QueUsrDTO> getPageListData(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<QueUsrDTO> queUsrDTOS = questionMapper.selectForIndex();
        queUsrDTOS.forEach(this::paddingCount);
        PageInfo<QueUsrDTO> pageInfo = new PageInfo<>(queUsrDTOS);
        return  pageInfo;
    }
    public <T extends DataEntity> void paddingCount(T result){
        /**
         * 填充评论数等
         */
        QuestionCountDTO dto = (QuestionCountDTO) redisUtil.hget("question", result.getId());
        try {
            if (Optional.ofNullable(dto).isPresent()) {
                DtoToPo.poToDto(dto, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public QueUsrDTO getQueUsr(String id){
        QueUsrDTO queUsr = questionMapper.getQueUsrById(id);
        paddingCount(queUsr);
        return queUsr;
    }

    public void setCount(List list, Consumer<List> consumer) {
        initCount();
        consumer.accept(list);
    }

    public void setCount(String id,String type) {
        List<String> list = Arrays.asList(id, type);
        setCount(list,(e)->{
            QuestionCountDTO countDto = (QuestionCountDTO) redisUtil.hget("question", id);
            if ("view".equals(type)){
                countDto.setViewCount(countDto.getViewCount() +1);
            }else if ("like".equals(type)){
                countDto.setLikeCount(countDto.getLikeCount() +1);
            }else if ("comment".equals(type)){
                countDto.setCommentCount(countDto.getCommentCount() +1);
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put(id,countDto);
            redisUtil.hmset("question",map);
        });
    }

    public void initCount() {
        List<QueUsrDTO> queUsrDTOS = questionMapper.selectForIndex();
        queUsrDTOS.forEach(queUsrDTO -> {
            Map<String, Object> countMap = new HashMap<>();
            countMap.put(queUsrDTO.getId(), new QuestionCountDTO());
            redisUtil.hmset("question",countMap);
        });
    }
}