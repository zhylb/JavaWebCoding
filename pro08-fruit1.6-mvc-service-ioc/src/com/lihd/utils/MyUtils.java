package com.lihd.utils;

/**
 * @author ：葬花吟留别1851053336@qq.com
 * @description：TODO
 * @date ：2022/4/3 20:11
 */
public class MyUtils {

    public static int parseIntQuite(String str){
        if(str!=null &&!"".equals(str)){
            try{
                return Integer.parseInt(str);
            }catch (Exception e){
                return -1;
            }

        }
        return -1;
    }
}
