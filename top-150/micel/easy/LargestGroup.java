// https://leetcode.com/problems/count-largest-group/description/

class LargestGroup {
  
    public int countLargestGroup(int n) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Directly count frequencies of digit sums
        for (int i = 1; i <= n; i++) {
            int digitSum = getSum(i);
            freqMap.put(digitSum, freqMap.getOrDefault(digitSum, 0) + 1);
        }

        // Find max frequency and count how many sums have this frequency
        int maxFreq = 0;
        int count = 0;
        for (int freq : freqMap.values()) {
            if (freq > maxFreq) {
                maxFreq = freq;
                count = 1;
            } else if (freq == maxFreq) {
                count++;
            }
        }

        return count;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
