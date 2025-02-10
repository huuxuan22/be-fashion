package com.example.projectc1023i1.utils;

public class GetFirstString {
    public static String getFirstString(String str) {
        String strResuslt = String.valueOf(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i-1) == ' ') {
                strResuslt += str.charAt(i);
            }
        }
        return strResuslt.toUpperCase();
    }
}
