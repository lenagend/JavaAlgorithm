package com.mingchico.ai.stack;

import java.util.Stack;

/*올바른 괄호의 짝
문제 설명
괄호가 바르게 짝지어졌다는 것은 ( 문자로 열렸으면 반드시 짝지어서 ) 문자로 닫혀야 한다는 뜻입니다. 예를 들어:

        "()()" 또는 "(())()" 는 올바른 괄호입니다.

")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.

괄호로만 이루어진 문자열 s가 주어졌을 때, 올바른 괄호이면 true를, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.

        제한 사항
문자열 s의 길이는 100,000 이하의 자연수입니다.

문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.

        s,answer
"()()",true
"(())()",true
")()(",false
"(()(",false     */
public class Stack1 {
    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);
        }

        int rightCount = 0;

        while(!stack.isEmpty()){
            char c = stack.pop();

            if(c == ')'){
                rightCount++;
            }else{
                rightCount--;
                if(rightCount < 0){
                    return false;
                }
            }

        }

        // 마지막에 스택이 비어있는지 확인!
        return true;
    }
}
