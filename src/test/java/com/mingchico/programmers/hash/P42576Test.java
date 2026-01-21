package com.mingchico.programmers.hash;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P42576Test {
    private final P42576 sol = new P42576();

    @Test
    @DisplayName("기본 케이스: 완주하지 못한 선수 한 명을 찾아야 한다")
    void testBasic42576() {
        // Given (준비)
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String expected = "leo";

        // When (실행)
        String result = sol.solution3(participant, completion);

        // Then (검증)
        assertEquals(expected, result, "완주하지 못한 선수는 leo여야 합니다.");
    }

    @Test
    @DisplayName("동명이인 케이스: 이름이 같아도 한 명만 완주했다면 남은 한 명을 찾아야 한다")
    void testSameName42576() {
        // Given
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String expected = "mislav";

        // When
        String result = sol.solution3(participant, completion);

        // Then
        assertEquals(expected, result);
    }
}