//https://leetcode.com/problems/multiply-strings/description/?envType=company&envId=facebook&favoriteSlug=facebook-six-months

class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        //Product of 2 numbers will not exceed the sum of digits of 2 numbers
        int[] result = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {

                //since, inbuilt function is not allowed, use char & subtract '0'
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';
                int mul = digit1 * digit2;

                // position in the result array to keep the product
                int posLow = i + j + 1;
                int posHigh = i + j;

                // add multiplication result to the current position & handle carry
                int sum = mul + result[posLow];

                result[posLow] = sum % 10; // remiander
                result[posHigh] = result[posHigh] + (sum / 10); // add the carry

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : result) {
            // skip leading zero
            if (!(sb.length() == 0 && n == 0)) {
                sb.append(n);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
