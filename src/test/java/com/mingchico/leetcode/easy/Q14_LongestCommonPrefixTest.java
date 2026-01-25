package com.mingchico.leetcode.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q14_LongestCommonPrefixTest {
    Q14_LongestCommonPrefix sol = new Q14_LongestCommonPrefix();

    @Test
    @DisplayName("답이 있는경우")
    void testBasicCase() {
        // Given
        String[] strs = {"flower","flow","flight"};

        // When
        String expected = "fl";

        String result = sol.longestCommonPrefix2(strs);

        // Then
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("빈 문자열인 경우")
    void testNoCommonPrefix() {
        // Given
        String[] strs = {"dog","racecar","car"};

        // When
        String expected = "";

        String result = sol.longestCommonPrefix2(strs);

        // Then
        assertEquals(expected, result);
    }
}