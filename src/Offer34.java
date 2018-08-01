/**
 * 题目描述：在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 *         并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 *
 * 解题思路：遍历字符串，用一个数组统计每个字符出现的次数，最后遍历数组找到只出现一次的字符，没找到则返回-1.
 */

public class Offer34 {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0){
            return -1;
        }
        char[] array = str.toCharArray();
        int[] index = new int[(int)'z' + 1];
        for(char c : array){
            index[(int)c]++;
        }
        for(int i=0; i< array.length; i++){
            if(index[(int)array[i]] == 1){
                return i;
            }
        }
        return -1;
    }
}
