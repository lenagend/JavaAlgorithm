package com.mingchico.ai.hash;

/*
최고의 간식왕을 찾아라!
문제 설명
학교 축제에서 학생들에게 간식을 나누어 주었습니다.
학생들은 각각 자기가 가장 좋아하는 간식 이름을 하나씩 적어 냈습니다.
가장 많은 표를 얻은 간식이 무엇인지 알아내려 합니다.

제한 사항
간식 목록이 담긴 배열 snacks가 매개변수로 주어집니다.
가장 많이 나온 간식의 이름을 반환하세요.
가장 많이 나온 간식이 여러 개일 경우, 그중 아무거나 하나만 반환해도 됩니다. (이 문제에서는 하나만 있다고 가정합니다.)

입출력 예["apple", "banana", "apple", "cherry", "apple"]"apple"
["candy", "chocolate", "candy", "candy"]"candy"
*/


import java.util.HashMap;
import java.util.Map;

public class Q1 {
    public String solution(String[] snacks){
        /*snacks를 돌며 map에 카운팅한다
        map을 돌며 가장 큰값의 키를찾는다        */

        Map<String, Integer> map = new HashMap<>();

        int max = 0;
        String answer = "";

        for(String snack : snacks){
            int count = map.merge(snack, 1, Integer::sum);
            if(count > max) {
                max = count;
                answer = snack;
            }
        }


        return answer;
    }
}
