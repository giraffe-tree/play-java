package com.github.giraffetree.leetcode.stack.t224;

import java.util.Stack;

/**
 * @author GiraffeTree
 * @date 2018-12-25
 */
public class Solution224_02 {

    public static void main(String[] args) {
        String s = "12+(12-23)+2";
        int calculate = new Solution224_02().calculate(s);

        System.out.println(s + " = " + calculate);
    }

    private int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        boolean numFlag = false;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                numFlag = false;
                continue;
            }
            if (c == '+') {
                numFlag = false;
                operatorStack.push(c);
            } else if (c == '-') {
                numFlag = false;
                operatorStack.push(c);
            } else if (c == '(') {
                operatorStack.push(c);
            } else if (c == ')') {
                numFlag = false;
                // 计算直到 '('
                int sum = 0;
                while (true) {
                    Character op = operatorStack.pop();
                    Integer num = numStack.pop();
                    if (op == '(') {
                        sum += num;
                        numStack.push(sum);
                        break;
                    }
                    sum = getSum(sum, op, num);
                }
            } else {
                // 数字
                int num = Character.digit(c, 10);
                if (numFlag) {
                    // 上一个输入为数字
                    int i = numStack.pop() * 10 + num;
                    numStack.push(i);
                }else {
                    numStack.push(num);
                    numFlag = true;
                }

            }
        }
        int result = 0;
        while (!numStack.isEmpty()) {
            if (operatorStack.isEmpty()) {
                // 结束了
                result += numStack.pop();
                break;
            }
            Integer num = numStack.pop();
            Character op = operatorStack.pop();
            result = getSum(result, op, num);
        }

        return result;
    }

    private Integer getSum(Integer sum, char op, Integer num) {
        if (op == '-') {
            return sum - num;
        }

        return sum + num;
    }

}
