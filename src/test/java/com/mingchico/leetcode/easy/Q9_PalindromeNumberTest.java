package com.mingchico.leetcode.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q9_PalindromeNumberTest {
    Q9_PalindromeNumber sol = new Q9_PalindromeNumber();

    @Test
    @DisplayName("정답인경우")
    void testPositiveNumbers() {
        // Given
        int num = 121;

        // When
        boolean expected = true;

        boolean result = sol.isPalindrome(num);

        // Then
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("오답인경우*음수는 애초에 답이 될 수 없다")
    void testNegativeNumbers() {
        // Given
        int num = 1212;

        // When
        boolean expected = false;

        boolean result = sol.isPalindrome(num);

        // Then
        assertEquals(expected, result);
    }
}