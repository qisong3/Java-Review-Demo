package cn.errison.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Demo1 {

    private static void createTime(){
        Date date = new Date();
        System.out.println(date.before(new Date()));
        Calendar calendar = new Calendar.Builder().build();
        System.out.println(calendar.toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.parse();

    }



    public static void main(String[] args) {
        createTime();
    }
}
