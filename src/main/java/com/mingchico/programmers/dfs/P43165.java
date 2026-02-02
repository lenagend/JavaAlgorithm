package com.mingchico.programmers.dfs;

public class P43165 {
    /* 타겟넘버와 조합의 일치갯수를 기록할 변수*/
    int answer = 0;

    public int solution(int[] numbers, int target) {

        /*dfs메서드 실행 index와 sum을 0,0으로 초기화해서 넘겨줌*/
        dfs(numbers, target, 0, 0);

        return answer;
    }
    /*dfs메서드
        nubers[], target, index, sum을 파라미터로 받아서
        index가 numbers.length와 같으면 종료
                또한, sum과 target이 같으면 aswer++

                +와 -인 경우를 따지기 위해
                sum에 numbers[index]를 더하는경우와 빼는경우의 dfs를 각각실행*/
    public void dfs(int[] numbers, int target, int index, int sum){
        if(index == numbers.length){
            if(sum == target){
                answer ++;
            }
            return;
        }

        dfs(numbers, target, index + 1, sum + numbers[index]);
        dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}
