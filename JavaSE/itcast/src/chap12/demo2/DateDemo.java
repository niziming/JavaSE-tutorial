package chap12.demo2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        // 创建日期对象，把当前的时间
        System.out.println(new Date());
        // 创建日期对象，把当前的毫秒值转成日期对象
        System.out.println(new Date(0L));
        // 把日期对象转换成对应的时间毫秒值。
        System.out.println(new Date().getTime());
        // 对应的日期格式如：2018-01-16 15:06:38
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(new Date());
        System.out.println(format);
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(parse);
        System.out.println(parse.getTime());
    }
}
