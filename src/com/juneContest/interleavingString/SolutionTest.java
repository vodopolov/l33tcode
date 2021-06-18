package com.juneContest.interleavingString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void isInterleave() {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        Solution s = new Solution();
        assertTrue(s.isInterleave(s1, s2, s3));

        String s4 = "aabcc", s5 = "dbbca", s6 = "aadbbbaccc";
        assertFalse(s.isInterleave(s4, s5, s6));

        String s7 = "", s8 = "", s9 = "";
        assertTrue(s.isInterleave(s7, s8, s9));

        String s10 = "aa", s11 = "ab", s12 = "aaba";
        assertTrue(s.isInterleave(s10, s11, s12));
    }
}