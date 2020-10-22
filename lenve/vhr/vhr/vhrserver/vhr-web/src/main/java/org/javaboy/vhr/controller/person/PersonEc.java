package org.javaboy.vhr.controller.person;

import org.javaboy.vhr.model.RespBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工奖惩
 *
 * @author wangkq
 * @date 2020/10/15
 */
@RestController("personEc")
public class PersonEc {
    /**
     * 1.查询所有奖惩数据
     * 2.条件查询
     */
    @GetMapping("/info")
    public RespBean getPersonEcNoArgs(){

    }

}
