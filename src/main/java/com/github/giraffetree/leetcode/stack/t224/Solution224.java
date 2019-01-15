package com.github.giraffetree.leetcode.stack.t224;

import java.util.Stack;

/**
 * @author GiraffeTree
 * @date 2018-12-20
 */
public class Solution224 {

    public static void main(String[] args) {
        Solution224 solution224 = new Solution224();
        System.out.println(solution224.calculate("2-(5-6)"));

    }

    /**
     * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
     * <p>
     * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
     */
    public int calculate(String s) {
        s = s.trim();
        // 0 为上个数已经结束输入
        int numFlag = 0;

        // 1 2 3
        Stack<Integer> numStack = new Stack<>();
        // + - ( )  -> 1 2 3 4
        Stack<Character> operatorStack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            boolean endFlag = (chars.length - 1) == i;
            if (c == ' ') {
                numFlag = 0;
                continue;
            }
            if (c == '+' || c == '-') {
                numFlag = 0;
                operatorStack.push(c);
                continue;
            }
            if (c == '(') {
                operatorStack.push(c);
                continue;
            }
            if (c == ')') {
                numFlag = 0;
                // 检查上一个是否为 `)`
                int sum = 0;
                while (!operatorStack.empty()) {
                    Character peek = operatorStack.peek();
                    if (peek.equals('(')) {
                        operatorStack.pop();
                        sum = sum + numStack.pop();
                        numStack.push(sum);
                        if (endFlag) {
                            continue;
                        }
                        break;
                    }
                    if (peek.equals('+')) {
                        Integer pop = numStack.pop();
                        operatorStack.pop();
                        sum += pop;
                    } else if (peek.equals('-')) {
                        Integer pop = numStack.pop();
                        operatorStack.pop();
                        sum = sum - pop;
                    }
                }

                continue;
            }
            if (endFlag) {
                // 数字入栈
                Integer value = Integer.valueOf(Character.toString(c));
                if (numFlag != 0) {
                    Integer pop1 = numStack.pop();
                    value = pop1 * 10 + value;
                    numStack.push(value);
                } else {
                    numStack.push(value);
                }
                int sum = 0;
                while (!operatorStack.empty()) {
                    Character peek = operatorStack.peek();
                    if (peek.equals('(')) {
                        operatorStack.pop();
                        sum = sum + numStack.pop();
                        break;
                    }
                    if (peek.equals('+')) {
                        Integer pop = numStack.pop();
                        operatorStack.pop();
                        sum += pop;
                    } else if (peek.equals('-')) {
                        Integer pop = numStack.pop();
                        operatorStack.pop();
                        sum = sum - pop;
                    }
                }
                numStack.push(sum);
                break;
            }

            // 数字入栈
            Integer value = Integer.valueOf(Character.toString(c));
            if (numFlag != 0) {
                Integer pop1 = numStack.pop();
                value = pop1 * 10 + value;
                numStack.push(value);
                continue;
            }
            numStack.push(value);
            numFlag = 1;
        }
        return numStack.pop();
    }

}
