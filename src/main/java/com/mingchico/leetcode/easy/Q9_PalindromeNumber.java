package com.mingchico.leetcode.easy;

public class Q9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false; // 음수 컷!

        String original = String.valueOf(x);
        String reversed = new StringBuilder(original).reverse().toString();

        return original.equals(reversed);
    }

    //문자열을 쓰지 않은 더 나은 솔루션
    public boolean isPalindrome2(int x) {
        // 1. 엣지 케이스 처리 (감각 포인트!)
        // 음수는 무조건 false
        // 0이 아닌데 0으로 끝나는 숫자(10, 100 등)도 무조건 false
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedNumber = 0;
        int originalX = x;

        while (x > 0) {
            // 2. 일의 자리 숫자 뽑기
            int pop = x % 10;

            // 3. 기존 숫자는 한 자리 줄이기
            x /= 10;

            // 4. 뒤집힌 숫자 만들기 (자릿수 올리기)
            // 기존 숫자에 10을 곱해 자릿수를 밀어내고 새 숫자를 더함
            reversedNumber = (reversedNumber * 10) + pop;
        }

        // 5. 원본과 뒤집은 숫자가 같은지 비교
        return originalX == reversedNumber;
    }
}
