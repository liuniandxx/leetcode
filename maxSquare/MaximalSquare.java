/**
 * 
 * @author liunian
 * 2015/07/04
 * 最大正方
 * 
 * 题目： 
 * 一个矩阵 matrix， 矩阵中的元素 要么是'0'，要么是'1'
 * 求矩阵中最大正方形（正方刑中的元素都是'1'）的面积
 * 
 * 动态规划:
 * 增加辅助dp[][]，
 * dp[i][j]表示 在matrix中以第i行第j列为正方形右下角顶点的最大正方形的宽度
 * 那么有
 * 当matrix[i][j] == '0'时，dp[i][j] = 0
 * 当matrix[i][j] == '1'时, 
 * dp[i][j] = min(dp[i - 1[j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
 * 
 * 最后得到的是 max(dp[i][j]) * max(dp[i][j])
 */
public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}

		int[][] dp = new int[matrix.length][matrix[0].length];
		
		int maxWidth = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == '1') {
				dp[i][0] = 1;
				maxWidth = 1;
			}
		}

		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == '1') {
				dp[0][i] = 1;
				maxWidth = 1;
			}
		}
		
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == '0') {
					dp[i][j] = 0;
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1],
							Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					if(maxWidth < dp[i][j]) {
						maxWidth = dp[i][j];
					}
				}
			}
		}
		return maxWidth * maxWidth;

	}

}
