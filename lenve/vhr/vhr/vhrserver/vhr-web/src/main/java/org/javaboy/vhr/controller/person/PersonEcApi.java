package org.javaboy.vhr.controller.person;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.javaboy.vhr.model.Enum.RewardPunishEnum;
import org.javaboy.vhr.model.RespBean;
import org.javaboy.vhr.model.RespPageBean;
import org.javaboy.vhr.model.person.Employeeec;
import org.javaboy.vhr.service.person.PersonEcService;
import org.javaboy.vhr.utils.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 员工奖惩
 *
 * @author wangkq
 * @date 2020/10/15
 */
@RestController
@RequestMapping("/personEc")
@Api(tags = "奖惩信息接口")
public class PersonEcApi {
    @Autowired
    PersonEcService personEcService;
    /**
     * 1.查询所有奖惩数据
     * 2.条件查询
     */
    @PostMapping("/info")
    @ApiOperation("奖惩数据有参请求接口")
    public RespPageBean getPersonEcNoArgs(@RequestBody(required = false) Employeeec searchParams){
        return personEcService.getEmployeeecNoArgs(searchParams);
    }

    @GetMapping("/getRewardPunishType")
    public Map getRewardPunishType(){
        return EnumUtils.EnumToMap(RewardPunishEnum.class);
    }

    @PostMapping("/add")
    public RespBean addPersonEcInfo(@RequestBody Employeeec employeeec){
        personEcService.insertRecord(employeeec);
        return RespBean.ok("ok");
    }

}
