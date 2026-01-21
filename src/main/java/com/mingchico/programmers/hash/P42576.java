package com.mingchico.programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class P42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        //여러명 등장할 수 있기때문에 맵에 이름과 등장횟수를 카운트
        for (String name : participant){
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        //만약 맵에 있으면 카운트--
        for(String name : completion){
            if(map.containsKey(name)){
                map.put(name, map.get(name) - 1);
            }
        }
        //맵 돌면서 0보다 큰 게 정답
        for (String name : map.keySet()){
            if(map.get(name) > 0){
                return name;
            }
        }
        
        return answer;
    }

    /*
        더 나은 솔루션
    */
    public String solution2(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        // 1. 참가자 등록 (merge 활용)
        for (String name : participant) {
            map.merge(name, 1, Integer::sum);
        }

        // 2. 완주자 차감 (computeIfPresent 활용)
        // 완주자는 반드시 participant에 있다는 조건이 있으므로 더 간결하게 처리 가능
        for (String name : completion) {
            map.computeIfPresent(name, (k, v) -> v - 1);
        }

        // 3. 결과 추출 (Entry 순회 및 Stream 활용 가능)
        // 5년 차라면 Stream을 써서 "값이 0보다 큰 첫 번째 키를 찾는다"는 의도를 보여줄 수 있습니다.
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("");
    }






//    안보고 나은 솔루션 복기

      public String solution3(String[] participant, String[] completion) {
        String answer = "";

        /*맵을 만들어서 참가자들의 등장 횟수를 카운트한다
        완주목록을 순회해서 맵의 등장횟수를 차감한다
        맵을 돌면서 0이 아닌 사람을 찾아 리턴한다   */

        Map<String, Integer> map = new HashMap<>();

        for(String name : participant){
            //Check-then-Act를 원자적 연산(Atomic Operation)으로 교체하여 가독성과 안전성 확보
            map.merge(name, 1, Integer::sum);
        }

        //불필요한 존재 여부 확인(containsKey) 절차를 없애고, 값이 있을 때만 안전하게 업데이트를 수행하는 원자적(Atomic) 연산
        for(String name : completion) {
            map.computeIfPresent(name, (k, v) -> (v - 1));
        }

        return map.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse("");

      }







}
