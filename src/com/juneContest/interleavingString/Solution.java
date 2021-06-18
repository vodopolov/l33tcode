package com.juneContest.interleavingString;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return checkAndTake(s1, s2, s3);
    }

    private boolean checkAndTake(String s1, String s2, String s3) {
        do {
            int first = takeInnerStringSIze(s1, s3);
            int second = takeInnerStringSIze(s2, s3);
            if (first == 0 && second == 0 && s3.length() != 0) {
                return false;
            }

            if (first > second) {
                s1 = s1.substring(first);
                s3 = s3.substring(first);
            } else {
                s2 = s2.substring(second);
                s3 = s3.substring(second);
            }

        } while (s3.length() != 0 || s2.length() != 0 || s1.length() != 0);
        return true;
    }

    private int takeInnerStringSIze(String s1, String s2) {
        if (s1.length() == 0) return 0;
        int counter = 0;
        while (counter < s1.length() && (counter < s2.length()) && s1.charAt(counter) == s2.charAt(counter)) {
            counter++;
        }
        return counter;
    }
}
