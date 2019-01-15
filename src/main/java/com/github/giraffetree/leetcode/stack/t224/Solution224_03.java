package com.github.giraffetree.leetcode.stack.t224;

/**
 * @author GiraffeTree
 * @date 2018-12-26
 */
public class Solution224_03 {

    public static void main(String[] args) {
        calculate("1+3");

    }

    public static int calculate(String s) {
        if (s.length() == 0) {
            return 0;
        }
        s = "(" + s + ")";
        int[] pos = {0};
        return eval(s, pos);
    }

    private static int eval(String s, int[] pos) {
        int val = 0, i = pos[0], sign = 1, num = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            switch (c) {
                case '+':
                    val = val + sign * num;
                    num = 0;
                    sign = 1;
                    i++;
                    break;
                case '-':
                    val = val + sign * num;
                    num = 0;
                    sign = -1;
                    i++;
                    break;
                case '(':
                    pos[0] = i + 1;
                    val = val + sign * eval(s, pos);
                    i = pos[0];
                    break;
                case ')':
                    pos[0] = i + 1;
                    return val + sign * num;
                case ' ':
                    i++;
                    continue;
                default:
                    num = num * 10 + c - '0';
                    i++;
            }
        }
        return val;
    }
}
