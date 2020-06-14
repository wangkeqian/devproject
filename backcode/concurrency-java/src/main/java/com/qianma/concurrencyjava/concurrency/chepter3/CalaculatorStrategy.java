package com.qianma.concurrencyjava.concurrency.chepter3;


import java.math.BigDecimal;

/**
 * 计算策略接口
 *
 * @author wangkq
 * @date 2020/5/23
 */
@FunctionalInterface
public interface CalaculatorStrategy {

    BigDecimal calculator(BigDecimal salary,BigDecimal bonus);
    
}
