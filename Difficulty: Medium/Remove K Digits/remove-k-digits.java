class Solution {
    public String removeKdig(String s, int k) {
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            while (stack.length() > 0 && k > 0 &&
                   stack.charAt(stack.length() - 1) > ch) {
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }
            stack.append(ch);
        }

        // If k still > 0, remove from end
        while (k > 0 && stack.length() > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Remove leading zeros
        int idx = 0;
        while (idx < stack.length() && stack.charAt(idx) == '0') {
            idx++;
        }

        String result = stack.substring(idx);
        return result.isEmpty() ? "0" : result;
    }
}
