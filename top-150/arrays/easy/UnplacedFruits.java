// https://leetcode.com/problems/fruits-into-baskets-ii/

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int len = fruits.length;
        int done = 0;
      
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(fruits[i] <= baskets[j] && baskets[j] != -1) {
                    baskets[j] = -1;
                    done++;
                    break;
                }
            }
        }

        return len - done;
    }
}
