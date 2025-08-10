// https://leetcode.com/problems/first-bad-version/description/
// TC: O(log n)

public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 1) {
            return 1;
        }

        int left = 0;
        int right = n;
        int firstBad = Integer.MAX_VALUE;
        ;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean isBad = isBadVersion(mid);
            if (isBad) {
                firstBad = Math.min(firstBad, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return firstBad;
    }
}
