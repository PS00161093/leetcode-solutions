package threeweekschallange.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalsTriangle {

    public static List<Integer> getRow(int rowIndex) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, Collections.singletonList(1));
        int counter = 0;

        while (counter < rowIndex) {
            List<Integer> from = map.get(counter);
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int i = 1; i < from.size(); i++) {
                newRow.add(from.get(i - 1) + from.get(i));
            }
            newRow.add(1);
            counter++;
            map.put(counter, newRow);
        }

        return map.get(rowIndex);
    }
}
