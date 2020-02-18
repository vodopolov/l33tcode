package com.vodopolov.FirstUniqueCharacterInString;

import java.util.HashMap;

/**
 * Created by Anton on 18.02.2020.
 */
public class FirstUniqueCharacterInString {
    public static void main(String[] args) {
        FirstUniqueCharacterInString inst = new FirstUniqueCharacterInString();
        System.out.println(inst.firstUniqChar("leetcode"));
        System.out.println(inst.firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int value = map.get(ch);
                map.put(s.charAt(i), value + 1);
            } else
                map.put(ch, 1);
        }

        for (int i = 0; i < s.length(); i++)
            if (map.get(s.charAt(i)) == 1) return i;

        return -1;
    }
}
