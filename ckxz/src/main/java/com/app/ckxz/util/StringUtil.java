package com.app.ckxz.util;

public class StringUtil {
    public static Boolean isNotEmpty(String str){
        if(str == null || "".equals(str)){
            return false;
        }
        return true;
    }
    public static Boolean isEmpty(String str){
        if(str == null || "".equals(str)){
            return true;
        }
        return false;
    }
}
