class Solution {
    long ExtractNumber(String sentence) {
        String[] words = sentence.split(" ");
        long max = -1;

        for (String word : words) {

            // Check if word is a number
            if (Character.isDigit(word.charAt(0))) {

                // Ignore numbers containing '9'
                if (word.contains("9")) continue;

                long num = Long.parseLong(word);
                max = Math.max(max, num);
            }
        }

        return max;
    }
}
