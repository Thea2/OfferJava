/**
 * 题目描述：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 *          每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 *          例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 *          因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 *
 */

public class Offer65 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix == null || str == null || rows < 0 || cols < 0){
            return false;
        }
        int[] tag = new int[matrix.length];//记录当前路径中是否经过矩阵对应位置，tag[i]=1时表示当前路径已经经过矩阵元素matrix[i]
        //指定路径开始的位置
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(hasPathSub(matrix, rows, cols, i, j, 0, str, tag)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean  hasPathSub(char[] matrix, int rows, int cols, int rNum, int cNum, int num, char[] str, int[] tag){
        int index = rNum * cols + cNum;//当前路径匹配到指定字符串的第几个字符
        if(rNum < 0 || rNum >= rows || cNum  < 0 || cNum >= cols || tag[index] == 1 || matrix[index] != str[num]){
            return false;
        }
        //完成匹配字符串
        if(num == str.length - 1){
            return true;
        }
        tag[index] = 1;
        //匹配字符串中下一个字符，尝试上下左右四个方向
        if(hasPathSub(matrix, rows, cols, rNum + 1, cNum, num + 1, str, tag)
                || hasPathSub(matrix, rows, cols, rNum - 1, cNum, num + 1, str, tag)
                || hasPathSub(matrix, rows, cols, rNum, cNum + 1, num + 1, str, tag)
                || hasPathSub(matrix, rows, cols, rNum, cNum - 1, num + 1, str, tag)
                ){
            return true;
        }
        tag[index] = 0;
        return false;
    }
}
