/**
 * Created with IntelliJ IDEA.
 * User: liuniandxx
 * Date: 15-12-9
 * Time: 下午12:20
 * To change this template use File | Settings | File Templates.
 */
public class EditDistance {
    public static int minDistance(String word1, String word2) {
        if((word1 == null && word2 == null) ||
                (word1 != null && word1.length() <= 0 && word2 != null && word2.length() <=0 )) {
            return 0;
        }

        if(word1 == null || word1.length() <= 0) {
            return word2.length();
        }

        if(word2 == null || word2.length() <= 0) {
            return word1.length();
        }

        int m = word1.length();
        int n = word2.length();

        int[][] matrix = new int[m + 1][n + 1];

        for(int i = 0; i <= m; i++) {
            matrix[i][0] = i;
        }

        for(int i = 0; i <= n; i++) {
            matrix[0][i] = i;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = minThree(matrix[i - 1][j] + 1,
                            matrix[i][j - 1] + 1, matrix[i - 1][j - 1] + 1);
                }

            }
        }
        return matrix[m][n];
    }

    public static int minThree(int a, int b, int c) {
        if(a <= b  && a <= c) {
            return a;
        }

        if(b <= a && b <= c) {
            return b;
        }

        return c;
    }

    public static void main(String[] args) {
        System.out.println(minDistance("a", "a"));
    }
}
