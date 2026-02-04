package com.mingchico.ai.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Stack1Test {
    Stack1 sol = new Stack1();

    @Test
    @DisplayName("정답인 케이스")
    void testRightCase(){
        String s = "()()";

        boolean expected = true;

        boolean result = sol.solution(s);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("오답인 케이스")
    void testWrongCase(){
        String s = ")()(";

        boolean expected = false;

        boolean result = sol.solution(s);

        assertEquals(expected, result);
    }

}