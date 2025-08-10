class IntersectionTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        Set<Integer> set = new HashSet<>();

        if (l1 > l2) {
            for (int n : nums1) {
                set.add(n);
            }
        } else {
            for (int n : nums2) {
                set.add(n);
            }
        }

        Set<Integer> list = new HashSet<>();
        if (l1 > l2) {
            for (int n : nums2) {
                if (set.contains(n)) {
                    list.add(n);
                }
            }
        } else {
            for (int n : nums1) {
                if (set.contains(n)) {
                    list.add(n);
                }
            }
        }

        int[] intArray = new int[list.size()];
        int i = 0;
        for (Integer number : list) {
            intArray[i++] = number; // Auto-unboxing happens here
        }

        return intArray;
    }
}
