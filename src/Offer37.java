/**
 * 题目描述：统计一个数字在排序数组中出现的次数。
 *
 * 解题思路：找出数字第一次出现的位置和最后一次出现的位置，相减即为出现次数
 */
public class Offer37 {

    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0){
            return 0;
        }
        int first = getFirstK(array, k);
        int last = getLastK(array, k);
        if(first != -1 && last != -1){
            return last - first + 1;
        }
        return 0;
    }

    public int getFirstK(int[] array, int k){
        int start = 0;
        int end = array.length - 1;
        int mid = (start + end) >> 1;
        while(start <= end){
            if(array[mid] > k){
                end = mid -1;
            }else if(array[mid] < k){
                start = mid + 1;
            }else if(mid - 1 >= 0 && array[mid-1]==k){
                end = mid - 1;
            }else{
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }

    public int getLastK(int[] array, int k){
        int start = 0;
        int end = array.length - 1;
        int mid = (start + end) >> 1;
        while(start <= end){
            if(array[mid] > k){
                end = mid -1;
            }else if(array[mid] < k){
                start = mid + 1;
            }else if(mid + 1 < array.length && array[mid+1]==k){
                start = mid + 1;
            }else{
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;
    }
}
