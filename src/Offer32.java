/**
 * 题目描述：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *          例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * 解题思路：写一个方法比较两个数一前一后拼接成一个数后哪种结果得出的数字较小，
 *          利用上述方法得出数组最佳组合
 */

public class Offer32 {

    public String PrintMinNumber(int [] numbers) {
        if(numbers == null){
            return null;
        }

        if(numbers.length == 1){
            return String.valueOf(numbers[0]);
        }

        //类似冒泡排序
        for(int i= 0; i < numbers.length; i++){
            for(int j=i+1; j < numbers.length; j++){
                if(compare(numbers[i], numbers[j]) > 0){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        StringBuilder str = new StringBuilder();
        for(int i=0; i<numbers.length; i++){
            str.append(numbers[i]);
        }
        return str.toString();
    }

    /**
     * 比较两个数一前一后拼接成一个数后哪种结果得出的数字较小，
     * 若num1接num2大于num2接num1，则返回结果大于零，
     * 若num1接num2小于num2接num1，则返回结果小于零，
     * 若num1接num2等于num2接num1，则返回结果等于零
     * @param num1
     * @param num2
     * @return 第一个数在前面第二个数在后面所拼接的数减去第二个数在前面第一个数在后面所拼接的数
     */
    public int compare(int num1, int num2){
        int temp = num2;
        int pow = 1;
        while(temp > 0){
            temp /= 10;
            pow *= 10;
        }
        int result1 = num1 * pow + num2;
        temp = num1;
        pow = 1;
        while(temp > 0){
            temp /= 10;
            pow *= 10;
        }
        int result2 = num1 + num2 * pow;
        return result1 - result2;
    }
}
