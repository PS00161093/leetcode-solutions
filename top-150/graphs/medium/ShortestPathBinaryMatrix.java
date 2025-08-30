// https://leetcode.com/problems/shortest-path-in-binary-matrix/
// TC: O(n)

class ShortestPathBinaryMatrix {
  
    public int shortestPathBinaryMatrix(int[][] grid) {
        int len = grid.length;
        if (grid[0][0] == 1 || grid[len - 1][len - 1] == 1) {
            return -1;
        }

        // Because of BFS
        Queue<int[]> queue = new LinkedList<>();

        // 0 = row, 1 = column, 2 = nodes count
        // initialize queue with 0, 0, 1
        queue.add(new int[] { 0, 0, 1 });

        // mark visited node = 1
        grid[0][0] = 1;

        // all directions we can move
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int point[] = queue.poll();

                // r = n - 1 and c = n - 1, means we reached bottom right
                if (point[0] == len - 1 && point[1] == len - 1) {
                    return point[2];
                }

                // move in all possible directions
                for (int[] d : dir) {
                    int r = point[0] + d[0];
                    int c = point[1] + d[1];

                    // move only in all possible but allowed directions
                    // for next allowed direction, add it to the queue (row, column, and current node count + 1
                    // mark visited/added node = 1
                    if (r >= 0 && c >= 0 && r < len && c < len && grid[r][c] == 0) {
                        queue.add(new int[] { r, c, point[2] + 1 });
                        grid[r][c] = 1;
                    }
                }
            }
        }

        // path not found
        return -1;
    }
}
