// https://leetcode.com/problems/can-place-flowers

class Solution {
    
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (n == 0)
            return true;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean isLeftEmpty = (i == 0) || flowerbed[i - 1] == 0;
                boolean isrightEmpty = (i == flowerbed.length - 1) || flowerbed[i + 1] == 0;

                if (isLeftEmpty && isrightEmpty) {
                    flowerbed[i] = 1;
                    n--;
                }

                if (n == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
