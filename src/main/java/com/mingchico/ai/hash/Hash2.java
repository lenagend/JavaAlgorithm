package com.mingchico.ai.hash;
import java.util.*;
/*문제 설명
탐험가인 당신은 고대 유적에서 보물상자를 발견했습니다. 보물상자를 열기 위해서는 보석 목록 중 딱 하나 누락된 보석의 이름을 입력해야 합니다.

현판에는 원래 있어야 할 보석 이름들이 적힌 required 배열이 있고, 당신이 실제로 가방에 가지고 있는 보석 이름들이 적힌 myBag 배열이 있습니다.

원래는 있어야 하지만 당신의 가방에는 없는 단 하나의 보석 이름을 찾아내세요.

제한 사항
required 배열의 길이는 1 이상 10,000 이하입니다.

myBag의 길이는 required의 길이보다 항상 1 작습니다.

보석 이름은 중복해서 나타날 수 있습니다. (예를 들어, "루비"가 2개 필요할 수도 있습니다.)

누락된 보석은 반드시 하나 존재합니다.

required (필요한 것),myBag (내 가방),return
        "[""ruby"", ""diamond"", ""opal""]","[""ruby"", ""opal""]","""diamond"""
        "[""topaz"", ""topaz"", ""emerald""]","[""topaz"", ""emerald""]","""topaz"""*/
public class Hash2 {
    public String solution(String[] required, String[] mybag){
        Map<String, Integer> map = new HashMap<>();
        for(String gem : required){
            map.merge(gem, 1, Integer::sum);
        }

        for(String mine: mybag){
            int count = map.merge(mine, -1, Integer::sum);
        }

        for(String result: map.keySet()){
            int count = map.get(result);
            if(count != 0){
                return result;
            }
        }

        /*entrySet을 사용하면 key와 value를 한 번에 꺼낼 수 있다.
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return entry.getKey();
            }
        }*/

        return "";
    }
}
