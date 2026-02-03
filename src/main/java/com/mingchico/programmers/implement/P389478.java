package com.mingchico.programmers.implement;

/*입출력 예
n	w	num	result
22	6	8	3
13	3	6	4*/
public class P389478 {
    public int solution(int n, int w, int num) {
        int answer = 0;

        // 1. 목표 상자의 위치(층, 칸) 찾기
        int targetRow = (num - 1) / w;
        int targetCol = getCol(num, w, targetRow);

        // 2. 목표 상자 층부터 끝까지 올라가며 상자가 있는지 확인
        // (제일 위층 상자의 row 값은 (n-1)/w 입니다)
        int maxRow = (n - 1) / w;

        for (int r = targetRow; r <= maxRow; r++) {
            // 현재 층(r)의 targetCol 위치에 있는 상자 번호를 역추적
            int currentNum = getNumAt(r, targetCol, w);

            // 만약 계산된 번호가 실제 존재하는 상자(n 이하)라면 카운트
            if (currentNum <= n) {
                answer++;
            }
        }

        return answer;
    }

    // 특정 번호의 열(Column) 위치를 구하는 메서드
    private int getCol(int num, int w, int row) {
        int remain = (num - 1) % w;
        if (row % 2 == 0) { // 짝수 층: 정방향
            return remain;
        } else { // 홀수 층: 역방향
            return (w - 1) - remain;
        }
    }

    // 특정 좌표(row, col)에 있어야 할 상자 번호를 구하는 메서드
    private int getNumAt(int row, int col, int w) {
        if (row % 2 == 0) { // 짝수 층
            return row * w + col + 1;
        } else { // 홀수 층
            return row * w + (w - 1 - col) + 1;
        }
    }
}
