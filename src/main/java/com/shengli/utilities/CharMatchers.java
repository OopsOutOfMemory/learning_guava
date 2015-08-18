package com.shengli.utilities;

import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;

import java.io.UnsupportedEncodingException;

/**
 * Created by shengli on 8/17/15.
 */
public class CharMatchers {
    public static void main(String[] args) {

        /*---------------Old Way-- Should specify ENCODER UTF-8---------------*/

        try{
            byte[] bytes = "foobarbaz".getBytes("UTF-8");
        }catch (UnsupportedEncodingException e){
            //This really can't happen UTF-8 must be supported
        }


        /*---------------Guava Charsets Class---------------*/
        byte[] bytes2 = "foobarbaz".getBytes(Charsets.UTF_8);
        byte[] bytes3 = "foobarbaz".getBytes(Charsets.ISO_8859_1);
        byte[] bytes4 = "foobarbaz".getBytes(Charsets.UTF_16);

        String string = "String  with   1234   spaces     and tabs";
        String scrubbed = CharMatcher.WHITESPACE.collapseFrom(string,' ');
        CharSequence stringWithLinebreaks;
        //BREAKING_WHITESPACE: 匹配所有可换行的空白字符(不包括非换行空白字符,例如"\u00a0")
//        CharMatcher.BREAKING_WHITESPACE.replaceFrom(stringWithLinebreaks,' ');
        System.out.println(scrubbed);

//原字符串
System.out.println(string);

//去掉控制字符(\t,\n,\b...)
System.out.println(CharMatcher.JAVA_ISO_CONTROL.removeFrom(string));

//获取所有的数字
System.out.println(CharMatcher.DIGIT.retainFrom(string));

//把多个空格替换为一个包括\t,并去掉首位的空格
System.out.println(CharMatcher.WHITESPACE.trimAndCollapseFrom(string, ' '));

//把所有的数字用"*"代替
System.out.println(CharMatcher.JAVA_DIGIT.replaceFrom(string, "*"));

//获取所有的数字和小写字母
System.out.println(CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom(string));

//获取所有的大写字母
System.out.println(CharMatcher.JAVA_UPPER_CASE.retainFrom(string));

//获取所有单字节长度的符号
System.out.println(CharMatcher.SINGLE_WIDTH.retainFrom(string));

/*
原字符串:
ROCKY  rocky  RoCkY ~!@#$%^&*()      23(*&gS   你好 234啊   GES

去掉控制字符(\t,\n,\b...):
ROCKY  rocky  RoCkY ~!@#$%^&*()      23(*&gS   你好234啊   GES

获取所有的数字:
23234

把多个空格替换为一个包括\t,并去掉首位的空格:
ROCKY rocky RoCkY ~!@#$%^&*() 23(*&gS 你好 234啊 GES

把所有的数字用"*"代替:
ROCKY  rocky  RoCkY ~!@#$%^&*()      **(*&gS   你好 ***啊   GES

获取所有的数字和小写字母:
rockyok23g234

获取所有的大写字母:
ROCKYRCYSGES

获取所有单字节长度的符号:
ROCKY  rocky  RoCkY ~!@#$%^&*()      23(*&gS      234   GES
*/

    }
}
