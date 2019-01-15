package com.github.giraffetree.leetcode.stack.t224;

/**
 * @author GiraffeTree
 * @date 2018-12-26
 */
public class Solution224_04 {

    int i;

    public int calculate(String s) {
        i = 0;
        return help(s);
    }

    private int help(String s) {
        int ans = 0;
        int n = s.length();
        int sign = 1;

        while (i < n) {
            char c = s.charAt(i);
            switch (c) {
                case ' ':
                    break;
                case '+':
                    sign = 1;
                    break;
                case '-':
                    sign = -1;
                    break;
                case '(':
                    i++;
                    ans += sign * help(s);
                    break;
                case ')':
                    return ans;
                default:
                    int num = c - '0';
                    while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                        num = num * 10 + s.charAt(++i) - '0';
                    }

                    ans += num * sign;
            }
            i++;
        }
        return ans;
    }
}
