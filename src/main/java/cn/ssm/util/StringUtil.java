package cn.ssm.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
/**
 * Created by Administrator on 2016/8/17.
 */
public class StringUtil {
    private static final DateFormat DF=new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 已分隔符来输出传入的字符串
     * @author cmt
     * @param split
     * @param obj
     * @return
     */
    public static String toStringSpilt(String split,String ... obj){
        if (obj==null) return "";

        StringBuffer sbBuffer=new StringBuffer();
        for (String s:obj){
            if (s!=null && !s.equals("")){
                if (sbBuffer.length()==0)
                    sbBuffer.append(s);
                else
                    sbBuffer.append(split).append(s);
            }
        }

        return sbBuffer.toString();
    }


    /**
     * 按照长度获取字符串，如果超出截取最大长度，后面加...
     * @author cmt
     * @param str
     * @param len
     * @return
     */
    public static String maxString(String str,Integer len){
        if (str==null) return str;
        if (str.length()<=len) return str;
        return str.substring(0, len)+"...";
    }

    /**
     * 判断传入参数,如果是Null或者空值，返回false，不为空返回true
     * @author cmt
     * @param checkAll   True:所有的为空才返回,False:只要有一个为空返回
     * @param
     * @return
     */
    public static Boolean checkNull(Boolean checkAll,Object ...objects ){
        Boolean ret=true;
        if (objects==null) return false;
        for (Object s : objects) {
            if (s==null || s.toString().trim().equals("")){
                if (!checkAll)
                    return false;
                else {
                    ret= false;
                }
            }
        }
        return ret;
    }



    /**
     * 返回等长字符，如果前缀+字符串>长度，返回字符串
     * @author cmt
     * @param prefix 前缀
     * @param len
     * @param str
     * @return
     */
    public static String getMaxLength(String prefix,int len,String str){
        if (!checkNull(false,str) || str.length()>=len ) return str;

        if (prefix.length()+str.length()>len) return str;

        StringBuilder sb=new StringBuilder();
        sb.append(prefix);
        for (int i = 0; i < len-prefix.length()- str.length(); i++) {
            sb.append("0");
        }
        sb.append(str);

        return sb.toString();
    }


    /**
     * 返回最长字符串，前方补足，如果传入值的长度大于，将切割字符串
     * @author cmt
     * @param prefix
     * @param len
     * @param str
     * @return
     */
    public static String fixLength(String prefix,int len,String str){
        if (str==null){
            str="";
        }

        if (str.length()>=len){
            return str.substring(str.length()-len,str.length());
        }


        StringBuilder sb=new StringBuilder();
        sb.append(prefix);
        for (int i = 0; i < len-prefix.length()- str.length(); i++) {
            sb.append(prefix);
        }
        sb.append(str);

        return sb.toString();
    }

    public  static  double getRandomA2B(double i ,double j, int point){
        if (i >= j || j <= 0||point<1||point>5) {
            return 1D;
        }
        int p = (int)(Math.pow(10,point));;
        Random ran = new Random();
        int m = (int) Math.floor((j - i) * p);
        int n = ran.nextInt(m);
        BigDecimal x = new BigDecimal(n);
        double y = x
                .divide(new BigDecimal(p), point, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        double z = i + y;
        double s = new BigDecimal(z).setScale(point, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        return s;
    }

    public static long ceil(double value) {
        return (long) Math.ceil(value);
    }

    public static String removeSpaces(String str){
        if(str==null){
            return "";
        }
        String result=str.replaceAll("\\s", "");
        return result;
    }


    public static String leftPatchZero(int length,int value){
        String fmt="";
        for(int i=0;i<length;i++){
            fmt+="0";
        }
        DecimalFormat df=new DecimalFormat(fmt);
        return df.format(value);
    }

    /**
     * 获取16位的序号
     * @return
     */
    public static String getSeq16(){
        String result="";
        result=DF.format(new Date())+genRandom(2);
        return result;
    }

    public static String genRandom(int length)
    {
        StringBuffer buffer = new StringBuffer();
        Random r = new Random();
        for(int i = 0; i < length;)
        {
            int c = r.nextInt(122);
            if(48 <= c && c <= 57 || 65 <= c && c <= 90 || 97 <= c && c <= 122)
            {
                buffer.append((char)c);
                i++;
            }
        }
        return buffer.toString();
    }

    /**
     * 通过所给的字符转成SQL语句中的条件
     * 如：传入123,123返回'123','123'
     * @param value
     * @return
     */
    public static String strToSqlChar(String value){
        String result="";
        if(StringUtil.checkNull(false, value)){
            String [] strs=value.split(",");
            for(String s:strs){
                result+="'"+s+"',";
            }
            result=result.substring(0,result.length()-1);
        }
        return result;
    }

    /**
     * 通过所给的字符转成SQL语句中的条件
     * 如：传入123,123返回'123','123'
     * @param value
     * @return
     */
    public static String strToSqlChar(List<String> value){
        String result="";
        if(StringUtil.checkNull(false, value)){
            for(String s:value){
                result+="'"+s+"',";
            }
            result=result.substring(0,result.length()-1);
        }
        return result;
    }
    /**
     * fmt是时间格式
     * 把当前时间转给转成给定的时间格式字符串
     * @param fmt
     * @return
     * @throws Exception
     */
    public static String currDateToStr(String fmt)throws Exception{
        try{
            DateFormat df=new SimpleDateFormat(fmt);
            return df.format(new Date());
        }catch(Exception e){
            throw new Exception("日期转化异常："+e.getMessage());
        }
    }

    /**
     * 【weqsa3423,e3234w】-> 【'weqsa3423','e3234w'】
     * @param ids
     * @return
     */
    public static String appendSingleQuotes(String ids) {
        String[] _ids = ids.split(",");
        if(_ids.length > 0) {
            StringBuffer sb = new StringBuffer();
            String result = "";
            for(int i = 0 ; i < _ids.length; i++) {
                sb.append("'");
                sb.append(_ids[i]);
                sb.append("'");
                sb.append(",");
            }
            System.out.println(sb.length());
            if(sb.length() > 0) {
                result = sb.toString().substring(0, sb.length() - 1);
            }
            return result;
        }else {
            return "";
        }
    }

    public static String generateRandomString(int len)
    {
        char mm[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
        };
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for(int i = 0; i < len; i++)
            sb.append(mm[random.nextInt(mm.length)]);

        return sb.toString();
    }

    public static boolean checkDouble(final String number) {
        try{
            Double.parseDouble(number);
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 获取20位的序号
     * @return
     */
    public static String getSeq20() {
        String result = "";
        result = DF.format(new Date()) + genNumberRandom();
        return result;
    }

    public static String genNumberRandom() {
        Random random = new Random();
        int a = random.nextInt(999999);
        while (a < 100000) {
            a = random.nextInt(999999);
        }
        return String.valueOf(a);
    }

    public static boolean isNumber(String s) {
        if (s == null || s.equals(""))
            return false;
        String num = "0123456789";
        for (int i = 0; i < s.length(); i++) {
            if (num.indexOf(s.charAt(i)) < 0)
                return false;
        }
        return true;
    }

}
