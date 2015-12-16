
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by liunian on 15-10-23.
 * 深度优先搜索 
 */
public class NumberOfIsland {
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length <= 0) {
            return 0;
        }

        int cnt = 0;

        int row = grid.length;
        int col = grid[0].length;

        for(int i = 0; i < row; i++) {
            for(int  j = 0; j < col; j++) {
                if(grid[i][j] == '1') {
                    cnt++;
                    dfs(i, j, row, col, grid);
                }
            }
        }
        return cnt;
    }

    public static void dfs(int i, int j, int row, int col, char[][] grid) {
        grid[i][j] = '0';
        if(i - 1 >= 0 && grid[i - 1][j] == '1') {
            dfs(i - 1, j, row, col, grid);
        }

        if(i + 1 < row && grid[i + 1][j] == '1') {
            dfs(i + 1, j, row, col, grid);
        }

        if(j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(i, j - 1, row, col, grid);
        }

        if(j + 1 < col && grid[i][j + 1] == '1') {
            dfs(i, j + 1, row, col, grid);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid));
    }
}

//class Pos {
//    int x;
//    int y;
//    Pos(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
