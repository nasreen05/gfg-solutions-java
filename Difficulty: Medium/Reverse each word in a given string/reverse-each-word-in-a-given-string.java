class Solution {
    public String reverseWords(String s) {

        // remove leading/trailing spaces and split by one or more spaces
        String[] words = s.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            String word = words[i];
            StringBuilder reversed = new StringBuilder(word).reverse();

            result.append(reversed);

            if (i != words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}
