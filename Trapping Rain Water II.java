class Cell {
    int x, y, h;
    public Cell(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}

class CellComparator implements Comparator<Cell> {
    public int compare(Cell c1, Cell c2) {
        return c1.h == c2.h ? 0 : c1.h > c2.h ? 1 : -1;
    }
}

public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        int m = heights.length;
        if (m == 0) {
            return 0;
        }
        int n = heights[0].length;
        if (n == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> q = new PriorityQueue<Cell>(1,new CellComparator());
        for (int i = 0; i < m; i++) {
            q.offer(new Cell(i,0,heights[i][0]));
            q.offer(new Cell(i,n-1,heights[i][n-1]));
            visited[i][0] = true;
            visited[i][n-1] = true;
        }
        for (int j = 1; j < n-1; j++) {
            q.offer(new Cell(0,j,heights[0][j]));
            q.offer(new Cell(m-1,j,heights[m-1][j]));
            visited[0][j] = true;
            visited[m-1][j] = true;
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int res = 0;
        int ix, iy;
        while (!q.isEmpty()) {
            Cell c = q.poll();
            for (int i = 0; i < 4; i++) {
                ix = c.x + dx[i];
                iy = c.y + dy[i];
                if (ix < 0 || ix >= m || iy < 0 || iy >= n || visited[ix][iy]) {
                    continue;
                }
                visited[ix][iy] = true;
                q.offer(new Cell(ix, iy, Math.max(c.h, heights[ix][iy])));
                res += Math.max(0, c.h - heights[ix][iy]);
            }
        }
        return res;
    }
};
