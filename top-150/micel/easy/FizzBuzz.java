// https://leetcode.com/problems/fizz-buzz/description/

class FizzBuzz {
  
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean divBy3 = i % 3 == 0 ? true : false;
            boolean divBy5 = i % 5 == 0 ? true : false;

            if (divBy3 && divBy5) {
                list.add("FizzBuzz");
            } else if (divBy5) {
                list.add("Buzz");
            } else if (divBy3) {
                list.add("Fizz");
            } else {
                list.add(String.valueOf(i));
            }
        }

        return list;
    }
}
