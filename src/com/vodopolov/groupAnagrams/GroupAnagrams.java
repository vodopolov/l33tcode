package com.vodopolov.groupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Anton on 11.04.2020.
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] array = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams inst = new GroupAnagrams();
        List<List<String>> result = inst.groupAnagrams(array);
        for (List<String> resultList : result) {
            System.out.println("");
            for (String s : resultList) {
                System.out.print(s);
                System.out.println(", ");
            }
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean hasAnagrams;
        for (String str : strs) {
            hasAnagrams = false;
            for (List<String> list : result) {
                String toCompareWith = list.get(0);
                if (isAnagram(str, toCompareWith)) {
                    list.add(str);
                    hasAnagrams = true;
                    break;
                }
            }
            if (!hasAnagrams) {
                ArrayList<String> anagramList = new ArrayList<>();
                anagramList.add(str);
                result.add(anagramList);
            }
        }
        return result;
    }

    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        List<Character> charA = new ArrayList<Character>();
        for (int i = 0; i < a.length(); i++) {
            charA.add(a.charAt(i));
        }
        for (char charB : b.toCharArray()) {
            int id = charA.indexOf(charB);
            if (id == -1) return false;
            charA.remove(id);
        }
        return charA.size() == 0;
    }
}
