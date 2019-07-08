package com.tarento.coding;

public class MixStrings {

    public static String mix(String str1, String str2, String str3)
    {
        if(str1.length() == 0 || str2.length() == 0 || str3.length() == 0) {
            return str1 + str2 + str3;
        }
        return str1.substring(0, 1) + str2.substring(0, 1) + str3.substring(0, 1) + mix(str1.substring(1), str2.substring(1), str3.substring(1));
    }
    public static void main(String args[]) {

        System.out.println(mix("abc", "def", "ghi"));
    }
}
