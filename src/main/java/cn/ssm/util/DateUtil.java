package cn.ssm.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期、时间类
 *
 * @author cmt
 *
 */
public class DateUtil {

    /**
     * 日期转换
     *
     * @author cmt
     * @param time
     * @param fmt
     *            :yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String formatTime(Timestamp time, String fmt) {
        if (time == null) {
            return "";
        }
        SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
        return myFormat.format(time);
    }

    /**
     * 获取系统当前时间（秒）
     *
     * @author cmt
     * @return
     */
    public static Timestamp getTime() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 获取当前日期(时间00:00:00)
     *
     * @author cmt
     * @return
     */
    public static Timestamp getDateFirst() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Calendar calendar = Calendar.getInstance();
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 获取当前日期(时间23:59:59)
     *
     * @author cmt
     * @return
     */
    public static Timestamp getDateLast() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        Calendar calendar = Calendar.getInstance();
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 获取当前日期
     *
     * @author cmt
     * @return
     */
    public static Date getDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * yyyy-MM-dd HH:mm:ss 转换成Timestamp
     *
     * @author cmt
     * @param timeString
     * @return
     */
    public static Timestamp getTime(String timeString) {
        return Timestamp.valueOf(timeString);
    }

    /**
     * 自定义格式的字符串转换成日期
     *
     * @author cmt
     * @param timeString
     * @param fmt
     * @return
     * @throws Exception
     */
    public static Timestamp getTime(String timeString, String fmt)
            throws Exception {
        SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
        Date date = myFormat.parse(timeString);
        myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return getTime(myFormat.format(date));
    }

    /**
     * 格式化日期
     *
     * @author cmt
     * @param date
     * @param fmt
     * @return
     * @throws Exception
     */
    public static String formatDate(Date date, String fmt) throws Exception {
        if (date == null) {
            return "";
        }
        SimpleDateFormat myFormat = new SimpleDateFormat(fmt);
        return myFormat.format(date);
    }

    /**
     * 返回日期或者时间，如果传入的是日期，返回日期的00:00:00时间
     *
     * @author cmt
     * @param timeString
     * @return
     * @throws Exception
     */
    public static Timestamp getDateFirst(String timeString) throws Exception {
        if (timeString == null || timeString.equals("")) {
            return null;
        }
        if (timeString.length() > 10) {
            return getTime(timeString, "yyyy-MM-dd HH:mm:ss");
        } else {
            return getTime(timeString, "yyyy-MM-dd");
        }
    }

    /**
     * 返回日期或者时间，如果传入的是日期，返回日期的23:59:59时间
     *
     * @author cmt
     * @param timeString
     * @return
     * @throws Exception
     */
    public static Timestamp getDateLast(String timeString) throws Exception {
        if (timeString == null || timeString.equals("")) {
            return null;
        }
        if (timeString.length() > 10) {
            return getTime(timeString, "yyyy-MM-dd HH:mm:ss");
        } else {
            return getTime(timeString + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
        }
    }

    /**
     * 获取本周 周一时间，返回 格式yyyy-MM-dd 00:00:00
     *
     * @author cmt
     * @return
     */
    public static Timestamp getMonday() {
        Calendar calendar = Calendar.getInstance();
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayofweek == 0)
            dayofweek = 7;
        calendar.add(Calendar.DATE, -dayofweek + 1);

        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 获取本周 周日 时间，返回格式yyyy-MM-dd 23:59:59
     *
     * @author cmt
     * @return
     */
    public static Timestamp getSunday() {
        Calendar calendar = Calendar.getInstance();
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayofweek == 0)
            dayofweek = 7;
        calendar.add(Calendar.DATE, -dayofweek + 7);

        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 增加天数
     *
     * @author cmt
     * @param time
     * @param day
     * @return
     */
    public static Timestamp addDay(Timestamp time, Integer day) {
        Timestamp time2 = new Timestamp(time.getTime() + day * 1000l * 60 * 60
                * 24);
        return time2;
    }

    /**
     * 比较2个日期格式的字符串
     *
     * @author cmt
     * @param str1
     *            格式：yyyyMMdd
     * @param str2
     *            格式：yyyyMMdd
     * @return
     */
    public static Integer compareDate(String str1, String str2)
            throws Exception {

        return Integer.parseInt(str1) - Integer.parseInt(str2);

    }

    /**
     * 比较2个日期格式的字符串
     *
     * @author cmt
     * @param str1
     *            格式：yyyyMMddhhmmss
     * @param str2
     *            格式：yyyyMMddhhmmss
     * @return
     */
    public static long compareDateTime(String str1, String str2)
            throws Exception {

        return Long.parseLong(str1) - Long.parseLong(str2);

    }

    /**
     * 2个时间的相差天数
     *
     * @author cmt
     * @param time1
     * @param time2
     * @return
     */
    public static Integer getDay(Timestamp time1, Timestamp time2) {
        Long dayTime = (time1.getTime() - time2.getTime())
                / (1000 * 60 * 60 * 24);
        return dayTime.intValue();
    }

    /**
     * 获取俩个时间相差的天数
     * @param t1
     * @param t2
     * @return
     */
    public static Integer getDay(Date t1, Date t2) {
        Long dayTime = (t1.getTime() - t2.getTime())
                / (1000 * 60 * 60 * 24);
        return dayTime.intValue();
    }

    /**
     * 获取系统当前时间（分）
     *
     * @author cmt
     * @return
     */
    public static String getMinute() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMddHHmm");
        return myFormat.format(new Date());
    }

    /**
     * 转换成时间 字符串格式必须为 yyyy-MM-dd HH:mm:ss 或 yyyy-MM-dd
     *
     * @author cmt
     * @return
     * @throws ParseException
     */
    public static Date parseToDate(String val) throws ParseException {
        Date date = null;
        if (val != null && val.trim().length() != 0
                && !val.trim().toLowerCase().equals("null")) {
            val = val.trim();
            if (val.length() > 10) {
                SimpleDateFormat sdf = new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss");
                date = sdf.parse(val);
            }
            if (val.length() <= 10) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                date = sdf.parse(val);
            }
        }
        return date;
    }

    /**
     * 获取上月的第一天yyyy-MM-dd 00:00:00和最后一天yyyy-MM-dd 23:59:59
     *
     * @author cmt
     * @return
     */
    @SuppressWarnings("static-access")
    public static Map<String, String> getPreMonth() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.add(Calendar.MONTH, -1);
        Date theDate = calendar.getTime();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first_prevM = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first_prevM).append(
                " 00:00:00");
        day_first_prevM = str.toString(); // 上月第一天

        calendar.add(cal.MONTH, 1);
        calendar.set(cal.DATE, 1);
        calendar.add(cal.DATE, -1);
        String day_end_prevM = df.format(calendar.getTime());
        StringBuffer endStr = new StringBuffer().append(day_end_prevM).append(
                " 23:59:59");
        day_end_prevM = endStr.toString(); // 上月最后一天

        Map<String, String> map = new HashMap<String, String>();
        map.put("prevMonthFD", day_first_prevM);
        map.put("prevMonthPD", day_end_prevM);
        return map;
    }

    /**
     * 获取上周 周一时间，返回 格式yyyy-MM-dd 00:00:00
     *
     * @author cmt
     * @return
     */
    @SuppressWarnings("static-access")
    public static Timestamp getPreMonday() {
        Calendar calendar = Calendar.getInstance();
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayofweek);
        if (dayofweek == 1) {
            calendar.add(calendar.WEEK_OF_MONTH, -1);
        }

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.add(calendar.WEEK_OF_MONTH, -1);

        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    /**
     * 获取上周 周日时间，返回 格式yyyy-MM-dd 23:59:59
     *
     * @author cmt
     * @return
     */
    @SuppressWarnings("static-access")
    public static Timestamp getPreSunday() {
        Calendar calendar = Calendar.getInstance();
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayofweek != 1) {
            calendar.add(calendar.WEEK_OF_MONTH, +1);
        }

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        calendar.add(calendar.WEEK_OF_MONTH, -1);

        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String mystrdate = myFormat.format(calendar.getTime());
        return Timestamp.valueOf(mystrdate);
    }

    public static String getDateyyyyMMddHHmmss() {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(
                "yyyyMMddHHmmss");
        Calendar localCalendar = Calendar.getInstance();
        return localSimpleDateFormat.format(localCalendar.getTime());
    }

    public static String getDateyyyyMMdd() {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(
                "yyyyMMdd");
        Calendar localCalendar = Calendar.getInstance();
        return localSimpleDateFormat.format(localCalendar.getTime());
    }

    /**
     * 给定时间，返回周期后的第一天，如time=20130426 executeCycle=02 返回：20130429（下一周的第一天）
     *
     * @param time
     *            时间
     * @param executeCycle
     *            周期 01日、02周、03月、04季度、05年
     * @return
     * @throws Exception
     */
    public static String getCycleDate(String time, String executeCycle)
            throws Exception {
        String result = "";
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(df.parse(time));
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        if ("01".equals(executeCycle)) {
            calendar.add(5, 1);
            result = df.format(calendar.getTime());
        } else if ("02".equals(executeCycle)) {
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            calendar.add(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
            result = df.format(calendar.getTime());
        } else if ("03".equals(executeCycle)) {
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
            calendar.set(Calendar.DAY_OF_MONTH,
                    calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            result = df.format(calendar.getTime());
        } else if ("04".equals(executeCycle)) {
            int month = calendar.get(Calendar.MONTH);
            int quarter = month / 3 + 1;
            month = quarter * 3;
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH,
                    calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            result = df.format(calendar.getTime());

        } else if ("05".equals(executeCycle)) {
            calendar.set(calendar.get(Calendar.YEAR) + 1, 0, 1);
            result = df.format(calendar.getTime());
        } else if ("06".equals(executeCycle)) {
            result = "";
        } else {
            throw new Exception("营销活动执行周期定义非法，无法找出对应的中奖记录");
        }
        return result;
    }

    /**
     * 给定时间，如time=20130426 executeCycle=02 返回：20130429-20130505（）
     *
     * @param time
     * @param executeCycle
     * @return
     * @throws Exception
     */
    public static String getCycleDate2(String time, String executeCycle)
            throws Exception {
        if (executeCycle == null) {
            throw new Exception("营销活动执行周期为null，无法找出对应的中奖记录");
        }
        executeCycle = executeCycle.trim();
        String result = "";
        String endStr = "";
        String startStr = "";
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(df.parse(time.trim()));
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        if ("01".equals(executeCycle)) {
            calendar.add(5, -1);
            startStr = df.format(calendar.getTime());
            endStr = df.format(calendar.getTime());
        } else if ("02".equals(executeCycle)) {
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            calendar.add(Calendar.DAY_OF_WEEK_IN_MONTH, -1);
            startStr = df.format(calendar.getTime());
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            endStr = df.format(calendar.getTime());
        } else if ("03".equals(executeCycle)) {
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
            calendar.set(Calendar.DAY_OF_MONTH,
                    calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            startStr = df.format(calendar.getTime());
            calendar.set(Calendar.DAY_OF_MONTH,
                    calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            endStr = df.format(calendar.getTime());
        } else if ("04".equals(executeCycle)) {
            int month = calendar.get(Calendar.MONTH);
            int quarter = month / 3;
            month = quarter * 3;
            calendar.set(Calendar.MONTH, month);
            calendar.add(Calendar.MONTH, -3);
            calendar.set(Calendar.DAY_OF_MONTH,
                    calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            startStr = df.format(calendar.getTime());
            calendar.add(Calendar.MONTH, 2);
            calendar.set(Calendar.DAY_OF_MONTH,
                    calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            endStr = df.format(calendar.getTime());
        } else if ("05".equals(executeCycle)) {
            calendar.set(calendar.get(Calendar.YEAR) - 1, 0, 1);
            startStr = df.format(calendar.getTime());
            calendar.set(Calendar.MONTH,
                    calendar.getActualMaximum(Calendar.MONTH));
            calendar.set(Calendar.DAY_OF_MONTH,
                    calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            endStr = df.format(calendar.getTime());
        } else {
            throw new Exception("营销活动执行周期定义非法，无法找出对应的中奖记录");
        }
        result = startStr + "-" + endStr;
        return result;
    }

    /**
     * yyyyMMddHHmmss格式的时间字符串转换成yyyy-MM-dd HH:mm:ss格式的时间字符串
     *
     * @param timeString
     * @return
     * @throws Exception
     */
    public static String datetimeTransform(String timeString) throws Exception {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = myFormat.parse(timeString);
        myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return myFormat.format(date);
    }
    /**
     * yyyy-MM-dd HH:mm:ss格式的时间字符串转换成yyyyMMddHHmmss格式的时间字符串
     *
     * @param timeString
     * @return
     * @throws Exception
     */
    public static String datetimeFormat(String timeString) throws Exception {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = myFormat.parse(timeString);
        myFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return myFormat.format(date);
    }

    /**
     * yyyyMMdd格式的时间字符串转换成yyyy-MM-dd格式的时间字符串
     *
     * @param timeString
     * @return
     * @throws Exception
     */
    public static String dateTransform(String timeString) throws Exception {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = myFormat.parse(timeString);
        myFormat = new SimpleDateFormat("yyyy-MM-dd");
        return myFormat.format(date);
    }
    /**
     * yyyy-MM-dd格式的时间字符串转换成yyyyMMdd格式的时间字符串
     * @param timeString
     * @return
     * @throws Exception
     */
    public static String dateFormat(String timeString) throws Exception {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = myFormat.parse(timeString);
        myFormat = new SimpleDateFormat("yyyyMMdd");
        return myFormat.format(date);
    }
    /**
     * 返回传入日期的第二天日期时间 如：传入20140101返回20140102
     *
     * @param date
     * @return
     */
    public static String getTomorrow(String date) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(df.parse(date));
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date d = calendar.getTime();
        return df.format(d);
    }

    /**
     * 判断要删除的记录是否在有效期内
     *
     * @param effectTime
     *            生效时间
     * @param etPattern
     *            日期格式
     * @param validTime
     *            失效时间
     * @param vtPattern
     *            日期格式
     * @return 是否有效
     * @throws Exception
     */
    public static boolean isValidDate(String effectTime, String etPattern,
                                      String validTime, String vtPattern) throws Exception {
        SimpleDateFormat sf1 = new SimpleDateFormat(etPattern);
        SimpleDateFormat sf2 = new SimpleDateFormat(vtPattern);
        Date etDate = sf1.parse(effectTime);
        Date vtDate = sf2.parse(validTime);
        return (etDate.before(new Date()) && vtDate.after(new Date())) ? true
                : false;
    }

    /**
     * 判断该条记录是否生效
     *
     * @param effectTime
     *            生效时间
     * @param etPattern
     *            日期格式
     * @return 是否生效
     * @throws Exception
     */
    public static boolean isOk(String effectTime, String etPattern)
            throws Exception {
        SimpleDateFormat sf1 = new SimpleDateFormat(etPattern);
        Date etDate = sf1.parse(effectTime);
        return (etDate.before(new Date())) ? true : false;
    }
    /**
     * 返回系统时间上一个月的年、月 如：201410 - > 2014年09月
     * @return
     */
    public static String getLastMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月");
        return format.format(c.getTime());
    }
    /**
     * 转换格式
     * @return
     */
    public static String getDateTime(String timeString) throws Exception {
        String returnTime = "";
        int year = timeString.indexOf("年");
        int month = timeString.indexOf("月");
        int day = timeString.indexOf("日");
        if(timeString != "" && !timeString.equals("")){
            returnTime = timeString.substring(0, year);
            String monthTime = timeString.substring(year+1, month);
            if(monthTime.length() == 2){
                returnTime = returnTime + monthTime + timeString.substring(month+1, day)+"000000";
            }else{
                returnTime =returnTime + "0" + monthTime + timeString.substring(month+1, day)+"000000";
            }
        }
        return datetimeTransform(returnTime);
    }
    /**
     * 转换格式  XXXX年XX月XX日->yyyyMMddHHmmss
     * @return
     */
    public static String getDateTime2(String timeString) throws Exception {
        String returnTime = "";
        int year = timeString.indexOf("年");
        int month = timeString.indexOf("月");
        int day = timeString.indexOf("日");
        if(timeString != "" && !timeString.equals("")){
            returnTime = timeString.substring(0, year);
            String monthTime = timeString.substring(year+1, month);
            String dayTime = timeString.substring(month+1, day);
            if(monthTime.length() == 2){
                if(dayTime.length() == 2){
                    returnTime = returnTime + monthTime + dayTime +"000000";
                }else{
                    returnTime = returnTime + monthTime + "0" + dayTime +"000000";
                }
            }else{
                if(dayTime.length() == 2){
                    returnTime = returnTime + "0" + monthTime + dayTime +"000000";
                }else{
                    returnTime = returnTime + "0" + monthTime + "0" + dayTime +"000000";
                }
            }
        }
        return returnTime;
    }
    /**
     * 转换格式：yyyyMMddHHmmss - > XXXX年XX月
     * @return
     */
    public static String getDateYearMonth(String timeString){
        String returnTime = "";
        returnTime = timeString.substring(0, 4) + "年" + timeString.substring(4, 6) + "月";
        return returnTime;
    }
    /**
     * 转换格式：yyyyMMddHHmmss - > XXXX年XX月XX日
     * @return
     */
    public static String getDateYearMonthDay(String timeString){
        String returnTime = "";
        returnTime = timeString.substring(0, 4) + "年" + timeString.substring(4, 6) + "月" + timeString.substring(6, 8) + "日";
        return returnTime;
    }

    public static String fmtTime(String timeString){
        String returnTime = "";
        returnTime = timeString.substring(0,2)+":"+timeString.substring(2, 4)+":"+timeString.substring(4,6);
        return returnTime;
    }

    public static String yyyyMMdd000000() {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyyMMdd");
        String dateStr = myFormat.format(new Date());
        return dateStr + "000000";
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.yyyyMMdd000000());;
    }

    /**
     * 获取下月的第一天yyyy-MM-dd 00:00:00和最后一天yyyy-MM-dd 23:59:59
     * @author cmt
     * @return
     */
    @SuppressWarnings("static-access")
    public static Map<String,String> getNextMonth(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.add(Calendar.MONTH, 1);
        Date theDate = calendar.getTime();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first_nextvM = df.format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(day_first_nextvM).append(
                " 00:00:00");
        day_first_nextvM = str.toString(); //下月第一天

        calendar.add(cal.MONTH, 1);
        calendar.set(cal.DATE, 1);
        calendar.add(cal.DATE, -1);
        String day_end_nextvM = df.format(calendar.getTime());
        StringBuffer endStr = new StringBuffer().append(day_end_nextvM).append(
                " 23:59:59");
        day_end_nextvM = endStr.toString();  //下月最后一天

        Map<String, String> map = new HashMap<String, String>();
        map.put("nextvMonthFD", day_first_nextvM);
        map.put("nextvMonthPD", day_end_nextvM);
        return map;
    }

}
