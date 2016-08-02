package com.wqj;

import java.util.ArrayList;
import java.util.Collections;
import java.lang.*;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> arrResult = new ArrayList<String>();  //保存子串
    public static ArrayList<String> duichen = new ArrayList<String>();//保存对称子串
    static String result = "";
    public static void main(String[] args) {
        String str2 = "";
        try {
            Scanner s = new Scanner(System.in);
            while (s.hasNext()) {
                String str1 = s.next();
                if (str1.toString().equals("0")) {
                    break;
                } else {
                    str2 += str1;
                }
            }
            strCombination(str2);
            Collections.sort(arrResult);
            //输出结果
            for (int i = 0; i < arrResult.size(); i++) {
                isPalindromeByBuffer(arrResult.get(i));//判断子集是否对称
            }
//           System.out.println(duichen.get(duichen.size()));
        } catch (Exception e) {

        }
        int a= duichen.size();
        System.out.println(duichen.get(a-1));
    }


    public static boolean isPalindromeByBuffer(String s) {
        //要输出的结果串
        String strOrigin = filterLetterAndDigit(s);
        //将strOrigin作为输入参数，构造一个StringBuffer对象
        StringBuffer strBuf = new StringBuffer(strOrigin);
        //调用StringBuffer对象自带的reverse()方法进行字符串翻转，最后调用toString()返回一个String类型字符串
        String strAfterReverse = strBuf.reverse().toString();
        //通过equals()方法判断原来的字符串和翻转后的字符串是否相等，来确定是否为回文
        if (strOrigin.equals(strAfterReverse)) {
            duichen.add(s);
        }
//        System.out.println(duichen);
//        System.out.println(duichen.get(duichen.size()));

//        for (int i = 0; i < huiwen.size(); i++) {
//            int bijiao = huiwen.get(i).compareTo(huiwen.get(i + 1));
//            if (bijiao > 0) {
//                result=huiwen.get(i+1);
//               System.out.println(result);
//           }
//        }
//        System.out.println(duichen);
        return true;
    }




    public static void strCombination(String str) {
        int len = str.length();     //获得字符串长度
        String temp = "";
        if (len > 1)  //字符串
        {
            for (int i = 0; i < len; i++) {
                StringBuffer sb = new StringBuffer(str);  //使用StringBuffer，为了删除字符串中的某一字符
                sb.deleteCharAt(i);
                temp = sb.toString();
                strCombination(temp);   //递归
            }
        }
        else if (len == 1 && arrResult.size() == 0)  //单个字母
        {
            int acs = 0;
            //大小写处理
            if (str.charAt(0) > 'A' && str.charAt(0) < 'a') {
                acs = 65;
            }
        }
        //如果子串没有保存在arrResult中，则添加到arrResult中
        if (!(arrResult.contains(str))) {
            arrResult.add(str);
        }
        return;
    }

    public static String filterLetterAndDigit(String s) {
        StringBuffer strBuf = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                //调用StringBuffer的append(Char char)方法,将输入的字母或者数字加入其中
                strBuf.append(s.charAt(i));
            }
        }
        //返回String类型，需要将StringBuffer转换为String，需要调用StringBuffer对象的toString()方法
        return strBuf.toString();
    }
}
