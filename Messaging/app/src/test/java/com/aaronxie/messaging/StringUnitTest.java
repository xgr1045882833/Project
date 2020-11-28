package com.aaronxie.messaging;

import org.junit.Test;

/**
 * create by Aaron Xie
 * on 2020/9/6
 * description:
 */
public class StringUnitTest {

    @Test
    public void main() {
        String string = "9797afdafa nALJDLJ%#@#%^&&";
        char[] ch = string.toCharArray();
        caculateCharCount(ch);
    }

    public void caculateCharCount(char[] charArray) {
        int countUpper = 0;
        int countLower = 0;
        int countNumber = 0;
        int countOther = 0;
        for (char c : charArray) {
            if ('A' <= c && c <= 'Z') {
                countUpper++;
            } else if ('a' <= c && c <= 'z') {
                countLower++;
            } else if ('0' <= c && c <= '9') {
                countNumber++;
            } else {
                countOther++;
            }
        }

        System.out.println("大写字母的个数为：" + countUpper);
        System.out.println("小写字母的个数为：" + countLower);
        System.out.println("数字的个数为：" + countNumber);
        System.out.println("其它字符的个数为：" + countOther);
    }

    @Test
    public void replaceString() {
        String string = "al.%flaj3452 038HKHKHIK2 $^#$#";
        String replace = string.replace(".", "20");
        System.out.println(replace);
    }
}
