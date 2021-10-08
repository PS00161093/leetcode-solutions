package threeweekschallange.medium;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class ColorsSort {

    public void sortColors(int[] nums) {

        int redBallCounter = 0;
        int whileBallCounter = 0;
        int blueBallCounter = 0;

        for (int n : nums) {
            if (n == 0) redBallCounter++;
            else if (n == 1) whileBallCounter++;
            else if (n == 2) blueBallCounter++;
        }

        int index = 0;
        while (redBallCounter > 0) {
            nums[index++] = 0;
            redBallCounter--;
        }
        while (whileBallCounter > 0) {
            nums[index++] = 1;
            whileBallCounter--;
        }
        while (blueBallCounter > 0) {
            nums[index++] = 2;
            blueBallCounter--;
        }
    }

}
