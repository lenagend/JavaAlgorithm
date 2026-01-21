package com.mingchico.leetcode.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q13_RomanToIntegerTest {

    Q13_RomanToInteger sol = new Q13_RomanToInteger();

    @Test
    @DisplayName("기본 케이스: 다 더한다")
    void testBasicTwoSum() {
        // Given (준비)
        String input = "III";
        int expect = 3;

        // When (실행)
        int result = sol.romanToInt(input);

        // Then (검증)
        assertEquals(expect, result);
    }

    @Test
    @DisplayName("감산 규칙: 40(XL)처럼 작은 숫자가 큰 숫자 앞에 오면 뺄셈으로 계산한다")
    void romanSubtractionTest() {
        // Given (준비)
        String input = "XL";
        int expect = 40;

        // When (실행)
        int result = sol.romanToInt(input);

        // Then (검증)
        assertEquals(expect, result);
    }

    @Test
    @DisplayName("좀더 복잡한")
    void romanComplicated() {
        // Given (준비)
        String input = "MCMXCIV";
        int expect = 1994;

        // When (실행)
        int result = sol.romanToInt(input);

        // Then (검증)
        assertEquals(expect, result);
    }

}