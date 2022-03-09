package chap12.demo3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        Date date1 = new Date(0L);
        System.out.println(date.getTime());
        System.out.println(date1.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        Date parse = simpleDateFormat.parse("2019-1-21");
        System.out.println(parse);
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);
    }
}
