package com.github.giraffetree.leetcode.stack.t844;

import java.util.Stack;

/**
 * @author GiraffeTree
 * @date 2018-12-20
 */
public class Solution844 {

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        for (Character c : S.toCharArray()) {
            if (c.equals('#')) {
                if (stackS.empty()) {
                    continue;
                }
                stackS.pop();
                continue;
            }
            stackS.push(c);
        }
        for (Character c : T.toCharArray()) {
            if (c.equals('#')) {
                if (stackT.empty()) {
                    continue;
                }
                stackT.pop();
                continue;
            }
            stackT.push(c);
        }
        while (true) {
            if (!stackS.empty()) {
                if (stackT.empty()) {
                    return false;
                }
                if (stackS.pop() != stackT.pop()) {
                    return false;
                }
                continue;
            }
            return stackT.empty();
        }

    }

}
