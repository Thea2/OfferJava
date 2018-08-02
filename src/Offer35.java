/**
 * 题目描述：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 *          输入一个数组,求出这个数组中的逆序对的总数P。
 *          并将P对1000000007取模的结果输出。 即输出P%1000000007
 *
 * 解题思路：摘抄
 *         先把数组分割成子数组，先统计出子数组内部的逆序对的数目，然后再统计出两个相邻子数组之间的逆序对的数目。
 *         在统计逆序对的过程中，还需要对数组进行排序。（归并排序的改进）
 */
public class Offer35 {

    public int InversePairs(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int[] copy = new int[array.length];
        return InversePairsCore(array, copy, 0, array.length - 1);
    }

    private  static int InversePairsCore(int[] array,int[] copy,int low,int high){
        if(low == high){
            return 0;
        }
        int mid = (low + high) >> 1;
        int leftCount = InversePairsCore(array, copy, low, mid);
        int rightCount = InversePairsCore(array, copy, mid+1, high);
        int one = mid;
        int two = high;
        int num = high;
        int count = 0;
        while(low <= one && mid < two){
            if(array[one] < array[two]){
                copy[num--] = array[two--];
            }else{
                count += (two - mid);
                copy[num--] = array[one--];
                if(count > 1000000007){
                    count %= 1000000007;
                }
            }
        }
        while(low <= one){
            copy[num--] = array[one--];
        }
        while(mid < two){
            copy[num--] = array[two--];
        }
        for(int i = low; i <= high; i++){
            array[i] = copy[i];
        }
        return (count + leftCount + rightCount) % 1000000007;
    }
}
