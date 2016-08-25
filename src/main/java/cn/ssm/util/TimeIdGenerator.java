package cn.ssm.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2016/8/17.
 */
public class TimeIdGenerator {
    public TimeIdGenerator() {
    }

    public static String getYear() {
        return String.valueOf(Calendar.getInstance().get(1));
    }

    public static String getMonth() {
        return String.valueOf(Calendar.getInstance().get(2));
    }

    public static String getDay() {
        return (new SimpleDateFormat("dd")).format(new Date());
    }

    public static String getHour() {
        return String.valueOf(Calendar.getInstance().get(11));
    }

    public static String getcuredate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String tmpDate = formatter.format(new Date());
        String tmp = tmpDate.toString();
        return tmp;
    }

    public static String getTimeid() {
        Class var0 = TimeIdGenerator.class;
        synchronized(TimeIdGenerator.class) {
            try {
                Thread.sleep(2L);
            } catch (InterruptedException var4) {
                var4.printStackTrace();
            }

            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String tmpDate = formatter.format(new Date());
            String tmp = tmpDate.toString();
            return tmp;
        }
    }

    public static String getinformixgetcuredate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String tmpDate = formatter.format(new Date());
        String tmp = tmpDate.toString();
        return tmp;
    }

    public static String getcuretime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String tmpDate = formatter.format(new Date());
        String tmp = tmpDate.toString();
        return tmp;
    }

    public static String getcurmitime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String tmpDate = formatter.format(new Date());
        String tmp = tmpDate.toString();
        return tmp;
    }

    public static String getcurrentDate() {
        Date date = new Date();
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern("yyyy-MM-dd");
        String SALETIME = formater.format(date);
        return SALETIME;
    }

    public static String getchncurrentDate() {
        Date date = new Date();
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern("yyyy��M��dd��");
        String SALETIME = formater.format(date);
        return SALETIME;
    }

    public static String getOraTodatecurrDate() {
        Date date = new Date();
        SimpleDateFormat formater = new SimpleDateFormat();
        formater.applyPattern("yyyy-MM-dd");
        String saletime = formater.format(date);
        saletime = " to_date(\'" + saletime + "\',\'yyyy-mm-dd\') ";
        return saletime;
    }

    public static String getiddate() {
        return (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()).toString();
    }

    public static String dateToString(String datestr, String splitstr) {
        String retdate = "";
        String[] tmpdate = datestr.split("[" + splitstr + "]");

        for(int i = 0; i < tmpdate.length; ++i) {
            retdate = retdate + tmpdate[i];
        }

        return "".equals(retdate)?datestr:retdate;
    }

    public static String dateTimeToString(String datestr, String splitdate, String splittime) {
        return "have\'nt implement";
    }

    public static String timeToString(String timestr, String splitstr) {
        String rettime = "";
        String[] tmpdate = timestr.split("[" + splitstr + "]");

        for(int i = 0; i < tmpdate.length; ++i) {
            rettime = rettime + tmpdate[i];
        }

        return "".equals(rettime)?timestr:"have\'nt implement";
    }

    public static String stringdateToDatefrm(String timestr, String splitstr) {
        String rettime = "";
        if(timestr.length() < 8) {
            return rettime;
        } else {
            String year = timestr.substring(0, 4);
            String mon = timestr.substring(4, 6);
            String dd = timestr.substring(6, 8);
            rettime = year + splitstr + mon + splitstr + dd;
            return rettime;
        }
    }

    public static String getpuretime() {
        return (new SimpleDateFormat("HHmmss")).format(new Date()).toString();
    }

    public static synchronized String getRandomcode() {
        String temp = getTimeid() + getthreerandom();
        return temp;
    }

    public static int getthreerandom() {
        return (int)(Math.random() * 900.0D) + 100;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 300; ++i) {
            String ttt = getTimeid();
            System.out.println(ttt);
        }

    }
}
