// https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int t1 = m - 1;
        int t2 = n - 1;
        int done = m + n - 1;

        while (t1 >= 0 && t2 >= 0) {
            if (nums1[t1] > nums2[t2]) {
                nums1[done] = nums1[t1];
                t1--;
            } else {
                nums1[done] = nums2[t2];
                t2--;
            }
            done--;
        }

        while (t2 >= 0) {
            nums1[done] = nums2[t2];
            t2--;
            done--;
        }
    }
}
