package springbootcase.demo.util;

import java.util.regex.Pattern;

/**
 * Created by MengJunlong on 2018/9/18.
 *
 * @Description
 */
public class RegEx {
    public static final String flightNo="\\S{6}";
    public static final String airPort="[A-Z|a-z]{3}";
    public static final String yyyyMMdd ="^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$";
    public static final String HHmm ="(([0,1][0-9])|2[0-3]):[0-5][0-9]";
    public static final String phoneNum = "1\\d{10}";//手机号
    public static final String phoneNums = "1\\d{10}(,1\\d{10})*";//手机号
    public static final String cabinClass = "[YBMUHQVWSTZEKGLNX](,[YBMUHQVWSTZEKGLNX])*";//舱位
    public static final String staffPass = "[A-Z|a-z|0-9|_]*";

    public static void main(String[] arg){
        String reg= yyyyMMdd;
        String s="2012-02-02";
        boolean b=Pattern.matches(reg,s);
        System.out.println(b);
    }

}
