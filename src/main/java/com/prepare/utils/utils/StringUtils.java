package com.prepare.utils.utils;

public class StringUtils {


    /**
     * 判断字符串是否为空或null
     * @param s
     * @return
     */
    public static boolean isEmpty(String s){
        return (s == null || s.equals("")) ;
    }


    /**
     * 判断字符串是否为纯空格的空
     * null true
     * " " true
     * " " true
     * "bob" false
     * " bob " false
     */
    public static boolean isBlank(CharSequence cs){
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }
}
