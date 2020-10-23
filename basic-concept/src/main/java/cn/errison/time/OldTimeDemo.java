package cn.errison.time;

import lombok.SneakyThrows;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class OldTimeDemo {

    private static void createTime() {
        Date date = new Date();
        System.out.println(date.toString());
        System.out.printf("%s %tB %<te, %<tY", "Due date:", date);

    }

    private static void formatTime() throws ParseException {

        String pattern1 = "G E M yyyy HH:mm:ss.SSS Z";
        String pattern2 = "yyyy-MM-dd HH:mm:ss";
        System.out.println(new SimpleDateFormat(pattern1).format(new Date()));
        System.out.println(new SimpleDateFormat(pattern2).format(new Date()));
    }

    private static void parseTime() throws ParseException {

        String pattern1 = "yyyy-MM-dd HH:mm:ss";
        // 日期字符串
        String dateStr = "2020-10-19 15:23:33";
        // 格式化输出
        System.out.println(new SimpleDateFormat(pattern1).parse(dateStr).getTime());
    }

    private static void local() throws ParseException {
        Locale locale = new Locale("zh", "CHINA");
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        dateFormatSymbols.setWeekdays(new String[]{
                "星期一",
                "星期二",
                "星期三",
                "星期四",
                "星期五",
                "星期六",
                "星期日"
        });

        String pattern = "EEEEE MMMMM yyyy";
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat(pattern, dateFormatSymbols);
        System.out.println(simpleDateFormat.format(new Date()));
    }

    private static void timezone() {

        Arrays.stream(TimeZone.getAvailableIDs()).forEach(item -> System.out.print(item + " "));
        System.out.println();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        System.out.println(simpleDateFormat.format(new Date()));

        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        System.out.println(simpleDateFormat.format(new Date()));


    }
    private static  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static void createException() {
        for (int i = 0; i < 100; i++){
            UnsafeTimeThread timeThread = new UnsafeTimeThread();
            timeThread.start();
        }
    }

    private static class  UnsafeTimeThread extends Thread{
        @SneakyThrows
        @Override
        public void run(){
            String string = dateFormat.format(new Date());
            System.out.println(dateFormat.parse(string));
        }
    }


    public static void main(String[] args) throws ParseException {
        createTime();
        formatTime();
        parseTime();
        local();
        timezone();
        createException();
    }
}
