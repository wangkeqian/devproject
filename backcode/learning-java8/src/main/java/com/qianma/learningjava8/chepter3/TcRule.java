package com.qianma.learningjava8.chepter3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/8/4
 */
public class TcRule {
    //0表示无期限；1表示指定时间范围
    private int timeType;

    //规则开始时间和结束时间。当timeType=1时，格式如"有效。2020-01-01"
    private String startDate;

    private String endDate;

    //timeType=1时，有效。生效的星期几，取值0-6，周日是0，用|分隔。如果星期1，2，则存储1|2
    private String week;

    //timeType=1时，有效。每天生效的时间。精确到分钟。格式如“21:00”
    private String startTime;

    private String endTime;

    //0表示所有员工，1表示指定的员工
    private int personType;

    //如果personType=1时，有效。用竖线隔开，每个都是员工ID，为整数 。比如1|2|10
    private String personList;

    /**

     * tcRule是新建的规则，listTcRule是已经存在的规则。

     * 判断tcRule是否和已有的listTcRule冲突。如果冲突，返回所有与tcRule冲突的规则。

     */

    public static List<TcRule> checkTcRule(TcRule tcRule, List<TcRule> listTcRule){
        /**
         * 按 月，周，日，员工的优先级来判断规则是否冲突
         */
        SimpleDateFormat monthDf = new SimpleDateFormat("yyyy-MM-dd");
        listTcRule.forEach(e ->{
            if (tcRule.timeType == 1){

            }
        });

        return null;

    }

    public static boolean DateComparator(TcRule rule1 ,TcRule rule2 ,String comparatorType) {
        SimpleDateFormat monthDf = null;
        try {
            if (comparatorType.equals("month")){
                monthDf = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = null;
                startDate = monthDf.parse(rule1.startDate);
                Date endDate = monthDf.parse(rule1.endDate);

                Date startDate2 = monthDf.parse(rule2.startDate);
                Date endDate2 = monthDf.parse(rule2.endDate);
                //时间段不重合 ，只有一种情况 rule1的开始/结束时间均小于rule2
                return  (startDate.before(startDate2) && (endDate.before(startDate2))
                        || startDate2.before(startDate) && (endDate2.before(startDate)));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return true;
    }

}
