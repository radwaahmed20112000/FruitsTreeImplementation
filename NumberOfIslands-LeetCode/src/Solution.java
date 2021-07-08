import java.awt.*;
import java.util.Stack;

public class Solution {
    boolean[][] visitedNodes ;
    int islandsNumber = 0;

    public int numIslands(char[][] grid) {
        visitedNodes = new boolean[grid.length][grid[0].length];
        Stack<Point> points = new Stack<>();
        for (int i = 0 ;i < grid.length;i++){
            for(int j = 0 ; j < grid[0].length;j++) {
                if(visitedNodes[i][j]) continue;
                if(grid[i][j] == '1'){
                    points.push(new Point(i,j));
                }
                visitedNodes[i][j] = true;
                if(!points.isEmpty())
                    DFS(grid,points);
            }
        }
        return islandsNumber;
    }

    private void DFS(char[][] grid,Stack<Point> points) {
        islandsNumber++;
        while (!points.empty()) {
            Point point = points.pop();
            int i = point.x;
            int j = point.y;
            visitedNodes[i][j] = true;
            if(grid[i][j] == '1' ){
                if (i != grid.length - 1 && !visitedNodes[i+1][j])
                    points.push(new Point(i + 1, j));
                if (j != grid[0].length - 1 && !visitedNodes[i][j+1])
                    points.push(new Point(i, j + 1));
                if (i != 0 && !visitedNodes[i-1][j])
                    points.push(new Point(i - 1, j));
                if (j != 0 && !visitedNodes[i][j-1])
                    points.push(new Point(i, j - 1));
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(solution.numIslands(grid));
    }
}
