/**
 * 题目描述：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *          如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *          我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 解题思路：用一个列表记录数据流中的数值，在插入时使列表中的元素按从小到大的顺序排列。
 */

import java.util.LinkedList;
import java.util.List;

public class Offer63 {

    private List<Integer> numList = new LinkedList<Integer>();
    public void Insert(Integer num) {
        if(numList.size() == 0){
            numList.add(num);
        }else{
            if(num < numList.get(0)){
                numList.add(0, num);
            }else if(num > numList.get(numList.size() - 1)){
                numList.add(num);
            }else{
                for(int i = 0; i < numList.size() - 1; i++){
                    if(num > numList.get(i) && num < numList.get(i + 1)){
                        numList.add(i+1, num);
                        break;
                    }
                }
            }
        }
    }

    public Double GetMedian() {
        int size = numList.size();
        if(size == 0){
            return null;
        }
        if(size % 2 == 0){
            return (numList.get(size / 2) + numList.get(size / 2 - 1)) * 1.0 / 2;
        }else{
            return numList.get(size / 2) * 1.0;
        }
    }
}
