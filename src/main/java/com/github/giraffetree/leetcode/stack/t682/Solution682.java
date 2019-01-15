package com.github.giraffetree.leetcode.stack.t682;

import java.util.Stack;

/**
 * @author GiraffeTree
 * @date 2018-12-26
 */
public class Solution682 {

    public int calPoints(String[] ops) {
        Stack<String> stack = new Stack<>();
        for (String s : ops) {
            switch (s) {
                case "C":
                    stack.pop();
                    break;
                case "+": {
                    String num01 = stack.pop();
                    String num02 = stack.pop();
                    int i = Integer.valueOf(num01) + Integer.valueOf(num02);
                    stack.push(num02);
                    stack.push(num01);
                    stack.push(Integer.toString(i));
                    break;
                }
                case "D": {
                    String num01 = stack.peek();
                    int i = Integer.valueOf(num01) * 2;
                    stack.push(Integer.toString(i));
                    break;
                }
                default:
                    stack.push(s);
                    break;
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            Integer num = Integer.valueOf(pop);
            sum += num;
        }
        return sum;
    }

}
