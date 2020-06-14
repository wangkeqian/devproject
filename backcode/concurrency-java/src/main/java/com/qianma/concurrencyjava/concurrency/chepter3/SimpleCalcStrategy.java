package com.qianma.concurrencyjava.concurrency.chepter3;

import java.math.BigDecimal;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/23
 */
public class SimpleCalcStrategy implements  CalaculatorStrategy {

    private final static BigDecimal SALARY_RATE = new BigDecimal(0.1);
    private final static BigDecimal BONUS_RATE = new BigDecimal(0.3);

    @Override
    public BigDecimal calculator(BigDecimal salary, BigDecimal bonus) {
         return salary.multiply(SALARY_RATE).add(bonus.multiply(BONUS_RATE));
    }
}
