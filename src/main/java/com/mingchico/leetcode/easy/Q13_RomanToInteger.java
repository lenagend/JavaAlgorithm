package com.mingchico.leetcode.easy;

import java.util.Map;

public class Q13_RomanToInteger {
    public int romanToInt(String s){
        /*각 로마자를 맵에 담는다
                총합을 담을 변수를 선언한다
                문자열을 순회하면서 이전값이 없으면(0) 또는 이전값이 나보다 같거나 크면
                그냥 총합에 더한다
                아닌 경우는 총합에 현재값을 더하고
                총합에서 이전값을 두번(이미 한번 더했으므로)뺀다*/

        int result = 0;
        Map<Character, Integer> map = Map.of(
          'I', 1,
          'V', 5,
          'X', 10,
          'L', 50,
          'C', 100,
          'D', 500,
          'M', 1000
        );

        int prev = 0;

        for(char roman : s.toCharArray()){
            int current = map.get(roman);
            if(prev == 0 || prev >= current){
                result += current;
            }else{
                result += current;
                result -= prev * 2;
            }
            prev = current;
        }

        return result;
    }

    //더 나은 솔루션
    public int romanToInt2(String s) {
        int result = 0;
        int prev = 0;

        // 뒤에서부터 순회하는 것이 로직이 가장 깔끔하게 떨어집니다.
        for (int i = s.length() - 1; i >= 0; i--) {
            int current = getValue(s.charAt(i));

            // 현재 값이 이전 값(오른쪽 값)보다 작으면 뺍니다. (감산 규칙)
            if (current < prev) {
                result -= current;
            } else {
                result += current;
            }
            prev = current;
        }

        return result;
    }

    /**
     * Map 조회보다 성능이 우수한 switch문 활용
     */
    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
