package com.aaronxie.messaging;

import org.junit.Test;

/**
 * create by Aaron Xie
 * on 2020/9/15
 * description:
 */
public class LogicalUnitTest {

    @Test
    public void main() {
        int a, b, c;
        for (a = 0; a <= 1; a++) {
            for (b = 0; b <= 1; b++) {
                for (c = 0; c <= 1; c++) {
                    boolean aTrue = (a == 1 && b == 0);
                    boolean aFalse = (a == 0 && b == 1);
                    boolean bTrue = (b == 1 && c == 0);
                    boolean bFalse = (b == 0 && c == 1);
                    boolean cTrue = (c == 1 && a == 0 && b == 0);
                    boolean cFalse = (c == 0 && (b == 1 || c == 1));
                    // 要么讲真，要么说谎
                    boolean aJudge = (aTrue || aFalse);
                    boolean bJudge = (bTrue || bFalse);
                    boolean cJudge = (cTrue || cFalse);
                    if (aJudge && bJudge && cJudge) {
                        System.out.println("a=" + a);
                        System.out.println("b=" + b);
                        System.out.println("c=" + c);
                    }
                }
            }
        }
    }

    String Judge(int var) {
        if (var == 1) {
            return "honest";
        } else {
            return "lier";
        }
    }

    @Test
    public void main2() {
        int a, b, c;
        for (a = 0; a <= 1; a++) {
            for (b = 0; b <= 1; b++) {
                for (c = 0; c <= 1; c++) {
                    // a讲真，2个诚实族
                    boolean aTrue = ((a == 1) && (a + b + c == 2));
                    // a说谎，不是2个诚实族
                    boolean aFalse = ((a == 0) && (a + b + c != 2));
                    boolean bTrue = ((b == 1) && (a + b + c == 1));
                    boolean bFalse = ((b == 0) && (a + b + c != 1));
                    boolean cTrue = ((a == 1) && (a + b + c == 1));
                    boolean cFalse = ((a == 0) && (a + b + c != 1));
                    // a,b,c同时：要么真，要么假
                    if ((aTrue || aFalse) && (bTrue || bFalse) && (cTrue || cFalse)) {
                        System.out.println("A is a " + Judge(a));
                        System.out.println("B is a " + Judge(b));
                        System.out.println("C is a " + Judge(c));
                    }
                }
            }
        }
    }
}
