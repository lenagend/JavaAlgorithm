package com.mingchico.programmers.bruteforce;

public class P86491 {
    public int solution(int[][] sizes) {
        /*지갑의 가로, 세로는 명함 중 가장 큰 가로의 길이이며 가장큰 세로의 길이이다
        명함의 가로*세로를 리턴한다
        단, 명함을 돌릴 수 있기때문에 큰값을 가로또는 세로 한쪽으로 몰아야한다

        지갑의 가로, 세로 변수를 초기화한다
        sizes[0]의 길이 만큼 반복해서
        math.max를 이용해서 가로와 세로중 큰값을 이 명함의 가로로 정하고
        '지갑'의 가로와 비교해서 큰값을 지갑의 가로로 재정의한다
        세로도 마찬가지      */

        int walletWidth = 0;
        int walletHeight = 0;

        for(int[] card : sizes){
            int cardWidth = Math.max(card[0], card[1]);
            int cardHeight = Math.min(card[0], card[1]);

            walletWidth = Math.max(walletWidth, cardWidth);
            walletHeight = Math.max(walletHeight, cardHeight);
        }

        return walletWidth * walletHeight;
    }
}
