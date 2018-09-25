/**
 * Created by m2lgsb on 2018/9/25 17:46
 */
public class MinStepsMatrix {
    /**
     * 给定一个矩阵m，从左上角开始每次只能向右走或者向下走
     * 最后到达右下角的位置，路径中所有数字加起来就是路径和
     * 返回所有路径的最小路径和
     */

    public static int[][] steps = new int[4][4];

    public static void main(String[] args) {
        int[][] arr = {
                {4, 1, 5, 3},
                {3, 2, 7, 7},
                {6, 5, 2, 8},
                {8, 9, 4, 5}
        };
        steps[3][3] = minSteps(arr, 3, 3);
        print(steps);
    }

    public static int minSteps(int[][] arr, int row, int col) {
        if (row == 0 && col == 0) {
            steps[row][col] = arr[row][col];
            return steps[row][col];
        }

        if (col >= 1 && steps[row][col-1] == 0) {
            steps[row][col-1] = minSteps(arr, row, col-1);
        }

        if (row >= 1 && steps[row-1][col] == 0) {
            steps[row-1][col] = minSteps(arr, row-1, col);
        }

        if (row == 0 && col != 0) {
            steps[row][col] = arr[row][col] + steps[row][col-1];
        } else if (col == 0 && row != 0) {
            steps[row][col] = arr[row][col] + steps[row-1][col];
        } else {
            steps[row][col] = arr[row][col] + min(steps[row][col-1], steps[row-1][col]);
        }

        return steps[row][col];
    }

    static int min(int minStep1, int minStep2) {
        return minStep1 < minStep2 ? minStep1:minStep2;
    }

    static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("到达arr" + i + "|" + j + "的路径: " + arr[i][j]);
            }
        }
    }
}
