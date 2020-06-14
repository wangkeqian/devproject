package com.qianma.concurrencyjava.concurrency.chepter2;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/23
 */
public class Bank {
    public static void main(String[] args) {
        TicketWindows ticketWindows1 = new TicketWindows("一号机");
        ticketWindows1.start();

        TicketWindows ticketWindows2 = new TicketWindows("二号机");
        ticketWindows2.start();

        TicketWindows ticketWindows3 = new TicketWindows("三号机");
        ticketWindows3.start();
    }
}
