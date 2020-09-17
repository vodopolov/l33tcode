package com.vodopolov.removeVowels;

import java.util.HashSet;

/**
 * Created by Anton on 08.03.2020.
 */
public class RemoveVowels {
    public String removeVowels(String S) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for(int i = 0; i < S.length(); i++) {
            if (!set.contains(S.charAt(i))) sb.append(S.charAt(i));
        }
        return sb.toString();
    }
}
