package challange;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/n-th-tribonacci-number/
 */
public class Tribonacci {

    public int tribonacci(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 1);
        int i = 3;
        while (i <= n) {
            map.put(i, map.get(i - 1) + map.get(i - 2) + map.get(i - 3));
            i++;
        }
        return map.get(n);
    }

}
