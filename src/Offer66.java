/**
 * 题目描述：地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 *          但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 *          但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 */

public class Offer66 {

    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold < 1 || rows < 0 || cols < 0){
            return 0;
        }
        int[][] visited = new int[rows][cols];//记录是否已经进入过矩阵对应坐标
        return movingCountSub(threshold, rows, cols, visited, 0, 0);
    }

    public int movingCountSub(int threshold, int rows, int cols, int[][] visited, int rNum, int cNum){
        if(rows <= rNum || cols <= cNum || rNum < 0|| cNum < 0 || isOver(threshold, rNum, cNum) || visited[rNum][cNum] == 1){
            return 0;
        }
        visited[rNum][cNum] = 1;
        return 1 + movingCountSub(threshold, rows, cols, visited, rNum - 1, cNum)
                + movingCountSub(threshold, rows, cols, visited, rNum + 1, cNum)
                + movingCountSub(threshold, rows, cols, visited, rNum, cNum - 1)
                + movingCountSub(threshold, rows, cols, visited, rNum, cNum + 1);
    }

    //判断当前坐标是否符合限制
    public boolean isOver(int threshold, int row, int col){
        int sum = 0;
        while(row != 0){
            sum += row % 10;
            row /= 10;
        }
        while(col != 0){
            sum += col % 10;
            col /= 10;
        }
        return sum <= threshold ? false : true;
    }
}
