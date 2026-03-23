class Solution {
    public int minFlips(String s) {

        int flipStartWith0 = 0;
        int flipStartWith1 = 0;

        for(int i = 0; i < s.length(); i++) {

            // expected character if starting with '0'
            char expected0 = (i % 2 == 0) ? '0' : '1';

            // expected character if starting with '1'
            char expected1 = (i % 2 == 0) ? '1' : '0';

            if(s.charAt(i) != expected0)
                flipStartWith0++;

            if(s.charAt(i) != expected1)
                flipStartWith1++;
        }

        return Math.min(flipStartWith0, flipStartWith1);
    }
}
