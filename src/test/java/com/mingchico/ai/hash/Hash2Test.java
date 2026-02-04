package com.mingchico.ai.hash;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Hash2Test {
    Hash2 sol = new Hash2();

    @Test
    @DisplayName("베이직 케이스")
    void testBasicCase(){
        String[] required = {"ruby", "diamond", "opal"};
        String[] myBag = {"ruby", "opal"};

        String expected = "diamond";

        String result = sol.solution(required, myBag);

        assertEquals(expected, result);

    }

    @Test
    @DisplayName("중복이 있는 경우")
    void testDuplicateCase(){
        String[] required = {"topaz", "topaz", "emerald"};
        String[] myBag = {"topaz", "emerald"};

        String expected = "topaz";

        String result = sol.solution(required, myBag);

        assertEquals(expected, result);

    }

}