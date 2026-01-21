package com.mingchico.leetcode.easy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Q1_TwoSumTest {

    private final Q1_TwoSum sol = new Q1_TwoSum();

    @Test
    @DisplayName("기본 케이스: 합이 9가 되는 두 인덱스를 찾는다")
    void testBasicTwoSum() {
        // Given (준비)
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expected = {0, 1};

        // When (실행)
        int[] result = sol.twoSumWithHashMap2(nums, target);

        // Then (검증)
        assertArrayEquals(expected, result, "2와 7의 인덱스인 [0, 1]이 반환되어야 합니다.");
    }

    @Test
    @DisplayName("음수가 포함된 경우에도 올바르게 동작해야 한다")
    void testNegativeNumbers() {
        // Given
        int[] nums = {-3, 4, 3, 90};
        int target = 0;
        int[] expected = {0, 2};

        // When
        int[] result = sol.twoSumWithHashMap2(nums, target);

        // Then
        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("정답이 없는 경우 빈 배열을 반환해야 한다")
    void testNoResult() {
        int[] nums = {1, 2, 3};
        int target = 10;

        int[] result = sol.twoSumWithHashMap2(nums, target);

        assertEquals(0, result.length);
    }
}