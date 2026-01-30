package com.mingchico.programmers.bruteforce;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P86491Test {
    P86491 sol = new P86491();

    @Test
    @DisplayName("기본케이스")
    void testBasicCase() {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int expected = 4000;

        // When (실행)
        int result = sol.solution(sizes);

        // Then (검증)
        assertEquals(expected, result);
    }

}