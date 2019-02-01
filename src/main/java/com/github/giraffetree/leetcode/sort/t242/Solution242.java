package com.github.giraffetree.leetcode.sort.t242;

/**
 * @author GiraffeTree
 * @date 2019-01-15
 */
public class Solution242 {

    /**
     * 思路
     * 1. 字母数组, 匹配 时间复杂度 O(n)
     *
     */
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }

}
