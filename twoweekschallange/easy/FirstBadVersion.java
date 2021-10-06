package twoweekschallange.easy;

public class FirstBadVersion {

    /**
     * challange.easy.FirstBadVersion - https://leetcode.com/problems/first-bad-version/
     */

    public int firstBadVersion(int n) {

        int low = 0;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) high = mid;
            else low = mid + 1;
        }

        return low;
    }

    public int firstBadVersion1(int n) {

        int low = 0;
        int high = n;
        int mid = low + (high - low) / 2;
        if (mid == 0) return 1;
        while (low <= high) {
            boolean x = isBadVersion(mid - 1);
            boolean y = isBadVersion(mid);
            if (!x && y) return mid;
            else if (x && y) {
                high = mid - 1;
            } else low = mid + 1;
            mid = low + (high - low) / 2;
        }

        return 0;
    }
}