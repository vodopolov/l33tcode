package com.vodopolov.phoneNumberLetters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Anton on 09.02.2020.
 */
public class PhoneNumberToLetterCombinations {
    private static final HashMap<Integer, List<Character>> map = new HashMap<>();

    public static void main(String[] args) {
        String input1 = "237";
        PhoneNumberToLetterCombinations inst = new PhoneNumberToLetterCombinations();
        inst.fillMap();
        String[] result = inst.createCombinations(input1);
        for (String s :
                result) {
            System.out.println(s);
        }
    }

    private String[] createCombinations(String input) {
        ArrayList<String> result = new ArrayList<>();
        this.backtrackPhoneNumber(result, "", input, 0);
        String[] strings = new String[result.size()];
        result.toArray(strings);
        return strings;
    }

    private void backtrackPhoneNumber(List<String> result, String currentStr, String number, int numberId) {
        if (number.length() == 0) return;
        if (currentStr.length() == number.length()) {
            result.add(currentStr);
            return;
        }
        int currentNumber = number.charAt(numberId) - '0';
        List<Character> characters = map.get(currentNumber);
        for (int i = 0; i < characters.size(); i++) {
            backtrackPhoneNumber(result, currentStr + characters.get(i), number, numberId + 1);
        }
    }

    private void fillMap() {
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
    }
}
