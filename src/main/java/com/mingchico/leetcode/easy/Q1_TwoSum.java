package com.mingchico.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Q1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        /*Example 1:

        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
        Example 2:

        Input: nums = [3,2,4], target = 6
        Output: [1,2]
        Example 3:

        Input: nums = [3,3], target = 6
        Output: [0,1]*/

        /*내 생각
        nums를 순회하면서 만약 target보다 큰수가 있다면 스킵
        이중반복문으로 풀 수 있을 것 같다*/
        for(int i = 0; i < nums.length - 1; i++){
                for(int j = i + 1; j < nums.length; j ++){
                    if((nums[i] + nums[j]) == target){
                        return new int[]{i, j};
                    }
                }
        }


        return new int[]{};
    }

    // [더 나은 솔루션] HashMap 방식
    /*이 문제의 핵심은 "내가 지금 보고 있는 숫자(A)와 더해서
    target이 되는 숫자(B)가 이전에 나온 적이 있는가?를 기억하는 것
        이때 '기억'하기 가장 좋은 도구가 바로 HashMap*/
    public int[] twoSumWithHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    /*
      [해시맵 방식 풀이 과정] - target: 6, nums: [3, 2, 4]
      * 1단계: 빈 장부(HashMap)를 준비한다.
      이 장부에는 '숫자 : 그 숫자의 위치(index)'를 기록하며 나아간다.
      * 2단계: 첫 번째 숫자 3 (index 0) 확인
      - 내가 필요한 숫자는 6 - 3 = 3이다.
      - 장부를 보니 3이 없다. (아직 아무도 안 지나감)
      - 나중에 누군가 3을 찾을 수도 있으니 내 정보 {3 : 0}을 장부에 적어두고 넘어간다.
      * 3단계: 두 번째 숫자 2 (index 1) 확인
      - 내가 필요한 숫자는 6 - 2 = 4이다.
      - 장부를 확인하니 4가 없다. (아까 적힌 3만 있음)
      - 역시 나중에 나를 찾을 놈을 위해 내 정보 {2 : 1}을 적어둔다.
      * 4단계: 세 번째 숫자 4 (index 2) 확인
      - 내가 필요한 숫자는 6 - 4 = 2이다.
      - 장부를 보니 아까 지나간 2가 있다! (index 1에 기록됨)
      - 드디어 짝꿍을 찾았으니 장부에 있던 2의 인덱스(1)와 내 인덱스(2)를 반환한다.
      결과: [1, 2]
     */

    // 로컬 테스트를 위한 main 메서드 (선택)
    public static void main(String[] args) {
        Q1_TwoSum sol = new Q1_TwoSum();

        // 1. 기존 테스트 케이스
        int[] nums = new int[]{-3, 4, 3, 90};
        sol.twoSum(nums, 0);
        /*효율을 생각한다고 타겟보다 크면 continue하라고 했는데
                nums에 음수가 올경우 target보다 작은 경우가 있을 거라고는 생각지 못했다
                continue 삭제*/

        //내 알고리즘과 더 나은 솔루션과의 성능비교
        // 2. 성능 비교 테스트를 위한 대량 데이터 생성 (10만 개)
        int size = 100000;
        int[] largeNums = new int[size];
        for (int i = 0; i < size; i++) largeNums[i] = i;
        int targetSum = (size - 2) + (size - 1); // 가장 마지막 두 수를 찾아야 하는 최악의 상황

        System.out.println("=== 성능 비교 시작 (데이터 " + size + "건) ===");

        // [Brute Force 테스트]
        long start = System.currentTimeMillis();
        sol.twoSum(largeNums, targetSum);
        long end = System.currentTimeMillis();
        System.out.println("이중 for문(Brute Force) 소요 시간: " + (end - start) + "ms");

        // [HashMap 테스트]
        start = System.currentTimeMillis();
        sol.twoSumWithHashMap(largeNums, targetSum);
        end = System.currentTimeMillis();
        System.out.println("해시맵(HashMap) 소요 시간: " + (end - start) + "ms");

        System.out.println("======================================");
    }

    /*안보고 복기하기*/
    public int[] twoSumWithHashMap2(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            map.put(num, i);

            int friend = target - nums[i];
            if(map.containsKey(friend)){
                return new int[]{map.get(friend), i};
            }
        }

        return new int[]{};
    }
}
