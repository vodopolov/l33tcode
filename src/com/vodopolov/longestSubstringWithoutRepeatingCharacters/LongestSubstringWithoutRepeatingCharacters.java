package com.vodopolov.longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Anton on 28.02.2020.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters inst = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(inst.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(inst.lengthOfLongestSubstring("bbbbbbb"));
        System.out.println(inst.lengthOfLongestSubstring("pwwkew"));
        System.out.println(inst.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {
        int currentMax = 0;
        int i = 0, j = 0;
        HashSet<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                currentMax = Math.max(currentMax, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return currentMax;
    }
}
