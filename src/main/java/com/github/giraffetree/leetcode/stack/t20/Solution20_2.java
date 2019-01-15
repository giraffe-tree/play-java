package com.github.giraffetree.leetcode.stack.t20;

/**
 * @author GiraffeTree
 * @date 2018-12-20
 */
public class Solution20_2 {

    public static void main(String[] args) {
        String s = "[{}]{()}";
        Solution20_2 solution20_2 = new Solution20_2();
        solution20_2.isValid(s);
    }

    static char[] pair = new char[256];
    static {
        pair[')'] = '(';
        pair[']'] = '[';
        pair['}'] = '{';
    }

    public boolean isValid(String s) {
        char[] stack = new char[s.length() + 1];
        stack[0] = '0';
        int k = 0;
        for (int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (pair[c] != 0) {
                if (stack[k] != pair[c]) {
                    return false;
                } else {
                    k--;
                }
            } else {
                stack[++k] = c;
            }
        }

        if (k == 0) {
            return true;
        } else {
            return false;
        }
    }
}