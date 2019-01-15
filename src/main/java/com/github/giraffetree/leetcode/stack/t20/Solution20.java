package com.github.giraffetree.leetcode.stack.t20;

import com.github.giraffetree.leetcode.stack.ArrayStack;

/**
 * @author GiraffeTree
 * @date 2018-12-20
 */
public class Solution20 {

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        solution20.isValid("\"([.;fsadfaf])\"");

    }

    public boolean isValid(String s) {
        ArrayStack stack = new ArrayStack(s.length());

        char[] chars = s.toCharArray();
        try {
            for (char c : chars) {
                if (c == 40 || c == 91 || c == 123) {
                    stack.push(c);
                }
                if (c == 41) {
                    if (stack.pop() != 40) {
                        return false;
                    }
                }
                if (c == 93) {
                    if (stack.pop() != 91) {
                        return false;
                    }
                }
                if (c == 125) {
                    if (stack.pop() != 123) {
                        return false;
                    }
                }
            }
        } catch (NullPointerException e) {
            return false;
        }

        try {
            stack.pop();
        } catch (NullPointerException e) {
            return true;
        }
        return false;
    }

}
