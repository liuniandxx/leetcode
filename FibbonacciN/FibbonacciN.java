/**
 * Created by liunian on 15-10-23.
 * 查找 Fibbnaccci 序列的第N个序列 
 * 时间复杂度 O(n * log(n))
 */
public class FibbonacciN {
    public static int Fn(int n) {
        if(n <= 1) {
            return 1;
        } else {
            int[][] matrix = matrix(n);
            return matrix[1][1];
        }
    }

    /**
      * 关键在于此计算 矩阵[[0,1] [1, 1]]的值
      * 原理时转化为计算 a^n 的方式 
      * n % 2 == 0 , a^n = (a^(n / 2))^2 , n % 2 == 1，a ^ n = (a * (a ^ ((n - 1)/2))^2)
      **/
    public static int[][] matrix(int n) {
        int[][] eMatrix = new int[][] {{0, 1}, {1, 1}};
        if(n == 1) {
            return eMatrix;
        } else if((n & 1) != 0) {
            int[][] matrixHalf = matrix(n / 2);
            return matrixMul(eMatrix,matrixMul(matrixHalf, matrixHalf));
        } else {
            int[][] matrixHalf = matrix(n / 2);
            return matrixMul(matrixHalf, matrixHalf);
        }
    }
    /**
      * 计算矩阵相乘
      * 按照运算法则实现就可
      **/
    public static int[][] matrixMul(int[][] p, int[][] q) {
        int row = p.length;
        int col = q[0].length;
        int qrow = q.length;

        int[][] result = new int[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int sum = 0;
                for(int k = 0; k < qrow; k++) {
                    sum += p[i][k] * q[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Fn(11));
    }
}
