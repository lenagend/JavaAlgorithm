package com.mingchico.programmers.sort;

import java.util.*;

public class P42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            // 1. i, j, k 추출 (가독성을 위해 변수로 선언)
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];

            // 2. 배열 자르기 (start-1부터 end까지)
            // copyOfRange는 마지막 인덱스를 포함하지 않으므로 end 그대로 사용
            int[] temp = Arrays.copyOfRange(array, start - 1, end);

            // 3. 정렬
            Arrays.sort(temp);

            // 4. K번째 수 추출
            answer[i] = temp[k - 1];
        }

        return answer;
    }
}
