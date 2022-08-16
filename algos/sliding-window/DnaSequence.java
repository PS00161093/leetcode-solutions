import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/repeated-dna-sequences/">...</a>*
 */
public class DnaSequence {

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i + 10 <= s.length(); i++) {
            String ts = s.substring(i, i + 10);
            if (map.containsKey(ts)) map.put(ts, map.get(ts) + 1);
            else map.put(ts, 1);
        }

        map.forEach((key, value) -> {
            if (value > 1) list.add(key);
        });

        return list;
    }

}
