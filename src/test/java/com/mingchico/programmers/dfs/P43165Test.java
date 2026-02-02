package com.mingchico.programmers.dfs;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P43165Test {
    P43165 sol = new P43165();

    @Test
    @DisplayName("기본테스트")
    void testBasicCase(){
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        int expect = 5;

        int result = sol.solution(numbers, target);

        assertEquals(expect, result);
    }

}