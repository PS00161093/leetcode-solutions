package threweekschallange.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/submissions/
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] numbers) {

        Arrays.sort(numbers);
        List<List<Integer>> result = new LinkedList<>();
        int counter = 0;
        for (int i = 0; i < numbers.length - 2; i++) {
            counter++;
            if (i == 0 || numbers[i] != numbers[i - 1]) {

                int low = i + 1;
                int high = numbers.length - 1;
                int totalSum = -numbers[i];

                while (low < high) {
                    counter++;
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
        System.out.println(counter);
        return result;
    }

}