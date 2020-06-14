package com.qianma.concurrencyjava.concurrency.chepter3;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 税收计算器
 *
 * @author wangkq
 * @date 2020/5/23
 */
@Data
public class TaxCalaculator {

    private final BigDecimal salary;

    private final BigDecimal bouns;

    private CalaculatorStrategy calaculatorStrategy;

    public TaxCalaculator(BigDecimal salary, BigDecimal bouns,CalaculatorStrategy calaculatorStrategy) {
        this.salary = salary;
        this.bouns = bouns;
        this.calaculatorStrategy = calaculatorStrategy;
    }

    protected BigDecimal calcTax(){
        return calaculatorStrategy.calculator(salary,bouns);
    }
    public BigDecimal claculate(){
        return calcTax();
    }


}
