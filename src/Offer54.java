/**
 * 题目描述：请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *          例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 *          当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 解题思路：统计每个字符出现的次数，并按顺序找出只出现一次的字符。
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Offer54 {

    Map<Character, Integer> map = new HashMap<Character, Integer>();
    ArrayList<Character> list = new ArrayList<Character>();

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(map.containsKey(ch)){
            map.put(ch, map.get(ch)+1);
        }else{
            map.put(ch, 1);
        }
        list.add(ch);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char result = '#';
        for(char ch : list){
            if(map.get(ch) == 1){
                result = ch;
                break;
            }
        }
        return result;
    }
}
