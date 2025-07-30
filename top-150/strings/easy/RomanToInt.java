// https://leetcode.com/problems/roman-to-integer/description/

class RomanToInt {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = map.get(s.charAt(i));

            if (i + 1 < s.length() && current < map.get(s.charAt(i + 1))) {
                result = result - current;
            } else {
                result = result + current;
            }
        }

        return result;
    }


public int romanToInt(String s) {
  Map<Character, Integer> map = new HashMap<>();
  map.put('I', 1);
  map.put('V', 5);
  map.put('X', 10);
  map.put('L', 50);
  map.put('C', 100);
  map.put('D', 500);
  map.put('M', 1000);

  int res = 0;
  for (int i = 0; i < s.length(); i++) {
      char cc = s.charAt(i);
      char nc = i + 1 < s.length() ? s.charAt(i + 1) : ' ';

      if (cc == 'I' || cc == 'X' || cc == 'C') {
          if (cc == 'I' && (nc == 'V' || nc == 'X')) {
              res = res + (map.get(nc) - 1);
              i++;
          } else if (cc == 'X' && (nc == 'L' || nc == 'C')) {
              res = res + (map.get(nc) - 10);
              i++;
          } else if (cc == 'C' && (nc == 'D' || nc == 'M')) {
              res = res + (map.get(nc) - 100);
              i++;
          } else {
              res = res + map.get(cc);
          }
      } else {
          res = res + map.get(cc);
      }
  }

  return res;
  }  
}
