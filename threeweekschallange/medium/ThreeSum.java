package threeweekschallange.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/3sum/submissions/
 */
public class ThreeSum {

    public List<List<Integer>> threeSum1(int[] numbers) {
        Set<List<Integer>> res = new HashSet<>();
        if (numbers.length == 0) new ArrayList<>(res);

        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            int j = i + 1;
            int k = numbers.length - 1;
            while (j < k) {
                int sum = numbers[i] + numbers[j] + numbers[k];
                if (sum == 0) res.add(Arrays.asList(numbers[i], numbers[j++], numbers[k--]));
                else if (sum > 0) k--;
                else j++;
            }
        }

        return new ArrayList<>(res);
    }

    public static List<List<Integer>> threeSum(int[] numbers) {

        Arrays.sort(numbers);
        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < numbers.length - 2; i++) {
            if (i == 0 || numbers[i] != numbers[i - 1]) {
                int low = i + 1;
                int high = numbers.length - 1;
                int totalSum = -numbers[i];
                while (low < high) {
                    if (numbers[low] + numbers[high] == totalSum) {
                        result.add(Arrays.asList(numbers[i], numbers[low], numbers[high]));
                        while (low < high && numbers[low] == numbers[low + 1]) low++;
                        while (low < high && numbers[high] == numbers[high - 1]) high--;
                        low++;
                        high--;
                    } else if (numbers[low] + numbers[high] < totalSum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }

        return result;
    }

}