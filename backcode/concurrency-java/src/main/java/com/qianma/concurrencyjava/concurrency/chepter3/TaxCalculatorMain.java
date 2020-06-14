package com.qianma.concurrencyjava.concurrency.chepter3;

import java.math.BigDecimal;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/23
 */
public class TaxCalculatorMain {
    public static void main(String[] args) {
        TaxCalaculator taxCalaculator = new TaxCalaculator(new BigDecimal(2000),new BigDecimal(500),
                (s,b)-> s.multiply(new BigDecimal(0.1)).add(b.multiply(new BigDecimal(0.3))));
        taxCalaculator.claculate();


        System.out.println(taxCalaculator.claculate());
    }
}
