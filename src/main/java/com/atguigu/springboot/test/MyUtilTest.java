package com.atguigu.springboot.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author changchen
 * @create 2019-06-16 下午 3:42
 */
public class MyUtilTest {

    public static void main(String[] args) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = sf.format(new Date());

        System.out.println("转换成str的时间"+format);
    }


}
