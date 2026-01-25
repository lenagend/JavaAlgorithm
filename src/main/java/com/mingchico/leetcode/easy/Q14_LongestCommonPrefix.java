package com.mingchico.leetcode.easy;

public class Q14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        /*처음 단어를 프리픽스로 두고,
                그 다음 거부터 비교
                뒤에글자 하나씩 빼면서 똑같아질때까지
                프리픽스 리턴*/

        String prefix = strs[0]; //flower
        for(int i = 1; i < strs.length; i++){
            while (strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);

                if(prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }


































    //안보고 복기
    public String longestCommonPrefix2(String[] strs) {
        /*첫번째 문장을 프리픽스로 저장
                두번째 문장부터 indexof로 일치여부를 구하고
                맞지않으면 맞을때까지 프리픽스 맨뒤에거를 날림

                프리픽스를 리턴*/
        String prefix = strs[0];

        for(int i = 1; i < strs.length; i ++){
            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length() - 1);

                if(prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}
