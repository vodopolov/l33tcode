package com.vodopolov.longestPalindrome;

/**
 * Created by Anton on 09.03.2020.
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        LongestPalindrome inst = new LongestPalindrome();
        System.out.println(inst.longestPalindrome("babad"));


        System.out.println(1 % 3);
    }

    public String longestPalindrome(String s) {
        String currentMax = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    String substr = s.substring(i, j + 1);
                    if ((substr.length() > currentMax.length()) && isPalindromic(substr))
                        currentMax = substr;
                }
            }
        }
        return currentMax;
    }

    private boolean isPalindromic(String s) {
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) return false;
        }
        return true;
    }
}
