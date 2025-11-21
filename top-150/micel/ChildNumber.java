// https://leetcode.com/problems/find-the-child-who-has-the-ball-after-k-seconds

class Solution {
    
    public int numberOfChild(int n, int k) {
        int pos = 0;
        int dir = 1;

        for (int i = 0; i < k; i++) {
            pos = pos + dir;
            if (pos == n - 1) {
                dir = -1;
            } else if (pos == 0) {
                dir = 1;
            }
        }

        return pos;
    }
}
