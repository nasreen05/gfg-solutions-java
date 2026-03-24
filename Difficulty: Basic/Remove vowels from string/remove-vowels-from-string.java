class Solution {
    String removeVowels(String s) {

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if(!isVowel(ch)) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' ||
               ch == 'o' || ch == 'u';
    }
}
