package com.lihd.book.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/6/13 15:36
 */
public class RandomDate {
    public static void main(String[] args) throws ParseException {
        for (int i = 0; i < 100; i++) {
            System.out.println(getRandomDate("2019-05-22 06:00:00","2022-06-22 06:00:00"));
        }
    }
    public static String getRandomDate(){
        String randomDate = "2019-05-22 06:00:00";
        try {
            randomDate = getRandomDate("2019-05-22 06:00:00", "2022-06-22 06:00:00");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return randomDate;
    }

    public static String getRandomDate(String s, String e) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //指定开始日期
        long start = sdf.parse(s).getTime();
        //指定结束日期
        long end = sdf.parse(e).getTime();
        //调用方法产生随机数
        long randomDate = nextLong(start, end);
        return sdf.format(new Date(randomDate));
    }

    public static long nextLong(long start, long end) {
        Random random = new Random();
        return start + (long) (random.nextDouble() * (end - start + 1));
    }

}
